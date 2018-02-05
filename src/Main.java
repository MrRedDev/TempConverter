public class Main {

    private static double fahrenheit;
    private static double celsius;

    public static void main(String[] args) {
        celsius = 0;

        // Check to see if any arguments have been passed
        if(args.length == 0) {
            System.out.println("Please provide at least 1 arguement for this application to work");
        } else if (args.length > 10) {    // Check that fewer than 10 arguments have been passed.
            System.out.println("Too many arguments passed. Please provide between 1 and 10 arguments");
        } else {
            try {
                for (int i = 0; i < args.length; i++){
                    double fahrenheit = Double.parseDouble(args[i]);
                    convertFahrenheitToCelsius(fahrenheit);
                    System.out.println(fahrenheit + " degrees Fahrenheit equals " + celsius + " degrees Celsius.");
                }

            } catch (NumberFormatException nfe) {
                System.out.println("You must provide a number.");
            }
        }

    }

    private static void convertFahrenheitToCelsius(double fahrenheit) {
        celsius = ((fahrenheit -32) / 1.8);
    }
}
