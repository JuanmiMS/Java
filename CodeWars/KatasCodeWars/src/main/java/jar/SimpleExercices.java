package jar;
public class SimpleExercices 
{
    public static void main(String [] args){
        //Here we can call the methods to see the prints and asserts
        isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'});
    }

    //https://www.codewars.com/kata/54ff0d1f355cfd20e60001fc/train/java
    public static int factorial(int n) {
        
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
        }
        return sum;
    }
    //https://www.codewars.com/kata/array-plus-array/train/java
    public static int arrayPlusArray(int[] arr1, int[] arr2) {

        
        int totalSum = 0;

        //Array 1
        for(int i=0; i< arr1.length; i++){
            totalSum += arr1[i];
        }

        //Array 2
        for(int i=0; i< arr2.length; i++){
            totalSum += arr2[i];
        }
        
        return totalSum;
      }

    //https://www.codewars.com/kata/take-a-ten-minute-walk
    
    public static boolean isValid(char[] walk) {

        int[] initialPosition = new int[2]; //Start position in [0,0], the first for X and the second for Y

        for (int i = 0; i<walk.length;i++){
            switch (walk[i]){
                case 'n':
                    initialPosition[0] += 1;
                    break;
                case 's':
                    initialPosition[0] -= 1;
                    break;
                case 'e':
                    initialPosition[1] += 1;
                    break;
                case 'w':
                    initialPosition[1] -= 1;
                    break;
            }
        }
        if ((initialPosition[0] + initialPosition[1] == 0) && (walk.length == 10)){
            System.out.println(true);
            return true;
        }else{
            System.out.println(false);
            return false;
        }
     }
    
    }

