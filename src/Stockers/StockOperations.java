package Stockers;
import java.util.Arrays;
//This class provides functionality for all the operations on StockDetails
public class StockOperations {
    double[] stockValues;
    private boolean isSorted;       // represents wether stockValues array is sorted

    public StockOperations(){
        this.isSorted = false;
    }
//Displays stock values in ascending order    
    public void displayStocksInAscOrder(StocksDetails[] stockers, int noOfCompanies){
        if(this.isSorted != true){
            stockValues = new double[noOfCompanies];
            for(int i=0; i<noOfCompanies ; ++i)
                stockValues[i] = (stockers[i]).stockValue;
            //sort this array in ascending order
            Arrays.sort(stockValues);
            this.isSorted = true;
        }
        System.out.println("Stock values in ascending order are: ");
        for(int i=0; i<noOfCompanies ; ++i)
            System.out.print(stockValues[i]+" ");
    
    }
//Displays stock values in descending order
    public void displayStocksInDescOrder(StocksDetails[] stockers, int noOfCompanies){
        if(this.isSorted != true){
            stockValues = new double[noOfCompanies];
            for(int i=0; i<noOfCompanies ; ++i)
                stockValues[i] = (stockers[i]).stockValue;
            //sort this array in ascending order
            Arrays.sort(stockValues);
            this.isSorted = true;
        }
        System.out.println("Stock values in descending order are: ");
        for(int i=noOfCompanies-1; i>-1 ; --i)
            System.out.print(stockValues[i]+" ");
    }
//returns count of stocks whoes values are rised
    public int showStockRiseCount(StocksDetails[] stockers, int noOfCompanies){
        int count = 0;
        for(int i=0; i<noOfCompanies ; ++i){
            if( (stockers[i]).incrementStatus == true)
                count++;
        }
        return count;
    }
//returns count of stocks whoes values are fall or decreased
    public int showStockFallCount(StocksDetails[] stockers, int noOfCompanies){
        int count = 0;
        for(int i=0; i<noOfCompanies ; ++i){
            if( (stockers[i]).incrementStatus == false)
                count++;
        }
        return count;
    }
//returns true if stocks to be searched if found else returns false
    public boolean seachStockValue(StocksDetails[] stockers, int noOfCompanies,double searchValue){
        for(int i=0; i<noOfCompanies ; ++i){
            if( (stockers[i]).stockValue == searchValue)
                return true;
        }
        return false;
    }
}
