package me.Delocaz.ChatUtils;

public class CUConfig {
	public boolean logChat;
	public boolean blockCaps;
	public boolean color;
	public CUConfig(ChatUtils cu) {
		cu.getConfig().addDefault("logChat", true);
		cu.getConfig().addDefault("blockCaps", true);
		cu.getConfig().addDefault("color", true);
		cu.getConfig().options().copyDefaults(true);
		cu.saveConfig();
		logChat = cu.getConfig().getBoolean("logChat");
		blockCaps = cu.getConfig().getBoolean("blockCaps");
		color = cu.getConfig().getBoolean("color");
	}
	
}
