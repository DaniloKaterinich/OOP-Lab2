package com.company;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static String Metacharacters(String del) {
        for (int i = 0; i < del.length(); i++) {
            if ((Objects.equals(del.charAt(i), '.')) ||
                    (Objects.equals(del.charAt(i), '+')) ||
                    (Objects.equals(del.charAt(i), '?')) ||
                    (Objects.equals(del.charAt(i), '^')) ||
                    (Objects.equals(del.charAt(i), '*')) ||
                    (Objects.equals(del.charAt(i), '$')) ||
                    (Objects.equals(del.charAt(i), '|')) ||
                    (Objects.equals(del.charAt(i), '\\')) ||
                    (Objects.equals(del.charAt(i), ')')) ||
                    (Objects.equals(del.charAt(i), '(')) ||
                    (Objects.equals(del.charAt(i), '&'))) {
                del = new StringBuilder(del).insert(i, "\\").toString();
                i++;
            }
        }
        return del;
    }

    public static int Add(String num) throws Exception{
        int result = 0;
        if (num.length() == 0){
            return 0;
        } else{
            if (num.toCharArray()[0] == '/' && num.toCharArray()[1] == '/'){
                StringBuffer sb = new StringBuffer();
                StringBuffer newline = new StringBuffer();
                String delimeter = "";
                if (num.toCharArray()[2] != '['){
                    for (int i = 2; i < num.split("\\\\n")[0].length(); i++){
                        sb.append(num.split("\\\\n")[0].toCharArray()[i]);
                    }
                } else{
                    String [] delimeters = num.split("\\\\n")[0].split("\\[|\\]");
                    for (int i = 1; i < delimeters.length; i++){
                        if (Objects.equals(delimeters[i], "")) continue;
                        else{
                            delimeters[i] = Metacharacters(delimeters[i]);
                            if (i == 1) delimeter += delimeters[i];
                            else delimeter += "|" + delimeters[i];
                        }
                    }
                    System.out.println(delimeter);
                }

                for (int i = num.split("\\\\n")[0].length() + 2; i < num.length(); i++){
                    newline.append(num.toCharArray()[i]);
                }
                String Line = newline.toString();
                String [] numbersLine = Line.split(delimeter + "|,|\\\\n");

                for (int i = 0; i < numbersLine.length; i++){
                    if(Integer.parseInt(numbersLine[i]) < 0){
                        StringBuffer nigga = new StringBuffer("");
                        for (int j = 0; j < numbersLine.length; j++) {
                            if (Integer.parseInt(numbersLine[j]) < 0) {
                                nigga.append(numbersLine[j]);
                            }
                        }
                        throw new Exception("negatives not allowed: " + nigga);
                    }
                    if (Integer.parseInt(numbersLine[i]) <= 1000){
                        result += Integer.parseInt(numbersLine[i]);
                    }
                }
            } else{
                String [] numbersLine = num.split(",|\\\\n");
                for (int i = 0; i < numbersLine.length; i++){
                    if(Integer.parseInt(numbersLine[i]) < 0){
                        StringBuffer nigga = new StringBuffer("");
                        for (int j = 0; j < numbersLine.length; j++) {
                            if (Integer.parseInt(numbersLine[j]) < 0) {
                                nigga.append(numbersLine[j]);
                            }
                        }
                        throw new Exception("negatives not allowed: " + nigga.toString());
                    }
                    if (Integer.parseInt(numbersLine[i]) <= 1000){
                        result += Integer.parseInt(numbersLine[i]);
                    }
                }
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("?????????????? ??????????: ");
        String num = in.nextLine();
        in.close();
        try{
            System.out.println("result " + Add(num));
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }

    }
}
