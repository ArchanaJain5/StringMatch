package project2;

public class Brute {

  public int match(String T, String P) {
    /** Your code goes here */
    int lenT = T.length();
    int lenP = P.length();

    for(int i=0;i<lenT;i++){
      int j=0;
      for(;j<lenP && i+j<lenT;j++){
        if(T.charAt(i+j)!=P.charAt(j)){
          break;
        }
      }
      if(j==lenP){
        return i;
      }
    }
    return -1;
  }
  
}
