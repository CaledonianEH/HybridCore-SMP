/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessagesConfig {
    private static File file;
    private static FileConfiguration messages;
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("HybridCore").getDataFolder(), "messages.yml");
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
            }
        }
        messages = YamlConfiguration.loadConfiguration(file);
    }
    public static FileConfiguration get(){
        return messages;
    }
    public static void save(){
        try{
            messages.save(file);
        }catch(IOException e){
            System.out.println("Couldn't save file [messages.yml]");
        }
    }
    public static void reload(){
        messages = YamlConfiguration.loadConfiguration(file);
    }
}
