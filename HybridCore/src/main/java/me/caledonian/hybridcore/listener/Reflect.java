/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.listener;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class Reflect {
	public static Class<?> getNMSClass(String name) throws ClassNotFoundException {
		return Class.forName("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + name);
	}
	
	public static void sendPacket(Player player, Object packet) {
		try {
			Class<?> entityPlayerClass = getNMSClass("EntityPlayer");
			Class<?> playerConnectionClass = getNMSClass("PlayerConnection");
			Class<?> packetClass = Reflect.getNMSClass("Packet");
			
			Method getHandlePlayerMethod = player.getClass().getDeclaredMethod("getHandle");
			Field playerConnectionField = entityPlayerClass.getDeclaredField("playerConnection");
			Method sendPacketMethod = playerConnectionClass.getMethod("sendPacket", packetClass);
			
			Object newPlayer = getHandlePlayerMethod.invoke(player);
			Object playerConnection = playerConnectionField.get(newPlayer);
			sendPacketMethod.invoke(playerConnection, packet);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
}
