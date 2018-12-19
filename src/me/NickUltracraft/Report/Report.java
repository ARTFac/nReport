package me.NickUltracraft.Report;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import me.NickUltracraft.Report.API.ChatManager;
import me.NickUltracraft.Report.API.Criar;

public class Report implements CommandExecutor, Listener {

	private String getHackName(String hack) {
		if(!hack.equalsIgnoreCase("Anti-Knockback") && (!hack.equalsIgnoreCase("X-Ray") && (!hack.equalsIgnoreCase("No-Fall")))) {
			if(hack.equalsIgnoreCase("Alianca")) {
				return "Alian�a";
			} else {
				return hack.replace("-", " ");
			}
		} else {
			return hack;
		}
	}
	private void remover(String target) {
		try {
			File file = new File(Main.m.getDataFolder() + "/userdata", target.toLowerCase() + ".yml");
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			config.set("Reports." + target + ".Aimbot", 0);
			config.set("Reports." + target + ".ForceField", 0);
			config.set("Reports." + target + ".AutoSoup", 0);
			config.set("Reports." + target + ".Fly", 0);
			config.set("Reports." + target + ".AutoArmor", 0);
			config.set("Reports." + target + ".AutoClicker", 0);
			config.set("Reports." + target + ".Anti-Knockback", 0);
			config.set("Reports." + target + ".X-Ray", 0);
			config.set("Reports." + target + ".Critical", 0);
			config.set("Reports." + target + ".No-Fall", 0);
			config.set("Reports." + target + ".Speed", 0);
			config.set("Reports." + target + ".Alianca", 0);
			config.set("Reports." + target + ".Total", 0);
			config.set("Reports." + target + ".UltimaRazao", "");
			config.set("Reports." + target + ".Reportado", false);
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void mandar(Player player, String target, String hack, String hack2, boolean cor) {
		if(cor) {
			ChatManager.getInstance(player).executarComando("  �7" + hack, "�7Clique para reportar este jogador por " + hack + ".", "reportar " + target + " " + hack2);
		} else {
			ChatManager.getInstance(player).executarComando("  �f" + hack, "�7Clique para reportar este jogador por " + hack + ".", "reportar " + target + " " + hack2);
		}
	}
	private void salvarReport(String target, String hack) {
		try {
			File file = new File(Main.m.getDataFolder() + "/userdata", target.toLowerCase() + ".yml");
			FileConfiguration config = YamlConfiguration.loadConfiguration(file);
			if(!config.isSet("Reports." + target + "." + hack)) {
				config.set("Reports." + target + "." + hack, 1);
				config.set("Reports." + target + ".Reportado", true);
			} else {
				config.set("Reports." + target + "." + hack, config.getInt("Reports." + target + "." + hack) + 1);
				config.set("Reports." + target + ".Reportado", true);
			}
			if(!config.isSet("Reports." + target + ".Total")) {
				config.set("Reports." + target + ".Total", 1);
			} else {
				config.set("Reports." + target + ".Total", config.getInt("Reports." + target + ".Total") + 1);
			}
			config.set("Reports." + target + ".UltimaRazao", hack);
			config.save(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("deprecation")
	private void reportar(Player player, String target, String hack) {
		salvarReport(target, hack);
		player.sendMessage("�7Voc� reportou o jogador �f" + target + " �7por �f" + getHackName(hack));
		for(Player on : Bukkit.getOnlinePlayers()) {
			if(on.hasPermission("nreport.report")) {
				on.sendTitle("�c�lReport", "�7Uma nova den�ncia foi recebida");
				on.playSound(on.getLocation(), Sound.ENDERDRAGON_GROWL, 15, 1);
			}
		}
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String lb, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player)sender;
			if(lb.equalsIgnoreCase("reports") || (lb.equalsIgnoreCase("reportes"))) {
				if(!p.hasPermission("nreport.report")) {
					p.sendMessage("�cVoc� n�o tem permiss�o para executar este comando.");
					return true;
				}
				Inventory inv = Bukkit.createInventory(null, 54, "�8Todos os Reports");
				
				for(Player on : Bukkit.getOnlinePlayers()) {
					File file = new File(Main.m.getDataFolder() + "/userdata", on.getName().toLowerCase() + ".yml");
					FileConfiguration config = YamlConfiguration.loadConfiguration(file);
					int inicio = 10;
					if(config.getBoolean("Reports." + on.getName() + ".Reportado")) {
						inv.setItem(inicio, Criar.getInstance().add("�7" + on.getName(), on.getName(), new String[] {"�7Total de den�ncias: �f" + config.getInt("Reports." + on.getName() + ".Total")}));
						inicio++;
						if(inicio == 44) {
							p.sendMessage("�cExistem mais den�ncias, mas nem todas puderam ser carregadas.");
						}
					}
				}
				
				
				p.openInventory(inv);
			}
			if(lb.equalsIgnoreCase("report") || (lb.equalsIgnoreCase("reportar"))) {
				if(args.length == 0) {
					p.sendMessage("�cVoc� deve usar: /" + lb.toLowerCase() + " <jogador>");
					return true;
				}
				if(args.length == 1) {
					String t = args[0];
					if(Bukkit.getPlayer(t) != null) {
						t = Bukkit.getPlayer(t).getName();
					}
					if(t.equalsIgnoreCase(p.getName())) {
						p.sendMessage("�cVoc� n�o pode reportar a si mesmo.");
						return true;
					}
					p.sendMessage("�ePara concluir sua den�ncia, escolha um dos motivos:");
					mandar(p, t, "Aimbot", "Aimbot", true);
					mandar(p, t, "Force Field", "Force-Field", false);
					mandar(p, t, "Auto Soup", "Auto-Soup", true);
					mandar(p, t, "Fly", "Fly", false);
					mandar(p, t, "Auto Armor", "Auto-Armor", true);
					mandar(p, t, "Auto Clicker", "Auto-Clicker", false);
					mandar(p, t, "Anti-Knockback", "Anti-Knockback", true);
					mandar(p, t, "X-Ray", "X-Ray", false);
					mandar(p, t, "Critical", "Critical", true);
					mandar(p, t, "No-Fall", "No-Fall", false);
					mandar(p, t, "Speed", "Speed", true);
					mandar(p, t, "Alian�a", "Alianca", false);
					p.sendMessage("");
					return true;
				}
				if(args.length > 1) {
					String t = args[0];
					if(Bukkit.getPlayer(t) != null) {
						t = Bukkit.getPlayer(t).getName();
					}
					if(t.equalsIgnoreCase(p.getName())) {
						p.sendMessage("�cVoc� n�o pode reportar a si mesmo.");
						return true;
					}
					String hack = args[1];
					reportar(p, t, hack);
					return true;
				}
			}
		}
		return false;
	}
	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if(e.getInventory().getName().equalsIgnoreCase("�8Todos os Reports")) {
			if(e.getCurrentItem() != null && (e.getCurrentItem().hasItemMeta() && (e.getCurrentItem().getItemMeta().hasDisplayName()))) {
				e.setCancelled(true);
				Player p = (Player) e.getWhoClicked();
				p.closeInventory();
				String display = e.getCurrentItem().getItemMeta().getDisplayName().replace("�7", "");
				
				File file = new File(Main.m.getDataFolder() + "/userdata", display.toLowerCase() + ".yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(file);
				
				Inventory inv = Bukkit.createInventory(null, 27, "�8Reports >> " + display);
				
				inv.setItem(11, Criar.getInstance().add(Material.STAINED_GLASS_PANE, "�cRecusar den�ncia(s)", new String[] {"�7Clique aqui para recusar as den�ncias."}, 14));
				inv.setItem(13, Criar.getInstance().add(Material.ENCHANTED_BOOK, "�aInforma��es das den�ncias", new String[] {"�7Total de den�ncias: " + config.getInt("Reports." + display + ".Total"), "", "�7Den�ncias:", " �7" + getHackName(config.getString("Reports." + display + ".UltimaRazao")) + ": " + config.getInt("Reports." + display + "." + config.getString("Reports." + display + ".UltimaRazao"))}, 5));
				inv.setItem(15, Criar.getInstance().add(Material.STAINED_GLASS_PANE, "�aAceitar den�ncia(s)", new String[] {"�7Clique aqui para aceitar as den�ncias."}, 5));
				
				p.openInventory(inv);
				
			}
		}
		if(e.getInventory().getName().startsWith("�8Reports >> ")) {
			if(e.getCurrentItem() != null && (e.getCurrentItem().hasItemMeta() && (e.getCurrentItem().getItemMeta().hasDisplayName()))) {
				e.setCancelled(true);
				Player p = (Player) e.getWhoClicked();
				String display = e.getCurrentItem().getItemMeta().getDisplayName();
				String player = e.getInventory().getName().replace("�8Reports >> ", "");
				
				File file = new File(Main.m.getDataFolder() + "/userdata", player.toLowerCase() + ".yml");
				FileConfiguration config = YamlConfiguration.loadConfiguration(file);
				
				if(display.equalsIgnoreCase("�cRecusar den�ncia(s)")) {
					p.sendMessage("�cVoc� recusou as den�ncias e todos os reports deste jogador foram removidos.");
					remover(player);
					p.closeInventory();
				}
				if(display.equalsIgnoreCase("�aAceitar den�ncia(s)")) {
					p.sendMessage("�aVoc� aceitou esta denuncia e o jogador foi automaticamente banido.");
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban " + player + " " + config.getString("Reports." + player + ".UltimaRazao"));
					remover(player);
					p.closeInventory();
				}
			}
		}
	}

}
