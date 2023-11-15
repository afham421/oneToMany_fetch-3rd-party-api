package com.detabase;

import java.math.BigInteger;
import java.util.Scanner;

public class DeffiHellman {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        BigInteger n,g,x,y,A,B,k1,k2;

        System.out.println("Enter two prime number : ");
        n=new BigInteger(scanner.next());
        g=new BigInteger(scanner.next());

        System.out.println("person A : Enter your secret number!!!");
        x=new BigInteger(scanner.next());
        A = g.modPow(x,n);

        System.out.println("person B : Enter your secret number!!!");
        y=new BigInteger(scanner.next());
        B = g.modPow(y,n);

        k1 = B.modPow(x,n);
        k2 = A.modPow(y,n);

        System.out.println("A's secret key is : " + k1);
        System.out.println("B's secret key is : " + k2);



    }
}
