package org.info_0.worldshop.listeners;

import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.info_0.worldshop.events.InteractShop;
import org.info_0.worldshop.util.Database;
import org.info_0.worldshop.util.InventoryUtil;
import org.info_0.worldshop.util.Metadata;

public class PlayerInteractListener implements Listener {

    @EventHandler
    public void interactEvent(PlayerInteractEvent event){
        Action action = event.getAction();
        if(!(action.equals(Action.RIGHT_CLICK_BLOCK) || action.equals(Action.LEFT_CLICK_BLOCK))) return;
        Block block = event.getClickedBlock();
        assert block != null;
        if(!Metadata.hasShopData(block)) return;
        Player player = event.getPlayer();
        if(!(player.getInventory().getItemInMainHand().getType().isAir() || player.getInventory().getItemInMainHand().getType() == null)) return;
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        InteractShop interactShop = new InteractShop(event.getPlayer(), block, action, itemStack);
        Database.catchInteracts.put(player,interactShop);
        if(action.equals(Action.LEFT_CLICK_BLOCK)){
            Block shopBlock = interactShop.getInteractedBlock();
            if(Metadata.isShopBlock(shopBlock)) {
                if(!(shopBlock.getState() instanceof Container)) return;
                Container container = (Container) interactShop.getInteractedBlock().getState();
                ItemStack item= interactShop.getInteractedItemStack();
                int freeSpace = InventoryUtil.invSpace(container.getInventory() ,item);
                player.sendMessage(String.format("Elinizde %s adet %s bulunmakta.",item.getItemMeta().getDisplayName()));
                player.sendMessage(String.format("Market oluşturmak için sohbete fiyatı giriniz. Bu market %s kadar boş alana sahip.",freeSpace));
            }else {


            }
        }
    }

}
