package jar;
public class SimpleExercices 
{

    //https://www.codewars.com/kata/54ff0d1f355cfd20e60001fc/train/java
    public static int factorial(int n) {
        
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
        
    }

    
}

