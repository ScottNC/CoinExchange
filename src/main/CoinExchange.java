import java.util.Arrays;

public class CoinExchange {
    public long exchange(int[] type, int n) {
        int[] descTypes = Arrays.stream(type)
                .map(i -> -i)
                .sorted()
                .map(i -> -i)
                .toArray();

        return findCompleteSum(descTypes, n);
    }

    private long findCompleteSum(int[] type, int n) {

        long count = 0;

        for (int coin : type) {
            int remainder = n % coin;

            if (remainder == 0)
                count++;
            else if( type.length > 1 )
                count += findCompleteSum(Arrays.copyOfRange(type, 1, type.length), remainder);
        }
        return count;
    }
}