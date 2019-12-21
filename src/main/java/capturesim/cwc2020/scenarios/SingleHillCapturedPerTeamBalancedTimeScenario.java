package capturesim.cwc2020.scenarios;

import capturesim.core.interfaces.Game;
import capturesim.core.interfaces.Simulator;
import capturesim.cwc2020.games.CyberWarfareContest2020Game;
import capturesim.cwc2020.players.Team;
import capturesim.cwc2020.services.GameService;
import capturesim.cwc2020.simulators.CyberWarfareContest2020Simulator;
import capturesim.cwc2020.transactions.HillCaptured;

import java.util.ArrayList;

public class SingleHillCapturedPerTeamBalancedTimeScenario {

    public static void main(String[] args) {
        Game game = new CyberWarfareContest2020Game();
        GameService gameService = new GameService(game);

        game.getPlayers().addAll(new ArrayList<>() {{
            add(new Team("S!gnature"));
            add(new Team("MAIDEN"));
            add(new Team("Newbie"));
        }});

        game.getTransactions().addAll(new ArrayList<>() {{
            gameService.teams().find("S!gnature").ifPresent(team -> {
                add(new HillCaptured(gameService.hills().find("The Fools"), team, 180));
            });
            gameService.teams().find("MAIDEN").ifPresent(team -> {
                add(new HillCaptured(gameService.hills().find("GGEZ Hosting"), team, 120));
            });
            gameService.teams().find("Newbie").ifPresent(team -> {
                add(new HillCaptured(gameService.hills().find("MineKrub"), team, 60));
            });
        }});

        Simulator simulator = new CyberWarfareContest2020Simulator(game, 240);
        simulator.simulate();
    }

}
