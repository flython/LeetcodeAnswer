package tmp;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import java.math.BigDecimal;
class Bank {

    List<BigDecimal> balance;

    public Bank(long[] balance) {
        this.balance = Arrays.stream(balance).mapToObj(BigDecimal::new).collect(Collectors.toList());
    }

    boolean check(int account,BigDecimal money){
        if (account > balance.size()){
            return false;
        }
        if (money != null){
            BigDecimal acc1 = balance.get(account - 1);
            if (acc1.compareTo(money) < 0){
                return false;
            }
        }
        return true;
    }

    void accountAction(int account,BigDecimal money,boolean add){
        BigDecimal acc1 = balance.get(account - 1);
        acc1 = add? acc1.add(money):acc1.subtract(money);
        balance.set(account-1,acc1);
    }

    public boolean transfer(int account1, int account2, long money) {
        BigDecimal tran = new BigDecimal(money);
        if (!check(account1, tran)){return false;}
        if (!check(account2, null)){return false;}
        accountAction(account1,tran,false);
        accountAction(account2,tran,true);
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!check(account,null)) { return false; }
        accountAction(account,new BigDecimal(money),true);
        return true;
    }

    public boolean withdraw(int account, long money) {
        BigDecimal get = new BigDecimal(money);
        if (!check(account,get)){return false;}
        accountAction(account,get,false);
        return true;
    }
}

