package midorin.info.tad;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Variables {

    // 0 : ゲーム開始前
    // 1 : ゲーム開始中
    public static int GameManageInt = 0;
    public static List<UUID> doNotJoin = new ArrayList<UUID>();
    public static String noPermission = ChatColor.RED + ">> 権限がありません。";

    public static void onMoneyViewRegularMessage()
    {
        new BukkitRunnable()
        {
            public void run()
            {
                Bukkit.broadcastMessage(ChatColor.GRAY + ">> お金の残高は /money で確認できます。");
                // もしゲーム時間が0になったらthis.cancel();
            }
        }.runTaskLater(TowerAttackDefence.getPlugin(), 6000L);
        // 秒に一回メッセージを送信
    }

    public static void onCoalRestoration(BlockBreakEvent e)
    {
        new BukkitRunnable()
        {
            public void run()
            {e.getBlock().setType(Material.COAL_ORE);}
        }.runTaskLater(TowerAttackDefence.getPlugin(), 100L);
        // 5秒経過すると元に戻る
    }

    public static void onIronRestoration(BlockBreakEvent e)
    {
        new BukkitRunnable()
        {
            public void run()
            {e.getBlock().setType(Material.IRON_ORE);}
        }.runTaskLater(TowerAttackDefence.getPlugin(), 500L);
        // 25秒経過すると元に戻る
    }

    public static void onGoldRestoration(BlockBreakEvent e)
    {
        new BukkitRunnable()
        {
            public void run()
            {e.getBlock().setType(Material.GOLD_ORE);}
        }.runTaskLater(TowerAttackDefence.getPlugin(), 1000L);
        // 50秒経過すると元に戻る
    }

    public static void onDiamondRestoration(BlockBreakEvent e)
    {
        new BukkitRunnable()
        {
            public void run()
            {e.getBlock().setType(Material.DIAMOND_ORE);}
        }.runTaskLater(TowerAttackDefence.getPlugin(), 1800L);
        // 1分30秒経過すると元に戻る
    }

    public static void onLogRestoration(BlockBreakEvent e)
    {
        new BukkitRunnable()
        {
            public void run()
            {e.getBlock().setType(Material.LOG);}
        }.runTaskLater(TowerAttackDefence.getPlugin(), 600L);
    }

    public static void onHelpMenu1(CommandSender sender)
    {
        sender.sendMessage("------------Attack & Defence------------");
        sender.sendMessage("まだヘルプ画面なんてない");
        sender.sendMessage("----------------------------------------");
    }
}