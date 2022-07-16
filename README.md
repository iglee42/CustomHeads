# CustomHeads
 
This is 2 classes to create heads with custom effects for minecraft plugin.

## Use

-Add classes to your plugin java project

-In your onEnable method you need to add :
> new HeadsManager()

**Create Custom Head**

-You must create a class **extends CustomHead** and **implement Listener**

```Java
public class TestHead extends CustomHead implements Listener {
 //Your Code
}
```

-You must add constructor like this 

```Java
public TestHead(){
 super("test",          "iglee42")
 //   Name of the head | Name of the player for the head skin
}
```

-You can redefine methods :
 -activate
 -desactivate
 
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
 
 Note : super.activate() & super.desactivate must be present if you rewrite methods !
 


