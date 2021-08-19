package com.jake.dreamrandomitemchallenge;

import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.inventory.meta.ItemMeta;

public class PickupListener implements Listener {
    @EventHandler
    public void onPickup(EntityPickupItemEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();
            Item item = e.getItem();
            ItemMeta meta = item.getItemStack().getItemMeta();
            if (DreamRandomItemChallenge.isStarted) {
                if (meta.getLore() != null && !meta.getLore().contains(player.getDisplayName())) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
