import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum Mine {
    DIAMOND(10),NUGGET(2),RUBY(5);

        private int price;
        Mine(int price) {
            this.price = price;
        }
        public int getPrice() {
            return this.price;
        }


        private static final List<Mine> VALUES =
                Collections.unmodifiableList(Arrays.asList(values()));

        private static final int SIZE = VALUES.size();

        private static final Random RANDOM = new Random();

        public static Mine randomValuable()  {
                return VALUES.get(RANDOM.nextInt(SIZE));

        }
}
