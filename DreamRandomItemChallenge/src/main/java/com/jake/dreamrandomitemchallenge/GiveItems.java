package com.jake.dreamrandomitemchallenge;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GiveItems extends BukkitRunnable {
    static List<Material> items = Arrays.asList(Material.values());
    Random random = new Random();

    public static void list() {
        items = (List<Material>) items.stream().filter(material -> (!material.isAir())).collect(Collectors.toList());
        items.remove(Material.END_GATEWAY);
        items.remove(Material.END_PORTAL);
        items.remove(Material.NETHER_PORTAL);
        items.remove(Material.AIR);
        items.remove(Material.VOID_AIR);
        items.remove(Material.CAVE_AIR);
        items.remove(Material.STRUCTURE_BLOCK);
        items.remove(Material.STRUCTURE_VOID);
        items.remove(Material.COMMAND_BLOCK_MINECART);
        items.remove(Material.COMMAND_BLOCK);
        items.remove(Material.CHAIN_COMMAND_BLOCK);
        items.remove(Material.REPEATING_COMMAND_BLOCK);
        items.remove(Material.BARRIER);
        items.remove(Material.KNOWLEDGE_BOOK);
        items.remove(Material.WATER);
        items.remove(Material.LAVA);
        items.remove(Material.DEBUG_STICK);
        items.remove(Material.END_PORTAL_FRAME);
        items.remove(Material.BEDROCK);
        items.remove(Material.SPAWNER);
        items.remove(Material.LEGACY_AIR);
        items.remove(Material.ENCHANTED_BOOK);
        items.remove(Material.POTION);
        items.remove(Material.LINGERING_POTION);
        items.remove(Material.SPLASH_POTION);
    }
    public void run() {
        if (DreamRandomItemChallenge.isStarted) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                Location location = player.getLocation();
                int select = random.nextInt(items.size());
                Material material = items.get(select);
                ItemStack itemStack = new ItemStack(material, 64);
                ItemMeta meta = itemStack.getItemMeta();
                meta.setLore(Arrays.asList(player.getDisplayName()));
                itemStack.setItemMeta(meta);
                location.getWorld().dropItemNaturally(location, itemStack);
                player.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "➜ ITEM DROP HAS ARRIVED!");
            }
        }
    }
}
