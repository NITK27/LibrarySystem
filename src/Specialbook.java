public class Specialbook extends Book {

    public Specialbook(String name, String Id, int quantity) {
        super(name, Id, quantity);
        
    }

    public boolean ValidateBorrow(Reader reader) {
        if (reader.ValidateReader()== 2) {
            return true;
            
        }
        else {
            System.out.println("you are not a VIP customer, hence you can't borrow this book");
            return false;
        }
    }
        
}
