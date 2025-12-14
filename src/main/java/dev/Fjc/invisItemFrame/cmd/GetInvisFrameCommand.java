package dev.Fjc.invisItemFrame.cmd;

import dev.Fjc.invisItemFrame.InvisItemFrame;
import dev.Fjc.invisItemFrame.builders.frames.Frame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GetInvisFrameCommand implements TabExecutor {

    private final InvisItemFrame plugin = InvisItemFrame.getInstance();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!sender.isOp()) {
            sender.sendMessage("You do not have permission to run this command.");
            return false;
        }

        boolean glow = args.length >= 1 && args[0].equals("glow");

        if (!(sender instanceof Player player)) {
            Player target = args.length >=2 ? plugin.getServer().getPlayer(args[1]) : null;
            if (target == null) {
                sender.sendMessage("You did not provide a valid playername.");
                return false;
            }

            target.give(Frame.getInvisFrame(1, true, glow));
        } else {
            player.give(Frame.getInvisFrame(1, true, glow));
        }
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (args.length == 2) return plugin.getServer().getOnlinePlayers().stream()
                .map(Player::getName)
                .filter(obj -> obj.startsWith(args[1].toLowerCase()))
                .toList();
        return List.of();
    }
}
