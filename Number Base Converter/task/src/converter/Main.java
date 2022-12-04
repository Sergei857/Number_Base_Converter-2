package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        while (true) {
            String out = "";
            System.out.print("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
            String type_to = InputStr();
            if (type_to.equals("/exit")) break;
            switch (type_to) {
                case "/from" -> {
                    System.out.print("Enter number in decimal system: ");
                    int decimal_input = Integer.parseInt(InputStr());
                    System.out.print("Enter target base: ");
                    int target_sys_input = Integer.parseInt(InputStr());
                    switch (target_sys_input) {
                        case 2 -> System.out.println("Conversion result: " + DecimalTo2(decimal_input));
                        case 8 -> System.out.println("Conversion result: " + DecimalTo8(decimal_input));
                        case 16 -> System.out.println("Conversion result: " + DecimalTo16(decimal_input));
                    }
                }
                case "/to" -> {
                    System.out.print("Enter source number: ");
                    String sourse_input = InputStr();
                    System.out.print("Enter source base: ");
                    int target_sys_input = Integer.parseInt(InputStr());
                    switch (target_sys_input) {
                        case 2 -> System.out.println("Conversion to decimal result: " + BinToDecimal(sourse_input));
                        case 8 -> System.out.println("Conversion to decimal result: " + V8ToDecimal(sourse_input));
                        case 16 -> System.out.println("Conversion to decimal result: " + S16ToDecimal(sourse_input));
                    }
                }
            }
        }
    }


    public static String InputStr() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();

    }

    public static String DecimalTo2(int dec) {
        Integer remainder, quotient;
        StringBuilder out_str = new StringBuilder("");
        while (true) {
            remainder = dec % 2;
            quotient = dec / 2;
            dec = quotient;
            out_str.append(remainder);
            if (quotient < 2 & dec != 0) {
                out_str.append(dec);
                break;
            } else if (quotient < 2) break;
        }
        return out_str.reverse().toString();
    }

    public static String DecimalTo8(int dec) {
        Integer remainder, quotient;
        StringBuilder out_str = new StringBuilder("");
        while (true) {
            remainder = dec % 8;
            quotient = dec / 8;
            dec = quotient;
            out_str.append(remainder);
            if (quotient < 8 & dec != 0) {
                out_str.append(dec);
                break;
            } else if (quotient < 8) break;
        }
        return out_str.reverse().toString();
    }

    public static String DecimalTo16(int dec) {
        Integer remainder, quotient;
        StringBuilder out_str = new StringBuilder("");
        String remainder_str = "";
        while (true) {
            remainder = dec % 16;
            quotient = dec / 16;
            dec = quotient;
            if (remainder < 10) {
                remainder_str = remainder.toString();
            } else {
                switch (remainder) {
                    case 10 -> remainder_str = "A";
                    case 11 -> remainder_str = "B";
                    case 12 -> remainder_str = "C";
                    case 13 -> remainder_str = "D";
                    case 14 -> remainder_str = "E";
                    case 15 -> remainder_str = "F";
                }
            }
            out_str.append(remainder_str);
            if (quotient < 16 & dec != 0) {
                remainder = dec;
                if (remainder < 10) {
                    remainder_str = remainder.toString();
                } else {
                    switch (remainder) {
                        case 10 -> remainder_str = "A";
                        case 11 -> remainder_str = "B";
                        case 12 -> remainder_str = "C";
                        case 13 -> remainder_str = "D";
                        case 14 -> remainder_str = "E";
                        case 15 -> remainder_str = "F";
                    }
                }
                out_str.append(remainder_str);
                break;
            } else if (quotient < 16) break;
        }
        return out_str.reverse().toString();
    }

    public static String BinToDecimal(String str){




    }

}



