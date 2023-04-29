package project2;

public class KMP {
  
  public int match(String T, String P) {
    /** Your code goes here */
    int[] lps = computelps(P);
    int lenP = P.length(),lenT=T.length();
    int i=0,j=0;

    while(i<lenT){
      if(T.charAt(i)==P.charAt(j)){
        i++;
        j++;
      }
      else{
        if(j==0){
          i++;
        }
        else{
          j=lps[j-1];
        }
      }
      if(j==lenP) return i-lenP;
    }
    return -1;
  }
  private int[] computelps(String P){
    int lenP = P.length();
    int[] lps = new int[lenP];
    lps[0]=0;
    int prevlps = 0,i=1;

    while(i<lenP){
      if(P.charAt(i)==P.charAt(prevlps)){
        prevlps++;
        lps[i] = prevlps;
        i++;
      }
      else{
        if(prevlps==0){
          lps[i]=0;
          i++;
        }
        else{
          prevlps = lps[prevlps-1];
        }
      }
    }
    return lps;
  }
}