public class Specialbook extends Book {

    public Specialbook(String name, String Id, int quantity) {
        super(name, Id, quantity);
        
    }

    public void ValidateBorrow(Reader reader) {
        if (!(reader instanceof VIP)) {
            System.out.println("YOU ARE NOT A VIP, HENCE YOU CAN'T BORROW THIS BOOK");
            throw new IllegalStateException("Non-VIP user attempted to borrow a special book.");
        }
    }
        
}
