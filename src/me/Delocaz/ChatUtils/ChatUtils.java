package me.Delocaz.ChatUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import me.Delocaz.ChatUtils.Features.BlockCaps;
import me.Delocaz.ChatUtils.Features.BlockSpam;
import me.Delocaz.ChatUtils.Features.ChatLog;
import me.Delocaz.ChatUtils.Features.Color;
import me.Delocaz.ChatUtils.Features.DisableChat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChatUtils extends JavaPlugin implements Listener {
	List<ChatFeature> features = new ArrayList<ChatFeature>();
	public CUConfig cfg;
	public CULang lng;
	public CUPerms pms;
	public void onEnable() {
		try {
			Metrics m = new Metrics(this);
			m.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		getServer().getPluginManager().registerEvents(this, this);
		cfg = new CUConfig(this);
		lng = new CULang(this);
		pms = new CUPerms(this);
		features.add(new ChatLog(this));
		features.add(new BlockCaps(this));
		features.add(new Color(this));
		features.add(new BlockSpam(this));
		features.add(new DisableChat(this));
		for (ChatFeature cf : features) {
			cf.init();
		}
	}
	@EventHandler
	public void onPlayerChat(final AsyncPlayerChatEvent e) {
		if (!e.isAsynchronous()) {
            execute(e);
        } else {
            final Future<Void> f = Bukkit.getScheduler().callSyncMethod(this, new Callable<Void>() {
                public Void call() throws Exception {
                    execute(e);
                    return null;
                }
            });
            try {
                while (true) {
                    try {
                        f.get();
                        break;
                    } catch (final InterruptedException e1) {}
                }
            } catch (final ExecutionException e1) {
            }
        }
	}
	public void execute(AsyncPlayerChatEvent e) {
		for (ChatFeature cf : features) {
			cf.chat(e);
		}
	}
	public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
		reloadConfig();
		s.sendMessage(lng.reload);
		return true;
	}
}
