package dev.Fjc.invisItemFrame.listeners;

import dev.Fjc.invisItemFrame.builders.frames.Frame;
import dev.Fjc.invisItemFrame.builders.frames.Keys;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Hanging;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.persistence.PersistentDataType;

public class Break implements Listener {

    @EventHandler
    public void onFrameBreak(HangingBreakEvent event) {
        Hanging target = event.getEntity();
        if (target.getPersistentDataContainer().has(Keys.invisKey, PersistentDataType.BYTE)) {
            event.setCancelled(true);

            if (target.getType() == EntityType.ITEM_FRAME) {
                target.remove();
                target.getWorld().dropItemNaturally(target.getLocation(), Frame.getInvisFrame(1, true, false));
            }
            else if (target.getType() == EntityType.GLOW_ITEM_FRAME) {
                target.remove();
                target.getWorld().dropItemNaturally(target.getLocation(), Frame.getInvisFrame(1, true, true));
            }
        }
    }
}
