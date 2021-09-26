import java.util.Scanner;
import Stockers.*;

public class Driver {
    int noOfCompanies;
    StocksDetails[] stockers;
    // Take input stock values and status from user and stores stock details of all companies in stockers array
    void takeInput(){
        Scanner sc = new Scanner(System.in);    
        System.out.print("Enter number of companies: ");
        noOfCompanies = sc.nextInt();
        stockers = new StocksDetails[noOfCompanies];

        for(int i=0; i<noOfCompanies; i++){
            //create StockDetails object, initialize it with user entered values and then add it to stockers array
            StocksDetails stocker = new StocksDetails();
            
            System.out.print("\nEnter current stock price of the company "+(i+1)+": ");
            stocker.stockValue = sc.nextDouble();
            System.out.print("Whether company's stock price rose today compare to yesterday? (true/false): ");
            stocker.incrementStatus = sc.nextBoolean();

            stockers[i] = stocker;
        }
   //     sc.close();           // It causes java.util.NoSuchElementException
    }
//Show Menu to user and return user choice
    int showMenu(Scanner sc){
        int choice;
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
        System.out.println("Enter the operation that you want to perform:");
        System.out.println("1. Display the companies stock prices in ascending order");
        System.out.println("2. Display the companies stock prices in descending order");
        System.out.println("3. Display the total no of companies for which stock prices rose today");
        System.out.println("4. Display the total no of companies for which stock prices declined today");
        System.out.println("5. Search a specific stock price");
        System.out.println("Press 0 to exit");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
        System.out.print("Enter your choice: ");
        choice = sc.nextInt();
        return (int)choice;
    }
//create menu driven control flow and perform various operations
    void action(){
        int choice;
        double searchValue;
        StockOperations so = new StockOperations();
        Scanner sc = new Scanner(System.in);
        do{
            choice = showMenu(sc);
            switch(choice){
                case 1: so.displayStocksInAscOrder(stockers, noOfCompanies);
                        break;
                case 2: so.displayStocksInDescOrder(stockers, noOfCompanies);
                        break;
                case 3: System.out.println("Total no of companies whose stock price rose today : "+ so.showStockRiseCount(stockers,noOfCompanies));
                        break;
                case 4: System.out.println("Total no of companies whose stock price declined today : "+ so.showStockFallCount(stockers,noOfCompanies));
                        break;
                case 5: System.out.print("Enter stock value to be searched : ");
                        searchValue = sc.nextDouble();
                        if(so.seachStockValue(stockers,noOfCompanies,searchValue))
                            System.out.println("Stock of value "+ searchValue +" is present.");
                        else
                            System.out.println("Stock of value "+ searchValue +" is not found.");
                        break;
                case 0: System.out.println("Exited successfully.");
                        break;
                default: System.out.println("You entered invalid choice!");
            }
        }while(choice != 0);
    }
}
