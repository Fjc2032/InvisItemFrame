package dev.Fjc.invisItemFrame;

import dev.Fjc.invisItemFrame.cmd.GetInvisFrameCommand;
import dev.Fjc.invisItemFrame.listeners.Break;
import dev.Fjc.invisItemFrame.listeners.Place;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class InvisItemFrame extends JavaPlugin {

    private static InvisItemFrame instance;

    @Override
    public void onEnable() {
        instance = this;

        registerEvent(new Break());
        registerEvent(new Place());
        this.getServer().getPluginCommand("invisframes").setExecutor(new GetInvisFrameCommand());
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void registerEvent(Listener listener) {
        this.getServer().getPluginManager().registerEvents(listener, this);
    }

    public static InvisItemFrame getInstance() {
        return instance;
    }
}
