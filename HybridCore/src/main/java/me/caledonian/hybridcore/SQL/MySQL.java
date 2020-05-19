/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.SQL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private JavaPlugin plugin;

    public MySQL(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    private Connection connection;
    public String host, database, username, password;
    public int port;

    public void setup() {
        host = plugin.getConfig().getString("host");
        port = plugin.getConfig().getInt("port");
        database = plugin.getConfig().getString("database");
        username = plugin.getConfig().getString("username");
        password = plugin.getConfig().getString("password");

        try{

            synchronized (this){
                if(getConnection() != null && !getConnection().isClosed()) {
                    return;
                }
                Class.forName("com.mysql.jdbc.Driver");
                setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database
                , this.username, this.password));

                if (plugin.getConfig().getBoolean("print-sql")) {
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "-------------------------------------------");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "[HybridCore] Successfully connected to SQL");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Host:" + ChatColor.WHITE + plugin.getConfig().getString("host"));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Port:" + ChatColor.WHITE + plugin.getConfig().getString("port"));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Database:" + ChatColor.WHITE + plugin.getConfig().getString("database"));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Username:" + ChatColor.WHITE + plugin.getConfig().getString("username"));
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Password:" + ChatColor.WHITE + "**********");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "To disable this message, set 'print-sql' to false.");
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GRAY + "-------------------------------------------");
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
}
