package com.company;
import java.util.Scanner;

public class Main {
    public static int Add(String num){
        int result = 0;
        if (num.length() == 0){
            return 0;
        } else{
            if (num.toCharArray()[0] == '/' && num.toCharArray()[1] == '/'){
                StringBuffer sb = new StringBuffer("");
                StringBuffer newline = new StringBuffer("");
                for (int i = 2; i < num.split("\\\\n")[0].length(); i++){
                    sb.append(num.split("\\\\n")[0].toCharArray()[i]);
                }
                for (int i = num.split("\\\\n")[0].length() + 2; i < num.length(); i++){
                    newline.append(num.toCharArray()[i]);
                }
                String Line = newline.toString();
                String delimeter = sb.toString();
                String [] numbersLine = Line.split(delimeter + "|,|\\\\n");

                for (int i = 0; i < numbersLine.length; i++){
                    result += Integer.parseInt(numbersLine[i]);
                }
            } else{
                String [] numbersLine = num.split(",|\\\\n");
                for (int i = 0; i < numbersLine.length; i++){
                    result += Integer.parseInt(numbersLine[i]);
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть рядок: ");
        String num = in.nextLine();
        in.close();
        System.out.println("result: " + Add(num));

    }
}
