package org.info_0.worldshop.events;

import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.info_0.worldshop.WorldShop;

import java.time.LocalDateTime;

public class InteractShop {

    private final FileConfiguration config = WorldShop.getInstance().getConfig();

    private final Player interactorPlayer;
    private final Block interactedBlock;
    private final Action actionType;
    private final ItemStack interactedItemStack;
    private LocalDateTime interactTimeOut;


    public InteractShop(Player interacterPlayer, Block interactedBlock, Action actionType, ItemStack interactedItemStack){
        this.interactorPlayer = interacterPlayer;
        this.interactedBlock = interactedBlock;
        this.actionType = actionType;
        this.interactedItemStack = interactedItemStack;
        this.interactTimeOut = localDateTime();
    }

    private LocalDateTime localDateTime(){
        return LocalDateTime.now().plusSeconds(config.getInt("interactDelay"));
    }

    public boolean isAfter(){
        return LocalDateTime.now().isAfter(interactTimeOut);
    }

    public void resetTimeOut(){
        this.interactTimeOut = localDateTime();
    }

    public Player getInteractorPlayer(){
        return interactorPlayer;
    }
    public Block getInteractedBlock(){
        return interactedBlock;
    }
    public Action getActionType(){
        return actionType;
    }
    public ItemStack getInteractedItemStack() {
        return interactedItemStack;
    }
    public LocalDateTime getInteractTimeOut(){
        return interactTimeOut;
    }
}
