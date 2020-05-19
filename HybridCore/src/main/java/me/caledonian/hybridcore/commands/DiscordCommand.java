/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.commands;

import me.caledonian.hybridcore.files.MessagesConfig;
import me.caledonian.hybridcore.managers.CommandHandler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class DiscordCommand implements CommandHandler {
    private JavaPlugin plugin;

    public DiscordCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        String prefix = MessagesConfig.get().getString("prefix");
        String noperm = MessagesConfig.get().getString("no-permission");
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission(plugin.getConfig().getString("discord"))){
                String discordLink = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("discord-link"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', discordLink));
            }else{
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', prefix) + ChatColor.translateAlternateColorCodes('&', noperm));
            }
        }
    }
}
