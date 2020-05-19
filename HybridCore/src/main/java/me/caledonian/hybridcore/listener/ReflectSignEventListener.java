/*
 *  Copyright (c) 2020 HybridDevelopment, Caledonian EH - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *
 */

package me.caledonian.hybridcore.listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Event.Result;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.caledonian.hybridcore.listener.Reflect;

public class ReflectSignEventListener implements Listener {	
	@EventHandler(priority=EventPriority.LOW)
	public void playerInteractEvent(PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Block block = e.getClickedBlock();
			Player player = e.getPlayer();
			if (Tag.SIGNS.isTagged(block.getType()) && !player.isSneaking()) {
				Sign state = (Sign) block.getState();
				state.setEditable(true);
				state.update();
				
				try {
					Class<?> blockPositionClass = Reflect.getNMSClass("BlockPosition");
					Class<?> signPacketClass = Reflect.getNMSClass("PacketPlayOutOpenSignEditor");
					Constructor<?> blockPositionConstructor = blockPositionClass.getConstructor(int.class, int.class, int.class);
					Constructor<?> signPacketConstructor = signPacketClass.getConstructor(blockPositionClass);
					Object blockPosition = blockPositionConstructor.newInstance(block.getLocation().getBlockX(), block.getLocation().getBlockY(), block.getLocation().getBlockZ());
					Object signPacket = signPacketConstructor.newInstance(blockPosition);
					
					Reflect.sendPacket(player, signPacket);
					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (NoSuchMethodException e1) {
					e1.printStackTrace();
				} catch (SecurityException e1) {
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					e1.printStackTrace();
				} catch (InvocationTargetException e1) {
					e1.printStackTrace();
				}
				
				e.setUseInteractedBlock(Result.DENY);
				e.setUseItemInHand(Result.DENY);
				
				e.setCancelled(true);
			}
		}
	}
}
