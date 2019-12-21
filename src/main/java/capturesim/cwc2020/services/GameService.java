package capturesim.cwc2020.services;

import capturesim.core.interfaces.Game;
import capturesim.cwc2020.players.Team;
import capturesim.cwc2020.scores.Flag;
import capturesim.cwc2020.scores.Hill;
import capturesim.cwc2020.scores.Item;

import java.util.stream.Collectors;

public class GameService {

    private Game game;

    public GameService(Game game) {
        this.game = game;
    }

    public TeamService teams() {
        return new TeamService(game.getPlayers()
            .stream()
            .filter(player -> player instanceof Team)
            .map(player -> (Team) player)
            .collect(Collectors.toList())
        );
    }

    public HillService hills() {
        return new HillService(game.getScores()
            .stream()
            .filter(score -> score instanceof Hill)
            .map(score -> (Hill) score)
            .collect(Collectors.toList())
        );
    }

    public FlagService flags() {
        return new FlagService(game.getScores()
            .stream()
            .filter(score -> score instanceof Flag)
            .map(score -> (Flag) score)
            .collect(Collectors.toList())
        );
    }

    public ItemService items() {
        return new ItemService(game.getScores()
            .stream()
            .filter(score -> score instanceof Item)
            .map(score -> (Item) score)
            .collect(Collectors.toList())
        );
    }

}
