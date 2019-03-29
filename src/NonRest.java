import java.util.Iterator;

public class NonRest {

     private String divisor;
     private String dividend;

     private int[] M;
     private int[] Mcompl;
     private int[] A;
     private int[] Q;

     public NonRest(String divisor, String dividend) {

         String[] split = dividend.split("");
         int length = split.length;
         int[] binary = new int[length];

         for(int i = 0; i < length; i++) {
             binary[i] = Integer.parseInt(split[i]);
         }

         this.Q = binary;

         this.A = new int[length+1];
         this.M = new int[length+1];
         for (int i = 0; i < length+1; i++) {
             this.A[i] = 0;
             this.M[i] = 0;
         }
        split = divisor.split("");
         length = split.length;
         int mlenght = this.M.length;
         int temp = length;

         for(int i = 0; i < temp; i++) {
             this.M[mlenght-1] = Integer.parseInt(split[length-1]);
             mlenght--;
             length--;
         }

     }

    public int[] getM() {
        return M;
    }

    public int[] getMcompl() {
        return Mcompl;
    }

    public int[] getA() {
        return A;
    }

    public int[] getQ() {
        return Q;
    }
}
