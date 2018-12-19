package me.NickUltracraft.Report.API;

import org.bukkit.entity.Player;
public class ChatManager {

	private Player player;
	private boolean versaoantiga = false;
	
	public ChatManager(Player player) {
		this.player = player;
	}
	public static ChatManager getInstance(Player player) {
		return new ChatManager(player);
	}	
	public void passarMouse(String texto, String passarMouse) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).passarMouse(texto, passarMouse);
	}
	public void sugestãoComando(String texto, String passarMouse, String sugestão) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).sugestãoComando(texto, passarMouse, sugestão);
	}
	public void abrirURL(String texto, String passarMouse, String url) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).abrirURL(texto, passarMouse, url);
	}	
	public void sugestãoComando(String texto, String sugestão) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).sugestãoComando(texto, sugestão);
	}
	public void mensagemSugestão(String texto, String passarMouse, String mensagem) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).mensagemSugestão(texto, passarMouse, mensagem);
	}
	public void executarComando(String texto, String passarMouse, String comando) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).executarComando(texto, passarMouse, comando);
	}
	public void executarComando(String texto, String comando) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).executarComando(texto, comando);
	}
}
