import java.util.Scanner;

class Calculator {

    Scanner in = new Scanner(System.in);

    private int n; //number of operands

    private double a[]; //massive of operands

    private char sel; //operation (plus or minus/'1' or '2')

    private double result;

    /*//Overloading constructors
    Calculator(int num, int arr[]) {

        n = num;

        int a[] = arr;

    }

    Calculator(int num, double arr[]) {

        n = num;

       double a[] = arr;

    }*/

    //enter number of operands and initialize them
    double[] enterOp() {
        System.out.println("Enter the number of operands");
        n = in.nextInt();
        a = new double[n];
            for (int i=0; i<a.length; i++) {
                System.out.println("Enter operand No." + (i+1));
                a[i] = in.nextDouble();
            }
        return a;
        }

    //sum of operands
    private double add() {
        result = 0;
        for (int i=a.length-1; i>=0; i--){
            result += a[i];
        }
        return result;
    }

    //subtraction of operands
    private double subtr() {
        result = a[0];
        for (int i=1; i<a.length; i++){
            result -= a[i];
        }
        return result;
    }

    //chose of operation (plus or minus)
    private char choseSign()
    throws java.io.IOException {
        do {
            System.out.println("1. addition");
            System.out.println("2. subtraction");
            System.out.println("Select the item");
            sel = (char) System.in.read();
        } while (sel<'1' || sel>'2');
        return sel;
    }

    //start calculator
    public void start()
    throws java.io.IOException {
        a = enterOp();
        sel = choseSign();
        if (sel=='1') {
            result = add();
            System.out.println("Result: " + result);
        } else
        {
            result = subtr();
            System.out.println("Result: " + result);
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
