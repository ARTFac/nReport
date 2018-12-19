package me.NickUltracraft.Report.API;

import org.bukkit.entity.Player;

public class ChatAddon {
	
	private Player player;
	private boolean json;
	
	public ChatAddon(Player player) {
		this.player = player;
		this.json = true;
	}
	public static ChatAddon getInstance(Player player) {
		return new ChatAddon(player);
	}
	public void passarMouse(String texto, String passarMouse) {
		net.md_5.bungee.api.chat.TextComponent text = new net.md_5.bungee.api.chat.TextComponent(texto);
		if(json) {
			PassarOMause(text, passarMouse);
		}
		player.spigot().sendMessage(text);
	}
	public void sugestãoComando(String texto, String passarMouse, String sugestão) {
		sugestão = sugestão.replace("/", "");
		net.md_5.bungee.api.chat.TextComponent text = new net.md_5.bungee.api.chat.TextComponent(texto);
		SugestaoCMause(text, passarMouse, "/" + sugestão);
		player.spigot().sendMessage(text);
	}
	public void abrirURL(String texto, String passarMouse, String url) {
		net.md_5.bungee.api.chat.TextComponent text = new net.md_5.bungee.api.chat.TextComponent(texto);
		OpenURL(text, passarMouse, url);
		player.spigot().sendMessage(text);
	}	
	public void sugestãoComando(String texto, String sugestão) {
		net.md_5.bungee.api.chat.TextComponent text = new net.md_5.bungee.api.chat.TextComponent(texto);
		SugestaoSMouse(text, "/" + sugestão);
		player.spigot().sendMessage(text);
	}
	public void mensagemSugestão(String texto, String passarMouse, String mensagem) {
		net.md_5.bungee.api.chat.TextComponent text = new net.md_5.bungee.api.chat.TextComponent(texto);
		MensagemSugestão(text, passarMouse, mensagem);
		player.spigot().sendMessage(text);
	}
	public void executarComando(String texto, String passarMouse, String comando) {
		net.md_5.bungee.api.chat.TextComponent text = new net.md_5.bungee.api.chat.TextComponent(texto);
		ComandoCMouse(text, passarMouse, comando);
		player.spigot().sendMessage(text);
	}
	public void executarComando(String texto, String comando) {
		net.md_5.bungee.api.chat.TextComponent text = new net.md_5.bungee.api.chat.TextComponent(texto);
		ComandoSMouse(text, comando);
		player.spigot().sendMessage(text);
	}
	private void PassarOMause(net.md_5.bungee.api.chat.TextComponent Nome, String PassarOMause) {
		net.md_5.bungee.api.chat.BaseComponent[] apipassaromause = new net.md_5.bungee.api.chat.ComponentBuilder(PassarOMause).create();
		net.md_5.bungee.api.chat.HoverEvent apipassaromauses = new net.md_5.bungee.api.chat.HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, apipassaromause);
		Nome.setHoverEvent(apipassaromauses);
	}
	private void SugestaoCMause(net.md_5.bungee.api.chat.TextComponent Nome, String PassarOMause, String Sugestão) {
		net.md_5.bungee.api.chat.BaseComponent[] apipassaromause = new net.md_5.bungee.api.chat.ComponentBuilder(PassarOMause).create();
		net.md_5.bungee.api.chat.HoverEvent apipassaromauses = new net.md_5.bungee.api.chat.HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, apipassaromause);
		net.md_5.bungee.api.chat.ClickEvent apiclicar = new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.SUGGEST_COMMAND, Sugestão);
		Nome.setClickEvent(apiclicar);
		Nome.setHoverEvent(apipassaromauses);
	}
	private void OpenURL(net.md_5.bungee.api.chat.TextComponent Nome, String PassarOMause, String Url) {
		net.md_5.bungee.api.chat.BaseComponent[] apipassaromause = new net.md_5.bungee.api.chat.ComponentBuilder(PassarOMause).create();
		net.md_5.bungee.api.chat.HoverEvent apipassaromauses = new net.md_5.bungee.api.chat.HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, apipassaromause);
		net.md_5.bungee.api.chat.ClickEvent apiclicar = new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.OPEN_URL, Url);
		Nome.setClickEvent(apiclicar);
		Nome.setHoverEvent(apipassaromauses);
	}	
	private void SugestaoSMouse(net.md_5.bungee.api.chat.TextComponent Nome, String Sugestão) {
		net.md_5.bungee.api.chat.ClickEvent apiclicar = new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.SUGGEST_COMMAND, Sugestão);
		Nome.setClickEvent(apiclicar);
	}
	private void MensagemSugestão(net.md_5.bungee.api.chat.TextComponent Nome, String PassarOMause, String Mensagem) {
		net.md_5.bungee.api.chat.BaseComponent[] apipassaromause = new net.md_5.bungee.api.chat.ComponentBuilder(PassarOMause).create();
		net.md_5.bungee.api.chat.HoverEvent apipassaromauses = new net.md_5.bungee.api.chat.HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, apipassaromause);
		net.md_5.bungee.api.chat.ClickEvent apiclicar = new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.SUGGEST_COMMAND, Mensagem);
		Nome.setClickEvent(apiclicar);
		Nome.setHoverEvent(apipassaromauses);
	}
	private void ComandoCMouse(net.md_5.bungee.api.chat.TextComponent Nome, String PassarOMause, String Comando) {
		net.md_5.bungee.api.chat.BaseComponent[] apipassaromause = new net.md_5.bungee.api.chat.ComponentBuilder(PassarOMause).create();
		net.md_5.bungee.api.chat.HoverEvent apipassaromauses = new net.md_5.bungee.api.chat.HoverEvent(net.md_5.bungee.api.chat.HoverEvent.Action.SHOW_TEXT, apipassaromause);
		net.md_5.bungee.api.chat.ClickEvent apiclicar = new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.RUN_COMMAND, "/" + Comando);
		Nome.setClickEvent(apiclicar);
		Nome.setHoverEvent(apipassaromauses);
	}
	private void ComandoSMouse(net.md_5.bungee.api.chat.TextComponent Nome, String Comando) {
		net.md_5.bungee.api.chat.ClickEvent apiclicar = new net.md_5.bungee.api.chat.ClickEvent(net.md_5.bungee.api.chat.ClickEvent.Action.RUN_COMMAND, "/" + Comando);	
		Nome.setClickEvent(apiclicar);
	}	
}
