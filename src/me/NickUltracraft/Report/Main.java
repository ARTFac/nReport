package me.NickUltracraft.Report;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main m;
	
	private void console(String msg) {
		Bukkit.getConsoleSender().sendMessage(msg);
	}
	public void onEnable() {
		m = this;
		try {
			console("Carregando nReport " + getDescription().getVersion() + "...");
			getCommand("report").setExecutor(new Report());
			getCommand("reportar").setExecutor(new Report());
			getCommand("reports").setExecutor(new Report());
			getCommand("reportes").setExecutor(new Report());
			getServer().getPluginManager().registerEvents(new Report(), this);
			File file = new File(getDataFolder(), "userdata");
			console("§anReport foi carregado com sucesso.");
			if(file != null && file.exists()) {
				int usuarios = file.listFiles().length;
				if(usuarios == 1) {
					console("Um usuário foi carregado com sucesso.");
				} else {
					console(usuarios + " usuários foram carregados com sucesso.");
				}
			}
		} catch (Exception e) {
			console("§cErro na inicialização do nReport.");
		}
	}

}
