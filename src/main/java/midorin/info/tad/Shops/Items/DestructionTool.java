package midorin.info.tad.Shops.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class DestructionTool {

    public static final ItemStack WoodAxe = new ItemStack(Material.WOOD_AXE);
    public static final ItemMeta itemMeta1 = WoodAxe.getItemMeta();
    public static void getWoodAxe()
    {
        itemMeta1.setDisplayName(ChatColor.YELLOW + "木の斧");
        itemMeta1.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "200円"));
        itemMeta1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        WoodAxe.setItemMeta(itemMeta1);
    }

    public static final ItemStack StoneAxe = new ItemStack(Material.STONE_AXE);
    public static final ItemMeta itemMeta2 = StoneAxe.getItemMeta();
    public static void getStoneAxe()
    {
        itemMeta2.setDisplayName(ChatColor.YELLOW + "石の斧");
        itemMeta2.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "500円"));
        itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        StoneAxe.setItemMeta(itemMeta2);
    }

    public static final ItemStack IronAxe = new ItemStack(Material.IRON_AXE);
    public static final ItemMeta itemMeta3 = IronAxe.getItemMeta();
    public static void getIronAxe()
    {
        itemMeta3.setDisplayName(ChatColor.YELLOW + "鉄の斧");
        itemMeta3.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "700円"));
        itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        IronAxe.setItemMeta(itemMeta3);
    }

    public static final ItemStack GoldAxe = new ItemStack(Material.GOLD_AXE);
    public static final ItemMeta itemMeta4 = GoldAxe.getItemMeta();
    public static void getGoldAxe()
    {
        itemMeta4.setDisplayName(ChatColor.YELLOW + "金の斧");
        itemMeta4.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "1000円"));
        itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        GoldAxe.setItemMeta(itemMeta4);
    }

    public static final ItemStack DiamondAxe = new ItemStack(Material.DIAMOND_AXE);
    public static final ItemMeta itemMeta5 = DiamondAxe.getItemMeta();
    public static void getDiamondAxe()
    {
        itemMeta5.setDisplayName(ChatColor.YELLOW + "ダイヤモンドの斧");
        itemMeta5.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "2000円"));
        itemMeta5.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        DiamondAxe.setItemMeta(itemMeta5);
    }

    public static final ItemStack GoldPickaxe = new ItemStack(Material.GOLD_PICKAXE);
    public static final ItemMeta itemMeta6 = GoldPickaxe.getItemMeta();
    public static void getGoldPickaxe()
    {
        itemMeta6.setDisplayName(ChatColor.YELLOW + "金のピッケル");
        itemMeta6.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "1500円"));
        itemMeta6.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        GoldPickaxe.setItemMeta(itemMeta6);
    }

    public static final ItemStack DiamondPickaxe = new ItemStack(Material.DIAMOND_PICKAXE);
    public static final ItemMeta itemMeta7 = DiamondPickaxe.getItemMeta();
    public static void getDiamondPickaxe()
    {
        itemMeta7.setDisplayName(ChatColor.YELLOW + "ダイヤモンドのピッケル");
        itemMeta7.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "2000円"));
        itemMeta7.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        DiamondPickaxe.setItemMeta(itemMeta7);
    }
}
