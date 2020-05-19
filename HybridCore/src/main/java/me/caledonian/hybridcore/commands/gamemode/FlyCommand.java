/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */


package me.caledonian.hybridcore.commands.gamemode;

import me.caledonian.hybridcore.files.MessagesConfig;
import me.caledonian.hybridcore.managers.CommandHandler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class FlyCommand implements CommandHandler {
    private ArrayList<Player> flying = new ArrayList<>();
    private JavaPlugin plugin;
    public FlyCommand(JavaPlugin plugin) { this.plugin = plugin; }

    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        String noPerm = MessagesConfig.get().getString("no-permission");
        String prefix = MessagesConfig.get().getString("prefix");
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 0){
                if(p.hasPermission(plugin.getConfig().getString("fly"))){
                    if(p.isFlying()){
                        String flySelfDisable = PlaceholderAPI.setPlaceholders(p, plugin.getConfig().getString("fly-self-disable"));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', flySelfDisable));
                        p.setFlying(false);
                    }else if(!p.isFlying()){
                        String flySelfEnable = PlaceholderAPI.setPlaceholders(p, plugin.getConfig().getString("fly-self-enable"));
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', flySelfEnable));
                        p.setFlying(true);
                    }
                }else{
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', noPerm));
                }
            }else if(args.length == 1){
                Player t = p.getServer().getPlayer(args[0]);
                if(t.isOnline()){
                    if(p.hasPermission(plugin.getConfig().getString("fly-others"))){
                        if(t.isFlying()){
                            String flyOtherDisable = PlaceholderAPI.setPlaceholders(p, plugin.getConfig().getString("fly-other-disable"));
                            t.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', flyOtherDisable));
                            String flyOtherDisableSender = PlaceholderAPI.setPlaceholders(t, plugin.getConfig().getString("fly-other-disable-sender"));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', flyOtherDisableSender));
                            t.setFlying(false);
                        }else if(!t.isFlying()){
                            String flyOtherEnable = PlaceholderAPI.setPlaceholders(p, plugin.getConfig().getString("fly-other-enable"));
                            t.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', flyOtherEnable));
                            String flyOtherEnableSender = PlaceholderAPI.setPlaceholders(t, plugin.getConfig().getString("fly-other-disable-sender"));
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', flyOtherEnableSender));
                            t.setFlying(false);
                        }
                    }else{
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', noPerm));
                    }
                }else{
                    String playerNotFound = PlaceholderAPI.setPlaceholders(t, plugin.getConfig().getString("player-not-found"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', playerNotFound));
                }
            }
        }else{
            System.out.println(plugin.getConfig().getString("console-deny"));
        }
    }
}
