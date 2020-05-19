/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.files;

public class MessagesDefault{
    public static void defaults(){
        MessagesConfig.get().addDefault("prefix", "&8(&c&lHybridCore&8) &7");
        MessagesConfig.get().addDefault("broadcast-format", "&8(&c&lHybridAlert&8) &c%player_name%&8: &7");
        MessagesConfig.get().addDefault("config-reload", "Reloading the &cHybridCore &7configuration.");
        MessagesConfig.get().addDefault("console-deny", "You must be a player to execute this command.");
        MessagesConfig.get().addDefault("player-not-found", "That player wasn''t found.");
        MessagesConfig.get().addDefault("missing-args", "You must supply &cmore &7arguments to &ccorrectly &7execute this command.");
        MessagesConfig.get().addDefault("no-permission", "You must be an &cAdmin &7or higher to execute this command.");
        MessagesConfig.get().addDefault("join-message", "&8(&a&lJoin&8) &a%player_name% &7joined the server.");
        MessagesConfig.get().addDefault("leave-message", "&8(&c&lQuit&8) &c%player_name% &7left the server.");
        MessagesConfig.get().addDefault("discord-link", "&b&lDISCORD: &7Join our server discord! &b&n&ohttps://discord.gg/sxcw4p");
        MessagesConfig.get().addDefault("fly-self-enable", "You enabled your flight");
        MessagesConfig.get().addDefault("fly-self-disable", "You disabled your flight.");
        MessagesConfig.get().addDefault("fly-other-enable", "Your flight was enabled by &c%player_name%&7.");
        MessagesConfig.get().addDefault("fly-other-disable", "Your flight was disabled by &c%player_name%&7.");
        MessagesConfig.get().addDefault("fly-other-enable-sender", "You enabled &c%player_name%''s &7flight.");
        MessagesConfig.get().addDefault("fly-other-disable-sender", "You disabled &c%player_name%''s &7flight.");
        MessagesConfig.get().addDefault("creative-self", "You set your gamemode to &cCreative&7.");
        MessagesConfig.get().addDefault("creative-other", "Your gamemode was set to &cCreative &7by &c%player_name%&7.");
        MessagesConfig.get().addDefault("creative-other-sender", "You set &c%player_name%''s &7gamemode to &cCreative&7.");
        MessagesConfig.get().addDefault("adventure-self", "You set your gamemode to &cAdventure&7.");
        MessagesConfig.get().addDefault("adventure-other", "Your gamemode was set to &cAdventure &7by &c%player_name%&7.");
        MessagesConfig.get().addDefault("adventure-other-sender", "You set &c%player_name%''s &7gamemode to &cAdventure");
        MessagesConfig.get().addDefault("spectator-self", "You set your gamemode to &cSpectator&7.");
        MessagesConfig.get().addDefault("spectator-other", "Your gamemode was set to &cSpectator &7by &c%player_name%&7.");
        MessagesConfig.get().addDefault("spectator-other-sender", "You set &c%player_name%''s &7gamemode &cSpectator&7.");
        MessagesConfig.get().addDefault("survival-self", "You set your gamemode to &cSurvival&7.");
        MessagesConfig.get().addDefault("survival-other", "Your gamemode was set to &cSurvival &7by &c%player-name%&7.");
        MessagesConfig.get().addDefault("survival-other-sender", "You set &c%player_name%''s &7gamemode to &cSurvival&7.");
        MessagesConfig.get().addDefault("feed-self", "You refilled your food bar");
        MessagesConfig.get().addDefault("feed-other", "Your food bar was refilled by &c%player_name%&7.");
        MessagesConfig.get().addDefault("feed-other-sender", "You refilled &c%player_name%''s &7food bar.");
        MessagesConfig.get().addDefault("heal-self", "You were healed");
        MessagesConfig.get().addDefault("heal-other", "You were healed by &c%player_name%&7.");
        MessagesConfig.get().addDefault("heal-other-sender", "You healed &c%player_name%&7.");
        MessagesConfig.get().addDefault("pay-respects", "&8(&a&lRespects&8) &a%player_name% &7has just paid their respects.");
        MessagesConfig.get().addDefault("no-respects", "&8(&c&l&mRespects&r&8) &c%player_name% &7has refused to pay their respects. Stop dying people.");
        MessagesConfig.get().addDefault("bruh", "&8(&d&lBruh&8) &d%player_name% &7has declared this as a &d&nBruh&r&7 moment.");
        MessagesConfig.get().addDefault("sleep", "&8(&b&lSleep&8) &b%player_name% &7has requested someone to sleep.");
        MessagesConfig.get().addDefault("good-game", "&8(&e&lSleep&8) &e%player_name% &7has declared this as a &e&nGood Game&r&7.");
        MessagesConfig.get().addDefault("ugly", "&8(&4&lUGLY&8) &c%player_name% &7has declared this to be &4&l&nUGLY!!!&r&7.");
        MessagesConfig.get().addDefault("swamp", "&8(&2&lSwamp&8) &2%player_name% &7is kindly asking you to &2&lGET OUTTA MY SWAMP.");
        MessagesConfig.get().addDefault("burnt-ketchup", "&8(&4&lBurnt&8) &4%player_name% &7has burnt the &4&nketchup&r&7.");
        MessagesConfig.get().addDefault("doubt", "&8(&6&lDoubt&8) &6%player_name% &7doubts that.");
        MessagesConfig.get().addDefault("rip", "&8(&7&l☠&8) &c%player_name% &7requests you to rest in peace.");
        MessagesConfig.get().addDefault("displayname-self", "You set your display name to &c");
        MessagesConfig.get().addDefault("displayname-other", "&c%player_name% &7 set your display name to &c");
        MessagesConfig.get().addDefault("displayname-other-sender", "You set &c%player_name%''s &7display name to &c");
    }
}
