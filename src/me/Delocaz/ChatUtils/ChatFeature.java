package me.Delocaz.ChatUtils;

import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFeature {
	public CUConfig cfg;
	public CULang lng;
	public CUPerms pms;
	public ChatUtils parent;
	public ChatFeature(ChatUtils cu) {
		parent = cu;
		cfg = parent.cfg;
		lng = parent.lng;
		pms = parent.pms;
	}
	public void init() {
	}
	public void chat(AsyncPlayerChatEvent e) {
	}
}
