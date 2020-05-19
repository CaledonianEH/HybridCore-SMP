/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore;

import me.caledonian.hybridcore.GUI.ClickEvent;
import me.caledonian.hybridcore.commands.events.JoinLeave;
import me.caledonian.hybridcore.commands.events.OpEvent;
import me.caledonian.hybridcore.files.*;
import me.caledonian.hybridcore.listener.ReflectSignEventListener;
import me.caledonian.hybridcore.managers.CommandManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class HybridCore extends JavaPlugin {
    private JavaPlugin javaPlugin;

    @Override
    public void onEnable() {
        new CommandManager(this);
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        BootSetup.msg();
        BootSetup.gui();
        Bukkit.getServer().getPluginManager().registerEvents(new OpEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinLeave(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ReflectSignEventListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new ClickEvent(), this);
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Enabling HybridCore v1.0-RELEASE by Caledonian EH");

    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.RED + "Disabling HybridCore v1.0-RELEASE by Caledonian EH");
    }
}
