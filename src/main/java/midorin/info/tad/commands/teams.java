package midorin.info.tad.commands;

import midorin.info.tad.GamePanel;
import midorin.info.tad.Teams.Admins;
import midorin.info.tad.Teams.Attackers;
import midorin.info.tad.Teams.Defenders;
import midorin.info.tad.Variables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class teams implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        try
        {
            if (args[0].equalsIgnoreCase("join"))
            {
                if (sender.hasPermission("towerattackdefence.commands.team.join") || sender.isOp()) {
                    if (args.length == 1) sender.sendMessage(Variables.noPermission);
                    else if (args.length == 2) {
                        Player p = (Player) sender;
                        add(sender, p, args[1]);
                    }
                    else if (args.length == 3){
                        if (Bukkit.getPlayer(args[2]) != null) {
                            Player p = Bukkit.getPlayer(args[2]);
                            add(sender, p, args[1]);
                        } else sender.sendMessage(ChatColor.RED + ">> " + args[1] + "はこのサーバーに参加していません。");
                    }
                    else sender.sendMessage(Variables.noPermission);
                }
            }
            else if (args[0].equalsIgnoreCase("leave"))
            {
                if (sender.hasPermission("towerattackdefence.commands.team.leave") || sender.isOp()) {
                    if (args.length == 2)
                    {
                        if (Bukkit.getPlayer(args[2]) != null) {
                            Player p = Bukkit.getPlayer(args[2]);
                            if (Admins.teamList.contains(p.getUniqueId()))
                            {
                                Admins.teamList.remove(p.getUniqueId());
                                Admins.team.removeEntry(p.getName());
                                p.setDisplayName(p.getName());
                                Bukkit.broadcastMessage(ChatColor.GRAY + ">> 運営から" + p.getName() + "さんが離脱しました");
                            }
                            else if (Attackers.teamList.contains(p.getUniqueId()))
                            {
                                Attackers.teamList.remove(p.getUniqueId());
                                Attackers.team.removeEntry(p.getName());
                                p.setDisplayName(p.getName());
                                Bukkit.broadcastMessage(ChatColor.GRAY + ">> アタッカーから" + p.getName() + "さんが離脱しました");
                            }
                            else if (Defenders.teamList.contains(p.getUniqueId()))
                            {
                                Defenders.teamList.remove(p.getUniqueId());
                                Defenders.team.removeEntry(p.getName());
                                p.setDisplayName(p.getName());
                                Bukkit.broadcastMessage(ChatColor.GRAY + ">> ディフェンダーから" + p.getName() + "さんが離脱しました");
                            }
                            else
                            {sender.sendMessage(ChatColor.RED + ">> その人はチームに参加していません。");}
                        } else sender.sendMessage(ChatColor.RED + ">> " + args[2] + "はこのサーバーに参加していません。");
                    }
                    else if (args.length == 1)
                    {
                        Player p = (Player) sender;
                        if (Admins.teamList.contains(p.getUniqueId()))
                        {
                            Admins.teamList.remove(p.getUniqueId());
                            Admins.team.removeEntry(p.getName());
                            p.setDisplayName(p.getName());
                            Bukkit.broadcastMessage(ChatColor.GRAY + ">> 運営から" + p.getName() + "さんが離脱しました");
                        }
                        else if (Attackers.teamList.contains(p.getUniqueId()))
                        {
                            Attackers.teamList.remove(p.getUniqueId());
                            Attackers.team.removeEntry(p.getName());
                            p.setDisplayName(p.getName());
                            Bukkit.broadcastMessage(ChatColor.GRAY + ">> アタッカーから" + p.getName() + "さんが離脱しました");
                        }
                        else if (Defenders.teamList.contains(p.getUniqueId()))
                        {
                            Defenders.teamList.remove(p.getUniqueId());
                            Defenders.team.removeEntry(p.getName());
                            p.setDisplayName(p.getName());
                            Bukkit.broadcastMessage(ChatColor.GRAY + ">> ディフェンダーから" + p.getName() + "さんが離脱しました");
                        }
                        else
                        {sender.sendMessage(ChatColor.RED + ">> あなたはチームに参加していません。");}
                    }
                }
            }
            else if (args[0].equalsIgnoreCase("random")) {
                if (sender.hasPermission("towerattackdefence.commands.team.random") || sender.isOp()) {
                    for (Player ap : Bukkit.getOnlinePlayers()) {
                        GamePanel.randomTeamSelect(ap);
                    }
                    Bukkit.broadcastMessage(ChatColor.GOLD + ">> チームの振り分けが完了しました。");
                }
                else sender.sendMessage(Variables.noPermission);
            }
        }
        catch (Exception ex)
        {Variables.onHelpMenu1(sender);}

        return true;
    }

    private void add(CommandSender sender, Player p, String team) {
        switch (team) {
            case "defender":
                if (Attackers.teamList.contains(p.getUniqueId())) {
                    Attackers.team.removeEntry(p.getName());
                    Attackers.teamList.remove(p.getUniqueId());
                } else if (Admins.teamList.contains(p.getUniqueId())) {
                    Admins.team.removeEntry(p.getName());
                    Admins.teamList.remove(p.getUniqueId());
                }
                Defenders.team.addEntry(p.getName());
                Defenders.teamList.add(p.getUniqueId());
                p.setDisplayName(ChatColor.AQUA + "[Defender] " + ChatColor.WHITE + p.getName());
                Bukkit.broadcastMessage(ChatColor.WHITE + ">> " + p.getName() + "さんが" + ChatColor.AQUA + "ディフェンス" + ChatColor.WHITE + "に参加しました。");
                break;
            case "attacker":
                if (Defenders.teamList.contains(p.getUniqueId())) {
                    Defenders.team.removeEntry(p.getName());
                    Defenders.teamList.remove(p.getUniqueId());
                } else if (Admins.teamList.contains(p.getUniqueId())) {
                    Admins.team.removeEntry(p.getName());
                    Admins.teamList.remove(p.getUniqueId());
                }
                Attackers.team.addEntry(p.getName());
                Attackers.teamList.add(p.getUniqueId());
                p.setDisplayName(ChatColor.RED + "[Attacker] " + ChatColor.WHITE + p.getName());
                Bukkit.broadcastMessage(ChatColor.WHITE + ">> " + p.getName() + "さんが" + ChatColor.RED + "アタッカー" + ChatColor.WHITE + "に参加しました。");
                break;
            case "admin":
                if (Defenders.teamList.contains(p.getUniqueId())) {
                    Defenders.team.removeEntry(p.getName());
                    Defenders.teamList.remove(p.getUniqueId());
                } else if (Attackers.teamList.contains(p.getUniqueId())) {
                    Attackers.team.removeEntry(p.getName());
                    Attackers.teamList.remove(p.getUniqueId());
                }
                Admins.team.addEntry(p.getName());
                Admins.teamList.add(p.getUniqueId());
                p.setDisplayName(ChatColor.GOLD + "[Admin] " + ChatColor.WHITE + p.getName());
                Bukkit.broadcastMessage(ChatColor.WHITE + ">> " + p.getName() + "さんが" + ChatColor.GOLD + "Admin" + ChatColor.WHITE + "になりました。");
                break;
            default:
                sender.sendMessage(ChatColor.RED + ">> そのチームは存在しません。");
        }
    }
}
