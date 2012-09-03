package me.Delocaz.ChatUtils.Features;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import me.Delocaz.ChatUtils.ChatFeature;
import me.Delocaz.ChatUtils.ChatUtils;

import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatLog extends ChatFeature {
	public ChatLog(ChatUtils cu) {
		super(cu);
	}
	public void chat(AsyncPlayerChatEvent e) {
		if (!cfg.logChat) {
			return;
		}
		try {
			File f = new File("plugins/ChatUtils/chat.log");
			f.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
			bw.write("["+new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(System.currentTimeMillis()) + "] <"+e.getPlayer().getName()+"> "+e.getMessage());
			bw.newLine();
			bw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void init() {
		if (!cfg.logChat) {
			return;
		}
		try {
			new File("plugins/ChatUtils/").mkdirs();
			new File("plugins/ChatUtils/chat.log").createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
