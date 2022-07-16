package fr.iglee42.customheads;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class HeadsManager implements Listener {
	
	public static Map<String,CustomHead> customHead = new HashMap<>();
	public static Map<Player,CustomHead> activatedHead = new HashMap<>();
	
	public HeadsManager(Plugin plugin) {
		Bukkit.getPluginManager().registerEvents(this, plugin);
	}

	public static void addHead(CustomHead head,Plugin plugin) {
		Bukkit.getPluginManager().registerEvents(head, plugin);
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if (event.getAction() == null && event.getItem() == null) return;
		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) return;
		if (!event.getItem().hasItemMeta()) return;
		if (!event.getItem().getItemMeta().hasDisplayName()) return;
		if (event.getItem().getType() == Material.SKULL_ITEM) {
			CustomHead h = null;
			for (CustomHead head : customHead.values()) {
				String hn = head.getName().replaceAll("&", "§");
				if (event.getItem().getItemMeta().getDisplayName().equals(hn)) {
					h = head;
				}
			}
			if (h == null) return;
			h.activate(event.getPlayer());
		}
	}
}
