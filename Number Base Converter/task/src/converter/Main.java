package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static String CHARE_BASE = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) throws IOException {

        while (true) {
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            String type_to = InputStr();
            if (type_to.equals("/exit")) break;
            int source_base = Integer.parseInt(type_to.split("\\s+")[0]), target_base = Integer.parseInt(type_to.split("\\s+")[1]);
            System.out.println(source_base + " " + target_base);
            while (true) {
                System.out.print("Enter number in base %d  to convert to base %d (To go back type /back) "
                        .formatted(source_base, target_base));
                type_to = InputStr();
                if (type_to.equals("/back")) break;
                String num_in_str = new String(type_to);
                System.out.println("Conversion result: " + num_in_str);
            }
        }
    }

    public static String ToDecimal(String num_in_str, int source_base) {
        BigInteger dec_out = BigInteger.ZERO;
        Integer i = 1, temp = 0;
        for (Character ch : new StringBuilder(num_in_str).reverse().toString().toCharArray()) {
            if (Character.isDigit(ch)) {
                temp = Integer.parseInt(ch.toString());
            } else {
                switch (Character.toUpperCase(ch)) {
                    case 'A' -> temp = 10;
                    case 'B' -> temp = 11;
                    case 'C' -> temp = 12;
                    case 'D' -> temp = 13;
                    case 'E' -> temp = 14;
                    case 'F' -> temp = 15;
                }
            }
            dec_out = dec_out + temp * i;
            i = i * 16;
        }
        return dec_out.toString();
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


    public static String BinToDecimal(String str) {
        Integer dec_out = 0, i = 1;
        for (Character ch : new StringBuilder(str).reverse().toString().toCharArray()) {
            dec_out = dec_out + Integer.parseInt(ch.toString()) * i;
            i = i * 2;
        }
        return dec_out.toString();
    }

    public static String V8ToDecimal(String str) {
        Integer dec_out = 0, i = 1;
        for (Character ch : new StringBuilder(str).reverse().toString().toCharArray()) {
            dec_out = dec_out + Integer.parseInt(ch.toString()) * i;
            i = i * 8;
        }
        return dec_out.toString();
    }

    public static String S16ToDecimal(String str) {
        Integer dec_out = 0, i = 1, temp = 0;
        for (Character ch : new StringBuilder(str).reverse().toString().toCharArray()) {
            if (Character.isDigit(ch)) {
                temp = Integer.parseInt(ch.toString());
            } else {
                switch (Character.toUpperCase(ch)) {
                    case 'A' -> temp = 10;
                    case 'B' -> temp = 11;
                    case 'C' -> temp = 12;
                    case 'D' -> temp = 13;
                    case 'E' -> temp = 14;
                    case 'F' -> temp = 15;
                }
            }
            dec_out = dec_out + temp * i;
            i = i * 16;
        }
        return dec_out.toString();
    }


    public static String InputStr() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}


