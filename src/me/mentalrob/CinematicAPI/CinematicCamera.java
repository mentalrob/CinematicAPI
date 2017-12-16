package me.mentalrob.CinematicAPI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;
import org.spigotmc.event.player.PlayerSpawnLocationEvent;
public class CinematicCamera implements Listener{
	private JavaPlugin plugin;
	
	public CinematicCamera(JavaPlugin plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	private int x = 0;
	private Location basloc  = null;
	private GameMode Mod = null;
	private Boolean flying = null;
	private ArrayList<String> Engellenenler = new ArrayList<String>();
	private Location OyuncuLoc = null;
	//CinematicAPI capi = new CinematicCamera();
	/* 
	 * 
	 * capi.setSpeed(5);
	 * 
	 * CameraPath Path1 = new CameraPath(loc,yaw,pitch,waittime,new commands(){//ygulanacak komutlar});
	 * capi.addPath(Path1,0);
	 * capi.addPath(toLoc2,1);
	 * capi.addPath(toLoc3,2);
	 * 
	 * capi.start(Player);
	 * path = capi.getPaths();
	 * path.get(2).setYaw((float)45);
	 * path.get(2).setWaitTime(2);
	 * 
	 * 
	 * 
	 */
	private int speed; 
	private List<CameraPath> Paths = new ArrayList<CameraPath>();
	private void smoothMoveByBerti(CameraPath path , Player player, Boolean ilkmi , Boolean sonmu,int waittime, Location locen){
		boolean aynimi = false;
		if(!ilkmi){
			if(path.getLoc().equals(Paths.get(x-1).getLoc())){
				aynimi = true;
			}
		}
		Location toLoc = path.getLoc();
			int time = speed;
			Location loc = new Location(toLoc.getWorld(),toLoc.getBlockX() - player.getLocation().getBlockX() , toLoc.getBlockY() - player.getLocation().getBlockY() , toLoc.getBlockZ()-player.getLocation().getBlockZ());
			Vector vec = new Vector(loc.getX()/time , loc.getY()/time , loc.getBlockZ()/time);
			float yaw1 = path.getYawS() - player.getLocation().getYaw();
			float pitch1 = path.getPitchS() - player.getLocation().getPitch();
			float yaw2 = yaw1 / time;
			float pitch2 = pitch1 / time;
			if(ilkmi){
			player.setAllowFlight(true);
			player.setFlying(true);
			player.setGameMode(GameMode.SPECTATOR);
			}
			
		    for (int i = 0; i < time; i++) {
		    	float a = i;
		    	boolean aynimif = aynimi;
		        plugin.getServer().getScheduler().runTaskLater(plugin, new Runnable() {
		        	
		            public void run() {
		            	if(Engellenenler.contains(player.getName())){
		            	Engellenenler.remove(player.getName());
		            	OyuncuLoc = null;
		            	}
		            	if(!aynimif){
		            	if(a==0){
			        		path.getKomutlar().giderken();
			        	}
		                player.setVelocity(vec);
		                
		                Location loc = player.getLocation();
		                			//25 + (14)/10
		                loc.setYaw(loc.getYaw() + yaw2);
		                loc.setPitch(loc.getPitch() + pitch2);
		                player.teleport(loc);
		            	}
		                if(speed - 1 == a){
		                	if(!aynimif){
		                	path.getKomutlar().ulasti();
		                	player.setVelocity(new Vector(0,0,0));
		                	if(path.isEngelle() && !sonmu){
		                		if(!Engellenenler.contains(player.getName())){
		                		Engellenenler.add(player.getName());
		                		OyuncuLoc = player.getLocation();
		                		}
		                	}
		                	}
		                	if(sonmu){
		    	            	player.teleport(locen);
		    	            	player.setAllowFlight(flying);
		    	            	player.setFlying(flying);
		    	            	player.setGameMode(Mod);
		    	            	basloc = null;
		    	            	Mod = null;
		    	            	CinematicCamera.this.flying = null;
		    	            	}
		                	start(player);
		                }
		            }
		        }, (waittime*20L)+(1L*i)); // Note this bit. Delays are the delay until the next task, therefore the delay needs to get larger as time goes on. Having 1L results in <time> tasks firing at once, after 1 tick delay.
		    }
		    
		    
		    }
	
	
	
	public void start(Player player){
		if(x>=Paths.size()){
			return;
		}
		if(basloc == null){
			basloc = player.getLocation();
		Mod = player.getGameMode();
		flying = player.getAllowFlight();
		}
			Boolean ilk = x == 0;
			Boolean son = x == Paths.size() - 1;
			Integer waittime = 0;
			if(!ilk){
			waittime += Paths.get(x-1).getWaittime();
			}
			smoothMoveByBerti(Paths.get(x), player, ilk, son,waittime,basloc);
			x++;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void addPath(CameraPath Path){
		Paths.add(Path);
	}
	public void delPath(int index){
		Paths.remove(Paths.get(index));
	}
	public ArrayList<CameraPath> getPaths(){
		return new ArrayList<>(Paths);
	}
	@EventHandler
	public void OyuncuEngellerkene(PlayerMoveEvent e){
		if(Engellenenler.contains(e.getPlayer().getName())){
			if(!(OyuncuLoc.getBlockX() == e.getPlayer().getLocation().getBlockX() && OyuncuLoc.getBlockY() == e.getPlayer().getLocation().getBlockY() && OyuncuLoc.getBlockZ() == e.getPlayer().getLocation().getBlockZ()))
			e.setTo(OyuncuLoc);
		}
	}
}
