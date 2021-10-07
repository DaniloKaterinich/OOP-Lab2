package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть рядок: ");
        String num = in.nextLine();
        in.close();

        if (num.length() == 0){
            System.out.println(0);
        } else{
            String [] numbers = num.split(",");
            int result = 0;
            for (int i = 0; i < numbers.length; i++){
                result += Integer.parseInt(numbers[i]);
            }
            System.out.println(result);
        }

    }
}
