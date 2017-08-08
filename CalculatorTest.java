/**
 * Created by 1 on 02.08.2017.
 */
import java.util.Scanner;

class Calculator {

    Scanner in = new Scanner(System.in);

    private int n; //number of operands

    private double a[]; //massive of operands

    /*Calculator() {

        n = num;

        a = arr;

    }*/

    //enter number of operands and initialize them
    double[] enterOp() {

        int num;

        double arr[];

        System.out.println("Enter the number of operands");
        num = in.nextInt();
        arr = new double[num];
            for (int i=0; i<arr.length; i++) {
                System.out.println("Enter operand No." + (i+1));
                arr[i] = in.nextDouble();
            }
        return arr;
        }

    //sum of operands
    double add(double arr[]) {

        double result = 0;

        for (int i=arr.length-1; i>=0; i--){
            result += arr[i];
        }
        return result;
    }

    //subtraction of operands
    double subtr(double arr[]) {

        double result = arr[0];

        for (int i=1; i<arr.length; i++){
            result -= arr[i];
        }
        return result;
    }

    //chose of operation (plus or minus)
    char choseSign()
    throws java.io.IOException {

        char sel;

        do {
            System.out.println("1. addition");
            System.out.println("2. subtraction");
            System.out.println("Select the item");
            sel = (char) System.in.read();
        } while (sel<'1' || sel>'2');
        return sel;
    }

    //start calculator
    void start()
    throws java.io.IOException {

        char choise;

        double res;

        double arr[] = this.enterOp();

        choise = this.choseSign();
        if (choise=='1') {
            res = add(arr);
            System.out.println("Result: " + res);
        } else
        {
            res = subtr(arr);
            System.out.println("Result: " + res);
        }
    }

}

class CalculatorTest {
    public static void main(String args[])
        throws java.io.IOException {
        Calculator ob = new Calculator();
        ob.start();
    }
}
