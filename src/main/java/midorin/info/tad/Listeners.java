package midorin.info.tad;

import midorin.info.tad.Shops.Items.Others;
import midorin.info.tad.Shops.MainShop;
import midorin.info.tad.Teams.Admins;
import midorin.info.tad.Teams.Attackers;
import midorin.info.tad.Teams.Defenders;
import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Listeners implements Listener {

    @EventHandler
    public void onBreakGiveMoney(BlockBreakEvent e)
    {
        if (Variables.GameManageInt == 1)
        {
            if (e.getBlock().getType() == Material.COAL_ORE && e.getPlayer().getGameMode() == GameMode.SURVIVAL)
            {
                TowerAttackDefence.jecon.getRepository().deposit(e.getPlayer().getUniqueId(), 10D);
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 50, 1);
                e.getPlayer().sendMessage(ChatColor.GOLD + "[+] " + ChatColor.WHITE + "10円");
                Variables.onCoalRestoration(e);
                e.setCancelled(true);
                e.getBlock().setType(Material.COBBLESTONE);

            }
            else if (e.getBlock().getType() == Material.IRON_ORE && e.getPlayer().getGameMode() == GameMode.SURVIVAL)
            {
                TowerAttackDefence.jecon.getRepository().deposit(e.getPlayer().getUniqueId(), 50D);
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 50, 1);
                e.getPlayer().sendMessage(ChatColor.GOLD + "[+] " + ChatColor.WHITE + "50円");
                Variables.onIronRestoration(e);
                e.setCancelled(true);
                e.getBlock().setType(Material.COBBLESTONE);

            }
            else if (e.getBlock().getType() == Material.GOLD_ORE && e.getPlayer().getGameMode() == GameMode.SURVIVAL)
            {
                TowerAttackDefence.jecon.getRepository().deposit(e.getPlayer().getUniqueId(), 100D);
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 50, 1);
                e.getPlayer().sendMessage(ChatColor.GOLD + "[+] " + ChatColor.WHITE + "100円");
                Variables.onGoldRestoration(e);
                e.setCancelled(true);
                e.getBlock().setType(Material.COBBLESTONE);

            }
            else if (e.getBlock().getType() == Material.DIAMOND_ORE && e.getPlayer().getGameMode() == GameMode.SURVIVAL)
            {
                TowerAttackDefence.jecon.getRepository().deposit(e.getPlayer().getUniqueId(), 500D);
                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENTITY_ITEM_PICKUP, 50, 1);
                e.getPlayer().sendMessage(ChatColor.GOLD + "[+] " + ChatColor.WHITE + "500円");
                Variables.onDiamondRestoration(e);
                e.setCancelled(true);
                e.getBlock().setType(Material.COBBLESTONE);
            }
            else if (e.getBlock().getType() == Material.FENCE && e.getPlayer().getGameMode() == GameMode.SURVIVAL)
            {
                if (!(e.getPlayer().getItemInHand().getType() == Material.WOOD_AXE || e.getPlayer().getItemInHand().getType() == Material.IRON_AXE || e.getPlayer().getItemInHand().getType() == Material.GOLD_AXE || e.getPlayer().getItemInHand().getType() == Material.DIAMOND_AXE))
                {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage(ChatColor.RED + ">> 斧以外での破壊はできません。");
                }
                else
                {
                    e.setCancelled(true);
                    e.getBlock().setType(Material.AIR);
                }
            }
            else if (e.getBlock().getType() == Material.WOOL && e.getPlayer().getGameMode() == GameMode.SURVIVAL)
            {
                if (!(e.getPlayer().getItemInHand().getType() == Material.SHEARS))
                {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage(ChatColor.RED + ">> はさみ以外での破壊はできません。");
                }
                else
                {
                    e.setCancelled(true);
                    e.getBlock().setType(Material.AIR);
                }
            }
            else if (e.getBlock().getType() == Material.STONE_PLATE && e.getPlayer().getGameMode() == GameMode.SURVIVAL)
            {
                if (Defenders.teamList.contains(e.getPlayer().getUniqueId()))
                {Bukkit.broadcastMessage(ChatColor.GREEN + ">> " + e.getPlayer().getName() + "さんがコア室へのドアを閉鎖しました。");}
                else e.getPlayer().sendMessage(ChatColor.RED + ">> アタッカーはコアへの入り口を破壊できません。");
            }
            else
            {if (!(e.getPlayer().isOp())) {e.setCancelled(true);e.getPlayer().sendMessage(ChatColor.RED + ">> そのブロックは破壊することができません。");}}
        }
        else
        {if (!(e.getPlayer().isOp())) {e.setCancelled(true);e.getPlayer().sendMessage(ChatColor.RED + ">> 現在ゲーム中ではないため破壊することができません。");}}
    }

    public static List<UUID> attackGUI = new ArrayList<UUID>();
    public static List<UUID> defenceGUI = new ArrayList<UUID>();
    @EventHandler
    public void onShopClick(InventoryClickEvent e)
    {
        Location loc = e.getWhoClicked().getLocation();
        Player p = (Player) e.getWhoClicked();

        // メインメニュー
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "攻撃チームショップ"))
        {
            if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.openInventory(MainShop.weaponsShop);
            }
            else if (e.getCurrentItem().getType() == Material.GOLD_CHESTPLATE)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.openInventory(MainShop.armorShop);
            }
            else if (e.getCurrentItem().getType() == Material.IRON_PICKAXE)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.openInventory(MainShop.destructionToolShop);
            }
            else if (e.getCurrentItem().getType() == Material.APPLE)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.openInventory(MainShop.foodShop);
            }
            else if (e.getCurrentItem().getType() == Material.ENDER_PEARL)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.openInventory(MainShop.othersShop);
            }
            else if (e.getCurrentItem().getType() == Material.BARRIER)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.closeInventory();
            }
            else e.setCancelled(true);
        }
        else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_GREEN + "防衛チームショップ"))
        {
            if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.openInventory(MainShop.weaponsShop);
            }
            else if (e.getCurrentItem().getType() == Material.GOLD_CHESTPLATE)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.openInventory(MainShop.armorShop);
            }
            else if (e.getCurrentItem().getType() == Material.APPLE)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.openInventory(MainShop.foodShop);
            }
            else if (e.getCurrentItem().getType() == Material.IRON_PICKAXE)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.openInventory(MainShop.destructionToolShop);
            }
            else if (e.getCurrentItem().getType() == Material.ENDER_PEARL)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.openInventory(MainShop.othersShop);
            }
            else if (e.getCurrentItem().getType() == Material.BARRIER)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.closeInventory();
            }
            else e.setCancelled(true);
        }

        else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "武器カテゴリー"))
        {
            if (e.getCurrentItem().getType() == Material.WOOD_SWORD)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 200L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 200L);
                    p.getInventory().addItem(new ItemStack(Material.WOOD_SWORD, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.STONE_SWORD)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 500L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 500L);
                    p.getInventory().addItem(new ItemStack(Material.STONE_SWORD, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.IRON_SWORD || e.getCurrentItem().getType() == Material.BOW)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 1000L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 1000L);
                    if (e.getCurrentItem().getType() == Material.IRON_SWORD)
                    {p.getInventory().addItem(new ItemStack(Material.IRON_SWORD, 1));}
                    else if (e.getCurrentItem().getType() == Material.BOW)
                    {p.getInventory().addItem(new ItemStack(Material.BOW, 1));}

                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.GOLD_SWORD)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 2500L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 2500L);
                    p.getInventory().addItem(new ItemStack(Material.GOLD_SWORD, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.DIAMOND_SWORD)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 5000L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 5000L);
                    p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.ARROW)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 300L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 300L);
                    p.getInventory().addItem(new ItemStack(Material.ARROW, 5));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.BARRIER)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                if (Attackers.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.attackerShop);}
                else if (Defenders.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.defenderShop);}
                else if (Admins.teamList.contains(p.getUniqueId()))
                {
                    if (attackGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.attackerShop);}
                    else if (defenceGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.defenderShop);}
                }
            }
            else e.setCancelled(true);
        }



        else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "防具カテゴリー"))
        {
            if (e.getCurrentItem().getType() == Material.LEATHER_HELMET || e.getCurrentItem().getType() == Material.LEATHER_BOOTS)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 100L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 100L);
                    if (e.getCurrentItem().getType() == Material.LEATHER_HELMET)
                    {p.getInventory().addItem(new ItemStack(Material.LEATHER_HELMET, 1));}
                    else if (e.getCurrentItem().getType() == Material.LEATHER_BOOTS)
                    {p.getInventory().addItem(new ItemStack(Material.LEATHER_BOOTS, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE || e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 150L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 150L);
                    if (e.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE)
                    {p.getInventory().addItem(new ItemStack(Material.LEATHER_CHESTPLATE, 1));}
                    else if (e.getCurrentItem().getType() == Material.LEATHER_LEGGINGS)
                    {p.getInventory().addItem(new ItemStack(Material.LEATHER_LEGGINGS, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }



            else if (e.getCurrentItem().getType() == Material.CHAINMAIL_HELMET || e.getCurrentItem().getType() == Material.CHAINMAIL_BOOTS)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 200L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 200L);
                    if (e.getCurrentItem().getType() == Material.CHAINMAIL_HELMET)
                    {p.getInventory().addItem(new ItemStack(Material.CHAINMAIL_HELMET, 1));}
                    else if (e.getCurrentItem().getType() == Material.CHAINMAIL_BOOTS)
                    {p.getInventory().addItem(new ItemStack(Material.CHAINMAIL_BOOTS, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE || e.getCurrentItem().getType() == Material.CHAINMAIL_LEGGINGS)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 250L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 250L);
                    if (e.getCurrentItem().getType() == Material.CHAINMAIL_CHESTPLATE)
                    {p.getInventory().addItem(new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1));}
                    else if (e.getCurrentItem().getType() == Material.CHAINMAIL_LEGGINGS)
                    {p.getInventory().addItem(new ItemStack(Material.CHAINMAIL_LEGGINGS, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }



            else if (e.getCurrentItem().getType() == Material.IRON_HELMET || e.getCurrentItem().getType() == Material.IRON_BOOTS)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 400L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 400L);
                    if (e.getCurrentItem().getType() == Material.IRON_HELMET)
                    {p.getInventory().addItem(new ItemStack(Material.IRON_HELMET, 1));}
                    else if (e.getCurrentItem().getType() == Material.IRON_BOOTS)
                    {p.getInventory().addItem(new ItemStack(Material.IRON_BOOTS, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.IRON_CHESTPLATE || e.getCurrentItem().getType() == Material.IRON_LEGGINGS)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 470L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 470L);
                    if (e.getCurrentItem().getType() == Material.IRON_CHESTPLATE)
                    {p.getInventory().addItem(new ItemStack(Material.IRON_CHESTPLATE, 1));}
                    else if (e.getCurrentItem().getType() == Material.IRON_LEGGINGS)
                    {p.getInventory().addItem(new ItemStack(Material.IRON_LEGGINGS, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }



            else if (e.getCurrentItem().getType() == Material.GOLD_HELMET || e.getCurrentItem().getType() == Material.GOLD_BOOTS)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 600L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 600L);
                    if (e.getCurrentItem().getType() == Material.GOLD_HELMET)
                    {p.getInventory().addItem(new ItemStack(Material.GOLD_HELMET, 1));}
                    else if (e.getCurrentItem().getType() == Material.GOLD_BOOTS)
                    {p.getInventory().addItem(new ItemStack(Material.GOLD_BOOTS, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.GOLD_CHESTPLATE || e.getCurrentItem().getType() == Material.GOLD_LEGGINGS)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 650L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 650L);
                    if (e.getCurrentItem().getType() == Material.GOLD_CHESTPLATE)
                    {p.getInventory().addItem(new ItemStack(Material.GOLD_CHESTPLATE, 1));}
                    else if (e.getCurrentItem().getType() == Material.GOLD_LEGGINGS)
                    {p.getInventory().addItem(new ItemStack(Material.GOLD_LEGGINGS, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }



            else if (e.getCurrentItem().getType() == Material.DIAMOND_HELMET || e.getCurrentItem().getType() == Material.DIAMOND_BOOTS)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 1000L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 1000L);
                    if (e.getCurrentItem().getType() == Material.DIAMOND_HELMET)
                    {p.getInventory().addItem(new ItemStack(Material.DIAMOND_HELMET, 1));}
                    else if (e.getCurrentItem().getType() == Material.DIAMOND_BOOTS)
                    {p.getInventory().addItem(new ItemStack(Material.DIAMOND_BOOTS, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE || e.getCurrentItem().getType() == Material.DIAMOND_LEGGINGS)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 1200L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 1200L);
                    if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE)
                    {p.getInventory().addItem(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));}
                    else if (e.getCurrentItem().getType() == Material.DIAMOND_LEGGINGS)
                    {p.getInventory().addItem(new ItemStack(Material.DIAMOND_LEGGINGS, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }



            else if (e.getCurrentItem().getType() == Material.BARRIER)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                if (Attackers.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.attackerShop);}
                else if (Defenders.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.defenderShop);}
                else if (Admins.teamList.contains(p.getUniqueId()))
                {
                    if (attackGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.attackerShop);}
                    else if (defenceGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.defenderShop);}
                }
            }
            else e.setCancelled(true);
        }


        else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.DARK_AQUA + "ショップ管理"))
        {
            if (e.getCurrentItem().getType() == Material.GOLD_PICKAXE)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                attackGUI.add(p.getUniqueId());
                p.openInventory(MainShop.attackerShop);
            }
            else if (e.getCurrentItem().getType() == Material.SHIELD)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                defenceGUI.add(p.getUniqueId());
                p.openInventory(MainShop.defenderShop);
            }
            else if (e.getCurrentItem().getType() == Material.BARRIER)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                p.closeInventory();
            }
            else e.setCancelled(true);
        }



        else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "破壊道具カテゴリー"))
        {
            if (e.getCurrentItem().getType() == Material.WOOD_AXE)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 200L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 200L);
                    p.getInventory().addItem(new ItemStack(Material.WOOD_AXE, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.STONE_AXE)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 500L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 500L);
                    p.getInventory().addItem(new ItemStack(Material.STONE_AXE, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.IRON_AXE)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 700L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 700L);
                    p.getInventory().addItem(new ItemStack(Material.IRON_AXE, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.GOLD_AXE)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 1000L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 1000L);
                    p.getInventory().addItem(new ItemStack(Material.GOLD_AXE, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.DIAMOND_AXE || e.getCurrentItem().getType() == Material.DIAMOND_PICKAXE)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 2000L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 2000L);
                    if (e.getCurrentItem().getType() == Material.DIAMOND_AXE)
                    {p.getInventory().addItem(new ItemStack(Material.DIAMOND_AXE, 1));}
                    else if (e.getCurrentItem().getType() == Material.DIAMOND_PICKAXE)
                    {p.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));}
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.GOLD_PICKAXE)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 1500L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 1500L);
                    p.getInventory().addItem(new ItemStack(Material.GOLD_PICKAXE, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.BARRIER)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                if (Attackers.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.attackerShop);}
                else if (Defenders.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.defenderShop);}
                else if (Admins.teamList.contains(p.getUniqueId()))
                {
                    if (attackGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.attackerShop);}
                    else if (defenceGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.defenderShop);}
                }
            }
            else e.setCancelled(true);
        }

        else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "食料カテゴリー"))
        {
            if (e.getCurrentItem().getType() == Material.BREAD)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 200L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 200L);
                    p.getInventory().addItem(new ItemStack(Material.BREAD, 5));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.APPLE)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 110L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 110L);
                    p.getInventory().addItem(new ItemStack(Material.APPLE, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.COOKED_BEEF)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 300L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 300L);
                    p.getInventory().addItem(new ItemStack(Material.COOKED_BEEF, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.GOLDEN_APPLE)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 1000L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 1000L);
                    p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.BARRIER)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                if (Attackers.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.attackerShop);}
                else if (Defenders.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.defenderShop);}
                else if (Admins.teamList.contains(p.getUniqueId()))
                {
                    if (attackGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.attackerShop);}
                    else if (defenceGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.defenderShop);}
                }
            }
            else e.setCancelled(true);
        }

        else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "その他カテゴリー"))
        {
            if (e.getCurrentItem().getType() == Material.FENCE)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 1000L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 1000L);
                    p.getInventory().addItem(new ItemStack(Material.FENCE, 32));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.WOOL)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 500L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 500L);
                    p.getInventory().addItem(new ItemStack(Material.WOOL, 16));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.SNOW_BALL)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 3000L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 3000L);
                    p.getInventory().addItem(new ItemStack(Others.SnowBallItem));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.BARRIER)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                if (Attackers.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.attackerShop);}
                else if (Defenders.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.defenderShop);}
                else if (Admins.teamList.contains(p.getUniqueId()))
                {
                    if (attackGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.attackerShop);}
                    else if (defenceGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.defenderShop);}
                }
            }
            else e.setCancelled(true);
        }

        else if (e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "防衛アイテムカテゴリー"))
        {
            if (e.getCurrentItem().getType() == Material.FENCE)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 1000L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                            TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 1000L);
                    p.getInventory().addItem(new ItemStack(Material.FENCE, 32));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.OBSIDIAN)
            {
                e.setCancelled(true);
                if (TowerAttackDefence.jecon.getRepository().has(p.getUniqueId(), 5000L))
                {
                    p.playSound(loc, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                    TowerAttackDefence.jecon.getRepository().withdraw(p.getUniqueId(), 5000L);
                    p.getInventory().addItem(new ItemStack(Material.OBSIDIAN, 1));
                }
                else
                {p.playSound(loc, Sound.BLOCK_ANVIL_PLACE, 50, 1);p.closeInventory();p.sendMessage(ChatColor.RED + ">> 購入できる金額を所持していないため購入に失敗しました。");}
            }
            else if (e.getCurrentItem().getType() == Material.BARRIER)
            {
                e.setCancelled(true);
                p.playSound(loc, Sound.UI_BUTTON_CLICK, 1, 1);
                if (Attackers.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.attackerShop);}
                else if (Defenders.teamList.contains(p.getUniqueId()))
                {p.openInventory(MainShop.defenderShop);}
                else if (Admins.teamList.contains(p.getUniqueId()))
                {
                    if (attackGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.attackerShop);}
                    else if (defenceGUI.contains(p.getUniqueId()))
                    {p.openInventory(MainShop.defenderShop);}
                }
            }
            else e.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e)
    {
        Player deather = e.getEntity().getPlayer();
        Player killer = e.getEntity().getKiller();
        e.setDeathMessage(ChatColor.RED + ">> " + ChatColor.AQUA + deather.getName() + ChatColor.RED + " は " + ChatColor.DARK_AQUA + killer.getName() + ChatColor.RED + " に倒された。");
        deather.teleport(deather.getWorld().getSpawnLocation());
    }

    List<UUID> hatsuLogin = new ArrayList<UUID>();

    @EventHandler
    public void onLogin(PlayerLoginEvent e)
    {
        if (!(hatsuLogin.contains(e.getPlayer().getUniqueId())))
        {
            TowerAttackDefence.jecon.getRepository().set(e.getPlayer().getUniqueId(), 0L);
            hatsuLogin.add(e.getPlayer().getUniqueId());
        }
    }

    @EventHandler
    public void onCoreClick(PlayerInteractEvent e)
    {
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if ((e.getClickedBlock() != null ? e.getClickedBlock().getType() : null) == Material.STONE_BUTTON)
            {
                Location location = e.getClickedBlock().getLocation().clone();
                location.add(0,-0.1,0);
                if (location.getBlock().getType().equals(Material.EMERALD_BLOCK))
                {
                    if (Attackers.teamList.contains(e.getPlayer().getUniqueId()))
                    {
                        e.getClickedBlock().setType(Material.AIR);
                        Bukkit.broadcastMessage(ChatColor.GREEN + ">> 今回コアを破壊したアタッカー: " + ChatColor.WHITE + e.getPlayer().getName() + "さん");
                        GamePanel.countdown = -1;
                    }
                    else e.getPlayer().sendMessage(ChatColor.RED + ">> アタッカー以外コアを破壊できません。");
                }
            }
        }
    }

    @EventHandler
    public void onPlacePlate(BlockPlaceEvent e)
    {
        if (!(e.getPlayer().isOp()))
        {
            if ((e.getBlock() != null ? e.getBlock().getType() : null) == Material.STONE_PLATE)
            {
                Location location = e.getBlock().getLocation().clone();
                location.add(0,-0.1,0);
                if (location.getBlock().getType().equals(Material.GOLD_BLOCK))
                {
                    if (Attackers.teamList.contains(e.getPlayer().getUniqueId()))
                    {Bukkit.broadcastMessage(ChatColor.GREEN + ">> " + e.getPlayer().getName() + "さんがコア室へのドアを解放しました。");}
                    else e.getPlayer().sendMessage(ChatColor.RED + ">> アタッカー以外コアを設置できません。");
                }
                else e.setCancelled(true);
            }
            else if (e.getBlock().getType() == Material.FENCE || e.getBlock().getType() == Material.OBSIDIAN)
            {e.setCancelled(false);}
            else e.setCancelled(true);
        }
    }

    @EventHandler
    public void onYukiBall(EntityDamageByEntityEvent e)
    {
        LivingEntity lv = (LivingEntity) e.getEntity();
        if (e.getDamager() instanceof Snowball)
        {lv.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 120,  120));}
    }


}
