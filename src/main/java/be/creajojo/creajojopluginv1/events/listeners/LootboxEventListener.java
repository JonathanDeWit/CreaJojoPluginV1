package be.creajojo.creajojopluginv1.events.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;

import java.util.Random;

public class LootboxEventListener implements Listener {

    private final Random random = new Random();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        // Define the location of the chest
        Location chestLocation = new Location(player.getWorld(), 7, 63, 3);  // x, y, z coords

        // Check if there's a block at the location
        Block block = chestLocation.getBlock();

        // If the block is not a chest, set it to a chest
        if (block.getType() != Material.CHEST) {
            block.setType(Material.CHEST);
        }

        Chest chest = (Chest) block.getState();

        // Randomly select an item set to add to the chest
        int choice = random.nextInt(3);  // Returns an integer between 0 (inclusive) and 3 (exclusive)

        switch (choice) {
            case 0:
                chest.getInventory().addItem(new ItemStack(Material.NETHERITE_INGOT, getRandomValue(1, 3)));

                break;

            case 1:
                chest.getInventory().addItem(new ItemStack(Material.IRON_INGOT, getRandomValue(3, 30)));
                chest.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, getRandomValue(10, 40)));
                break;

            case 2:
                chest.getInventory().addItem(new ItemStack(Material.QUARTZ, getRandomValue(15, 40)));
                chest.getInventory().addItem(new ItemStack(Material.OBSIDIAN, getRandomValue(4, 15)));
                chest.getInventory().addItem(new ItemStack(Material.DIAMOND, getRandomValue(1, 15)));
                chest.getInventory().addItem(new ItemStack(Material.SLIME_BLOCK, getRandomValue(3, 10)));
                chest.getInventory().addItem(new ItemStack(Material.OAK_WOOD, getRandomValue(32, 64)));
                break;

            default:
                // This shouldn't be reached, but you could handle an unexpected choice here if desired
                break;
        }
    }

    /**
     * Helper method to get a random value between the given bounds (inclusive).
     *
     * @param min The minimum bound.
     * @param max The maximum bound.
     * @return A random value between the given bounds.
     */
    private int getRandomValue(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }


}
