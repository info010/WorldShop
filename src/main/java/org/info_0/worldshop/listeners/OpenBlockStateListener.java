package org.info_0.worldshop.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.info_0.worldshop.events.InteractShop;
import org.info_0.worldshop.util.Database;
import org.info_0.worldshop.util.Metadata;

public class OpenBlockStateListener implements Listener {

    @EventHandler
    public void openBlockState(InventoryOpenEvent event){
        if(!Metadata.allowShopData().contains(Material.valueOf(event.getInventory().getType().name()))) return;
        Player player = (Player) event.getPlayer();
        InteractShop interactShop = Database.catchInteracts.get(player);
    }

}
