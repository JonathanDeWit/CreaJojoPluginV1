package be.creajojo.creajojopluginv1;

import be.creajojo.creajojopluginv1.events.listeners.MobEventListener;
import be.creajojo.creajojopluginv1.events.listeners.PlayerEventListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class CreaJojoPluginV1 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getLogger().info("Start Crea jojo plugin");

        // Add username color event
        this.getServer().getPluginManager().registerEvents(new PlayerEventListener(), this);
        this.getServer().getPluginManager().registerEvents(new MobEventListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("Stop Crea jojo plugin");
    }
}
