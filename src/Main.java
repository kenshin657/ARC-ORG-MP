import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NonRest start = new NonRest("10", "101");

        //for testing
        /*
        System.out.println(Arrays.toString(start.getQ()));
        System.out.println(Arrays.toString(start.getA()));
        System.out.println(Arrays.toString(start.getM()));
        System.out.println(Arrays.toString(start.getMc()));
        start.compute(start.getA(), start.getQ());
        System.out.println(Arrays.toString(start.getA()));
        System.out.println(Arrays.toString(start.getQ())); */

        int length = start.getQ().length;

        for (int i = 0; i < length; i++) {
            start.compute(start.getA(), start.getQ());
        }

        System.out.println("\n\nStart of Arrayist");
        /*for (int i = 0; i < start.getAqArrayList().size(); i++) {
            System.out.println((i+1) + " iteration");
            System.out.println(Arrays.toString(start.getAqArrayList().get(i).getA()));
            System.out.println(Arrays.toString(start.getAqArrayList().get(i).getQ()));
            System.out.println("\n");
        }*/

        start.printArrayList();

        //System.out.println(Arrays.toString(start.getA()));
        //System.out.println(Arrays.toString(start.getQ()));
    }
}
