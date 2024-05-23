public class Book {
    public String name;
    public String Id;
    public int quantity;

    public Book(String name, String Id, int quantity) {
        this.name = name;
        this.Id = Id;
        this.quantity = quantity;
    }

   

   public boolean ValidateBorrow(Reader reader){

    if(reader.ValidateReader()== 3){
        System.out.println("this is a child account, parent account authentication is required");
        return false;
    }
   
    else{return true;}
  
}
}



    

