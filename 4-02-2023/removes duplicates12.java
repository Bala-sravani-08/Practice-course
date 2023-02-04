import java.io.*;
import java.util.*;

public class Remove {

    public static void main(String[] args) {
        Scanner du = new Scanner(System.in);
        String str = du.nextLine();
        
        for(int i=0;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                if (str.charAt(i)==str.charAt(j))
                    str = str.substring(0, j) + '@' + str.substring(j + 1,str.length());
            }
        }
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)!='@'){
                System.out.print(str.charAt(i));
            }
        }
    }
}
