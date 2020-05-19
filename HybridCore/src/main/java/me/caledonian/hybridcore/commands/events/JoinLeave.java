/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */


package me.caledonian.hybridcore.commands.events;

import me.caledonian.hybridcore.files.MessagesConfig;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class JoinLeave implements Listener {
    public JoinLeave(){
    }
    @EventHandler
    void PlayerJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        String joinMessage = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("join-message"));
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(joinMessage)));
    }
    @EventHandler
    void PlayerLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        String quitmessage = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("leave-message"));
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', quitmessage));
    }
}
