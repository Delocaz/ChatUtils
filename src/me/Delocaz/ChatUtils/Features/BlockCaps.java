package me.Delocaz.ChatUtils.Features;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.Delocaz.ChatUtils.ChatFeature;
import me.Delocaz.ChatUtils.ChatUtils;

public class BlockCaps extends ChatFeature {
	public BlockCaps(ChatUtils cu) {
		super(cu);
	}
	public void chat(AsyncPlayerChatEvent e) {
		if (e.getPlayer().hasPermission(pms.allowCaps)) {
			return;
		}
		if (cfg.blockCaps) {
			if (isAllCaps(e.getMessage())) {
				e.getPlayer().sendMessage(lng.noCaps);
				e.setCancelled(true);
			}
		}
	}
	public boolean isAllCaps(String s) {
		s = s.replaceAll("[^a-zA-Z]", "");
		if (s.isEmpty()) return false;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (!Character.isUpperCase(c)) return false;
		}
		return true;
	}

}
