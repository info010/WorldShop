package org.info_0.worldshop.util;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryUtil {

    public static int invSpace (Inventory inv, ItemStack item) {
        int count = 0;
        for (int slot = 0; slot < 36; slot ++) {
            ItemStack is = inv.getItem(slot);
            if (is == null) {
                count += item.getType().getMaxStackSize();
                continue;
            } else {
                if(is == item)
                    count += item.getType().getMaxStackSize() - is.getAmount();
            }
        }
        return count;
    }

    public static int getAmount(Inventory inv, ItemStack item) {
        if (inv == null)
            return 0;
        int amount = 0;
        for (int i = 0; i < 36; i++) {
            ItemStack slot = inv.getItem(i);
            if (slot == null || !slot.equals(item))
                continue;
            amount += slot.getAmount();
        }
        return amount;
    }

}
