package org.info_0.worldshop.listeners;

import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.info_0.worldshop.util.Metadata;

public class BlockPlaceListener implements Listener {

    @EventHandler
    public void placeEvent(BlockPlaceEvent event){
        if(event.isCancelled()) return;
        Block block = event.getBlock();
        if(!Metadata.allowShopData().contains(block.getType())) return;
        Metadata.addShopData(block);
    }

}
