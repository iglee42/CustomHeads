package fr.iglee42.customheads;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

/*
 * @author iglee42
 */
public class TestHead extends CustomHead implements Listener {

	public TestHead(){
		 super("test",          "iglee42");
		 //   Name of the head | Name of the player for the head skin
	}
	
	@Override
	public void activate(Player p){
	  super.activate(p);
	  p.sendMessage("§aYou activate the head :" + this.getName());
	}

	@Override
	public void desactivate(Player p){
	  super.desactivate(p);
	  p.sendMessage("§cYou desactivate the head :" + this.getName());
	}
	
	@EventHandler
	public void onBlockBreak(BlockBreakEvent event){
	 if (event.getBlock().getType() == Material.TNT){
	  CustomHead h = HeadsManager.activatedHead.get(event.getPlayer());
	  h.desactivate(event.getPlayer());
	  event.getBlock().getLocation().getWorld().createExplosion(event.getBlock().getLocation(),10.0f);
	 }
	}
}