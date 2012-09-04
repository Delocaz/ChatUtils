package me.Delocaz.ChatUtils.Features;

import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.Delocaz.ChatUtils.ChatFeature;
import me.Delocaz.ChatUtils.ChatUtils;

public class DisableChat extends ChatFeature {
	public DisableChat(ChatUtils cu) {
		super(cu);
	}
	public void chat(AsyncPlayerChatEvent e) {
		if (!cfg.disableChat) {
			return;
		}
		e.getPlayer().sendMessage(lng.disabled);
		e.setCancelled(true);
	}
}
