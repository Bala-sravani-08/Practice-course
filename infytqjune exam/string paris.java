import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        ArrayList <String> list=new ArrayList<>();
        Scanner input =new Scanner(System.in);
        String str=input.nextLine();
        int m=0;
        char co=',';
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==co){
                list.add(str.substring(m,i));
                m=i+1;
            }
        }
        list.add(str.substring(m,str.length()));
        int c=0;
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(i==j){
                    continue;
                }
                String s=list.get(i);
                int ch=0;
                for(int k=0;k<s.length();k++){
                    if(list.get(j).contains(Character.toString(s.charAt(k)))){
                        ch++;
                    }
                }
                if(ch==s.length()){
                    c++;
                }
            }
        }
        System.out.println(c);               
    }
}
