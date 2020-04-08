package esc.problemset3.cohortexercise07;

/*
 * System of Inequalities
 *   x > 0
 *   y > 0
 *   z > 0
 *   x > 1
 *   y > 1
 *   z > 1
 *   x > 2
 * 
 * In this example, each variable is independent and not constrained by each other. Thus the inequalities for one
 * variable are mutually exclusive to the inequalities for another variable, and will never contradict each other.
 * Furthermore, the inequalities for each variable are ordered in such a way that an inequality that comes after
 * will not be contradicted by another one before it. This means that all branch conditions can be reached, which
 * explains why 100% branch coverage can be achieved. Thus, this example is easier than the example that was given.
 * 
 * 
 * EvoSuite search finished after 8s and 89 generations, 59304 statements, best individual has fitness: 1.0
 * 
 * Coverage of criterion CBRANCH: 100%
 * Resulting test suite's coverage: 100% (average coverage for all fitness functions)
 * Uncovered lines: []
 * Uncovered branches: []
 */
public class Example3 
{
    public void test(double x, double y, int z)
    {
        if (x > 0) {
            if (y > 0) {
                if (z > 0) {
                    if (x > 1) {
                        if (y > 1) {
                            if (z > 1) {
                                if (x > 2) {
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
