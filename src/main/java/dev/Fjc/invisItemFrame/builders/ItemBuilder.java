package dev.Fjc.invisItemFrame.builders;

import dev.Fjc.invisItemFrame.builders.frames.Keys;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemBuilder {

    private final ItemStack item;
    private final ItemMeta meta;

    public ItemBuilder(ItemStack item) {
        this.item = item;
        this.meta = item.getItemMeta();
    }

    public ItemBuilder(@NotNull Material material, int amount) {
        this.item = ItemStack.of(material, amount);
        this.meta = item.getItemMeta();
    }

    /**
     * Sets the item invisible.
     * @return This {@link ItemBuilder}, for chaining.
     */
    public ItemBuilder setInvis() {
        if (meta == null) return this;

        PersistentDataContainer container = meta.getPersistentDataContainer();
        container.set(Keys.invisKey, PersistentDataType.BYTE, Keys.b);

        item.setItemMeta(meta);
        return this;
    }

    /**
     * Sets the name of this item.
     * @param name The name
     * @return This {@link ItemBuilder}, for chaining.
     */
    public ItemBuilder setName(String name) {
        meta.displayName(PlainTextComponentSerializer.plainText().deserialize(name));
        item.setItemMeta(meta);

        return this;
    }

    /**
     * Adds an enchantment to this item.
     * @param enchantment The enchantment
     * @param level The level of the enchantment
     * @return This {@link ItemBuilder}, for chaining.
     */
    public ItemBuilder addEnchant(@NotNull Enchantment enchantment, int level) {
        meta.addEnchant(enchantment, level, true);
        item.setItemMeta(meta);

        return this;
    }

    /**
     * Adds flags to an item that can reveal or hide certain information about an item.
     * @param flags The flags to add
     * @return This {@link ItemBuilder}, for chaining.
     */
    public ItemBuilder addItemFlag(ItemFlag... flags) {
        meta.addItemFlags(flags);
        item.setItemMeta(meta);

        return this;
    }

    /**
     * Adds lore to an item
     * @param line The lore
     * @return This {@link ItemBuilder}, for chaining
     */
    public ItemBuilder addLoreLine(String line) {
        if (meta.hasLore()) {
            List<Component> lore = meta.lore();
            if (lore == null) return this;
            lore.add(PlainTextComponentSerializer.plainText().deserialize(line));
        }

        item.setItemMeta(meta);
        return this;
    }

    /**
     * Builds the resulting ItemStack after applying chained properties.
     * @return The new {@link ItemStack}, or null if the item or its metadata is null.
     */
    public ItemStack build() {
        if (item != null && meta != null) return item;

        return null;
    }
}
