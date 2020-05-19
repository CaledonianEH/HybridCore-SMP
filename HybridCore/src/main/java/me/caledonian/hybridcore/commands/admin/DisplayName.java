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
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class DisplayName implements CommandHandler {
    private JavaPlugin plugin;

    public DisplayName(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission(plugin.getConfig().getString("set-name"))){
                if(args.length == 0){
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesConfig.get().getString("prefix"))
                            + ChatColor.translateAlternateColorCodes('&', MessagesConfig.get().getString("missing-args")));
                }else if(args.length == 1){
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesConfig.get().getString("prefix"))
                            + ChatColor.translateAlternateColorCodes('&', MessagesConfig.get().getString("displayname-self") +
                            ChatColor.translateAlternateColorCodes('&', args[0])));
                    p.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[0]));
                }else if(args.length == 2){
                    Player t = p.getServer().getPlayer(args[0]);

                    String Osender = PlaceholderAPI.setPlaceholders(t, MessagesConfig.get().getString("displayname-other-sender"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesConfig.get().getString("prefix") + Osender +
                            ChatColor.translateAlternateColorCodes('&', args[1])));
                    String other = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("displayname-other"));
                    t.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesConfig.get().getString("prefix") + other +
                            ChatColor.translateAlternateColorCodes('&', args[1])));
                    t.setDisplayName(ChatColor.translateAlternateColorCodes('&', args[1]));
            }
            }else{
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesConfig.get().getString("no-permission")));
            }
        }else{
            System.out.println(MessagesConfig.get().getString("console-error"));
        }
    }
}
