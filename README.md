# CustomHeads
 
This is 2 classes to create heads with custom effects for minecraft plugin.

## Use

-Add classes to your plugin java project

-In your onEnable method you need to add :
> HeadsManager headManager = new HeadsManager();

> headManager.register();

**Create Custom Head**

You must create a class **extends CustomHead** and **implement Listener**

```Java
public class TestHead extends CustomHead implements Listener {
 //Your Code
}
```

You must add constructor like this 

```Java
public TestHead(){
 super("test",          "iglee42");
 //   Name of the head | Name of the player for the head skin
}
```

You can redefine methods :
  
  - activate() called when player use the head (right click)
  
  - desactivate() called when player finish use the head ( called when an other head is already activated)
 
 Example:
 ```Java
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
 ```
 
 Note : super.activate() & super.desactivate() must be present if you rewrite methods !
 
 Methods are at your disposal :
 
 - isActivated(player) return if the head is activated for the player

 - getName() return the name of the head

 - getHeadName() return the name of the player with the skin of the head

 - build() return the itemstack of the head
 
You can use events of bukkit in your head

Example :
```Java
@EventHandler
public void onBlockBreak(BlockBreakEvent event){
 if (event.getBlock().getType() == Material.TNT){
  CustomHead h = HeadsManager.activatedHead.get(event.getPlayer());
  h.desactivate(event.getPlayer());
  event.getBlock().getLocation().getWorld().createExplosion(event.getBlock().getLocation(),10.0f);
 }
}
```

To finish you must register head

> headManager.addHead(new TestHead());

