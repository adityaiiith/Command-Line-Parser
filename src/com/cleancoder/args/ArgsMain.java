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
      x = sc.next().charAt(0);
      String stt = type.get(x);
        boolean logging=false;
        String directory="";
        int number=0;
        Double num=0.0;
        String []port={""};
    
        switch(stt)
        {
          case "Boolean" :  logging = arg.getBoolean(x); break;
          case "String" :  directory = arg.getString(x); break;
          case "Integer" :  number = arg.getInt(x);  break;
          case "Double" :  num = arg.getDouble(x); break;
          case "StringArray" :  port = arg.getStringArray(x); break;
        }
              executeApplication(logging, port, directory,number,num);

      
    } 
    catch (ArgsException e) {
      System.out.printf("Argument error: %s\n", e.errorMessage());
    }
  }
  
  private static void executeApplication(boolean logging, String[] port, String directory, int number , double num) {
    System.out.printf("logging is %s, port:%s, directory:%s, number:%d, num:%f\n",logging, port[0], directory,number,num);
  }
}