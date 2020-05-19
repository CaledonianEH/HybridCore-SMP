/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.managers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public interface CommandHandler {
    void execute (CommandSender sender, Command command, String[] args);
}
