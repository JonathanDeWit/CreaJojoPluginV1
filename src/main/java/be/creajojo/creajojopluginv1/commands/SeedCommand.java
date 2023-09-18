package be.creajojo.creajojopluginv1.commands;

import be.creajojo.creajojopluginv1.services.PlayerService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // Check if command is send by a user
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        // Check if the player is an operator
        if (!player.isOp()) {
            player.sendMessage("You do not have permission to use this command.");
            return true;
        }

        try {
            // Save command param
            float walkSpeed = Float.parseFloat(args[0]);

            // Change player speed
            PlayerService.getInstance().changeSpeed(player, walkSpeed);

            player.sendMessage("Your walking speed has been set to: " + walkSpeed);
        } catch (NumberFormatException e) {
            player.sendMessage("Invalid parameter. Please enter a number");
        } catch (Exception e){
            player.sendMessage(e.getMessage());
        }


        return true;
    }
}