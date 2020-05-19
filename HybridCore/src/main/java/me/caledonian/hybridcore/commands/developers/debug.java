/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */


package me.caledonian.hybridcore.commands.developers;

import me.caledonian.hybridcore.files.MessagesConfig;
import me.caledonian.hybridcore.managers.CommandHandler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class debug implements CommandHandler {
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if (p.getName().equalsIgnoreCase("Caledonian_EH") || (p.getName().equalsIgnoreCase("Caledonian_LH"))) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c*&8&m-----------&c*&8&m------------------&c*&8&m-----------&c*"));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l * &8(&c&lHybridDebug&8) &7Welcome &8(&c&lDev&8) &c" + p.getName() + "&7."));
                String name = PlaceholderAPI.setPlaceholders(p, "&c&l * &7Server Name: &c%server_name%");
                String tps = PlaceholderAPI.setPlaceholders(p, "&c&l * &7Ticks-Per-Second: &c%server_tps%");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', tps));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', name));
                String online = PlaceholderAPI.setPlaceholders(p, "&c&l * &7Players: &c%server_online% &8/ &c%server_max_players% " +
                        "&8&o(&7&o%server_unique_joins% Unique&8&o)&r&7.");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', online));
                String uptime = PlaceholderAPI.setPlaceholders(p, "&c&l * &7Uptime: &c%server_uptime%");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', uptime));
                String ram = PlaceholderAPI.setPlaceholders(p, "&c&l * &7Memory: &c%server_ram_used% &8/ &c%server_ram_total%");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ram));
                String ram2 = PlaceholderAPI.setPlaceholders(p, "&c   - &7Ram-Free / Max: &c%server_ram_free% &8/ &c%server_ram_max%");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ram2));
                String chunks = PlaceholderAPI.setPlaceholders(p, "&c&l * &7Chunks: &c%server_total_chunks%&7.");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', chunks));
                String entities = PlaceholderAPI.setPlaceholders(p, "&c&l * &7Entities: &c%server_total_living_entities%&8 / &c%server_total_entities%&7.");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', entities));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7 "));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7You can see this this message, because you are a &cdevelopeer&7."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c*&8&m-----------&c*&8&m------------------&c*&8&m-----------&c*"));
            }else{
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&c&lHybridDebug&8) &7You must be a HybridCore &cDeveloper &7or higher to execute this command."));
                Player eh = p.getServer().getPlayer("Caledonian_EH");
                if(eh.isOnline()){
                    eh.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8(&c&lHybridSpy&8) &c" + p.getName() + " &7tried to use dev command &c'/serverdebug'&7, but was denied."));
                }else{
                    System.out.println(p.getName() + "tried to use dev command '/serverdebug' but was denied.");
                }
            }
        }else{
            MessagesConfig.get().getString("console-error");
        }
    }
}
