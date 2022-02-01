package practice.demo.Services;

import practice.demo.entities.Developers;
import practice.demo.entities.Team;

public class TeamService {

    public String createTeam(Team team, List<Developers>) {
        team.setDevelopersList(Developers);
        repoService(Developers);
        return repoService.save(team);
    }
}
