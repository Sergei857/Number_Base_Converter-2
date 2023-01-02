package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    static StringBuilder CHARE_BASE = new StringBuilder("0123456789abcdefghijklmnopqrstuvwxyz");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter two numbers in format: {source base} {target base} (To quit type /exit) ");
            String type_to = scanner.nextLine();
            if (type_to.equals("/exit")) break;
            int source_base = Integer.parseInt(type_to.split("\\s+")[0]), target_base = Integer.parseInt(type_to.split("\\s+")[1]);
            while (true) {
                System.out.print("Enter number in base %d  to convert to base %d (To go back type /back) "
                        .formatted(source_base, target_base));
                type_to = scanner.nextLine();
                if (type_to.equals("/back")) break;
                StringBuilder num_in_str = new StringBuilder(type_to);

                if (num_in_str.indexOf(".") == -1) {
                    System.out.println("Conversion result: " + ToBase(ToDecimal(num_in_str.toString(), source_base), target_base));
                } else {
                    StringBuilder celay = new StringBuilder(num_in_str.substring(0, num_in_str.indexOf(".")));
                    StringBuilder drobnay = new StringBuilder(num_in_str.substring(num_in_str.indexOf(".") + 1, num_in_str.length()));
                    System.out.println("Conversion result: " + ToBase(ToDecimal(celay.toString(), source_base), target_base) + "."
                            + ToBaseDrob(ToDecimalDrob(drobnay.toString(), source_base), target_base).substring(0, 5));
                }
            }
        }
    }


    public static String ToDecimal(String num_in_str, int source_base) {
        BigInteger dec_out = BigInteger.ZERO;
        int i = 0;
        for (Character ch : new StringBuilder(num_in_str).reverse().toString().toCharArray()) {
            dec_out = dec_out.add(BigInteger.valueOf(CHARE_BASE.toString().indexOf(ch)).multiply
                    (new BigInteger(String.valueOf(source_base)).pow(i)));
            i++;
        }
        return dec_out.toString();
    }

    public static String ToBase(String num_in_str, int target_base) {
        BigInteger dec_in = new BigInteger(num_in_str);
        StringBuilder base_out = new StringBuilder("");
        BigInteger ostatok;
        while (dec_in.compareTo(BigInteger.ZERO) > 0) {
            ostatok = dec_in.mod(BigInteger.valueOf(target_base));
            dec_in = dec_in.subtract(ostatok).divide(BigInteger.valueOf(target_base));
            base_out.append(CHARE_BASE.charAt(ostatok.intValue()));
        }
        return base_out.reverse().toString();
    }

    public static String ToDecimalDrob(String num_in_str, int source_base) {
        Double dec_out = 0.0;
        int i = num_in_str.length();
        for (Character ch : new StringBuilder(num_in_str).reverse().toString().toCharArray()) {
            dec_out = dec_out + CHARE_BASE.toString().indexOf(ch) * Math.pow(source_base, -i);
            i--;
        }
        BigDecimal big_dec_out = new BigDecimal(dec_out);
        return new String(String.valueOf(big_dec_out.setScale(10, RoundingMode.HALF_UP)));
    }

    public static String ToBaseDrob(String num_in_str, int target_base) {
        BigDecimal dec_in = new BigDecimal(num_in_str);
        StringBuilder base_out = new StringBuilder("");
        Integer celoe = null;
        while (true) {
            celoe = dec_in.multiply(BigDecimal.valueOf(target_base)).setScale(0, RoundingMode.DOWN).intValue();
            base_out.append(CHARE_BASE.charAt(celoe));
            if (base_out.length() == 6) {
                break;
            }
            dec_in = dec_in.multiply(BigDecimal.valueOf(target_base)).subtract(BigDecimal.valueOf(celoe));
        }
        return base_out.toString()+"00000";
    }
}


