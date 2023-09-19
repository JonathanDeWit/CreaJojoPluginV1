package be.creajojo.creajojopluginv1.commands;

import be.creajojo.creajojopluginv1.services.PlayerService;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JumpCommand implements CommandExecutor {
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

        // Check if the command has the correct number of arguments
        if (args.length != 1) {
            player.sendMessage("Usage: /jump <0|1>");
            return true;
        }


        if (args[0].equals("1")) {
            // Add the Jump Boost effect with a duration of 60 seconds and an amplifier of 1 (Jump Boost II)
            PlayerService.getInstance().addJumpBoost(player);
            player.sendMessage("Jump Boost activated.");
        } else if (args[0].equals("0")) {
            // Remove the Jump Boost effect
            PlayerService.getInstance().removeJumpBoost(player);
            player.sendMessage("Jump Boost deactivated.");
        } else {
            player.sendMessage("Invalid argument. Usage: /jump <0|1>");
        }

        return true;
    }
}
