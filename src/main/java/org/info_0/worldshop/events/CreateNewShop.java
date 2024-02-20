package org.info_0.worldshop.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.info_0.worldshop.WorldShop;

public class CreateNewShop {

    private static final FileConfiguration config = WorldShop.getInstance().getConfig();

    public static void setShop(Block shop, ItemStack item){
        if(!(shop.getType().equals(Material.TRAPPED_CHEST) || shop.getType().equals(Material.CHEST))) return;

    }

    private static void placeSign(Block block, ItemStack item, Player player, double price){

    }

}
