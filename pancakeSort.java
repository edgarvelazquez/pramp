import java.io.*;
import java.util.*;


//Explanation
/*
The idea is to find the max and move to the end
Then we move inwards one by one moving closer to the left
*/

class Solution {

 
  static int[] pancakeSort(int[] arr) {
  int len = arr.length;
    while(len >= 0) {
      int maxVal = findMax(arr,len);
      flip(arr,maxVal+1);
      flip(arr,len);
      len--;
    }
   return arr;
  }
    /*
  Backtracking 
   
  round 1
  len=5
  max=1
  [1, 5, 4, 3, 2] 
  [2, 3, 4, 1, 5] 
  
  round 2
  len=4
  max=2
  [2, 3, 4, 1, 5]original
  [4, 3, 2, 1, 5]first flip
  [1, 2, 3, 4, 5]second flip
  
  round 3
  len=3
  max=2
  [1, 2, 3, 4, 5]original
  [3, 2, 1, 4, 5]original
  [1, 2, 3, 4, 5]original
  */
  
  static int findMax(int arr[], int n) { 
    int i=0;
    int max = 0;
    while(i < n) {
      if(arr[i] > arr[max]) max = i;
      i++;
    }

    return max;
  } 
  
  static void flip(int[] arr, int k) {//k-1
    
    if(arr == null|| k == 1 || k > arr.length ){
      return;
    }
    int left=0;
    int right=(k-1);
    
    while(left < right) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }

  public static void main(String[] args) {
    //Test cases
    /*
    int[] test1 = {1, 5,7,8,100,0, 4, 3, 2};
      
    System.out.println(Arrays.toString(test1));
    int[] test2 =pancakeSort(test1);
    System.out.println(Arrays.toString(test2));
    */
  }


}