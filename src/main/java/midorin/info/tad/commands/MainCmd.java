package midorin.info.tad.commands;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import com.sk89q.worldedit.world.DataException;
import midorin.info.tad.GamePanel;
import midorin.info.tad.Teams.Attackers;
import midorin.info.tad.Teams.Defenders;
import midorin.info.tad.Variables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class MainCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        try
        {
            if (args[0].equalsIgnoreCase("help"))
            {
                Variables.onHelpMenu1(sender);
            }
            else if (args[0].equalsIgnoreCase("start"))
            {
                if (sender.hasPermission("towerattackdefence.commands.tad.start") || sender.isOp()) {
                    GamePanel.gameCountdown();
                }
                else sender.sendMessage(Variables.noPermission);
            }
            else if (args[0].equalsIgnoreCase("reset"))
            {
                if (sender.hasPermission("towerattackdefence.commands.tad.reset") || sender.isOp()) {
                    for (Player alluser : Bukkit.getOnlinePlayers())
                    {
                        if (Attackers.teamList.contains(alluser.getUniqueId()))
                        {Attackers.team.removeEntry(alluser.getName());Attackers.teamList.remove(alluser.getUniqueId());alluser.setDisplayName(alluser.getName());}
                        else if (Defenders.teamList.contains(alluser.getUniqueId()))
                        {Defenders.team.removeEntry(alluser.getName());Defenders.teamList.remove(alluser.getUniqueId());alluser.setDisplayName(alluser.getName());}
                    }
                    WorldEditPlugin worldEditPlugin = (WorldEditPlugin) Bukkit.getPluginManager().getPlugin("WorldEdit");
                    File schematic = new File("plugins/WorldEdit/schematics/main_map.schematic");
                    EditSession session = worldEditPlugin.getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(Bukkit.getWorld("Initial-Tower")), 10000);
                    try {MCEditSchematicFormat.getFormat(schematic).load(schematic).paste(session, new Vector(5, 102, -12), false);}
                    catch (MaxChangedBlocksException | DataException | IOException e)
                    {e.printStackTrace();}
                    Bukkit.reload();
                    Bukkit.broadcastMessage(ChatColor.GOLD + ">> ゲームのリセットが完了しました。");
                }
                else sender.sendMessage(Variables.noPermission);
            }
            else if (args[0].equalsIgnoreCase("spawn-atk"))
            {

            }
            else if (args[0].equalsIgnoreCase("spawn-def"))
            {
                
            }
        }
        catch (Exception ex) {Variables.onHelpMenu1(sender);}

        return true;
    }
}
