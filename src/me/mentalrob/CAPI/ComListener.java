package me.mentalrob.CAPI;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

import com.avaje.ebean.enhance.agent.LocalClassLoader;
import me.mentalrob.CinematicAPI.CameraPath;
import me.mentalrob.CinematicAPI.CinematicCamera;
import me.mentalrob.CinematicAPI.Commands;

public class ComListener implements CommandExecutor{
	Core plugin;
	
	public ComListener(Core instance){
		plugin = instance;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player){
			Player player = (Player) sender;
			if(label.equalsIgnoreCase("capi")){
				if(args.length == 1){
					if(args[0].equalsIgnoreCase("add")){
						
					}else if(args[0].equalsIgnoreCase("clear")){
						
					}else if(args[0].equalsIgnoreCase("play")){
						Location locent = player.getLocation();
						Location loc = player.getLocation();
						Location loc1 = loc.clone().add(0,35,0);
						Location loc2 = loc.clone().add(35,0,0);
						Location loc3 = loc.clone().add(0,0,35);
						CinematicCamera capi = new CinematicCamera(plugin);
						CameraPath path1 = new CameraPath(loc1, 30, -55, 0, new Commands() {
							
							@Override
							public void ulasti() {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4ulastin "));
							}
							
							@Override
							public void giderken() {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Gidiyon suan"));
							}
						},false);
						CameraPath path2 = new CameraPath(loc2,-30,55,3,new Commands() {
							
							@Override
							public void ulasti() {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4ulastin2"));
							}
							
							@Override
							public void giderken() {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Gidiyon suan2"));
							}
						},true);
						CameraPath path3 = new CameraPath(loc3,0,0,5,new Commands() {
							
							@Override
							public void ulasti() {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4ulastin3 bu sondu"));
							}
							
							@Override
							public void giderken() {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Gidiyon suan3"));
							}
						},false);
						CameraPath path4 = new CameraPath(player.getLocation(),-131,31,5,new Commands() {
							
							@Override
							public void ulasti() {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4ulastin4 bu sondu"));
							}
							
							@Override
							public void giderken() {
								player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&4Gidiyon4"));
							}
						},false);
						capi.addPath(path1);
						capi.addPath(path2);
						capi.addPath(path3);
						capi.addPath(path3);
						capi.setSpeed(60);
						capi.start(player);
						//player.sendMessage(loc1 + " == " + loc2);
					}
				}
			}
			
		}
		
		
		return false;
	}
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
	 * capi.play();
	 * 
	 */

}
