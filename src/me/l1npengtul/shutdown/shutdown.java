package me.l1npengtul.shutdown;

import com.google.common.util.concurrent.AbstractScheduledService;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.permissions.PermissibleBase;
import org.bukkit.scheduler.*;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.*;
import static org.bukkit.Server.*;
import static org.bukkit.World.*;

public class shutdown extends JavaPlugin{
    public shutdown(){

    }

    public static void main(String[] args) {

    }
    @Override
    public void onEnable(){

        this.getLogger().info("Shutdown: Not Shutting Down yet!");
    }

    @Override
    public void onDisable(){
        this.getLogger().info("Shutdown: Going to sleep...");

    }



    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (command.getName().equalsIgnoreCase("shutdown")){


            if(sender.isOp() || sender.isPermissionSet("shutdown.shutdown")){
                this.getLogger().info("Server Shutdown in 20 seconds");
                broadcastMessage("Server Shutdown in 20 seconds!");
                BukkitScheduler sched = getServer().getScheduler();
                sched.scheduleSyncDelayedTask(this, new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.shutdown();
                    }
                },400L);

            }

        }
        return false;
    }

}


