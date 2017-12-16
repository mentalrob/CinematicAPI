package me.mentalrob.CAPI;

import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

import me.mentalrob.CinematicAPI.CinematicCamera;

public class Core extends JavaPlugin{

	public void onEnable(){
		getCommand("capi").setExecutor(new ComListener(this));
	}
}
