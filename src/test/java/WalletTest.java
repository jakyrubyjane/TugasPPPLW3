import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WalletTest {
    private Wallet wallet;

    @BeforeAll
    void initClass() {
        System.out.println("Initializing WalletTest class...");
    }

    @AfterAll
    void cleanClass() {
        System.out.println("Cleaning up WalletTest class...");
    }

    @BeforeEach
    void initMethod() {
        System.out.println("Initializing test method...");
        Owner owner = new Owner("Jane", 20);
        List<Card> cards = new ArrayList<>();
        wallet = new Wallet(owner, cards, 100.0);
    }

    @AfterEach
    void cleanMethod() {
        System.out.println("Cleaning up test method...");
        wallet = null;
    }

    @Test
    void testWithdrawSufficientCash() {
        assertEquals(100.0, wallet.Withdraw(100.0));
    }

    @Test
    void testWithdrawInsufficientCash() {
        assertEquals(0.0, wallet.Withdraw(150.0));
    }

    @Test
    void testWithdrawExceedBalance() {
        assertEquals(0.0, wallet.Withdraw(150.0));
    }

    @Test
    void testDepositSuccessful() {
        assertEquals(150.0, wallet.Deposit(50.0));
    }

    @Test
    void testDepositFailed() {
        assertNotEquals(10.0, wallet.Deposit(20.0));
    }

    @Test
    void testAddCard() {
        wallet.addCards("BRI", 1234567890);
        wallet.addCards("BCA", 1233333333);
        assertEquals(2, wallet.getCards().size());
    }

    @Test
    void testRemoveCard() {
        Card card = new Card("Jane Doe", 1234567890);
        wallet.getCards().add(card);
        wallet.removeCard(1234567890);
        assertEquals(0, wallet.getCards().size());
    }

    @Test
    void testFalseCard() {
        wallet.addCards("BRI", 1234567890);
        assertFalse(wallet.getCards().isEmpty());
    }

    @Test
    void testRemoveNonExistentCard() {
        wallet.removeCard(1234567890);
        assertTrue(wallet.getCards().isEmpty());
    }
}
