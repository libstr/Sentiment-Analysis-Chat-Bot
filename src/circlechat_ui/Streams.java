/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package circlechat_ui;

import java.io.*;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Rinchen
 */
public class Streams {
    
    public static void cut(File path) throws FileNotFoundException{
        Scanner in=new Scanner(path);
         String g=in.nextLine();
        int s=g.length();
        char z;
        int pos=0,count=0,r=0;
        String a[]=new String[s];
         for(int l=0;l<s;l++){
             z=g.charAt(l);
             if(z=='.'){
               a[count]=g.substring(pos,l);
               pos=l+1;
               count++;
               
             
             }
         } 
          r=(int)(Math.random()*count);
          for(int i=0;i<a[r].length();i++){
              System.out.print(a[r].charAt(i));
              if(i%50==0)
                  System.out.println("");
          }
    }
    
    public static void main(String[] args) throws FileNotFoundException{
      File path=new File("Happy.txt");
       File path1=new File("Sad.txt");
       File path2=new File("Neutral.txt");
        Scanner kn=new Scanner(System.in);
        int u=kn.nextInt();
  
       
  switch(u){
      case 3: 
  cut(path);
     
     break;
     
  case 1:
     cut(path1);
   break;
   
  case 2:
    cut(path2);
       break;
   
  default:
           System.out.println("No Emotions Can Be Given");
    
    }
   }
}


