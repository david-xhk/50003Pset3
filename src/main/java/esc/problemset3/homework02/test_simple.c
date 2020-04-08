int main() 
{
    int x;
    
    /* declare the memory region occupied by 
     * variable "x" to be symbolic
     * 
     * This means the program will be executed
     * with uninstantiated, i.e., symbolic
     * values of x.
     */
    
    klee_make_symbolic(&x, sizeof(x), "x");
    
    switch (x % 8)
    {
        case 0:
            printf("x mod 8 = 0");
            break;
        
        case 1:
            printf("x mod 8 = 1");
            break;
        
        case 2:
            printf("x mod 8 = 2");
            break;
        
        case 3:
            printf("x mod 8 = 3");
            break;
        
        case 4:
            printf("x mod 8 = 4");
            break;
        
        case 5:
            printf("x mod 8 = 5");
            break;
        
        case 6:
            printf("x mod 8 = 6");
            break;
        
        case 7:
            printf("x mod 8 = 7");
            break;
    }
}
