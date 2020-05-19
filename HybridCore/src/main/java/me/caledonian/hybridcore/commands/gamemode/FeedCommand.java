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
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FeedCommand implements CommandHandler {
    private JavaPlugin plugin;

    public FeedCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            String prefix = MessagesConfig.get().getString("prefix");
            if (args.length == 0) {
                if (p.hasPermission(plugin.getConfig().getString("adventure"))) {
                    p.setFoodLevel(20);
                    String feedSelf = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("feed-self"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', feedSelf));
                } else {
                    String noperm = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("no-permission"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', noperm));
                }
            } else if (args.length == 1) {
                Player target = p.getServer().getPlayer(args[0]);
                if (p.hasPermission(plugin.getConfig().getString("adventure-others"))) {
                    target.setFoodLevel(20);
                    String feedothersender = PlaceholderAPI.setPlaceholders(target, MessagesConfig.get().getString("feed-other-sender"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', feedothersender));
                    String feedOther = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("feed-other"));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', feedOther));
                } else {
                    String noperm = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("no-permission"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', noperm));
                }
            } else {
                System.out.println(plugin.getConfig().getString("console-deny"));
            }
        }
    }
}
