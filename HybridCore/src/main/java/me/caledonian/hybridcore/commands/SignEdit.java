/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.commands;

import me.caledonian.hybridcore.managers.CommandHandler;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SignEdit implements CommandHandler {
    @Override
    public void execute(CommandSender sender, Command command, String[] args) {
        if(sender instanceof Player){
            Player p = (Player) sender;
            p.sendMessage(ChatColor.DARK_GRAY + "(" + ChatColor.RED + "HybridCore" + ChatColor.DARK_GRAY + ")" + ChatColor.GRAY + " This server is running SignEdit by Pepper.");
        }else{
            System.out.println("This server is using SignEdit by Pepper");
        }
    }
}
