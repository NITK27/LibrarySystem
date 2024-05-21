

public class Comic extends Book{
    

    public Comic(String name, String Id, int quantity) {
        super(name, Id, quantity);
        
        
    }
    public boolean ValidateBorrow(Reader reader) {
        return true;
    }



    
}
