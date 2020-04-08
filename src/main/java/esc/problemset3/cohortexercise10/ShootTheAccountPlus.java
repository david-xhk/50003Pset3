package esc.problemset3.cohortexercise10;

import esc.problemset3.cohortexercise09.AccountNoSmell;


public class ShootTheAccountPlus extends AccountNoSmell
{
    private Type type;
    
    private ShootTheAccountPlus(int balance, Type type)
    {
        super(balance);
        
        this.type = type;
    }
    
    // only use these static factory methods to instantiate ShootTheAccountPlus
    public static ShootTheAccountPlus newPersonalAccount(int balance)
    {
        ShootTheAccountPlus account = new ShootTheAccountPlus(balance, Type.PERSONAL);
        
        account.checkBalance();
        
        return account;
    }
    
    public static ShootTheAccountPlus newBusinessAccount(int balance)
    {
        return new ShootTheAccountPlus(balance, Type.BUSINESS);
    }
    
    public static ShootTheAccountPlus newInvestmentAccount(int balance)
    {
        return new ShootTheAccountPlus(balance, Type.INVESTMENT);
    }
    
    public Type getType()
    {
        return type;
    }
    
    // personal accounts cannot transact debit if their balance is less than 500
    @Override
    public void debitTransaction(int amount)
    {
        if (type == Type.PERSONAL && !checkBalance())
            return;
        
        super.debitTransaction(amount);
    }
    
    // personal accounts cannot transfer funds if their balance is less than 500
    public void transfer(int amount, AccountNoSmell otherAccount)
    {
        if (type == Type.PERSONAL && !checkBalance())
            return;
        
        debitTransaction(amount);
        
        otherAccount.creditTransaction(amount);
    }
    
    public boolean checkBalance()
    {
        if (getBalance() >= 500)
            return true;
        
        System.out.println("Balance must be more than 500, please deposit");
        
        return false;
    }
    
    public enum Type
    {
        PERSONAL,
        BUSINESS,
        INVESTMENT
    }
}
