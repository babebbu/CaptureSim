package capturesim.cwc2020.services;

import capturesim.cwc2020.players.Team;

import java.util.List;
import java.util.Optional;

public class TeamService {

    private final List<Team> teams;

    TeamService(List<Team> teams) {
        this.teams = teams;
    }

    public Optional<Team> find(String name) {
        return teams
            .stream()
            .filter(team -> team.getName().equals(name))
            .findFirst();
    }
}
