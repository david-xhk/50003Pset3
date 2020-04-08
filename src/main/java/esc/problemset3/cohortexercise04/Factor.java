package esc.problemset3.cohortexercise04;


public class Factor
{
    final Type type;
    Expression expression;
    Integer leftHandSide;
    Integer rightHandSide;
    
    Factor(Type type)
    {
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        switch (type)
        {
            case NEGATIVE_INTEGER:
                return "-" + leftHandSide.toString();
            
            case EXPRESSION:      
                return "(" + expression.toString() + ")";
            
            case INTEGER:
                return leftHandSide.toString();
            
            case FLOATING_INTEGER:
                return leftHandSide.toString() + "." + rightHandSide.toString();
            
            default:
                throw new IllegalStateException("Factor has no type");
        }
    }
    
    enum Type
    {
        NEGATIVE_INTEGER,
        EXPRESSION,
        INTEGER,
        FLOATING_INTEGER
    }
}
