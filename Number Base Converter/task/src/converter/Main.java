package converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {


        System.out.println("Enter number in decimal system:");
        int decimal_input = Integer.parseInt(InputStr());
        System.out.println("Enter target base:");
        int target_sys_input = Integer.parseInt(InputStr());
        //System.out.println(decimal_input + " -> " + target_sys_input);
        System.out.println("Conversion result:");

    }

    public static String InputStr() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }
}
