import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {

    Scanner in = new Scanner(System.in);

    private int n; //number of operands

    private float a[]; //massive of operands

    private int sel; //operation (plus or minus/'1' or '2')

    private float result;

    //Overloading constructors
    Calculator()
        throws java.io.IOException {
        try {
            //enter number of operands and initialize them
            System.out.println("Enter the number of operands");
            n = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
            System.out.println("You has a mistake (entering number of operands), please try again");
            createCalc();
        }
        try {
            a = new float[n];
            for (int i = 0; i < a.length; i++) {
                System.out.println("Enter operand No." + (i + 1));
                a[i] = in.nextFloat();
            }
        } catch (InputMismatchException e) {
            System.out.println(e);
            System.out.println("You has a mistake (entering operands), please try again");
            createCalc();
        }
        //chose of operation (plus or minus)
        System.out.println("1. addition");
        System.out.println("2. subtraction");
        System.out.println("Select the item");
        try {
            sel = in.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
            System.out.println("Wrong select of item, please try again");
            createCalc();
        }
    }

    /*Calculator(int num, float arr[]) {

        n = num;

        float a[] = arr;

    }*/

    //sum of operands
    private float add() {
        result = 0;
        for (float i : a){
            result += i;
        }
        return result;
    }

    //subtraction of operands
    private float subtr() {
        result = a[0];
        for (int i=1; i<a.length; i++){
            result -= a[i];
        }
        return result;
    }

    //create object of Calculator
    static void createCalc()
    throws java.io.IOException {
        Calculator ob = new Calculator();
        ob.start();
    }

    //start calculator
    //it may be a static method
    public void start()
    throws java.io.IOException {
        try {
            switch (sel) {
                case 1:
                    result = add();
                    System.out.println("Result: " + result);
                    break;
                case 2:
                    result = subtr();
                    System.out.println("Result: " + result);
                    break;
                default:
                    System.out.println("Wrong select of item, please try again");
                    createCalc();
            }
        } catch (InputMismatchException e) {
            System.out.println(e);
            System.out.println("Wrong select of item, please try again");
            createCalc();
        }

    }
    public static void main(String args[])
        throws java.io.IOException {

        /*
        System.out.println("Enter number of operands")
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        ...
        System.out.println("Enter operands")
        arr[i] = in.nextInt();
        ...
        Calculator ob = new Calculator(num, arr[i])
        */

        Calculator.createCalc();

    }
}