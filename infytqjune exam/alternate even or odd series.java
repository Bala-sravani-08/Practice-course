import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int c=0;
        String s=sc.nextLine();
        //System.out.println(s);
        StringBuffer f=new StringBuffer();
        List<Integer> fin=new ArrayList<>();
        List<Integer> num=new ArrayList<>();
        List<Character> alp=new ArrayList<>();
        List<Character> spe=new ArrayList<>();
        List<Integer> even=new ArrayList<>();
        List<Integer> odd=new ArrayList<>();
        for (int i=0; i<s.length(); i++){  
            if (Character.isDigit(s.charAt(i))){
                int a= s.charAt(i)-'0';
                if(a%2==0){
                    even.add(a);
                }
                else{
                    odd.add(a);
                }
                
            }
               else if(Character.isAlphabetic(s.charAt(i))){  
                alp.add(s.charAt(i));  
            }
            else{ 
                spe.add(s.charAt(i));  
                c=c+1;
             }    
        }

        if(c%2==0){
            int i=0,j=0;
            while(i<even.size()||j<odd.size()){
                if(i<even.size()){
                    f.append(even.get(i));
                    i=i+1;
                }if(j<odd.size()){
                    f.append(odd.get(j));
                    j=j+1;
                }
            }

        }else{
                int i=0,j=0;
            while(i<odd.size()||j<even.size()){
                if(i<odd.size()){
                    f.append(odd.get(i));
                    i=i+1;
                }if(j<even.size()){
                    f.append(even.get(j));
                    j=j+1;
                }
            }
    
}
        System.out.println(f);
      
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
}}
