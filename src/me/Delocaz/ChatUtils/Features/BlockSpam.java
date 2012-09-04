package me.Delocaz.ChatUtils.Features;

import java.util.HashMap;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.Delocaz.ChatUtils.ChatFeature;
import me.Delocaz.ChatUtils.ChatUtils;

public class BlockSpam extends ChatFeature {
	public BlockSpam(ChatUtils cu) {
		super(cu);
	}
	HashMap<String, Long> h = new HashMap<String, Long>();
	HashMap<String, Long> b = new HashMap<String, Long>();
	public void chat(AsyncPlayerChatEvent e) {
		if (e.getPlayer().hasPermission(pms.allowSpam)) {
			return;
		}
		if (b.containsKey(e.getPlayer().getName())) {
			if (b.get(e.getPlayer().getName())+(cfg.spamWait) > System.currentTimeMillis()) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(lng.noSpam.replace("%s", 10-(System.currentTimeMillis()-b.get(e.getPlayer().getName()))/1000+""));
				return;
			}
		}
		if (h.containsKey(e.getPlayer().getName())) {
			if (h.get(e.getPlayer().getName())+(cfg.spamThreshold) > System.currentTimeMillis()) {
				e.setCancelled(true);
				e.getPlayer().sendMessage(lng.noSpam.replace("%s", cfg.spamWait/1000+""));
				b.put(e.getPlayer().getName(), System.currentTimeMillis());
			}
		}
		h.put(e.getPlayer().getName(), System.currentTimeMillis());

	}
}
