package com.hypo;

public class Variables {

    public static void main(String args[])
    {
        int x = 10;
        char y = 'C';
        double z = 5.6;
        boolean flag = true;

        x = x+10;
        String s = String.valueOf(y).toLowerCase();
        z = z*2;
        flag = false;

        System.out.println("x = "+x);
        System.out.println("s="+s);
        System.out.println("z="+z);
        System.out.println("flag="+flag);


    }
}
