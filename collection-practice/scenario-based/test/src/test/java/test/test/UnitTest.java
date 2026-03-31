package test.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class UnitTest {
	private Program account;
	
	@BeforeEach
	public void setup() {
		account = new Program(1000);
	}
	
	@Test
	public void Test_Deposit_ValidAmount() {
		account.deposit(500);
		assertEquals(1500, account.getBalance());
	}
	
	@Test
	public void Test_Deposit_NegativeAmount() {
		Exception ex = assertThrows(IllegalArgumentException.class, () -> account.deposit(-250));
		
		assertEquals("Deposit amount cannot be negative",ex.getMessage());
	}

    @Test
    public void Test_Withdraw_ValidAmount() {
        account.withdraw(400);

        assertEquals(600, account.getBalance());
    }

    @Test
    public void Test_Withdraw_InsufficientFunds() {
        Exception ex = assertThrows(
                IllegalArgumentException.class,
                () -> account.withdraw(2000)
        );

        assertEquals("Insufficient funds.", ex.getMessage());
    }
}