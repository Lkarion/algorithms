package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// делители числа
    /*    double n = 36;
        System.out.println("Делители числа " +n+" :");
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                System.out.println(i);
                System.out.println((int) n / i);
            }
        }*/
      /*  Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        int wanted = sc.nextInt();
        System.out.println(getIndex(arr,wanted));*/

        // линейный поиск
        int[] arr1 = {1,2,5,2,5,2,4};
        int wanted = 2, count = 0;
        for (int elem: arr1) {
            if (elem == wanted) count++;
        }
        System.out.println(Arrays.toString(arr1)+"\nnumber "+wanted+" is there "+count+" times");
        System.out.println("number "+wanted+" is there in the array -> "+ifPresent(arr1,wanted));
        System.out.println("number "+wanted+" is there in the array with index(-es): ");
        printIndex(arr1,wanted);


        // ближайшее число
        int x = 3;
        System.out.println("the closest number to "+x+" is " +getClosest(arr1, x));

        System.out.println("max number in the array is "+getmax(arr1));
        System.out.println("index of max number in the array is "+getMaxIndex(arr1));

        //binary search
        int[] array = {1,2,4,5,6,7};
        System.out.println("binary search "+customBinarySearch(array, 3));
    }

    private static int getClosest(int[] arr1, int x) {
        int dif = Math.abs(arr1[0]-x);
        int closestIndex = 0;
        for (int i = 0; i < arr1.length-1; i++) {
            if (arr1[i] == x) return x;
            else if (dif > Math.abs(arr1[i+1]-x)){
                dif = Math.abs(arr1[i+1]-x);
                closestIndex = i+1;
            }
        }
        return arr1[closestIndex];
    }

    private static boolean ifPresent(int[] arr1, int wanted) {
        for (int elem: arr1) {
            if (elem == wanted) return true;
        }
        return false;
    }

    private static int getIndex(int[] arr,int wanted) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == wanted) return i;
        }
        return -1;
    }
    private static void printIndex(int[] arr,int wanted) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == wanted) System.out.print(i+" ");
        }
        System.out.println();
    }

    private static int getmax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }
    private static int getMaxIndex(int[] arr) {
        int max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

     public static int customBinarySearch(int[]arr, int wanted){
        int mid = arr.length/2;
        int start = 0, end = arr.length-1;
        for (int i = 0; i < arr.length; i++) {
             if (wanted > arr[mid]){
                 start = mid+1;
                 mid += (end - start)/2;
             }else if (wanted < arr[mid]){
                 end =mid-1;
                 mid = (end - start)/2;
             }else return mid;
         }
        return -(end+1);
     }


}
