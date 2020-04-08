package esc.problemset3.cohortexercise04;


public class Expression
{
    final Type type;
    Expression leftHandSide;
    Term rightHandSide;
    
    Expression(Type type)
    {
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        switch (type)
        {
            case EXPRESSION_PLUS_TERM:
                return leftHandSide.toString() + "+" + rightHandSide.toString();
            
            case EXPRESSION_MINUS_TERM:
                return leftHandSide.toString() + "-" + rightHandSide.toString();
            
            case TERM:
                return rightHandSide.toString();
            
            default:
                throw new IllegalStateException("Expression has no type");
        }
    }
    
    enum Type
    {
        EXPRESSION_PLUS_TERM,
        EXPRESSION_MINUS_TERM,
        TERM
    }
}
