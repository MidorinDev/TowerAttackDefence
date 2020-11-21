package midorin.info.tad.Shops.Items;

import midorin.info.tad.Teams.Defenders;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class Icons {

    public static final ItemStack GuiBackIcon = new ItemStack(Material.BARRIER);
    public static final ItemMeta itemMeta00 = GuiBackIcon.getItemMeta();
    public static void getGuiBackIcon()
    {
        itemMeta00.setDisplayName(ChatColor.RED + "Back");
        GuiBackIcon.setItemMeta(itemMeta00);
    }

    public static final ItemStack NoItemGlass = new ItemStack(Material.STAINED_GLASS_PANE);
    public static final ItemMeta itemMeta0 = NoItemGlass.getItemMeta();
    public static void getGuiNoItem()
    {
        itemMeta0.setDisplayName(" ");
        NoItemGlass.setItemMeta(itemMeta0);
    }

    public static final ItemStack WeaponIcon = new ItemStack(Material.DIAMOND_SWORD);
    public static final ItemMeta itemMeta1 = WeaponIcon.getItemMeta();
    public static void getGuiWeaponIcon()
    {
        itemMeta1.setDisplayName(ChatColor.YELLOW + "武器カテゴリー");
        itemMeta1.setLore(Arrays.asList(ChatColor.GRAY + "様々な武器を購入することができます。"));
        itemMeta1.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        WeaponIcon.setItemMeta(itemMeta1);
    }

    public static final ItemStack ArmorIcon = new ItemStack(Material.GOLD_CHESTPLATE);
    public static final ItemMeta itemMeta2 = ArmorIcon.getItemMeta();
    public static void getGuiArmorIcon()
    {
        itemMeta2.setDisplayName(ChatColor.YELLOW + "防具カテゴリー");
        itemMeta2.setLore(Arrays.asList(ChatColor.GRAY + "様々な防具を購入することができます。"));
        itemMeta2.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        ArmorIcon.setItemMeta(itemMeta2);
    }

    public static final ItemStack AttackerIcon = new ItemStack(Material.GOLD_PICKAXE);
    public static final ItemMeta itemMeta3 = AttackerIcon.getItemMeta();
    public static void getGuiAttackerIcon()
    {
        itemMeta3.setDisplayName(ChatColor.YELLOW + "アタッカーショップ");
        itemMeta3.setLore(Arrays.asList(ChatColor.GRAY + "アタッカーに表示されるショップ"));
        itemMeta3.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        AttackerIcon.setItemMeta(itemMeta3);
    }

    public static final ItemStack DefenceIcon = new ItemStack(Material.SHIELD);
    public static final ItemMeta itemMeta4 = DefenceIcon.getItemMeta();
    public static void getGuiDefenceIcon()
    {
        itemMeta4.setDisplayName(ChatColor.YELLOW + "ディフェンダーショップ");
        itemMeta4.setLore(Arrays.asList(ChatColor.GRAY + "ディフェンダーに表示されるショップ"));
        itemMeta4.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        DefenceIcon.setItemMeta(itemMeta4);
    }

    public static final ItemStack DestructionToolIcon = new ItemStack(Material.IRON_PICKAXE);
    public static final ItemMeta itemMeta5 = DestructionToolIcon.getItemMeta();
    public static void getGuiDestructionToolIcon()
    {
        itemMeta5.setDisplayName(ChatColor.YELLOW + "破壊道具カテゴリー");
        itemMeta5.setLore(Arrays.asList(ChatColor.GRAY + "様々な破壊ツールを購入することができます。"));
        itemMeta5.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        DestructionToolIcon.setItemMeta(itemMeta5);
    }

    public static final ItemStack FoodIcon = new ItemStack(Material.APPLE);
    public static final ItemMeta itemMeta7 = FoodIcon.getItemMeta();
    public static void getGuiFoodIcon()
    {
        itemMeta7.setDisplayName(ChatColor.YELLOW + "食料カテゴリー");
        itemMeta7.setLore(Arrays.asList(ChatColor.GRAY + "様々な食料を購入することができます。"));
        FoodIcon.setItemMeta(itemMeta7);
    }

    public static final ItemStack SpecialItemIcon = new ItemStack(Material.ENDER_PEARL);
    public static final ItemMeta itemMeta8 = SpecialItemIcon.getItemMeta();
    public static void getGuiSpecialItemIcon()
    {
        itemMeta8.setDisplayName(ChatColor.YELLOW + "特殊アイテムカテゴリー");
        itemMeta8.setLore(Arrays.asList(ChatColor.GRAY + "様々な特殊ツールを購入することができます。"));
        SpecialItemIcon.setItemMeta(itemMeta8);
    }

    public static final ItemStack DefenceItemIcon = new ItemStack(Material.FENCE);
    public static final ItemMeta itemMeta9 = DefenceItemIcon.getItemMeta();
    public static void getGuiDefenceItemicon()
    {
        itemMeta9.setDisplayName(ChatColor.YELLOW + "防衛アイテムカテゴリー");
        itemMeta9.setLore(Arrays.asList(ChatColor.GRAY + "コアを防衛するためのブロックを購入することができます。"));
        DefenceItemIcon.setItemMeta(itemMeta9);
    }

}
