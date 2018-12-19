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
	public void sugest�oComando(String texto, String passarMouse, String sugest�o) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).sugest�oComando(texto, passarMouse, sugest�o);
	}
	public void abrirURL(String texto, String passarMouse, String url) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).abrirURL(texto, passarMouse, url);
	}	
	public void sugest�oComando(String texto, String sugest�o) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).sugest�oComando(texto, sugest�o);
	}
	public void mensagemSugest�o(String texto, String passarMouse, String mensagem) {
		if(versaoantiga) {
			player.sendMessage(texto);
			return;
		}
		ChatAddon.getInstance(player).mensagemSugest�o(texto, passarMouse, mensagem);
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
