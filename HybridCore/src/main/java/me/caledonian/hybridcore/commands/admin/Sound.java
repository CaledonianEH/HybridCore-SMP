/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */


package me.caledonian.hybridcore.commands.admin;

import me.caledonian.hybridcore.files.MessagesConfig;
import me.caledonian.hybridcore.managers.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sound implements CommandHandler {
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("hybridcore.bob")){
                if(args.length == 0){
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "bob"));
                }else if(args.length == 1){
                    Player t = p.getServer().getPlayer(args[0]);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou have anoyed"));
                    assert t != null;
                    t.sendMessage(ChatColor.translateAlternateColorCodes('&', "&chas anoyed you"));
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.BLOCK_ANVIL_LAND, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.BLOCK_ANVIL_LAND, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.BLOCK_ANVIL_LAND, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.BLOCK_ANVIL_LAND, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.BLOCK_ANVIL_LAND, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.BLOCK_ANVIL_LAND, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.BLOCK_ANVIL_LAND, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.BLOCK_ANVIL_LAND, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.BLOCK_ANVIL_LAND, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.BLOCK_ANVIL_LAND, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_GHAST_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_GHAST_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_GHAST_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_GHAST_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_GHAST_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_GHAST_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_GHAST_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_GHAST_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_GHAST_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_GHAST_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_WITHER_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_WITHER_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_WITHER_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_WITHER_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_WITHER_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_WITHER_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_WITHER_DEATH, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_SCREAM, 100, 100);
                    t.playSound(t.getLocation(), org.bukkit.Sound.ENTITY_ENDERMAN_SCREAM, 100, 100);

                }
            }
        }else{
            System.out.println(MessagesConfig.get().getString("console-error"));
        }
    }
}
