import static org.junit.jupiter.api.Assertions.*;

class CoinExchangeTest {

    @org.junit.jupiter.api.Test
    void exchange() {
        CoinExchange exchanger = new CoinExchange();
        assertEquals(5, exchanger.exchange(new int[] {1,2,3},5));
        assertEquals(4, exchanger.exchange(new int[] {1,5,10,50,100},11));
    }
}