# CinematicAPI
Cinematic API for Minecraft Bukkit servers
It allows you make cinematics in game

# How To Use

```
// CinematicCamera capi = new CinematicCamera(PluginClass);
// Create your CinematicCamera
CinematicCamera capi = new CinematicCamera(this);

Location loc = player.getLocation(); // Take a location from somewhere in this example our location comin from player
Location loc1 = loc.clone().add(0,35,0); // Add loc y value to 35
Location loc2 = loc.clone().add(35,0,0); // Add loc x value to 35
Location loc3 = loc.clone().add(0,0,35); // Add loc z value to 35
/*CameraPath path = new CameraPath(Location loc , float yawS , float pitchS , int waittime ,Command commands , boolean engelle);
* loc is CinematicCamera's next position
* yawS is determine player camera's turning 
* pitchS is same as yawS
* waittime is when player arrives the loc, the player waits with waittime
* engelle determines when player arrives the loc, player can move or not  
* commands determines what will happen when player goin and what will happen when player arrived.
*/

CameraPath path1 = new CameraPath(loc1 , loc1.getYaw() , loc1.getPitch() , 1 , new Commands(){
  @Override
  public void ulasti(){
    player.sendMessage("You arrived");
  }
  @Override
  public void giderken(){
    player.sendMessage("You are going");
  }
} , true);


CameraPath path2 = new CameraPath(loc2 , loc2.getYaw() , loc2.getPitch() , 0 , new Commands(){
  @Override
  public void ulasti(){
    player.sendMessage("You arrived");
  }
  @Override
  public void giderken(){
    player.sendMessage("You are going");
  }
} , false);

CameraPath path2 = new CameraPath(loc3 , loc3.getYaw() , loc3.getPitch() , 2 , new Commands(){
  @Override
  public void ulasti(){
    player.sendMessage("The end of your journey");
  }
  @Override
  public void giderken(){
    player.sendMessage("You are going to end of your journey");
  }
} , false);
//Add the paths to your cinematic camera
capi.addPath(path1);
capi.addPath(path2);
capi.addPath(path3);
capi.setSpeed(60); //Set your cinematic camera's speed
capi.start(player); // Start your cinematic camera for a player.
```

You can show a demo in game with /capi play
