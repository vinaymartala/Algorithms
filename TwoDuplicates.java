import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count = 0;
        while(t-- > 0){
            int n = sc.nextInt();
            int [] a = new int[n];
            int xorResult = 0;
            int num1 = 0;
            int num2 = 0;
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
                xorResult ^= a[i];
            }
           
            while((xorResult & 1) == 0 ){
                count++;
                xorResult  = xorResult>>1;
            }
            
             System.out.println(count);
            List<Integer> l1 = new ArrayList();
            List<Integer> l2 = new ArrayList();
            for(int i=0;i<n;i++){
                if(((a[i]>>count) & 1) == 0){
                    l1.add(a[i]);
                }else{
                    l2.add(a[i]);
                }
            }
            
            for(int i : l1){
                num1 ^= i;
            }
            
            for(int i : l2){
                num2 ^= i;
            }
            System.out.println(num1+" "+num2);
        }
    }
}
