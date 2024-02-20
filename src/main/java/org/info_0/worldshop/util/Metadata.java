package org.info_0.worldshop.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.info_0.worldshop.WorldShop;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Metadata {

    private static final FileConfiguration config = WorldShop.getInstance().getConfig();

    public static List<Material> allowShopData(){
        List<Material> materials = new ArrayList<>();
        for (String string : config.getStringList("allowShopData")) materials.add(Material.valueOf(string.toUpperCase()));
        return materials;
    }

    public static boolean hasShopData(Block block){
        return block.hasMetadata("SHOP-DATA");
    }

    public static boolean isShopBlock(Block block){
        return block.getMetadata("SHOP-DATA").get(0).asBoolean();
    }

    public static void setShopData(Block block, boolean setShop){
        block.getMetadata("SHOP-DATA").set(0, new FixedMetadataValue(WorldShop.getInstance(), setShop));
    }

    public static void addShopData(Block block){
        block.setMetadata("SHOP-DATA", new FixedMetadataValue(WorldShop.getInstance(), false));
    }

    public static void setOwner(Block block, Player player){
        String uuid = player.getUniqueId().toString();
        block.setMetadata("SHOP-OWNER", new FixedMetadataValue(WorldShop.getInstance(), uuid));
    }

    public static Player getOwner(Block block){
        String uuid = block.getMetadata("SHOP-OWNER").get(0).asString();
        return Bukkit.getPlayer(uuid);
    }

    public static void createShopUUID(Block block){
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        block.setMetadata("SHOP-UUID", new FixedMetadataValue(WorldShop.getInstance(), uuidAsString));
    }

    public static UUID getShopUUID(Block block){
        return UUID.fromString(block.getMetadata("SHOP-UUID").get(0).asString());
    }

    public static void setShopType(Block block, ShopType shopType){
        String type = shopType.toString();
        block.setMetadata("SHOP-TYPE", new FixedMetadataValue(WorldShop.getInstance(), type));
    }

    public static ShopType getShopType(Block block){
        return ShopType.valueOf(block.getMetadata("SHOP-TYPE").get(0).asString());
    }


}
