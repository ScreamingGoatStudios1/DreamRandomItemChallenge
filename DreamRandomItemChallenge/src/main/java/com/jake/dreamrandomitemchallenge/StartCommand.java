package com.jake.dreamrandomitemchallenge;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StartCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("randomitem.toggle")) {
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("start")) {
                        if (!DreamRandomItemChallenge.isStarted) {
                            DreamRandomItemChallenge.isStarted = true;
                            Bukkit.broadcastMessage(ChatColor.GRAY + "Dream's Random Item Challenge has " + ChatColor.GREEN + "started" + ChatColor.GRAY + "!");
                        } else {
                            player.sendMessage(ChatColor.RED + "The challenge has already started!");
                        }
                    } else if (args[0].equalsIgnoreCase("stop")) {
                        if (DreamRandomItemChallenge.isStarted) {
                            DreamRandomItemChallenge.isStarted = false;
                            Bukkit.broadcastMessage(ChatColor.GRAY + "Dream's Random Item Challenge has " + ChatColor.RED + "ended" + ChatColor.GRAY + "!");
                        } else {
                            player.sendMessage(ChatColor.RED + "The challenge has already started!");
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "/randomitem <start/stop>");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "/randomitem <start/stop>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use that command!");
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Only players can use that command!");
        }

        return false;
    }
}
