package be.maxgaj.cm.rowdyracers.domain.items.item_generators;

import be.maxgaj.cm.rowdyracers.domain.items.light_grenades.PickableLightGrenade;
import be.maxgaj.cm.rowdyracers.domain.squares.Square;

import java.util.Random;

public class LightGrenadeGenerator implements ItemGenerator {
    private static final int MIN_AMOUNT = 2;
    private static final double MAX_AMOUNT_RATIO = 0.04;

    private Square[][] squares;
    private int height;
    private int width;
    private Random random = new Random();

    @Override
    public void generate(Square[][] squares) {
        setSquares(squares);
        int amount = getRandomAmount();
        while(amount > 0){
            int amountCreated = createGrenade();
            amount -= amountCreated;
        }
    }

    private void setSquares(Square[][] squares) {
        this.squares = squares;
        this.height = squares.length;
        this.width = squares[0].length;
    }

    private int getRandomAmount() {
        int maxAmount = (int) Math.ceil((height * width) * MAX_AMOUNT_RATIO);
        return random.nextInt(maxAmount - MIN_AMOUNT + 1) + MIN_AMOUNT;
    }

    private int createGrenade() {
        Square position = getRandomSquare();
        if (!position.isSuitableForAGrenade()){
            return 0;
        }
        position.setItem(new PickableLightGrenade());
        return 1;
    }

    private Square getRandomSquare() {
        int rowId = random.nextInt(height);
        int colId = random.nextInt(width);
        return squares[rowId][colId];
    }
}
