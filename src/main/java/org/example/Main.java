package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game Uno;
        Boolean END=false;
        char restart ='Y';
        while(restart!='N'){
            System.out.println("Select the number of real players :");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            System.out.println("Select the number of bots :");
            int m = sc.nextInt();
            Game uno=new Game(n,m);
            uno.Start();
            System.out.println("do you want to restart? (Y/N)");
            restart=sc.next().charAt(0);
            if(restart!='N'&& restart!='Y'){
                System.out.println("wrong input Try again");
            }
        }
    }
    }
