package midorin.info.tad;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import com.sk89q.worldedit.world.DataException;
import midorin.info.tad.Teams.Admins;
import midorin.info.tad.Teams.Attackers;
import midorin.info.tad.Teams.Defenders;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class GamePanel {

    public static int beforeStart = 5;
    public static int countdown = 1200;

    public static void gameCountdown()
    {
        BukkitRunnable task1 = new BukkitRunnable() {
            public void run() {

                for (Player alluser : Bukkit.getOnlinePlayers()) {alluser.getPlayer().getLocation().getWorld().playSound(alluser.getPlayer().getLocation(), Sound.BLOCK_COMPARATOR_CLICK, 10, 1);}
                Bukkit.broadcastMessage(ChatColor.GRAY + ">> ゲーム開始まで残り" + beforeStart + "秒");

                if (beforeStart == 0) {

                    TowerAttackDefence.main_object.setDisplaySlot(DisplaySlot.SIDEBAR);
                    Variables.GameManageInt = 1;
                    for (Player player : Bukkit.getOnlinePlayers()) {
                        Location loc = player.getPlayer().getLocation();
                        loc.getWorld().playSound(loc, Sound.ENTITY_GENERIC_EXPLODE, 50, 1);
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendTitle(ChatColor.GREEN + "ゲーム開始", ChatColor.GRAY + "TowerAttackDefence", 10, 10, 10);
                        player.teleport(player.getWorld().getSpawnLocation());
                        if (Attackers.teamList.contains(player.getUniqueId()))
                        {
                            player.getInventory().addItem(new ItemStack(Material.STONE_PICKAXE, 1));
                        }
                        Variables.GameManageInt = 1;
                    }

                    this.cancel();

                    BukkitRunnable task2 = new BukkitRunnable() {
                        public void run() {
                            TowerAttackDefence.timer.setScore(countdown);
                            if (countdown == 900)
                            {
                                WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
                                File schematic = new File("plugins/WorldEdit/schematics/kabeOpen.schematic");
                                EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(Bukkit.getWorld("Initial-Tower")), 10000);
                                try
                                {MCEditSchematicFormat.getFormat(schematic).load(schematic).paste(session, new Vector(5,102,-12), false);}
                                catch (MaxChangedBlocksException | DataException | IOException e)
                                {e.printStackTrace();}
                                Bukkit.broadcastMessage(ChatColor.YELLOW + ">> ゲーム開始から5分が経過したため、タワーへの突入が可能になりました。");
                            }
                            else if (countdown == 600) {Bukkit.broadcastMessage(ChatColor.GRAY + ">> ゲーム時間が残り10分になりました。");}
                            else if (countdown == 300) {Bukkit.broadcastMessage(ChatColor.GRAY + ">> ゲーム時間が残り5分になりました。");}
                            else if (countdown == 0)
                            {
                                for (Player player : Bukkit.getOnlinePlayers()) {
                                    player.sendTitle(ChatColor.AQUA + "TowerAttackDefence", ChatColor.RED + "ディフェンスの勝利", 10, 10, 10);
                                    player.getPlayer().getLocation().getWorld().playSound(player.getPlayer().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 50, 1);
                                }
                                TowerAttackDefence.main_object.setDisplaySlot(DisplaySlot.SIDEBAR);
                                Variables.GameManageInt = 0;
                                this.cancel();
                            }
                            else if (countdown == -1)
                            {
                                for (Player player : Bukkit.getOnlinePlayers()) {
                                    player.sendTitle(ChatColor.AQUA + "TowerAttackDefence", ChatColor.GREEN + "アタッカーの勝利", 10, 10, 10);
                                    player.getPlayer().getLocation().getWorld().playSound(player.getPlayer().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 50, 1);
                                }
                                TowerAttackDefence.main_object.setDisplaySlot(DisplaySlot.SIDEBAR);
                                Variables.GameManageInt = 0;
                                this.cancel();
                                countdown = 0;
                            }
                            countdown--;
                        }
                    };
                    task2.runTaskTimer(TowerAttackDefence.getPlugin(), 0L, 20L);
                }

                beforeStart--;

            }
        };
        task1.runTaskTimer(TowerAttackDefence.getPlugin(), 0L, 20L);
    }

    public static Random random = new Random();

    public static void randomTeamSelect(Player p) {
        if (Attackers.team.getPlayers().size() == Defenders.team.getPlayers().size()) {

            if (random.nextBoolean()) {
                if (!(Defenders.teamList.contains(p.getUniqueId()) || Attackers.teamList.contains(p.getUniqueId()) || Admins.teamList.contains(p.getUniqueId())))
                {
                    Defenders.team.addEntry(p.getName());
                    Defenders.teamList.add(p.getUniqueId());
                    p.setDisplayName(ChatColor.AQUA + "[Defender] " + ChatColor.WHITE + p.getName());
                    p.sendMessage(ChatColor.WHITE + ">> あなたは" + ChatColor.AQUA + "ディフェンダー" + ChatColor.WHITE + "になりました。");
                }
            } else {
                if (!(Defenders.teamList.contains(p.getUniqueId()) || Attackers.teamList.contains(p.getUniqueId()) || Admins.teamList.contains(p.getUniqueId())))
                {
                    Attackers.team.addEntry(p.getName());
                    Attackers.teamList.add(p.getUniqueId());
                    p.setDisplayName(ChatColor.RED + "[Attacker] " + ChatColor.WHITE + p.getName());
                    p.sendMessage(ChatColor.WHITE + ">> あなたは" + ChatColor.AQUA + "アタッカー" + ChatColor.WHITE + "になりました。");
                }
            }
        } else {
            if (Defenders.team.getPlayers().size() < Attackers.team.getPlayers().size()) {
                if (!(Defenders.teamList.contains(p.getUniqueId()) || Attackers.teamList.contains(p.getUniqueId()) || Admins.teamList.contains(p.getUniqueId())))
                {
                    Defenders.team.addEntry(p.getName());
                    Defenders.teamList.add(p.getUniqueId());
                    p.setDisplayName(ChatColor.AQUA + "[Defender] " + ChatColor.WHITE + p.getName());
                    p.sendMessage(ChatColor.WHITE + ">> あなたは" + ChatColor.AQUA + "ディフェンダー" + ChatColor.WHITE + "になりました。");
                }
            } else {
                if (!(Defenders.teamList.contains(p.getUniqueId()) || Attackers.teamList.contains(p.getUniqueId()) || Admins.teamList.contains(p.getUniqueId())))
                {
                    Attackers.team.addEntry(p.getName());
                    Attackers.teamList.add(p.getUniqueId());
                    p.setDisplayName(ChatColor.RED + "[Attacker] " + ChatColor.WHITE + p.getName());
                    p.sendMessage(ChatColor.WHITE + ">> あなたは" + ChatColor.AQUA + "アタッカー" + ChatColor.WHITE + "になりました。");
                }
            }
        }
    }

}
