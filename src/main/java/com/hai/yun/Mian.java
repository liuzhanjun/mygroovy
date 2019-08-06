package com.hai.yun;

import java.io.File;

public class Mian {
    public static void main(String [] args){
      Man man=new Man();
      Integer integer=1;
      awap(man,integer);
      System.out.println(man.a);
      System.out.println(integer);
      

    }
    
    
    public static void awap(Man a,Integer b){
       a.a=2;
       b=a.a;
    }
    
    public static class Man{
        public int a;
    }
}
