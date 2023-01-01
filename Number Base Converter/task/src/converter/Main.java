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
                System.out.println("Conversion result: TO 10  -> " + ToDecimal(num_in_str, source_base));
                System.out.println("Conversion result: TO Base-> " + ToBase(ToDecimal(num_in_str, source_base), target_base));
            }
        }
    }

    public static String ToDecimal(String num_in_str, int source_base) {
        BigInteger dec_out = BigInteger.ZERO;
        int i = 0;
        for (Character ch : new StringBuilder(num_in_str).reverse().toString().toCharArray()) {
            dec_out = dec_out.add(BigInteger.valueOf(CHARE_BASE.indexOf(ch)).multiply(new BigInteger(String.valueOf(source_base)).pow(i)));
            i++;
        }
        return dec_out.toString();
    }

    public static String ToBase(String num_in_str, int target_base) {
        BigInteger dec_out = BigInteger.ZERO;
        Integer i = 0;
        BigInteger raz = BigInteger.ONE;
        for (Character ch : new StringBuilder(num_in_str).reverse().toString().toCharArray()) {
            raz = BigInteger.valueOf(CHARE_BASE.indexOf(ch));
            dec_out = dec_out.add(raz.multiply(new BigInteger(String.valueOf((int) Math.pow(target_base, i)))));
            i++;
        }
        return dec_out.toString();
    }

    public static String InputStr() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }


}


