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

public class SurvivalCommand implements CommandHandler {
    private JavaPlugin plugin;

    public SurvivalCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            String prefix = MessagesConfig.get().getString("prefix");
            if (args.length == 0) {
                if (p.hasPermission(plugin.getConfig().getString("survival"))) {
                    p.setGameMode(GameMode.SURVIVAL);
                    String survivalSelf = PlaceholderAPI.setPlaceholders(p, plugin.getConfig().getString("survival-self"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', survivalSelf));
                } else {
                    String noperm = PlaceholderAPI.setPlaceholders(p, plugin.getConfig().getString("no-permission"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', noperm));
                }
            } else if (args.length == 1) {
                Player target = p.getServer().getPlayer(args[0]);
                if (p.hasPermission(plugin.getConfig().getString("survival-others"))) {
                    target.setGameMode(GameMode.SURVIVAL);
                    String survivalOtherSender = PlaceholderAPI.setPlaceholders(target, plugin.getConfig().getString("survival-other-sender"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', survivalOtherSender));
                    String survivalOther = PlaceholderAPI.setPlaceholders(p, plugin.getConfig().getString("survival-other"));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', survivalOther));
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
