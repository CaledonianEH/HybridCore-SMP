/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */


package me.caledonian.hybridcore.commands.reactions;

import me.caledonian.hybridcore.files.MessagesConfig;
import me.caledonian.hybridcore.managers.CommandHandler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class BurntKetchup implements CommandHandler {
    private JavaPlugin plugin;

    public BurntKetchup(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission(plugin.getConfig().getString("burnt-ketchup"))){
                String bc = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("burnt-ketchup"));
                assert bc != null;
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', bc));
            }else{
                String noperm = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("no-permission"));
                String prefix = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("prefix"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', noperm));
            }
        }else{
            MessagesConfig.get().getString("console-error");
        }
    }
}
