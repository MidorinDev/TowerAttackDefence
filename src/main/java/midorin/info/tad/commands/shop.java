package midorin.info.tad.commands;

import midorin.info.tad.Listeners;
import midorin.info.tad.Shops.MainShop;
import midorin.info.tad.Teams.Admins;
import midorin.info.tad.Teams.Attackers;
import midorin.info.tad.Teams.Defenders;
import midorin.info.tad.Variables;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class shop implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if (Variables.GameManageInt == 1) {
            if (Attackers.teamList.contains(p.getUniqueId()))
            {p.openInventory(MainShop.attackerShop);}
            else if (Defenders.teamList.contains(p.getUniqueId()))
            {p.openInventory(MainShop.defenderShop);}
            else if (Admins.teamList.contains(p.getUniqueId()))
            {
                if (Listeners.attackGUI.contains(p.getUniqueId()))
                {Listeners.attackGUI.remove(p.getUniqueId());}
                else if (Listeners.defenceGUI.contains(p.getUniqueId()))
                {Listeners.defenceGUI.contains(p.getUniqueId());}
                p.openInventory(MainShop.shopManage);
            }
            else sender.sendMessage(ChatColor.RED + ">> チームに参加していないためショップが開けません。");
        }
        else if (Admins.teamList.contains(p.getUniqueId()))
        {
            if (Listeners.attackGUI.contains(p.getUniqueId()))
            {Listeners.attackGUI.remove(p.getUniqueId());}
            else if (Listeners.defenceGUI.contains(p.getUniqueId()))
            {Listeners.defenceGUI.contains(p.getUniqueId());}
            p.openInventory(MainShop.shopManage);
        }
        else sender.sendMessage(ChatColor.RED + ">> ゲーム時間外にショップは開けません。");
        return true;
    }
}
