package me.NickUltracraft.Report.API;
 
import java.util.Arrays;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
 
public class Criar {
	
	public static enum Cabe�a {
    	OTIMO, BOM, ACEITAVEL, PESSIMO, LAG;
    }  
    public static Criar getInstance() {
    	return new Criar();
    }

    public ItemStack add(Material m){
        return new ItemStack(m);
    }
    public ItemStack add(Material m, int quantidade){
        return new ItemStack(m,quantidade);
    }
    public ItemStack add(Material m, String nome){
        ItemStack item = new ItemStack(m);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack add1(Material m, String nome, int quantidade){
        ItemStack item = new ItemStack(m,quantidade);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack add(Material m, String nome, Enchantment ench , int level){
        ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(ench, level);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack add(Material m , String nome , int durability){
        ItemStack item = new ItemStack(m);
        item.setDurability((short) durability);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack add(Material m , String nome , int quantidade , String nada){
        ItemStack item = new ItemStack(m);
        item.setAmount(quantidade);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
	public ItemStack add(String nome , String dono , String[] lore){
        ItemStack item = new ItemStack(Material.SKULL_ITEM, 1);
        item.setDurability((short) 3);
        SkullMeta skull = (SkullMeta)item.getItemMeta();
        skull.setDisplayName(nome);
        skull.setOwner(dono);
        skull.setLore(Arrays.asList(lore));
        item.setItemMeta(skull);
        return item;
    }
    public ItemStack add(Material m , String nome ,String[] lore, int durability){
        ItemStack item = new ItemStack(m);
        item.setDurability((short) durability);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        meta.setLore(Arrays.asList(lore));
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack add(Material m, String nome , String[] lore){
        ItemStack item = new ItemStack(m);
        ItemMeta meta = item.getItemMeta();
        meta.addItemFlags(ItemFlag.values());
        meta.setLore(Arrays.asList(lore));
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack add(Material m, String nome , String[] lore, Enchantment enchant , int lvl){
        ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant, lvl);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack add(Material m, String nome , String[] lore, Enchantment enchant1 , int lvl1 ,  Enchantment enchant2 , int lvl2){
        ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant1, lvl1);
        item.addUnsafeEnchantment(enchant2, lvl2);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack add(Material m, String nome , String[] lore, Enchantment enchant1 , int lvl1 ,  Enchantment enchant2 , int lvl2,  Enchantment enchant3 , int lvl3){
        ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant1, lvl1);
        item.addUnsafeEnchantment(enchant2, lvl2);
        item.addUnsafeEnchantment(enchant3, lvl3);
        ItemMeta meta = item.getItemMeta();
        meta.setLore(Arrays.asList(lore));
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack potion(PotionEffectType efeito, String nome , String[] lore){
        ItemStack item = new ItemStack(Material.POTION);
        PotionMeta eta = (PotionMeta)item.getItemMeta();
        eta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 60*60, 9), true);
        eta.setLore(Arrays.asList(lore));
        eta.setDisplayName(nome);
        item.setItemMeta(eta);
        return item;
    }
    public ItemStack couro(){
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
        meta.setColor(Color.BLUE);
        meta.setDisplayName("�bArmadura de Couro");
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack couro(Color cor, String nome){
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        item.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
        LeatherArmorMeta meta = (LeatherArmorMeta)item.getItemMeta();
        meta.setColor(cor);
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    @SuppressWarnings("deprecation")
	public ItemStack getNamedSkull(String nick, String nome , String[] lore) {
    	ItemStack skull = new ItemStack(397, 1, (short)3);
        SkullMeta meta = (SkullMeta)skull.getItemMeta();
        meta.setDisplayName(nome);
        meta.setLore(Arrays.asList(lore));
        meta.setOwner(nick);
        skull.setItemMeta(meta);
        return skull;
    }
    public ItemStack outro(Material m, String nome , Enchantment enchant , int lvl){
        ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant, lvl);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack outro(Material m, String nome ,Enchantment enchant1 , int lvl1 ,  Enchantment enchant2 , int lvl2){
        ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant1, lvl1);
        item.addUnsafeEnchantment(enchant2, lvl2);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
    public ItemStack outro(Material m, String nome ,Enchantment enchant1 , int lvl1 ,  Enchantment enchant2 , int lvl2,  Enchantment enchant3 , int lvl3){
        ItemStack item = new ItemStack(m);
        item.addUnsafeEnchantment(enchant1, lvl1);
        item.addUnsafeEnchantment(enchant2, lvl2);
        item.addUnsafeEnchantment(enchant3, lvl3);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        item.setItemMeta(meta);
        return item;
    }
}