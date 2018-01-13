
import java.io.*;
import java.util.*;

class MyCode {
  public static int strStr(String haystack, String needle) {
        String[] n = needle.split("\\*");
        int count = 0;
        for(int i = 0; i < needle.length();i++){
          if(needle.charAt(i) == '*') count ++;
        }
        System.out.println(count);
        int index;
        int index1;
        if(needle.length() == 0){
            return 0;
        }
        int[] next = new int[needle.length()];

        String first = n[0];
        String second = n[0+count];
        getNextArr(next, needle);
        int[] nextF = new int[first.length()];
        int[] nextS = new int[second.length()];
        getNextArr(nextF,first);
        getNextArr(nextS,second);

        int i = 0, j = 0;

        int i1 = 0, j1= 0;
        while(i < haystack.length() && j < first.length()){

            if(j == -1 || haystack.charAt(i) == first.charAt(j)){
                i++;
                j++;

            } else {
                j = nextF[j];
            }
        }
        if (j == first.length() ){
          index = i - j;
        }else{
          return -1;
        }
       System.out.println(index);
       String remind = haystack.substring(index+first.length()+count);
       System.out.println(remind);
       
       while(i1 < remind.length() && j1 < second.length()){

            if(j1 == -1 || remind.charAt(i1) == second.charAt(j1)){
                i1++;
                j1++;

            } else {
                j1 = nextS[j1];
            }
        }
        if (j1 == second.length() ){
          index1 = i1 - j1;
        }else{
          return -1;
        }
        return index;
    }
    
    private static void getNextArr(int[] next, String needle){
 
        int k = -1, j = 0;
        next[0] = -1;
        while(j < needle.length() - 1){

            if (k == -1 || needle.charAt(j) == needle.charAt(k)){
                k++;
                j++;
                next[j] = k;
            } else {

                k = next[k];
            }
        }
    }
  public static void main(String[] args) {
        
        System.out.println(strStr("abcabcdef","abc**b"));
    }
}