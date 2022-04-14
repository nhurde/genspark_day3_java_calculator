import java.util.Scanner;

public class GenSpark_Week1_Project
{
        public static void main(String[] args)
        {
            String lineInput = "";
            String operationInput = "";
            String operationNumber2 = "";
            double number1 = 0.0d, number2 = 0.0d, result = 0.0d, pastResult = 0.0d;
            boolean operationExitRequested = false;
            boolean number1InputFound = false, number2InputFound = false, operationInputFound = false;
            boolean validCalculationMade = false;

            Scanner inputObj = new Scanner(System.in);

            while( !operationExitRequested  )
            {
                //Resets variables for calculator
                number1InputFound = false;
                number2InputFound = false;
                operationInputFound = false;
                validCalculationMade = false;

                System.out.println("~ Super Console Calculator by Nathan Hurde ~");
                System.out.println("\n  Current Value (" + pastResult + ")");

                System.out.println(" Please enter an number( To use current value type 'M' ) or type esc,end or exit :");

                lineInput = inputObj.nextLine();

                if (lineInput.equalsIgnoreCase("end") || lineInput.equalsIgnoreCase("esc") || lineInput.equalsIgnoreCase("exit")) {
                    operationExitRequested = true;
                }

                if (lineInput.equalsIgnoreCase("escape") || lineInput.equalsIgnoreCase("quit")) {
                    operationExitRequested = true;
                }
                else
                {
                    if (lineInput.equalsIgnoreCase("m"))
                    {
                        number1 = pastResult;
                        number1InputFound = true;
                    }
                    else
                    {
                        try
                        {
                            number1 = Double.valueOf(lineInput);
                            number1InputFound = true;
                        }
                        catch (NumberFormatException ex)
                        {
                            System.out.println("Error!, invalid input, let's try again! \n \n \n \n \n \n");
                        }
                    }
                }

                if (number1InputFound)
                {
                    System.out.println("(" + number1 + ")");

                    System.out.println("Operation? ( +,-,*,/,%,^) :");

                    operationInput = inputObj.nextLine();

                    System.out.println("(" + number1 + " " + operationInput + ")");

                    if ( operationInput.equals("+") || operationInput.equals("-")  ||  operationInput.equals("*") ||  operationInput.equals("/") )
                    {
                        operationInputFound = true;
                    }
                    else if ( operationInput.equals("%") ||  operationInput.equals("^") )
                    {
                        operationInputFound = true;
                    }
                    else
                    {
                        System.out.println("Error!, invalid input, unknown math operator entered("+ operationInput +")! \n \n \n");
                    }

                    if( number1InputFound && operationInputFound )
                    {
                        System.out.println("Please enter 2nd number of equation :");
                        operationNumber2 = inputObj.nextLine();
                        try {
                            number2 = Double.valueOf(operationNumber2);
                            number2InputFound = true;
                        } catch (NumberFormatException ex) {
                            System.out.println("Error!, invalid input(" + operationNumber2 + "), let's try again! \n \n \n \n \n \n");
                            number2InputFound = false;
                        }
                    }

                    if (number1InputFound && number2InputFound && operationInputFound)
                    {
                        System.out.println("(" + number1 + " " + operationInput + " " + number2 + ")");

                        validCalculationMade = false;
                        if (operationInput.equals("+")) {
                            result = number1 + number2;
                            validCalculationMade = true;
                        }
                        else if (operationInput.equals("-")) {
                            result = number1 - number2;
                            validCalculationMade = true;
                        }
                        else if (operationInput.equals("*")) {
                            result = number1 * number2;
                            validCalculationMade = true;
                        }
                        else if (operationInput.equals("^")) {
                            result = Math.pow(number1, number2);
                            validCalculationMade = true;
                        } else if (operationInput.equals("/")) {
                            if (number2 == 0) {
                                System.out.println("Error!, invalid input, It is IMPOSSIBLE for humans to divide by 0! \n \n \n");
                            } else {
                                result = number1 / number2;
                                validCalculationMade = true;
                            }
                        } else if (operationInput.equals("%")) {
                            if (number2 == 0) {
                                System.out.println("Error!, invalid input, It is IMPOSSIBLE for humans to divide by 0! \n \n \n");
                            } else {
                                result = number1 % number2;
                                validCalculationMade = true;
                            }
                        }
                        else
                        {
                            System.out.println("Error!, invalid input, unknown math operator entered("+ operationInput +")! \n \n \n");
                        }
                        if (validCalculationMade)
                        {
                            System.out.println("\n(" + number1 + " " + operationInput + " " + number2 + ") EQUALS " + result + "\n \n " );
                            pastResult = result;
                        }
                        else
                        {
                            System.out.println("Error!, invalid input, let's try again! \n \n \n");
                        }
                    }
                }
            }
            System.out.println("Exiting now via "+lineInput + "command...");
        }
}
