import java.util.Arrays;

public class CoinExchange {
    public long exchange(int[] type, int n) {
        int[] descTypes = Arrays.stream(type)
                .filter(i -> i <= n) // remove coin values larger than target as they are redundant
                .map(i -> -i) // sorts array into descending order
                .sorted()
                .map(i -> -i)
                .toArray();

        return findCompleteSum(descTypes, n);
    }

    /*
     Uses recursion to find total amount of combinations
     For example if we want to find the amount of combinations to make 5 out of {1,2,3}
     We start with 3 and have 2 to make up
     We can run the same function to find the amount of combinations to make 2 out of {1,2}
     */
    private long findCompleteSum(int[] type, int n) {
        long count = 0;

        for (int coin : type) {
            int remainder = n - coin;

            int[] filteredCoins = Arrays.stream(type)
                    .filter(i -> i <= coin)
                    .toArray();

            if (remainder == 0)
                count++;
            else if (remainder > 0)
                count += findCompleteSum(filteredCoins, remainder);
        }
        return count;
    }
}