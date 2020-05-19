/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.GUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class FillerGlass {
    public static void white() {
        ItemStack white = new ItemStack(Material.WHITE_STAINED_GLASS_PANE);
        ItemMeta whiteItemMeta = white.getItemMeta();
        whiteItemMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
                ""));
        ArrayList<String> whiteLore = new ArrayList<>();
        whiteLore.add(ChatColor.translateAlternateColorCodes('&',
                ""));
        whiteItemMeta.setLore(whiteLore);
        white.setItemMeta(whiteItemMeta);
    }
}
