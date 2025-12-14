package dev.Fjc.invisItemFrame.listeners;

import dev.Fjc.invisItemFrame.builders.frames.Keys;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Hanging;
import org.bukkit.entity.ItemFrame;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class Place implements Listener {

    @EventHandler
    public void onHangingPlace(HangingPlaceEvent event) {
        Hanging target = event.getEntity();
        Player player = event.getPlayer();
        if (target.getType() != EntityType.ITEM_FRAME && target.getType() != EntityType.GLOW_ITEM_FRAME) return;
        if (player == null) return;

        ItemStack hand = player.getInventory().getItemInMainHand();
        ItemStack off = player.getInventory().getItemInOffHand();
        ItemStack frame = null;

        if (hand.getType() == Material.ITEM_FRAME || hand.getType() == Material.GLOW_ITEM_FRAME)
            frame = hand;
        else if (off.getType() == Material.ITEM_FRAME || off.getType() == Material.GLOW_ITEM_FRAME)
            frame = off;

        if (frame == null) return;
        PersistentDataContainer container = frame.getItemMeta().getPersistentDataContainer();
        if (container.has(Keys.invisKey, PersistentDataType.BYTE)) {
            ItemFrame itemFrame = (ItemFrame) target;
            itemFrame.setVisible(false);


            target.getPersistentDataContainer().set(Keys.invisKey, PersistentDataType.BYTE, Keys.b);
        }
    }
}
