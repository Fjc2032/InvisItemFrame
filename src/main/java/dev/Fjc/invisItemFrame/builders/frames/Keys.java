package dev.Fjc.invisItemFrame.builders.frames;

import dev.Fjc.invisItemFrame.InvisItemFrame;
import org.bukkit.NamespacedKey;

public abstract class Keys {
    private static final InvisItemFrame plugin = InvisItemFrame.getInstance();

    public static NamespacedKey invisKey = new NamespacedKey(plugin, "invisible");
    public static final byte b = 1;
}
