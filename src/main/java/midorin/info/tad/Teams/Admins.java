package midorin.info.tad.Teams;

import midorin.info.tad.TowerAttackDefence;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Admins {

    public static List<UUID> teamList = new ArrayList<UUID>();

    public static final String TEAM_ADMIN = "admin";
    public static Team team;
    public static void setupTeam() {
        team = TowerAttackDefence.board.getTeam(TEAM_ADMIN);
        if (team == null) {
            team = TowerAttackDefence.board.registerNewTeam(TEAM_ADMIN);
            team.setPrefix(ChatColor.GOLD + "[Admin] " + ChatColor.WHITE);
            team.setSuffix(ChatColor.RESET.toString());
            team.setDisplayName(ChatColor.GOLD + "Admin");
            team.setOption(Team.Option.NAME_TAG_VISIBILITY, Team.OptionStatus.FOR_OTHER_TEAMS);
            team.setAllowFriendlyFire(true);
        }
    }

}
