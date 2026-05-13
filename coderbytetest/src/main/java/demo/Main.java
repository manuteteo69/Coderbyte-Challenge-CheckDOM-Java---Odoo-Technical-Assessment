package demo;

import java.util.*; 
import java.io.*;

class Main {

  public static String CodingChallenge(String str) {
    // code goes here  

    str = str.replace("<", "<");
    String[] partes = str.split(" ");

    String[] pila = new String[100];
    int top = -1;

    for (String x : partes)
    {
      if(x.startsWith("<") && x.endsWith(">"))
      {
        if(!x.startsWith("</"))
        {
          String tag = x.substring(1, x.length() -1);
          top ++;
          pila[top] = tag;
        }
        else
        {
          String tag = x.substring(2, x.length() -1);
          if(top == -1)
          {
              return "false";
          }

          if(!pila[top].equals(tag))
          {
            return pila[top];
          }
           top --;
        }
      }
    }

    if(top != -1){
      return pila[top];
    }

    return "true";
    //return str;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(CodingChallenge(s.nextLine())); 
  }

}