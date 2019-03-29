import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NonRest start = new NonRest("101", "10101");

        //for testing
        System.out.println(Arrays.toString(start.getQ()));
        System.out.println(Arrays.toString(start.getA()));
        System.out.println(Arrays.toString(start.getM()));
        System.out.println(Arrays.toString(start.getMc()));
        start.compute(start.getA(), start.getQ());
        System.out.println(Arrays.toString(start.getA()));
        System.out.println(Arrays.toString(start.getQ()));

        System.out.println("Laman ng AQ Array list");
        System.out.println(Arrays.toString(start.getAqArrayList().get(0).getQ()));
        System.out.println(Arrays.toString(start.getAqArrayList().get(0).getA()));
    }
}
