import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Driver driver = new Driver();
        // Takes input details from user like no.of companies, stock value and its status
        driver.takeInput();
        //it shows menu to user and performs required functionality
        driver.action();
    }
}
