package capturesim.cwc2020.scenarios;

import capturesim.core.interfaces.Game;
import capturesim.core.interfaces.Simulator;
import capturesim.cwc2020.games.CyberWarfareContest2020Game;
import capturesim.cwc2020.players.Team;
import capturesim.cwc2020.services.GameService;
import capturesim.cwc2020.simulators.CyberWarfareContest2020Simulator;
import capturesim.cwc2020.transactions.FlagCaptured;
import capturesim.cwc2020.transactions.HillCaptured;

import java.util.ArrayList;

public class MaximumScoreScenario {

    public static void main(String[] args) {
        Game game = new CyberWarfareContest2020Game();
        GameService gameService = new GameService(game);

        game.getPlayers().addAll(new ArrayList<>() {{
            add(new Team("S!gnature"));
        }});

        game.getTransactions().addAll(new ArrayList<>() {{
            gameService.teams().find("S!gnature").ifPresent(team -> {
                gameService.hills().all().forEach(hill -> add(new HillCaptured(hill, team, 10)));
                gameService.flags().all().forEach(flag -> add(new FlagCaptured(flag, team, 5)));
            });
        }});

        Simulator simulator = new CyberWarfareContest2020Simulator(game, 240);
        simulator.simulate();
    }

}
