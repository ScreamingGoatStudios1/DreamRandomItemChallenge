package com.jake.dreamrandomitemchallenge;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (DreamRandomItemChallenge.isStarted) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
        }
    }
}
