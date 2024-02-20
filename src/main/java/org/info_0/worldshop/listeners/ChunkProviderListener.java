package org.info_0.worldshop.listeners;

import org.bukkit.block.BlockState;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;
import org.info_0.worldshop.util.Metadata;

public class ChunkProviderListener implements Listener {

    @EventHandler
    public static void provideChunk(ChunkPopulateEvent event) {
        if(event.getChunk().isLoaded()) return;
        BlockState[] blockStates = event.getChunk().getTileEntities();
        for(BlockState blockState : blockStates){
            if(!Metadata.allowShopData().contains(blockState.getType())) continue;
            if(Metadata.hasShopData(blockState.getBlock())) continue;
            Metadata.addShopData(blockState.getBlock());
        }
    }

}
