package capturesim.cwc2020.transactions;

import capturesim.core.Player;
import capturesim.core.Transaction;
import capturesim.cwc2020.scores.Flag;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlagCaptured implements Transaction {

    private Flag flag;
    private Player player;
    private int timestamp;

    @Override
    public int process() {
        if(flag.getFirstBloodClaimer().isEmpty()) {
            flag.setFirstBloodClaimer(player);
            return flag.getPoints() + flag.getFirstBloodPoints();
        }
        return flag.getPoints();
    }

}
