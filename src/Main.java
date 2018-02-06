public class Main {

    private static double celsius;

    public static void main(String[] args) {
        double fahrenheit;
        celsius = 0;

        // Check to see if any arguments have been passed

        if(args.length == 0) {
            System.out.println("Error, no arguments provided. Please provide either 1 or 3 arguments.");
            converterInstructions();
        } else if (args.length == 1) {
            fahrenheit = parser(args[0]);
            convertFahrenheitToCelsius(fahrenheit);
            printToScreen(celsius, fahrenheit);
        } else if (args.length == 2) {
            System.out.println("Error, 2 arguments provided. Please provide either 1 or 3 arguments.");
            converterInstructions();
        } else if (args.length == 3){
            double start = parser(args[0]);
            double finish = parser(args[1]);
            double step = parser(args[2]);
            printTableOfTemperatureConversions(step, start, finish);
        } else {
            System.out.println("Error, too many arguments provided.");
            converterInstructions();
        }
    }

    // args parse string to double
    private static double parser(String args) {
        try {
            return Double.parseDouble(args);
        } catch (NumberFormatException nfe) {
            System.out.println("You must provide a number.");
            converterInstructions();
            System.exit(0); // exit program if number not found
            return 0;
        }
    }

    // Convert a single temperature from Fahrenheit to Celsius
    private static void convertFahrenheitToCelsius(double fahrenheit) {
        celsius = ((fahrenheit -32) / 1.8);
    }

    /*
    * Takes 3 arguments, step change, starting and finish point.
    * Prints to screen the temperature conversions incremented by the step value between the start and finish points
     */
    private static void printTableOfTemperatureConversions(double step, double start, double finish){
        if (start < finish) {
            System.out.println("Fahrenheit conversions starting from " + start + " finishing at " + finish + ", " +
                    "incrementing by " + step);
            while (start <= finish) {
                convertFahrenheitToCelsius(start);
                printToScreen(celsius, start);
                start = start + step;
            }
        } else {
            System.out.println("Fahrenheit conversions starting from " + start + " finishing at " + finish + ", " +
                    "decreasing by " + step);
            while (start >= finish) {
                convertFahrenheitToCelsius(start);
                printToScreen(celsius, start);
                start = start - step;
            }
        }
    }

    // Print conversion to screen
    private static void printToScreen(double celsius, double fahrenheit) {
        System.out.println(fahrenheit + " degrees Fahrenheit equals " + celsius + " degrees Celsius.");
    }

    // Print converter instructions
    private static void converterInstructions() {
        System.out.println("Provide 1 argument, to convert 1 temperature from fahrenheit to celsius.");
        System.out.println("Provide 3 arguments to convert a range of temperatures, in the following format;");
        System.out.println("Starting temperature, finish temperature and incremental amount.");
    }

}
