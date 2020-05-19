/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.managers;

import me.caledonian.hybridcore.GUI.StatGUI;
import me.caledonian.hybridcore.commands.*;
import me.caledonian.hybridcore.commands.admin.*;
import me.caledonian.hybridcore.commands.developers.debug;
import me.caledonian.hybridcore.commands.gamemode.*;
import me.caledonian.hybridcore.commands.reactions.*;
import me.caledonian.hybridcore.files.ReloadCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class CommandManager implements CommandExecutor {
    private Map<String, CommandHandler> commands = new HashMap<>();
    private JavaPlugin javaPlugin;
    public CommandManager(JavaPlugin javaPlugin){
        this.javaPlugin = javaPlugin;
        initCommands();
    }
    private void initCommands(){
        // Core commands
        commands.put("hybridcore", new HybridCoreCmd(javaPlugin));
        commands.put("signedit", new SignEdit());
        commands.put("discord", new DiscordCommand(javaPlugin));
        // Developer
        commands.put("serverinfo", new ServerInfo(javaPlugin));
        commands.put("testing", new StatGUI());
        commands.put("serverdebug", new debug());
        // Admin
        commands.put("nick", new DisplayName(javaPlugin));
        commands.put("bc", new Broadcast());
        // Gamemode
        commands.put("c", new CreativeCommand(javaPlugin));
        commands.put("a", new AdventureCommand(javaPlugin));
        commands.put("sp", new SpectatorCommand(javaPlugin));
        commands.put("s", new SurvivalCommand(javaPlugin));
        commands.put("feed", new FeedCommand(javaPlugin));
        commands.put("heal", new HealCommand(javaPlugin));
        commands.put("fly", new FlyCommand(javaPlugin));
        // Files
        commands.put("hcrl", new ReloadCommand(javaPlugin));
        // Reactions
        commands.put("f", new PayRespects(javaPlugin));
        commands.put("nf", new NoRespects(javaPlugin));
        commands.put("bruh", new Bruh(javaPlugin));
        commands.put("sleep", new Sleep(javaPlugin));
        commands.put("gg", new GoodGame());
        commands.put("ugly", new Ugly());
        commands.put("swamp", new Swamp());
        commands.put("burn", new BurntKetchup(javaPlugin));
        commands.put("doubt", new Doubt());
        commands.put("rip", new RIP(javaPlugin));
        // Other
        commands.put("anoy", new Sound());
        // Register
        registerCommands();
    }
    private void registerCommands() { commands.forEach((s, c) -> javaPlugin.getCommand(s).setExecutor(this));}

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String cmdname = command.getName();
        CommandHandler commandHandler = commands.get(cmdname);
        if(commandHandler != null) commandHandler.execute(sender, command,args);
        return false;
    }
}
