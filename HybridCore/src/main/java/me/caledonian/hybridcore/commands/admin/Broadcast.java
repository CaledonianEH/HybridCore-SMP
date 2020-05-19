/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.commands.admin;

import me.caledonian.hybridcore.files.MessagesConfig;
import me.caledonian.hybridcore.managers.CommandHandler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Broadcast implements CommandHandler {
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("hybridcore.broadcast") || (p.getName().equalsIgnoreCase("Caledonian_EH")) || (p.getName().equalsIgnoreCase("Caledonian_LH"))){
                if(args.length == 0){
                    String missingArgs = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("missing-args"));
                    String prefix = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("prefix"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', missingArgs));
                }else if(args.length == 1){
                    String broadcastFormat = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("broadcast-format"));
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', broadcastFormat) + args[0]);
                }
            }else{
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesConfig.get().getString("no-permission")));
            }
        }else{
            System.out.println(MessagesConfig.get().getString("console-error"));
        }
    }
}
