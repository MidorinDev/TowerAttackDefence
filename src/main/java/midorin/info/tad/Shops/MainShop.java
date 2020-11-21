package midorin.info.tad.Shops;

import midorin.info.tad.Shops.Items.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class MainShop {

    public static Inventory attackerShop = Bukkit.createInventory(null, 45, ChatColor.DARK_GREEN + "攻撃チームショップ");
    public static Inventory defenderShop = Bukkit.createInventory(null, 45, ChatColor.DARK_GREEN + "防衛チームショップ");
    public static Inventory shopManage = Bukkit.createInventory(null, 45, ChatColor.DARK_AQUA + "ショップ管理");

    public static Inventory weaponsShop = Bukkit.createInventory(null, 45, ChatColor.RED + "武器カテゴリー");
    public static Inventory armorShop = Bukkit.createInventory(null, 54, ChatColor.RED + "防具カテゴリー");
    public static Inventory destructionToolShop = Bukkit.createInventory(null, 45, ChatColor.RED + "破壊道具カテゴリー");
    public static Inventory defenceItemShop = Bukkit.createInventory(null, 45, ChatColor.RED + "防衛アイテムカテゴリー");
    public static Inventory foodShop = Bukkit.createInventory(null, 45, ChatColor.RED + "食料カテゴリー");
    public static Inventory othersShop = Bukkit.createInventory(null, 45, ChatColor.RED + "その他カテゴリー");

    public static void onShopsSetup()
    {
        // 自作アイテム
        Others.getSnowBallItem();
        // ショップマネージャーGUI | アイテム
        Icons.getGuiAttackerIcon();
        Icons.getGuiDefenceIcon();
        shopManage.setItem(20, new ItemStack(Icons.AttackerIcon));
        shopManage.setItem(24, new ItemStack(Icons.DefenceIcon));
        // アタッカー購入GUI | アイテム
        Icons.getGuiWeaponIcon();
        Icons.getGuiArmorIcon();
        Icons.getGuiDestructionToolIcon();
        Icons.getGuiFoodIcon();
        Icons.getGuiSpecialItemIcon();
        Icons.getGuiDefenceItemicon();
        attackerShop.setItem(20, new ItemStack(Icons.WeaponIcon));
        attackerShop.setItem(21, new ItemStack(Icons.ArmorIcon));
        attackerShop.setItem(22, new ItemStack(Icons.DestructionToolIcon));
        attackerShop.setItem(23, new ItemStack(Icons.FoodIcon));
        attackerShop.setItem(24, new ItemStack(Icons.SpecialItemIcon));
        // ディフェンダー購入GUI | アイテム
        defenderShop.setItem(20, new ItemStack(Icons.WeaponIcon));
        defenderShop.setItem(21, new ItemStack(Icons.ArmorIcon));
        defenderShop.setItem(22, new ItemStack(Icons.DefenceItemIcon));
        defenderShop.setItem(23, new ItemStack(Icons.DestructionToolIcon));
        defenderShop.setItem(24, new ItemStack(Icons.FoodIcon));


        // 武器カテゴリー | アイテム
        Weapons.getWoodSword();
        Weapons.getStoneSword();
        Weapons.getIronSword();
        Weapons.getGoldSword();
        Weapons.getDiamondSword();
        Weapons.getBow();
        Weapons.getArrow();
        weaponsShop.setItem(19, new ItemStack(Weapons.WoodSword));
        weaponsShop.setItem(20, new ItemStack(Weapons.StoneSword));
        weaponsShop.setItem(21, new ItemStack(Weapons.IronSword));
        weaponsShop.setItem(22, new ItemStack(Weapons.GoldSword));
        weaponsShop.setItem(23, new ItemStack(Weapons.DiamondSword));
        weaponsShop.setItem(24, new ItemStack(Weapons.Bow));
        weaponsShop.setItem(25, new ItemStack(Weapons.Arrow));

        // 防具カテゴリー | アイテム
        Armors.getLeatherHelmet();
        Armors.getLeatherChestPlate();
        Armors.getLeatherLeggings();
        Armors.getLeatherBoots();
        armorShop.setItem(11, new ItemStack(Armors.LeatherHelmet));
        armorShop.setItem(20, new ItemStack(Armors.LeatherChestPlate));
        armorShop.setItem(29, new ItemStack(Armors.LeatherLeggings));
        armorShop.setItem(38, new ItemStack(Armors.LeatherBoots));
        Armors.getChainmailHelmet();
        Armors.getChainmailChestPlate();
        Armors.getChainmailLeggings();
        Armors.getChainmailBoots();
        armorShop.setItem(12, new ItemStack(Armors.ChainmailHelmet));
        armorShop.setItem(21, new ItemStack(Armors.ChainmailChestPlate));
        armorShop.setItem(30, new ItemStack(Armors.ChainmailLeggings));
        armorShop.setItem(39, new ItemStack(Armors.ChainmailBoots));
        Armors.getIronHelmet();
        Armors.getIronChestPlate();
        Armors.getIronLeggings();
        Armors.getIronBoots();
        armorShop.setItem(13, new ItemStack(Armors.IronHelmet));
        armorShop.setItem(22, new ItemStack(Armors.IronChestPlate));
        armorShop.setItem(31, new ItemStack(Armors.IronLeggings));
        armorShop.setItem(40, new ItemStack(Armors.IronBoots));
        Armors.getGoldHelmet();
        Armors.getGoldChestPlate();
        Armors.getGoldLeggings();
        Armors.getGoldBoots();
        armorShop.setItem(14, new ItemStack(Armors.GoldHelmet));
        armorShop.setItem(23, new ItemStack(Armors.GoldChestPlate));
        armorShop.setItem(32, new ItemStack(Armors.GoldLeggings));
        armorShop.setItem(41, new ItemStack(Armors.GoldBoots));
        Armors.getDiamondHelmet();
        Armors.getDiamondChestPlate();
        Armors.getDiamondLeggings();
        Armors.getDiamondBoots();
        armorShop.setItem(15, new ItemStack(Armors.DiamondHelmet));
        armorShop.setItem(24, new ItemStack(Armors.DiamondChestPlate));
        armorShop.setItem(33, new ItemStack(Armors.DiamondLeggings));
        armorShop.setItem(42, new ItemStack(Armors.DiamondBoots));

        // 破壊道具カテゴリー | アイテム
        DestructionTool.getWoodAxe();
        DestructionTool.getStoneAxe();
        DestructionTool.getIronAxe();
        DestructionTool.getGoldAxe();
        DestructionTool.getDiamondAxe();
        DestructionTool.getGoldPickaxe();
        DestructionTool.getDiamondPickaxe();
        destructionToolShop.setItem(19, new ItemStack(DestructionTool.WoodAxe));
        destructionToolShop.setItem(20, new ItemStack(DestructionTool.StoneAxe));
        destructionToolShop.setItem(21, new ItemStack(DestructionTool.IronAxe));
        destructionToolShop.setItem(22, new ItemStack(DestructionTool.GoldAxe));
        destructionToolShop.setItem(23, new ItemStack(DestructionTool.DiamondAxe));
        destructionToolShop.setItem(24, new ItemStack(DestructionTool.GoldPickaxe));
        destructionToolShop.setItem(25, new ItemStack(DestructionTool.DiamondPickaxe));

        // 食料カテゴリー | アイテム
        Foods.getBread();
        Foods.getApple();
        Foods.getSteak();
        Foods.getGoldenApple();
        foodShop.setItem(19, new ItemStack(Foods.Bread));
        foodShop.setItem(20, new ItemStack(Foods.Apple));
        foodShop.setItem(21, new ItemStack(Foods.Steak));
        foodShop.setItem(22, new ItemStack(Foods.GoldenApple));

        // その他カテゴリー | アイテム
        Others.getFence();
        Others.getWool();
        Others.getSnowBall();
        othersShop.setItem(19, new ItemStack(Others.Fence));
        othersShop.setItem(20, new ItemStack(Others.Wool));
        othersShop.setItem(21, new ItemStack(Others.SnowBall));

        // ショップマネージャーGUI枠 ⇓
        Icons.getGuiNoItem();
        Icons.getGuiBackIcon();
        onGuiFrame45(shopManage);
        // アタッカー購入GUI枠 ⇓
        onGuiFrame45(attackerShop);
        // ディフェンダー購入GUI枠 ⇓
        onGuiFrame45(defenderShop);
        // 武器カテゴリーGUI枠 ⇓
        onGuiFrame45(weaponsShop);
        // 防具カテゴリーGUI枠 ⇓
        onGuiFrame40(armorShop);
        // 破壊道具カテゴリーGUI枠 ⇓
        onGuiFrame45(destructionToolShop);
        // 食料カテゴリーGUI枠 ⇓
        onGuiFrame45(foodShop);
        // 特殊アイテムカテゴリーGUI枠 ⇓
        onGuiFrame45(othersShop);
        // 防衛アイテムカテゴリーGUI枠 ⇓
        onGuiFrame45(defenceItemShop);
    }

    public static void onGuiFrame45(Inventory shop)
    {
        shop.setItem(0, new ItemStack(Icons.NoItemGlass));
        shop.setItem(1, new ItemStack(Icons.NoItemGlass));
        shop.setItem(2, new ItemStack(Icons.NoItemGlass));
        shop.setItem(3, new ItemStack(Icons.NoItemGlass));
        shop.setItem(4, new ItemStack(Icons.NoItemGlass));
        shop.setItem(5, new ItemStack(Icons.NoItemGlass));
        shop.setItem(6, new ItemStack(Icons.NoItemGlass));
        shop.setItem(7, new ItemStack(Icons.NoItemGlass));
        shop.setItem(8, new ItemStack(Icons.NoItemGlass));
        shop.setItem(36, new ItemStack(Icons.NoItemGlass));
        shop.setItem(37, new ItemStack(Icons.NoItemGlass));
        shop.setItem(38, new ItemStack(Icons.NoItemGlass));
        shop.setItem(39, new ItemStack(Icons.NoItemGlass));
        shop.setItem(40, new ItemStack(Icons.NoItemGlass));
        shop.setItem(41, new ItemStack(Icons.NoItemGlass));
        shop.setItem(42, new ItemStack(Icons.NoItemGlass));
        shop.setItem(43, new ItemStack(Icons.NoItemGlass));
        shop.setItem(44, new ItemStack(Icons.GuiBackIcon));
    }
    public static void onGuiFrame40(Inventory shop)
    {
        shop.setItem(0, new ItemStack(Icons.NoItemGlass));
        shop.setItem(1, new ItemStack(Icons.NoItemGlass));
        shop.setItem(2, new ItemStack(Icons.NoItemGlass));
        shop.setItem(3, new ItemStack(Icons.NoItemGlass));
        shop.setItem(4, new ItemStack(Icons.NoItemGlass));
        shop.setItem(5, new ItemStack(Icons.NoItemGlass));
        shop.setItem(6, new ItemStack(Icons.NoItemGlass));
        shop.setItem(7, new ItemStack(Icons.NoItemGlass));
        shop.setItem(8, new ItemStack(Icons.NoItemGlass));
        shop.setItem(45, new ItemStack(Icons.NoItemGlass));
        shop.setItem(46, new ItemStack(Icons.NoItemGlass));
        shop.setItem(47, new ItemStack(Icons.NoItemGlass));
        shop.setItem(48, new ItemStack(Icons.NoItemGlass));
        shop.setItem(49, new ItemStack(Icons.NoItemGlass));
        shop.setItem(50, new ItemStack(Icons.NoItemGlass));
        shop.setItem(51, new ItemStack(Icons.NoItemGlass));
        shop.setItem(52, new ItemStack(Icons.NoItemGlass));
        shop.setItem(53, new ItemStack(Icons.GuiBackIcon));
    }
}