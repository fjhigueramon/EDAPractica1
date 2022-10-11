import heap.HeapPriorityQueue;
import heap.PriorityQueue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HeapTests {

    PriorityQueue<Integer, String> heap;

    @Test
    @BeforeEach
    void setUpHeap(){
        heap = new HeapPriorityQueue<>();
        heap.insert(0, "Giannis Antetokounmpo");
        heap.insert(1, "Kevin Durant");
        heap.insert(2, "Stephen Curry");
        heap.insert(3, "Nikola Jokic");
        heap.insert(5, "Joel Embiid");
        heap.insert(6, "Jayson Tatum");
        heap.insert(7, "Luka Dončić");
        heap.insert(8, "LeBron James");
        heap.insert(9, "Kawhi Leonard");
        heap.insert(10, "Ja Morant");
        heap.insert(11, "Devin Booker");
        heap.insert(13, "Jimmy Butler");
        heap.insert(15, "James Harden");
        heap.insert(17, "Karl-Anthony Towns");
    }

    @Test
    void testGetFiveBestPlayers(){
        Assertions.assertEquals("Giannis Antetokounmpo", heap.removeMin().getSecond());
        Assertions.assertEquals("Kevin Durant", heap.removeMin().getSecond());
        Assertions.assertEquals("Stephen Curry", heap.removeMin().getSecond());
        Assertions.assertEquals("Nikola Jokic", heap.removeMin().getSecond());
        Assertions.assertEquals("Joel Embiid", heap.removeMin().getSecond());
    }

    @Test
    void testGetFiveBestPlayersInsertingNewOnes(){
        Assertions.assertEquals("Giannis Antetokounmpo", heap.removeMin().getSecond());
        heap.insert(0, System.getProperty("user.name"));
        heap.insert(4, "Pau Gasol");
        Assertions.assertEquals(System.getProperty("user.name"), heap.removeMin().getSecond());
        Assertions.assertEquals("Kevin Durant", heap.removeMin().getSecond());
        Assertions.assertEquals("Stephen Curry", heap.removeMin().getSecond());
        Assertions.assertEquals("Nikola Jokic", heap.removeMin().getSecond());
        Assertions.assertEquals("Pau Gasol", heap.removeMin().getSecond());
        Assertions.assertEquals("Joel Embiid", heap.removeMin().getSecond());
    }

}
