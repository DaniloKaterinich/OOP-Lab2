package com.company;
import java.util.Scanner;

public class Main {
    public static int Add(String num){
        int result = 0;
        if (num.length() == 0){
            return 0;
        } else{
            String [] numbersLine = num.split(",|\\\\n");
            System.out.println(numbersLine[0] + " " + numbersLine[1] + " " + numbersLine[2]);
            for (int i = 0; i < numbersLine.length; i++){
                result += Integer.parseInt(numbersLine[i]);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть рядок: ");
        String num = in.nextLine();
        in.close();
        System.out.println(Add(num));

    }
}
