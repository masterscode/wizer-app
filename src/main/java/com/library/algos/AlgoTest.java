package com.library.algos;

import java.util.Arrays;

public class AlgoTest {


    public void printRightAlignedTriangle(int height){
        for (int i = 0; i <= height; i++){
            System.out.println(
                    "*".repeat(i)
            );
        }
    }

    public  void targetSum(int[] collection, int value){
        //[1,2,3,4,5] Earliest opt-out
        for (int i= 0; i < collection.length; i++){
            for (int j = i + 1; j < collection.length; j++){
                int firstValue = collection[i];
                int secondValue = collection[j];
                int sum = firstValue + secondValue;
                if (sum == value){
                    System.out.println(
                            String.format("%d %d", i, j)
                    );
                    break;
                }
            }
        }
    }

    public int[] rotateArrayByN(int[] collection, int n){

      //
    }


    public static void main(String[] args) {
        AlgoTest test = new AlgoTest();


//        test.printRightAlignedTriangle(5);
//        test.targetSum(new int[]{1,2,3,4,5,6}, 10);

        System.out.println(Arrays.toString(test.rotateArrayByN(new int[]{1,2,3,4,5,6}, 2)));
    }
}
