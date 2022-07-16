package fr.iglee42.customheads;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public abstract class CustomHead implements Listener{
	
	private String name,headName;
	private List<String> lore = new ArrayList<>();

	/**
	 * @param name
	 * @param headName
	 */
	public CustomHead(String name, String headName) {
		this.name = name;
		this.headName = headName;
		HeadsManager.customHead.put(name, this);
	}

	public String getName() {
		return name;
	}

	public String getHeadName() {
		return headName;
	}
	
	public void activate(Player p) {
		HeadsManager.activatedHead.put(p, this);
		p.getInventory().setItemInMainHand(null);
	}
	public void desactivate(Player p) {
		HeadsManager.activatedHead.remove(p);
	}
	
	public void isActivated(Player p){
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof CustomHead)) return false;
		boolean flag1 = ((CustomHead)obj).getName() == this.getName();
		return flag1;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack build() {
		ItemStack itemStack = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
		SkullMeta itemMeta = (SkullMeta) itemStack.getItemMeta();
		itemMeta.setDisplayName(name.replaceAll("&", "§"));
		itemMeta.setOwner(headName);
		if (lore != null) itemMeta.setLore(lore);
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}

}
