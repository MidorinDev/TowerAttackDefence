package midorin.info.tad;

import jp.jyn.jecon.Jecon;

import midorin.info.tad.Shops.MainShop;
import midorin.info.tad.Teams.Admins;
import midorin.info.tad.Teams.Attackers;
import midorin.info.tad.Teams.Defenders;
import midorin.info.tad.commands.MainCmd;

import midorin.info.tad.commands.shop;
import midorin.info.tad.commands.teams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class TowerAttackDefence extends JavaPlugin {

    public static JavaPlugin plugin;
    public static Jecon jecon;
    private Listeners listeners;

    public static Objective main_object;
    public static Score timer;

    public static Scoreboard board;
    ScoreboardManager manager;


    @Override
    public void onEnable() {

        plugin = this;
        this.listeners = new Listeners();
        Bukkit.getPluginManager().registerEvents(this.listeners, this);

        Plugin JPlugin = Bukkit.getPluginManager().getPlugin("Jecon");
        if(JPlugin == null || !JPlugin.isEnabled()) {getLogger().warning("Jecon is not available.");}
        jecon = (Jecon) JPlugin;

        manager = Bukkit.getScoreboardManager();
        board = manager.getMainScoreboard();

        main_object = board.registerNewObjective("main-object","dummy");
        main_object.setDisplayName("--Info--");

        timer = main_object.getScore(ChatColor.GOLD + "ゲーム時間:");
        timer.setScore(0);

        Admins.setupTeam();
        Attackers.setupTeam();
        Defenders.setupTeam();

        getCommand("towerattackdefence").setExecutor(new MainCmd());
        getCommand("shop").setExecutor(new shop());
        getCommand("teams").setExecutor(new teams());

        MainShop.onShopsSetup();

        // 0 - 剣購入一覧
        // 1 - ピッケル購入一覧
        // 2 -
        //slot 19 から剣（き）

        super.onEnable();
    }

    @Override
    public void onDisable() {

        main_object.getScoreboard().getScores(ChatColor.GOLD + "ゲーム時間:");
        main_object.unregister();

        Attackers.team.unregister();
        Defenders.team.unregister();
        Admins.team.unregister();

        super.onDisable();
    }

    public static JavaPlugin getPlugin() {return plugin;}

}
