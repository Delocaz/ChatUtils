package me.Delocaz.ChatUtils;

import org.bukkit.ChatColor;

public class CULang {
	public String noCaps;
	public String reload;
	public CULang(ChatUtils cu) {
		noCaps = ChatColor.RED+"No typing in all caps, please!";
		reload = ChatColor.RED+"ChatUtils is reloaded!";
	}
}
