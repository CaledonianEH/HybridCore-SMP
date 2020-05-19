/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */


package me.caledonian.hybridcore.commands.events;

import me.caledonian.hybridcore.files.MessagesConfig;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatFormat implements Listener {
    private JavaPlugin plugin;

    public ChatFormat(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    void test(AsyncPlayerChatEvent e){
        e.getFormat();
        Player p = e.getPlayer();
        String chat = PlaceholderAPI.setPlaceholders(p, MessagesConfig.get().getString("no-permission"));
        e.setFormat(ChatColor.translateAlternateColorCodes('&', "&f" + p.getDisplayName() + "&8: &f" + e.getMessage()));
    }
}
