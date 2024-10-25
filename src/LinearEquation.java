public class LinearEquation {
    //instance var
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int rise;
    private int run;
    private double slope;


    //constructor
    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }


    //methods
    public double distance() {
        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return roundedToHundredth(d);
    }


    public double yIntercept() {
        double yInt = y1 - slope * x1;
        return roundedToHundredth(yInt);
    }


    public double slope() {
        if (y1 == y2) {
            return 0;
        }
        rise = y2 - y1;
        run = x2 - x1;
        slope = (double) rise/run;
        return roundedToHundredth(slope);
    }


    public String equation() {
        String str = "";
        if (slope() != 0) {
            //is a whole number
            if (rise % run == 0) {
                if (rise / run == 1) { // slope = 1
                    str+= "y = x";
                } else if (rise / run == -1) { //slope = -1
                    str += "y = -x";
                } else if (rise / run < 0) { //slope is negative
                    str += "y = -" + Math.abs(rise/run) + "x";
                } else {
                    str += "y = " + (rise/run) + "x"; //slope is positive
                }
            } else {
                //isn't a whole number
                if ((double) rise / run < 0) { //slope is negative
                    str += "y = -" + Math.abs(rise) + "/" + Math.abs(run) + "x";
                } else if (rise < 0 && run < 0) { //slope is positive due to double negatives
                    str += "y = " + Math.abs(rise) + "/" + Math.abs(run) + "x";
                } else {
                    str += "y = " + rise + "/" + run + "x"; //slope is positive naturally
                }
            }
        }
        if (yIntercept() != 0) {
            if (yIntercept() < 0) {
                str += " - " + Math.abs(yIntercept());
            } else {
                str += " + " + yIntercept();
            }
        }
        if (str.indexOf("y = ") < 0) {
            return "y = " + y1;
        }
        return str;
    }


    public String coordinateForX(double x) {
        double yCoord = slope() * x + yIntercept();
        return "(" + x + ", " + roundedToHundredth(yCoord) + ")";
    }


    public String lineInfo() {
        String str = "";
        str += "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe y-intercept of this line is: " + yIntercept();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe distance between these points is " + distance();
        return str;
    }


    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100)/ 100.00;
    }
}