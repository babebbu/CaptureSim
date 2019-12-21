package capturesim.cwc2020.scenarios;

import capturesim.core.Game;
import capturesim.cwc2020.games.CyberWarfareContest2020Game;
import capturesim.core.Simulator;
import capturesim.cwc2020.players.Team;
import capturesim.cwc2020.services.*;
import capturesim.cwc2020.simulators.CyberWarfareContest2020Simulator;
import capturesim.cwc2020.transactions.FlagCaptured;
import capturesim.cwc2020.transactions.HillCaptured;
import capturesim.cwc2020.transactions.ItemPurchased;

import java.util.ArrayList;

public class SampleScenario {

    private static GameService gameService;

    public static void main(String[] args) {
        Game game = new CyberWarfareContest2020Game();
        gameService = new GameService(game);

        game.getPlayers().addAll(new ArrayList<>() {{
            add(new Team("S!gnature"));
            add(new Team("MAIDEN"));
            add(new Team("Newbie"));
        }});

        game.getTransactions().addAll(new ArrayList<>() {{
            gameService.teams().find("S!gnature").ifPresent(team -> {
                add(new HillCaptured(team, gameService.hills().find("The Fools"), 150));
                add(new FlagCaptured(team, gameService.flags().find("Stupid Filter"), 60));
                add(new ItemPurchased(team, gameService.items().find("Powerful Hint"), 60));
            });
            gameService.teams().find("MAIDEN").ifPresent(team -> {
                add(new HillCaptured(team, gameService.hills().find("GGEZ Hosting"), 120));
                add(new FlagCaptured(team, gameService.flags().find("Stupid Filter"), 120));
            });
            gameService.teams().find("Newbie").ifPresent(team -> {
                add(new HillCaptured(team, gameService.hills().find("MineKrub"), 60));
            });
        }});

        Simulator simulator = new CyberWarfareContest2020Simulator(game, 240);
        simulator.simulate();
    }

}
