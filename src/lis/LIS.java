/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lis;

import java.util.*;

/**
 *
 * @author mahinjm
 */
public class LIS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int arr[] = {1,10,2,3,4,5,6,7,8};
        
        
        int arr2[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        
        System.out.println(LISLoop(arr));
        
    }
    
    
    //LIS in Dynamic Programming
    public static int LISDP(int[] arr) {
        int[] result = new int[arr.length+1];
        Arrays.fill(result, 1);
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i ; j++) {
                if (arr[j] < arr[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                    max = result[i];
                }
            }
        }
        return max;
    }
    
    
    //LIS in Loop 
    //May be there is a small issue
    public static int LISLoop(int[] a) {
        int max=0;
        int res[] = new int[a.length+1];
        
        for(int i=0;i<a.length;i++){
            max=0;
            for(int j=0;j<a.length-1;j++){
                if(a[i]<a[j] && a[j]!=a[j+1]){
                    max++;
                }
                //res[i]=max;
            }
            res[i]=max;
        }
        
        int maxLength =1;
        for(int i=0;i<a.length;i++){
            if(res[i]>maxLength){
                maxLength+=res[i];
            }
            
        }
        return maxLength;
    }
    
}
