package esc.problemset3.cohortexercise04;


public class Term
{
    final Type type;
    Term leftHandSide;
    Factor rightHandSide;
    
    Term(Type type)
    {
        this.type = type;
    }
    
    @Override
    public String toString()
    {
        switch (type)
        {
            case TERM_MULTIPLY_FACTOR:
                return leftHandSide.toString() + "*" + rightHandSide.toString();
            
            case TERM_DIVIDE_FACTOR:
                return leftHandSide.toString() + "/" + rightHandSide.toString();
            
            case FACTOR:
                return rightHandSide.toString();
            
            default:
                throw new IllegalStateException("Term has no type");
        }
    }
    
    enum Type
    {
        TERM_MULTIPLY_FACTOR,
        TERM_DIVIDE_FACTOR,
        FACTOR
    }
}
