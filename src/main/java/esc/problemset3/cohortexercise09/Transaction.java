package esc.problemset3.cohortexercise09;


public class Transaction
{
    private String type;
    private int amount;
    
    public Transaction(String type, int amount)
    {
        this.type = type;
        this.amount = amount;
    }
    
    public static Transaction newDebit(int amount)
    {
        return new Transaction("debit", amount);
    }
    
    public static Transaction newCredit(int amount)
    {
        return new Transaction("credit", amount);
    }
    
    public String getType()
    {
        return type;
    }
    
    public int getAmount()
    {
        return amount;
    }
}
