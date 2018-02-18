import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    int x = 0;
    int y = 0;
    
    String test1 = hammingDistance(x, y);
    System.out.println(test1);
  }
  
  public int hammingDistance(int x, int y) {
    int error = 0;
    // first convert x & y int's to binary string
    String binaryX = Integer.toBinaryString(x);
    String binaryY = Integer.toBinaryString(y);
    // convert binary string's to char[]
    char[] xBits = binaryX.toCharArray();
    char[] yBits = binaryY.toCharArray();
    // back fill smallest array with 0's
    int length
    if 
    // loop through char[]
    for (int i = 0; i <
      // compare xChar[i] to yChar[i]
          // if not same increment error count.
          
      // return error count;
  }
}