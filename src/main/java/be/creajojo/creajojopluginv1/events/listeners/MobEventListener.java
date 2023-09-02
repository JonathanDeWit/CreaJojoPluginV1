package be.creajojo.creajojopluginv1.events.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class MobEventListener implements Listener {


    private int safeZoneMinX = -100; // Replace with your actual coordinates
    private int safeZoneMaxX = 100;
    private int safeZoneMinZ = -100;
    private int safeZoneMaxZ = 100;
    private int safeZoneMinY = 50;   // Minimum Y coordinate
    private int safeZoneMaxY = 100; // Maximum Y coordinate


    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        double x = event.getLocation().getX();
        double y = event.getLocation().getY();
        double z = event.getLocation().getZ();

        if (x >= safeZoneMinX && x <= safeZoneMaxX &&
                y >= safeZoneMinY && y <= safeZoneMaxY &&
                z >= safeZoneMinZ && z <= safeZoneMaxZ) {
            event.setCancelled(true); // Prevent mobs from spawning in the safe zone
        }
    }

}
