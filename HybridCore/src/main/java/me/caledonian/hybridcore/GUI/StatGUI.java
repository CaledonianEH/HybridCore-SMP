/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.GUI;

import me.caledonian.hybridcore.files.GuiConfig;
import me.caledonian.hybridcore.files.MessagesConfig;
import me.caledonian.hybridcore.managers.CommandHandler;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class StatGUI implements CommandHandler {
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            if(p.hasPermission("hybridcore.admin")){
                String name = PlaceholderAPI.setPlaceholders(p, GuiConfig.get().getString("name"));
                Inventory inventory = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes(
                        '&', name));

                // Glass panes
                ItemStack red = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                ItemMeta redItemMeta = red.getItemMeta();
                redItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                        "&7 "));
                ArrayList<String> redLore = new ArrayList<>();
                redLore.add(ChatColor.translateAlternateColorCodes('&',
                        " "));
                redItemMeta.setLore(redLore);
                red.setItemMeta(redItemMeta);
                inventory.setItem(0, red);
                inventory.setItem(8, red);
                inventory.setItem(18, red);
                inventory.setItem(26, red);
                ItemStack white = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
                ItemMeta whiteItemMeta = white.getItemMeta();
                whiteItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                        "&7 "));
                ArrayList<String> whiteLore = new ArrayList<>();
                whiteLore.add(ChatColor.translateAlternateColorCodes('&',
                        " "));
                whiteItemMeta.setLore(whiteLore);
                white.setItemMeta(whiteItemMeta);
                inventory.setItem(1, white);
                inventory.setItem(7, white);
                inventory.setItem(9, white);
                inventory.setItem(17, white);
                inventory.setItem(19, white);
                inventory.setItem(25, white);
                ItemStack black = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                ItemMeta blackItemMeta = black.getItemMeta();
                blackItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                        "&7 "));
                ArrayList<String> blackLore = new ArrayList<>();
                blackLore.add(ChatColor.translateAlternateColorCodes('&',
                        ""));
                blackItemMeta.setLore(blackLore);
                black.setItemMeta(blackItemMeta);
                inventory.setItem(2, black);
                inventory.setItem(3, black);
                inventory.setItem(4, black);
                inventory.setItem(5, black);
                inventory.setItem(6, black);
                inventory.setItem(10, black);
                inventory.setItem(12, black);
                inventory.setItem(14, black);
                inventory.setItem(16, black);
                inventory.setItem(20, black);
                inventory.setItem(21, black);
                inventory.setItem(22, black);
                inventory.setItem(23, black);
                inventory.setItem(24, black);


                // Items
                ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta swordItemMeta = black.getItemMeta();
                String weapons = PlaceholderAPI.setPlaceholders(p, GuiConfig.get().getString("weapon-stats-name"));
                swordItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                        weapons));
                ArrayList<String> swordLore = new ArrayList<>();
                swordLore.add(ChatColor.translateAlternateColorCodes('&', ""));
                swordItemMeta.setLore(swordLore);
                sword.setItemMeta(swordItemMeta);
                inventory.setItem(11, sword);







                ItemStack[] items = {red, white, black, sword};
                p.openInventory(inventory);
            }else{
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', MessagesConfig.get().getString("no-permission")));
            }

        }else{
            System.out.println(MessagesConfig.get().getString("console-error"));
        }
    }
}
