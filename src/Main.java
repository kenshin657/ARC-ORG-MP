import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String multiplier = "101010101";
        String[] split = multiplier.split("");

        int length = split.length;

        int [] binary = new int[length];

        for(int i = 0; i < length; i++) {
            binary[i] = Integer.parseInt(split[i]);
        }

        System.out.println(Arrays.toString(binary));
    }
}
