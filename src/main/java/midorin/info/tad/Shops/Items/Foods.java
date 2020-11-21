package midorin.info.tad.Shops.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Foods {

    public static final ItemStack Bread = new ItemStack(Material.BREAD);
    public static final ItemMeta itemMeta1 = Bread.getItemMeta();
    public static void getBread()
    {
        itemMeta1.setDisplayName(ChatColor.YELLOW + "ぱさぱさのパン5個");
        itemMeta1.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "200円"));
        Bread.setItemMeta(itemMeta1);
    }

    public static final ItemStack Apple = new ItemStack(Material.APPLE);
    public static final ItemMeta itemMeta2 = Apple.getItemMeta();
    public static void getApple()
    {
        itemMeta2.setDisplayName(ChatColor.YELLOW + "りんご");
        itemMeta2.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "110円"));
        Apple.setItemMeta(itemMeta2);
    }

    public static final ItemStack Steak = new ItemStack(Material.COOKED_BEEF);
    public static final ItemMeta itemMeta3 = Steak.getItemMeta();
    public static void getSteak()
    {
        itemMeta3.setDisplayName(ChatColor.YELLOW + "ステーキ");
        itemMeta3.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "300円"));
        Steak.setItemMeta(itemMeta3);
    }

    public static final ItemStack GoldenApple = new ItemStack(Material.GOLDEN_APPLE);
    public static final ItemMeta itemMeta4 = GoldenApple.getItemMeta();
    public static void getGoldenApple()
    {
        itemMeta4.setDisplayName(ChatColor.YELLOW + "金のりんご");
        itemMeta4.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "1000円"));
        GoldenApple.setItemMeta(itemMeta4);
    }
}
