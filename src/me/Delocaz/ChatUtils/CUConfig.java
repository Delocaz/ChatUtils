package me.Delocaz.ChatUtils;

public class CUConfig {
	public boolean logChat;
	public boolean blockCaps;
	public boolean color;
	public boolean blockSpam;
	public int spamThreshold;
	public int spamWait;
	public boolean disableChat;
	public CUConfig(ChatUtils cu) {
		cu.getConfig().addDefault("logChat", true);
		cu.getConfig().addDefault("blockCaps", true);
		cu.getConfig().addDefault("color", true);
		cu.getConfig().addDefault("blockSpam", true);
		cu.getConfig().addDefault("spamThreshold", 500);
		cu.getConfig().addDefault("spamWait", 10000);
		cu.getConfig().addDefault("disableChat", false);
		cu.getConfig().options().copyDefaults(true);
		cu.saveConfig();
		logChat = cu.getConfig().getBoolean("logChat");
		blockCaps = cu.getConfig().getBoolean("blockCaps");
		color = cu.getConfig().getBoolean("color");
		blockSpam = cu.getConfig().getBoolean("blockSpam");
		spamThreshold = cu.getConfig().getInt("spamThreshold");
		spamWait = cu.getConfig().getInt("spamWait");
		disableChat = cu.getConfig().getBoolean("disableChat");
	}
}
