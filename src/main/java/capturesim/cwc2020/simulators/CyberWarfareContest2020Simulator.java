package capturesim.cwc2020.simulators;

import capturesim.cwc2020.scores.Hill;
import capturesim.cwc2020.transactions.HillCaptured;
import capturesim.core.Game;
import capturesim.core.Simulator;
import capturesim.core.Transaction;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CyberWarfareContest2020Simulator implements Simulator {

    private Game game;
    private int duration;

    @Getter(AccessLevel.PUBLIC)
    @Setter(AccessLevel.NONE)
    private int clock;

    @Getter(AccessLevel.PRIVATE)
    @Setter(AccessLevel.PRIVATE)
    private List<Hill> hills;

    public CyberWarfareContest2020Simulator(Game game, int duration) {
        setGame(game);
        setDuration(duration);
    }

    @Override
    public void start() {
        setHills(game.getScores()
            .stream()
            .filter(score -> score instanceof Hill)
            .map(score -> (Hill) score)
            .collect(Collectors.toList())
        );
    }

    @Override
    public void processEvents() {
        for (clock = 0; clock <= duration; clock++) {
            System.out.println("=======================================");
            System.out.println("Time: " + clock);
            System.out.println("---------------------------------------");
            // Search Transactions that match clock
            List<Transaction> transactions = game.getTransactions()
                .stream()
                .filter(transaction -> transaction.getTimestamp() == clock)
                .collect(Collectors.toList());

            // Process Transactions
            transactions.forEach(transaction -> transaction.getPlayer().updateScore(transaction.process()));

            // Process Hills Holding Points
            hills.forEach(hill -> {
                if(clock % hill.getInterval() == 0 && clock >= hill.getFirstClockTick()) {
                    hill.getNextHolder().ifPresentOrElse(
                        player -> player.updateScore(HillCaptured.getPoints(player, hill, clock)),
                        () -> hill.getCurrentHolder().ifPresent(player -> player.updateScore(HillCaptured.getPoints(player, hill, clock)))
                    );
                }
            });
        }
    }

    @Override
    public void stop() {
        System.out.println("=======================================");
        System.out.println("Final Results");
        System.out.println("---------------------------------------");
        game.getPlayers().forEach(System.out::println);
    }
}
