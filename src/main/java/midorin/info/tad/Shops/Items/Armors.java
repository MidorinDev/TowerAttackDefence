package midorin.info.tad.Shops.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Armors {

    public static final ItemStack LeatherHelmet = new ItemStack(Material.LEATHER_HELMET);
    public static final ItemMeta itemMeta01 = LeatherHelmet.getItemMeta();
    public static void getLeatherHelmet()
    {
        itemMeta01.setDisplayName(ChatColor.YELLOW + "革のヘルメット");
        itemMeta01.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "100円"));
        itemMeta01.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        LeatherHelmet.setItemMeta(itemMeta01);
    }
    public static final ItemStack LeatherChestPlate = new ItemStack(Material.LEATHER_CHESTPLATE);
    public static final ItemMeta itemMeta02 = LeatherChestPlate.getItemMeta();
    public static void getLeatherChestPlate()
    {
        itemMeta02.setDisplayName(ChatColor.YELLOW + "革のチェストプレート");
        itemMeta02.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "150円"));
        itemMeta02.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        LeatherChestPlate.setItemMeta(itemMeta02);
    }
    public static final ItemStack LeatherLeggings = new ItemStack(Material.LEATHER_LEGGINGS);
    public static final ItemMeta itemMeta03 = LeatherLeggings.getItemMeta();
    public static void getLeatherLeggings()
    {
        itemMeta03.setDisplayName(ChatColor.YELLOW + "革のレギンス");
        itemMeta03.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "150円"));
        itemMeta03.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        LeatherLeggings.setItemMeta(itemMeta03);
    }
    public static final ItemStack LeatherBoots = new ItemStack(Material.LEATHER_BOOTS);
    public static final ItemMeta itemMeta04 = LeatherBoots.getItemMeta();
    public static void getLeatherBoots()
    {
        itemMeta04.setDisplayName(ChatColor.YELLOW + "革のブーツ");
        itemMeta04.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "100円"));
        itemMeta04.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        LeatherBoots.setItemMeta(itemMeta04);
    }



    public static final ItemStack ChainmailHelmet = new ItemStack(Material.CHAINMAIL_HELMET);
    public static final ItemMeta itemMeta11 = ChainmailHelmet.getItemMeta();
    public static void getChainmailHelmet()
    {
        itemMeta11.setDisplayName(ChatColor.YELLOW + "チェーンのヘルメット");
        itemMeta11.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "200円"));
        itemMeta11.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ChainmailHelmet.setItemMeta(itemMeta11);
    }
    public static final ItemStack ChainmailChestPlate = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
    public static final ItemMeta itemMeta12 = ChainmailChestPlate.getItemMeta();
    public static void getChainmailChestPlate()
    {
        itemMeta12.setDisplayName(ChatColor.YELLOW + "チェーンのチェストプレート");
        itemMeta12.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "250円"));
        itemMeta12.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ChainmailChestPlate.setItemMeta(itemMeta12);
    }
    public static final ItemStack ChainmailLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS);
    public static final ItemMeta itemMeta13 = ChainmailLeggings.getItemMeta();
    public static void getChainmailLeggings()
    {
        itemMeta13.setDisplayName(ChatColor.YELLOW + "チェーンのレギンス");
        itemMeta13.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "250円"));
        itemMeta13.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ChainmailLeggings.setItemMeta(itemMeta13);
    }
    public static final ItemStack ChainmailBoots = new ItemStack(Material.CHAINMAIL_BOOTS);
    public static final ItemMeta itemMeta14 = ChainmailBoots.getItemMeta();
    public static void getChainmailBoots()
    {
        itemMeta14.setDisplayName(ChatColor.YELLOW + "チェーンのブーツ");
        itemMeta14.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "200円"));
        itemMeta14.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ChainmailBoots.setItemMeta(itemMeta14);
    }



    public static final ItemStack IronHelmet = new ItemStack(Material.IRON_HELMET);
    public static final ItemMeta itemMeta21 = IronHelmet.getItemMeta();
    public static void getIronHelmet()
    {
        itemMeta21.setDisplayName(ChatColor.YELLOW + "鉄のヘルメット");
        itemMeta21.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "400円"));
        itemMeta21.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        IronHelmet.setItemMeta(itemMeta21);
    }
    public static final ItemStack IronChestPlate = new ItemStack(Material.IRON_CHESTPLATE);
    public static final ItemMeta itemMeta22 = IronChestPlate.getItemMeta();
    public static void getIronChestPlate()
    {
        itemMeta22.setDisplayName(ChatColor.YELLOW + "鉄のチェストプレート");
        itemMeta22.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "470円"));
        itemMeta22.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        IronChestPlate.setItemMeta(itemMeta22);
    }
    public static final ItemStack IronLeggings = new ItemStack(Material.IRON_LEGGINGS);
    public static final ItemMeta itemMeta23 = IronLeggings.getItemMeta();
    public static void getIronLeggings()
    {
        itemMeta23.setDisplayName(ChatColor.YELLOW + "鉄のレギンス");
        itemMeta23.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "470円"));
        itemMeta23.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        IronLeggings.setItemMeta(itemMeta23);
    }
    public static final ItemStack IronBoots = new ItemStack(Material.IRON_BOOTS);
    public static final ItemMeta itemMeta24 = IronBoots.getItemMeta();
    public static void getIronBoots()
    {
        itemMeta24.setDisplayName(ChatColor.YELLOW + "鉄のブーツ");
        itemMeta24.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "400円"));
        itemMeta24.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        IronBoots.setItemMeta(itemMeta24);
    }



    public static final ItemStack GoldHelmet = new ItemStack(Material.GOLD_HELMET);
    public static final ItemMeta itemMeta31 = GoldHelmet.getItemMeta();
    public static void getGoldHelmet()
    {
        itemMeta31.setDisplayName(ChatColor.YELLOW + "金のヘルメット");
        itemMeta31.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "600円"));
        itemMeta31.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        GoldHelmet.setItemMeta(itemMeta31);
    }
    public static final ItemStack GoldChestPlate = new ItemStack(Material.GOLD_CHESTPLATE);
    public static final ItemMeta itemMeta32 = GoldChestPlate.getItemMeta();
    public static void getGoldChestPlate()
    {
        itemMeta32.setDisplayName(ChatColor.YELLOW + "金のチェストプレート");
        itemMeta32.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "650円"));
        itemMeta32.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        GoldChestPlate.setItemMeta(itemMeta32);
    }
    public static final ItemStack GoldLeggings = new ItemStack(Material.GOLD_LEGGINGS);
    public static final ItemMeta itemMeta33 = GoldLeggings.getItemMeta();
    public static void getGoldLeggings()
    {
        itemMeta33.setDisplayName(ChatColor.YELLOW + "金のレギンス");
        itemMeta33.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "650円"));
        itemMeta33.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        GoldLeggings.setItemMeta(itemMeta33);
    }
    public static final ItemStack GoldBoots = new ItemStack(Material.GOLD_BOOTS);
    public static final ItemMeta itemMeta34 = GoldBoots.getItemMeta();
    public static void getGoldBoots()
    {
        itemMeta34.setDisplayName(ChatColor.YELLOW + "金のブーツ");
        itemMeta34.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "600円"));
        itemMeta34.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        GoldBoots.setItemMeta(itemMeta34);
    }



    public static final ItemStack DiamondHelmet = new ItemStack(Material.DIAMOND_HELMET);
    public static final ItemMeta itemMeta41 = DiamondHelmet.getItemMeta();
    public static void getDiamondHelmet()
    {
        itemMeta41.setDisplayName(ChatColor.YELLOW + "ダイヤモンドのヘルメット");
        itemMeta41.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "1000円"));
        itemMeta41.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        DiamondHelmet.setItemMeta(itemMeta41);
    }
    public static final ItemStack DiamondChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE);
    public static final ItemMeta itemMeta42 = DiamondChestPlate.getItemMeta();
    public static void getDiamondChestPlate()
    {
        itemMeta42.setDisplayName(ChatColor.YELLOW + "ダイヤモンドのチェストプレート");
        itemMeta42.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "1200円"));
        itemMeta42.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        DiamondChestPlate.setItemMeta(itemMeta42);
    }
    public static final ItemStack DiamondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
    public static final ItemMeta itemMeta43 = DiamondLeggings.getItemMeta();
    public static void getDiamondLeggings()
    {
        itemMeta43.setDisplayName(ChatColor.YELLOW + "ダイヤモンドのレギンス");
        itemMeta43.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "1200円"));
        itemMeta43.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        DiamondLeggings.setItemMeta(itemMeta43);
    }
    public static final ItemStack DiamondBoots = new ItemStack(Material.DIAMOND_BOOTS);
    public static final ItemMeta itemMeta44 = DiamondBoots.getItemMeta();
    public static void getDiamondBoots()
    {
        itemMeta44.setDisplayName(ChatColor.YELLOW + "ダイヤモンドのブーツ");
        itemMeta44.setLore(Arrays.asList(ChatColor.GOLD + "値段: " + ChatColor.WHITE + "1000円"));
        itemMeta44.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        DiamondBoots.setItemMeta(itemMeta44);
    }

}
