package converter;

import java.math.BigInteger;
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
                String num_in_str = new String(type_to);
                System.out.println("Conversion result: " + ToBase(ToDecimal(num_in_str, source_base), target_base));
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
}


