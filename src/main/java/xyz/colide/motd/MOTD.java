package xyz.colide.motd;

import org.bukkit.plugin.java.JavaPlugin;
import xyz.colide.motd.motd.Servermotd;

public class MOTD extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("[SimpleMotd] plugin has been enabled!");
        saveDefaultConfig();

        getServer().getPluginManager().registerEvents(new Servermotd(this),this);


    }

    @Override
    public void onDisable() {

        System.out.println("[SimpleMOTD] plugin has been disabled!");
    }
}
