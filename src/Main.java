import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NonRest start = new NonRest("101", "10101");

        System.out.println(Arrays.toString(start.getQ()));
        System.out.println(Arrays.toString(start.getA()));
        System.out.println(Arrays.toString(start.getM()));
        System.out.println(Arrays.toString(start.getMc()));
        start.compute(start.getA(), start.getQ());
    }
}
