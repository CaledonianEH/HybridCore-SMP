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

public class ServerInfo implements CommandHandler {
    private JavaPlugin plugin;

    public ServerInfo(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.getName().equalsIgnoreCase("Caledonian_EH") || (p.getName().equalsIgnoreCase("Caledonian_LH"))) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c*&8&m-----------&c*&8&m------------------&c*&8&m-----------&c*"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 "));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Hello &8(&c&lDev&8) &c" + p.getName() + "&7!"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7This server is currently running version &c" + Bukkit.getBukkitVersion() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Server Name: &c" + Bukkit.getServer().getName() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Game Port: &c" + Bukkit.getPort() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Server IP: &c" + Bukkit.getIp() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 "));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&o Only you can see this message, because you are a developer."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c*&8&m-----------&c*&8&m------------------&c*&8&m-----------&c*"));
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&c&lHybridCore&8) &7You MUST be a HybridCore &cDeveloper &7or higher to view this information."));
            }
        }
    }
}
