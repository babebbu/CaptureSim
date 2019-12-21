package capturesim.cwc2020.transactions;

import capturesim.core.Player;
import capturesim.core.Transaction;
import capturesim.cwc2020.scores.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemPurchased implements Transaction {

    private Item item;
    private Player player;
    private int timestamp;

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public int process() {
        return item.getPoints();
    }

    @Override
    public int getTimestamp() {
        return timestamp;
    }

}
