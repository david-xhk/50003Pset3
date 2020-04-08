package esc.problemset3.cohortexercise09;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class AccountNoSmell
{
    private int balance;
    private List<Transaction> transactionList;
    private String lastDebitTime;
    private String lastCreditTime;
    
    public AccountNoSmell()
    {
        this(0);
    }

    public AccountNoSmell(int balance)
    {
        this.balance = balance;
        
        transactionList = new ArrayList<Transaction>();
    }
    
    public void withdraw(int amount)
    {
        balance -= amount;
    }
    
    public void deposit(int amount)
    {
        balance += amount;
    }
        
    public void setBalance(int amount)
    {
        balance = amount;
    }
    
    public int getBalance()
    {
        return balance;
    }
    
    private String getTimestamp()
    {
        Calendar cal = Calendar.getInstance();
        
        return cal.get(Calendar.DATE) + "." + cal.get(Calendar.MONTH) + "." + cal.get(Calendar.YEAR);
    }
    
    private void addTransaction(Transaction transaction)
    {
        transactionList.add(transaction);
    }
    
    public void debitTransaction(int amount)
    {
        withdraw(amount);
        
        addTransaction(Transaction.newDebit(amount));
        
        lastDebitTime = getTimestamp(); 
    }
    
    public void creditTransaction(int amount)
    {
        deposit(amount);
        
        addTransaction(Transaction.newCredit(amount));
        
        lastCreditTime = getTimestamp(); 
    }
    
    public String getLastDebitTime()
    {
        return lastDebitTime;
    }
    
    public String getLastCreditTime()
    {
        return lastCreditTime;
    }
}
