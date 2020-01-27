package com.cleancoder.args;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class ArgsMain {
  

public static void main(String[] args) {
    try {
      System.out.println("Enter the String : ");
      Scanner s = new Scanner(System.in);
      String st = s.nextLine();
      Args arg = new Args(st, args);
      Map<Character,String> type = new HashMap<Character,String>();
      ParseSchema pp = new ParseSchema();
      type = pp.gettypeMap();
      char x;
      Scanner sc = new Scanner(System.in);
      
        boolean logging=false;
        String directory="";
        int number=0;
        Double num=0.0;
        Boolean flag = true;
        flag  = sc.nextBoolean();
        while(flag)
        {
        x = sc.next().charAt(0);
        String stt = type.get(x);
        switch(stt)
        {
          case "Boolean" :  logging = arg.getBoolean(x); 
           System.out.println("Logging : "+ logging );
          break;
          case "String" :  directory = arg.getString(x);
           System.out.println("Directory : " + directory);
           break;
          case "Integer" :  number = arg.getInt(x); 
           System.out.println("Number : "+ number);
           break;
          case "Double" :  num = arg.getDouble(x); 
           System.out.println("Double : "+num);
          break;
          case "StringArray" : 
          String[] port = arg.getStringArray(x);
          for(int i = 0 ; i < port.length;i++)
          {
              System.out.println("Port : "+ port[i]);   
          }
           
           break;
        }
              //executeApplication(logging, port, directory,number,num);
              System.out.println("Enter True/False : ");
              flag = sc.nextBoolean();
      }
    } 
    catch (ArgsException e) {
      System.out.printf("Argument error: %s\n", e.errorMessage());
    }
  }
  
  private static void executeApplication(boolean logging, String[] port, String directory, int number , double num) {
    System.out.printf("logging is %s, port:%s, directory:%s, number:%d, num:%f\n",logging, port[0], directory,number,num);
  }
}
