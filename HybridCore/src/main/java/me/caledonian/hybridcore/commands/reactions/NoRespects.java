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

public class NoRespects implements CommandHandler {
    private JavaPlugin plugin;
    public NoRespects(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            String noRespects = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("no-respects"));
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', noRespects));
        }else{
            System.out.println(plugin.getConfig().getString("console-error"));
        }
    }
}
