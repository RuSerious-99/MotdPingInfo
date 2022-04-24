package com.ruserious99.networkmotd;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.Favicon;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public final class NetworkMotd extends Plugin implements Listener {

    private Favicon favicon;

    @Override
    public void onEnable() {
        try{
            favicon = Favicon.create(ImageIO.read(new File("favicon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        getProxy().getPluginManager().registerListener(this, this);
    }

@EventHandler
    public void onPing(ProxyPingEvent pingEvent){

      ServerPing ping =  pingEvent.getResponse();
      ping.setDescription(ChatColor.WHITE + "MysticWorld\n"
              + ChatColor.BOLD + "Come Enjoy, "
              + ChatColor.BLUE + "A Chill Survival World");
      ping.setPlayers(new ServerPing.Players(1000, getProxy().getOnlineCount(), ping.getPlayers().getSample()));
      ping.setVersion(new ServerPing.Protocol("Best Connect with 1.18.1", 757));
      ping.setFavicon(favicon);

      pingEvent.setResponse(ping);
    }
}
