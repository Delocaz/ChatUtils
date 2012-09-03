package me.Delocaz.ChatUtils.Features;

import me.Delocaz.ChatUtils.ChatFeature;
import me.Delocaz.ChatUtils.ChatUtils;

import org.bukkit.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Color extends ChatFeature {
	public Color(ChatUtils cu) {
		super(cu);
	}
	public void chat(AsyncPlayerChatEvent e) {
		if (e.getPlayer().hasPermission(pms.color)) {
			if (!cfg.color) {
				return;
			}
			String s = e.getMessage();
			s = s.replaceAll("&0", ChatColor.BLACK.toString());
			s = s.replaceAll("&1", ChatColor.DARK_BLUE.toString());
			s = s.replaceAll("&2", ChatColor.DARK_GREEN.toString());
			s = s.replaceAll("&3", ChatColor.DARK_AQUA.toString());
			s = s.replaceAll("&4", ChatColor.DARK_RED.toString());
			s = s.replaceAll("&5", ChatColor.DARK_PURPLE.toString());
			s = s.replaceAll("&6", ChatColor.GOLD.toString());
			s = s.replaceAll("&7", ChatColor.GRAY.toString());
			s = s.replaceAll("&8", ChatColor.DARK_GRAY.toString());
			s = s.replaceAll("&9", ChatColor.BLUE.toString());
			s = s.replaceAll("&a", ChatColor.GREEN.toString());
			s = s.replaceAll("&b", ChatColor.AQUA.toString());
			s = s.replaceAll("&c", ChatColor.RED.toString());
			s = s.replaceAll("&d", ChatColor.LIGHT_PURPLE.toString());
			s = s.replaceAll("&e", ChatColor.YELLOW.toString());
			s = s.replaceAll("&f", ChatColor.WHITE.toString());
			s = s.replaceAll("&k", ChatColor.MAGIC.toString());
			s = s.replaceAll("&l", ChatColor.BOLD.toString());
			s = s.replaceAll("&m", ChatColor.STRIKETHROUGH.toString());
			s = s.replaceAll("&n", ChatColor.UNDERLINE.toString());
			s = s.replaceAll("&o", ChatColor.ITALIC.toString());
			s = s.replaceAll("&r", ChatColor.RESET.toString());
			e.setMessage(s);
		}
	}
}
