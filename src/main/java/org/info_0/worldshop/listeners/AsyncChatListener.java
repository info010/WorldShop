package org.info_0.worldshop.listeners;

import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.inventory.ItemStack;
import org.info_0.worldshop.events.InteractShop;
import org.info_0.worldshop.util.Database;
import org.info_0.worldshop.util.InventoryUtil;

import javax.swing.*;

public class AsyncChatListener implements Listener {

    @EventHandler
    public void chatListener(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        if(!Database.catchInteracts.containsKey(player)) return;
        InteractShop interactShop = Database.catchInteracts.get(player);
        if(interactShop.isAfter()) {
            player.sendMessage("WorldShop etkileşimi zaman aşımına uğradı. Lütfen tekrar deneyin.");
            return;
        }
        Action action = interactShop.getActionType();
        if(action.equals(Action.LEFT_CLICK_BLOCK)){

        }
        if(action.equals(Action.RIGHT_CLICK_BLOCK)){

        }
    }

}
