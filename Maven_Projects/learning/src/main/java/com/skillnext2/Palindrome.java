package com.skillnext2;



import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int temp = num;
        int rev = 0;

        while (num != 0) {
            int digit = num % 10;      // get last digit
            rev = rev * 10 + digit;   // build reverse
            num = num / 10;
        }

        if (temp == rev)
            System.out.println("Palindrome Number");
        else
            System.out.println("Not a Palindrome");
    }
}
