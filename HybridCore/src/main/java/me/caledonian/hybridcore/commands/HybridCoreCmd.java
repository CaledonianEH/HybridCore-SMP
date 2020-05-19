/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.commands;

import me.caledonian.hybridcore.managers.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class HybridCoreCmd implements CommandHandler {
    private JavaPlugin plugin;
    public HybridCoreCmd(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if (p.getName().equalsIgnoreCase("Caledonian_EH") || (p.getName().equalsIgnoreCase("Caledonian_LH"))) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c*&8&m-----------&c*&8&m------------------&c*&8&m-----------&c*"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 "));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Hello &8(&c&lDev&8) &c" + p.getName() + "&7!"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7This server is currently running HybridCore &cv" + plugin.getDescription().getVersion() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Plugin Name: &c" + plugin.getDescription().getName() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Author: &c" + plugin.getDescription().getAuthors() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Folder: &c" + plugin.getDataFolder() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 "));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&o Only you can see this message, because you are a developer."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c*&8&m-----------&c*&8&m------------------&c*&8&m-----------&c*"));
            }else{
                p.sendMessage(ChatColor.DARK_GRAY + "(" + ChatColor.RED + "" + ChatColor.BOLD + "HybridCore" + ChatColor.DARK_GRAY + ")" + ChatColor.GRAY + " This server is running HybridCore " + this.plugin.getDescription().getVersion() + " by Caledonian EH.");
            }

        }else{
            Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "This server is running HybridCore " + this.plugin.getDescription().getVersion() + " by Caledonian EH, with help from Pepper_Bell");
        }
    }
}
