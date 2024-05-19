import java.util.Scanner;

public class App {
      
    public static Scanner vce = new Scanner(System.in);
    
    public static Library objLibrary = new Library();

    public static void main(String[] args) {
        
        String response="y".toLowerCase();
            do{
                Reader reader = null;
                do{
                    System.out.println("Enter Login Id:");
                    int readerId = vce.nextInt();
    
                    System.out.println("Enter Password:");
                    String Password = vce.next();
                    reader = objLibrary.Login(readerId,Password);
    

                } while (reader == null);

               
            String output="y".toLowerCase();

            do{
                
            objLibrary.DoTransaction(reader);
            System.out.println("Make another transaction? (y) "); 
            output = vce.next();

           } while(output.equals("y"));    
           System.out.println("Logout? (y) ");
           response = vce.next();  
        } while (response.equals("y"));
    }
}