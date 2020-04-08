package esc.problemset3.cohortexercise07;

/*
 * System of equations:
 *   -9x +  4y + -6z =  2.1
 *   y > 10
 *   y < 16
 *   x > 5
 *   x < 20
 *   z < 3
 *   z > 0
 * 
 * Solving an equation using genetic algorithm is not easy because the probability of randomly generating the exact
 * answer is very low, especially for a double which has an input space that is orders of magnitude larger than an
 * integer. Thus, it is much more difficult to solve this nondeterministically. Since the first condition is an
 * equation, it is very difficult to obtain branch coverage using genetic algorithm (as seen from the results of
 * CBRANCH coverage at 13%). Thus, this example is way more difficult than the example that was given.
 * 
 * 
 * EvoSuite search finished after 31s and 566 generations, 157914 statements, best individual has fitness: 340.88888882257487
 * 
 * Coverage of criterion CBRANCH: 13%
 * Resulting test suite's coverage: 63% (average coverage for all fitness functions)
 * Uncovered lines: [45, 46, 47, 48, 49, 50, 51, 52]
 * Uncovered branches: [
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=44, truthValue=false],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=45, truthValue=true],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=45, truthValue=false],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=46, truthValue=true],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=46, truthValue=false],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=47, truthValue=true],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=47, truthValue=false],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=48, truthValue=true],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=48, truthValue=false],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=49, truthValue=true],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=49, truthValue=false],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=50, truthValue=true],
 *     BranchInfo [className=esc.problemset3.question7.Example2, methodName=test(DDI)V, lineNo=50, truthValue=false]]
 */
public class Example2 
{
    public void test(double x, double y, int z)
    {
        if (-9*x + 4*y + -6*z == 2.1) {
            if (y > 10) {
                if (y < 16) {
                    if (x > 5) {
                        if (x < 20) {
                            if (x < 3) {
                                if(z > 0) {
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
