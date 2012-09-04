package me.Delocaz.ChatUtils;

import org.bukkit.ChatColor;

public class CULang {
	public String noCaps;
	public String reload;
	public String noSpam;
	public String disabled;
	public CULang(ChatUtils cu) {
		noCaps = ChatColor.RED+"No typing in all caps, please!";
		reload = ChatColor.RED+"ChatUtils is reloaded!";
		noSpam = ChatColor.RED+"No spamming, please! Wait %s seconds to chat again.";
		disabled = ChatColor.RED+"Sorry, chat is disabled.";
	}
}
