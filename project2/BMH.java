package project2;

import java.util.Arrays;

public class BMH {
  
  public int match(String T, String P) {
    /** Your code goes here */
    int[] shifts = computehueristic(P);
    int lenP = P.length() ,lenT = T.length();
    int i = lenP-1,j=lenP-1;

    while(i<lenT){
      if(T.charAt(i)==P.charAt(j)){
        if(j==0) return i;
        i--;
        j--;
      }
      else{
        int jumps = shifts[(int)T.charAt(i)];
        i = i+lenP - Math.min(j,1+jumps);
        j=lenP-1;
      }
    }
    return -1;
  }
  private int[] computehueristic(String P){
    int[] shifts = new int[256];
    int lenP = P.length();
    Arrays.fill(shifts,-1);
    for(int i=0;i<lenP;i++){
      char c = P.charAt(i);
      shifts[(int)c]=i;
    }
    return shifts;
  }
}
