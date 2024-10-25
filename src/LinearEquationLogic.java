import java.util.Scanner;


public class LinearEquationLogic {
    //instance var
    private int xCoordinate;
    private int yCoordinate;
    private int xCoordinate2;
    private int yCoordinate2;
    private Scanner scan;
    private Boolean quit;
    private LinearEquation obj;


    //constructor
    public LinearEquationLogic() {
        scan = new Scanner(System.in);
        quit = false;
    }


    //main
    public void start() {
        System.out.println("Welcome to the linear equation calculator!");
        while (!quit) {
            getData();
            obj = new LinearEquation(xCoordinate, yCoordinate, xCoordinate2, yCoordinate2);
            System.out.println();


            if (xCoordinate != xCoordinate2) {
                System.out.println(obj.lineInfo());
                System.out.println();
                getXPoint();
            } else {
                System.out.println("These points are on a vertical line: x = " + xCoordinate);
            }
            System.out.println();
            System.out.print("Would you like to enter another pair of coordinates? y/n: ");
            String choice = scan.nextLine();
            if (choice.equals("n")) {
                quit = true;
            }
        }
        System.out.println("Thank you for using the slope calculator, goodbye!");
    }


    //helper
    private void getData() {
        System.out.print("Enter coordinate 1: ");
        String coordinate1 = scan.nextLine();
        int idx = coordinate1.indexOf(",");
        xCoordinate = Integer.parseInt(coordinate1.substring(1, idx));
        yCoordinate = Integer.parseInt(coordinate1.substring(idx+2, coordinate1.length()-1));


        System.out.print("Enter coordinate 2: ");
        String coordinate2 = scan.nextLine();
        int idx2 = coordinate2.indexOf(",");
        xCoordinate2 = Integer.parseInt(coordinate2.substring(1, idx2));
        yCoordinate2 = Integer.parseInt(coordinate2.substring(idx2+2, coordinate2.length()-1));
    }


    private void getXPoint() {
        System.out.print("Enter a value for x: ");
        double xVal = scan.nextDouble();
        scan.nextLine();
        System.out.println();
        System.out.println("The point on the line is " + obj.coordinateForX(xVal));
    }
}