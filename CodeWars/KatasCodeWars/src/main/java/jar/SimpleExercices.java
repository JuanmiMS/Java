package jar;
public class SimpleExercices 
{
    public static void main(String [] args){
        arrayPlusArray(new int[]{1,2,3}, new int[]{4,5,6});
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

    
}

