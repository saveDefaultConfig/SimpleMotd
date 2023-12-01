package xyz.colide.motd.motd;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;
import xyz.colide.motd.MOTD;

import java.util.List;

public class Servermotd implements Listener {

    private final MOTD motd;

    public Servermotd(MOTD motd) {
        this.motd = motd;
    }

    @EventHandler
    public void onServerListPing(ServerListPingEvent event) {
        List<String> motdLines = motd.getConfig().getStringList("MOTD_Display");

        if (motdLines.size() >= 2) {
            String line1 = motdLines.get(0);
            String line2 = motdLines.get(1);

            event.setMotd(ChatColor.translateAlternateColorCodes('&', line1 + "\n" + line2));
        }

        if (motd.getConfig().getBoolean("Max_Players.Enabled")) {
            int maxPlayers = motd.getConfig().getInt("Max_Players.Count", 50);
            event.setMaxPlayers(maxPlayers);
        }
    }
}
