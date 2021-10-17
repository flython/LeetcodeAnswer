package tmp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    @Test
    void transfer() {
        Bank bank = new Bank(new long[]{10, 100, 20, 50, 30});
        System.out.println(bank.withdraw(5480, 50));
        System.out.println(bank.deposit(5480, 50));
        System.out.println(bank.transfer(5480, 2,5));
        System.out.println(bank.transfer(1, 2,5));
        System.out.println(bank.transfer(1, 2,5));
    }
}