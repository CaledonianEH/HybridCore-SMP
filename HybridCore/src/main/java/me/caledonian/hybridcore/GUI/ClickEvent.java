/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.GUI;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClickEvent implements Listener {

    public void clickEvent(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&cPlayer &fstatistics"))){
            e.setCancelled(true);

        }
    }
}
