package dev.Fjc.invisItemFrame.builders.frames;

import dev.Fjc.invisItemFrame.builders.ItemBuilder;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

/**
 * Represents an abstract supplier of invisible item frames.
 */
public abstract class Frame {

    /**
     * Returns an invisible item frame with the set properties.
     * @param amount The amount of frames
     * @param enchanted Whether the frame should be enchanted
     * @param glowing Whether a glowing item frame should be used
     * @return The item frame, as an ItemStack
     */
    public static ItemStack getInvisFrame(int amount, boolean enchanted, boolean glowing) {
        String name = ChatColor.translateAlternateColorCodes('&', "&eInvisible Item Frame");
        ItemBuilder builder = new ItemBuilder((glowing ? Material.GLOW_ITEM_FRAME : Material.ITEM_FRAME), amount);
        if (enchanted) {
            return builder
                    .setName(name)
                    .setInvis()
                    .addEnchant(Enchantment.POWER, 1)
                    .addItemFlag(ItemFlag.HIDE_ENCHANTS)
                    .build();
        }
        else {
            return builder
                    .setName(name)
                    .setInvis()
                    .build();
        }
    }
}
