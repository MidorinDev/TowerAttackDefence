package midorin.info.tad.Shops.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Weapons {

    public static final ItemStack WoodSword = new ItemStack(Material.WOOD_SWORD);
    public static final ItemMeta itemMeta1 = WoodSword.getItemMeta();
    public static void getWoodSword()
    {
        itemMeta1.setDisplayName(ChatColor.YELLOW + "木の剣");
        itemMeta1.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "200円"));
        WoodSword.setItemMeta(itemMeta1);
    }

    public static final ItemStack StoneSword = new ItemStack(Material.STONE_SWORD);
    public static final ItemMeta itemMeta2 = StoneSword.getItemMeta();
    public static void getStoneSword()
    {
        itemMeta2.setDisplayName(ChatColor.YELLOW + "石の剣");
        itemMeta2.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "500円"));
        StoneSword.setItemMeta(itemMeta2);
    }

    public static final ItemStack IronSword = new ItemStack(Material.IRON_SWORD);
    public static final ItemMeta itemMeta3 = IronSword.getItemMeta();
    public static void getIronSword()
    {
        itemMeta3.setDisplayName(ChatColor.YELLOW + "鉄の剣");
        itemMeta3.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "1000円"));
        IronSword.setItemMeta(itemMeta3);
    }

    public static final ItemStack GoldSword = new ItemStack(Material.GOLD_SWORD);
    public static final ItemMeta itemMeta4 = GoldSword.getItemMeta();
    public static void getGoldSword()
    {
        itemMeta4.setDisplayName(ChatColor.YELLOW + "金の剣");
        itemMeta4.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "2500円"));
        GoldSword.setItemMeta(itemMeta4);
    }

    public static final ItemStack DiamondSword = new ItemStack(Material.DIAMOND_SWORD);
    public static final ItemMeta itemMeta5 = DiamondSword.getItemMeta();
    public static void getDiamondSword()
    {
        itemMeta5.setDisplayName(ChatColor.YELLOW + "ダイヤの剣");
        itemMeta5.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "5000円"));
        DiamondSword.setItemMeta(itemMeta5);
    }

    public static final ItemStack Bow = new ItemStack(Material.BOW);
    public static final ItemMeta itemMeta6 = Bow.getItemMeta();
    public static void getBow()
    {
        itemMeta6.setDisplayName(ChatColor.YELLOW + "弓");
        itemMeta6.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "1000円"));
        Bow.setItemMeta(itemMeta6);
    }

    public static final ItemStack Arrow = new ItemStack(Material.ARROW);
    public static final ItemMeta itemMeta7 = Arrow.getItemMeta();
    public static void getArrow()
    {
        itemMeta7.setDisplayName(ChatColor.YELLOW + "矢5本");
        itemMeta7.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "300円"));
        Arrow.setItemMeta(itemMeta7);
    }

}
