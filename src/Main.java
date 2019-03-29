import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NonRest start = new NonRest("1110101", "1010001");

        System.out.println(Arrays.toString(start.getQ()));
        System.out.println(Arrays.toString(start.getA()));
        System.out.println(Arrays.toString(start.getM()));
        System.out.println(Arrays.toString(start.getMc()));
    }
}
