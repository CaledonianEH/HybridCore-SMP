/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.files;

import me.caledonian.hybridcore.files.MessagesConfig;
import me.caledonian.hybridcore.managers.CommandHandler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ReloadCommand implements CommandHandler {
    private JavaPlugin plugin;

    public ReloadCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if(sender instanceof Player){
            String prefix = plugin.getConfig().getString("prefix");
            String noPermission = MessagesConfig.get().getString("no-permission");
            String configReload = MessagesConfig.get().getString("config-reload");
            if(sender.hasPermission(plugin.getConfig().getString("reload"))){
                if(sender instanceof Player){
                    Player p = (Player) sender;
                    System.out.println("Reloading the config...");
                    plugin.reloadConfig();
                    MessagesConfig.reload();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', configReload));
                }else{
                    System.out.println("[HybridHub] Reloading the config...");
                    plugin.reloadConfig();
                    MessagesConfig.reload();
                    Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "The HybridHub config file was reloaded.");
                }
            }else{
                if(sender instanceof Player){
                    Player p = (Player) sender;
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', noPermission));
                }else{
                    System.out.println("You shouldn't ever see this error message. The console doesn't have access to " + plugin.getConfig().getString("reload"));
                }
            }
        }
    }
}
