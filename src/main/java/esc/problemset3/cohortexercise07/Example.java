package esc.problemset3.cohortexercise07;

/*
 * System of Inequalities
 *   x - y < 0
 *   y > 10
 *   y < 16
 *   x > 5
 *   x < 20
 *   z < 3
 *   z > 0
 * 
 * In this example, x and y are dependent due to the first inequality. This causes the inequalities for y to affect
 * the inequalities for x, since the inequalities for y come before x and thus x is already effectively constrained.
 * This has actually created a contradiction, because x - y < 0, y > 10, and y < 16 effectively constrains x to x <
 * 16. This means that the x >= 20 can never be covered, thus 100% branch coverage can never be obtained (as seen 
 * from the results of CBRANCH coverage at 93%).
 * 
 * 
 * EvoSuite search finished after 31s and 693 generations, 295073 statements, best individual has fitness: 6.49999999720685
 * 
 * Coverage of criterion CBRANCH: 93%
 * Resulting test suite's coverage: 98% (average coverage for all fitness functions)
 * Uncovered lines: []
 * Uncovered branches: [BranchInfo [className=esc.problemset3.question7.Example, methodName=test(DDI)V, lineNo=35, truthValue=true]]
 */
public class Example 
{
    public void test(double x, double y, int z)
    {
        if (x - y < 0) {
            if (y > 10) {
                if (y < 16) {
                    if (x > 5) {
                        if (x < 20) {
                            if (z < 3) {
                                if (z > 0) {
                                    System.currentTimeMillis();
                                    System.currentTimeMillis();
                                }
                            }
                        }
                    }
                }
            }
        }
    } 
}
