package midorin.info.tad.Shops.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Others {

    public static final ItemStack SnowBall = new ItemStack(Material.SNOW_BALL);
    public static final ItemMeta itemMeta1 = SnowBall.getItemMeta();
    public static void getSnowBall()
    {
        itemMeta1.setDisplayName(ChatColor.YELLOW + "骨折ボール");
        itemMeta1.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "3000円"));
        SnowBall.setItemMeta(itemMeta1);
    }

    public static final ItemStack SnowBallItem = new ItemStack(Material.SNOW_BALL);
    public static final ItemMeta itemMeta1Item = SnowBallItem.getItemMeta();
    public static void getSnowBallItem()
    {
        itemMeta1Item.setDisplayName(ChatColor.YELLOW + "骨折ボール");
        itemMeta1Item.setLore(Arrays.asList(ChatColor.GRAY + "一撃で相手を倒すことができる。"));
        itemMeta1Item.addEnchant(Enchantment.KNOCKBACK, 0,false);
        itemMeta1Item.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        SnowBallItem.setItemMeta(itemMeta1Item);
    }

    public static final ItemStack Fence = new ItemStack(Material.FENCE);
    public static final ItemMeta itemMeta2 = Fence.getItemMeta();
    public static void getFence()
    {
        itemMeta2.setDisplayName(ChatColor.YELLOW + "木の柵32個");
        itemMeta2.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "1000円"));
        Fence.setItemMeta(itemMeta2);
    }

    public static final ItemStack Wool = new ItemStack(Material.WOOL);
    public static final ItemMeta itemMeta3 = Wool.getItemMeta();
    public static void getWool()
    {
        itemMeta3.setDisplayName(ChatColor.YELLOW + "羊毛16個");
        itemMeta3.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "500円"));
        Wool.setItemMeta(itemMeta3);
    }

}
