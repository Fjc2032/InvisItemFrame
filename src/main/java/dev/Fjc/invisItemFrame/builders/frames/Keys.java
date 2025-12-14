package dev.Fjc.invisItemFrame.builders;

import dev.Fjc.invisItemFrame.InvisItemFrame;
import org.bukkit.NamespacedKey;

public abstract class Keys {
    private static InvisItemFrame plugin = InvisItemFrame.getInstance();

    public static NamespacedKey invisKey = new NamespacedKey(plugin, "invisible");
}
