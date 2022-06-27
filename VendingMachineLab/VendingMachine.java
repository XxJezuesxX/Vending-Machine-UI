import java.util.Scanner;

public class VendingMachine
{
    public static final Scanner sc = new Scanner(System.in);
    static double totalAmt; 
    static double change;
    static String food = null;
    static int stockPC = 1;
    static int stockCo = 2;
    static int stockCa = 2;
    static int restartInput;
    static String input;
    static int quarter;
    static int dimes;
    static int nickels;
    static int cents;
    
    public static void Transaction(String input)
    {
        
        System.out.println("Main menu -  \n "); 
        System.out.println("a -   Potato Chips   -     $1.25   -  "+ stockPC + " (in stock)");
        System.out.println("b -   Cookies        -     $0.85");
        System.out.println("c -   Candies        -     $0.95");
        System.out.println("d -   Terminate Process");
        
        input= sc.next();
         
        if(input.equals("a"))
        {
            if(stockPC > 0)
            {
                if(totalAmt >= 1.25)
                {
                    food = "Potato Chips";
                    System.out.println("Here's your " + food + "\n");
                    change = totalAmt - 1.25;
                    totalAmt = totalAmt - 1.25;
                    stockPC = stockPC -1;
                    System.out.println("Current Balance - $" + change + "\n");
                    restart();
                    
                }
                else if (totalAmt < 1.25)
                {
                    System.out.println("Not enough money.");
                    change=totalAmt;
                    restart();
                    
                }
            }else if(stockPC == 0)
            {
                System.out.println("Sold out. Please make another choice");
                Transaction(input);
            }   
        }else if (input.equals("b"))
        {
            if(stockCo > 0)
            {
                if(totalAmt >= 0.85)
                {
                    food = "Cookies";
                    System.out.println("Here's your " + food + "\n");
                    change = totalAmt - 0.85;
                    totalAmt = totalAmt = totalAmt - 0.85;
                    stockCo = stockCo -1;
                    System.out.println("Current Balance - $" + change + "\n");
                    restart();
                }
                else if (totalAmt < 0.85)
                {
                    System.out.println("Not enough money.");
                    change=totalAmt;
                    restart();
                }
            }
            else if(stockCo == 0)
            {
                change = totalAmt;
                System.out.println("Sold out. Please make another choice");
                Transaction(input);
            }
        }else if (input.equals("c"))
        {
         if(stockCa == 0)
            {   
                if (totalAmt < 0.95)
                {
                    System.out.println("Not enough money ");
                    change=totalAmt;
                    Transaction(input);
                }
                System.out.println("Sold out. Please make another choice");
                Transaction(input);
            }else if(stockCa > 0)
            {
                if(totalAmt >= 0.95)
                {
                    food = "Candies";
                    System.out.println("Here's your " + food + "\n");
                    change = totalAmt - 0.95;
                    totalAmt = totalAmt = totalAmt - 0.95;
                    stockCa = stockCa - 1; 
                    System.out.println("Current Balance - $" + change + "\n");
                    restart();
                }
                else if (totalAmt < 0.95)
                {
                    System.out.println("Not enough money.");
                    change=totalAmt;
                    restart();
                }
            }
        }else if(input.equals("d"))
        {
            restart();
            change=totalAmt;
        }else 
        {
             change=totalAmt;
             System.out.println("Please select choice between a-d \n");
             Transaction(input);
        }
    }    
    public static void changeCalculator(){
        
        change = change * 100;
        int changeInt = (int) change;
        quarter = changeInt/25; 
        int remainingAmt = changeInt%25; 
        dimes = remainingAmt/10; 
        remainingAmt = remainingAmt%10;
        nickels = remainingAmt/5;
        remainingAmt = remainingAmt%5;
        cents = remainingAmt;
        
    }
    public static void restart()
    {   
        System.out.println("1 - End");
        System.out.println("2 - Buy again");
        restartInput = sc.nextInt();
        sc.useDelimiter("\\R");
        if(restartInput==2)
        {
            Transaction(input);
        }else if (restartInput > 2 || restartInput <= 0)
        { 
            System.out.println("Please select between 1 or 2");
            restart();
        }
    }
    public static void main(String[] args)
    {
        System.out.println("Hi! Welcome to De Anza Vending Machine!");
         
        
        System.out.println("How many quarters do you have?");
        double noOfQt = sc.nextDouble();
        totalAmt = noOfQt * 0.25;
         
        System.out.println("How many dimes do you have?");
        double noOfDm = sc.nextDouble();
        totalAmt = totalAmt + (noOfDm * 0.1);
         
        System.out.println("How many nickels do you have?");
        double noOfNk = sc.nextDouble();
        totalAmt = totalAmt + (noOfNk * 0.05);
         
        System.out.println("You have = $" + totalAmt +"\n");
        
        
         
        Transaction(input);
        
        
        
        System.out.println("Here is your change - $" + change);
        changeCalculator();
        System.out.println("(" + quarter + "quarter(s), " + dimes + "dime(s), " + nickels + "nickel(s), and " + cents + "cent(s)" + ")");
        System.out.println("Thank you for coming here:)");
    }
}
    

             
            
         
         
         
        




