import java.util.* ;

     public class Library {
    
    
    public ArrayList<Reader> Readers = new ArrayList<Reader>(); 
    public ArrayList<Book> AvailableBooks = new ArrayList<Book>();
   
    public Scanner vce = new Scanner(System.in);
      
    public Library(){
        this.LoadBooks();
        this.LoadReaders(); 
    }

    public  void PrintAvailableBooks(){
        System.out.println("----------  Available Books -------------");
        for (Book  book : this.AvailableBooks) {
            System.out.println(book.name +" , quantity : "+ book.quantity );
        }
        System.out.println("---------- --------------------------------");

               
    }

    public  void DisplayReaders(){
        System.out.println("----------  Available Readers -------------");
        for (Reader  reader : Readers) {
            System.out.println(reader.ReaderName +" has borrowed :"+ reader.getBorrowedBooks() );
        }
        System.out.println("---------- --------------------------------");
    }

    public Book GetBookById(String bookId){
        for (Book book : AvailableBooks) {
            if (book.Id.equals(bookId))
            return book;
        }

        return null;
    }

    public Reader GetReaderById(int readerId){
        for (Reader reader : Readers) {
            if (reader.Id == readerId)
            return reader;
        }
        return null;
    }

    public  void LoadBooks() {        

        AvailableBooks.add(new Book("Harry Potter ", "HP1", 2));
        AvailableBooks.add(new Book("Game of Thrones ", "GOT1", 1));
        AvailableBooks.add(new Book("LOTR ", "LOTR1", 1));
        AvailableBooks.add(new Book("Percy Jackson ", "PJ1", 2));
        AvailableBooks.add(new Specialbook("Atomic Habits", "AH1", 2));
    }

    public  void LoadReaders(){
        

        Readers.add(new Reader(6,"Vishu","v"));
        Readers.add(new Reader(27,"krish","k"));
        Readers.add(new VIP(18991,"Dad","d"));
        Readers.add(new Reader(4,"Mom","m"));
        
    }


    public  void borrowBook(Reader reader , Book book){

        try {
            book.ValidateBorrow(reader); 
        } catch (IllegalStateException e) {
            return; 
        }
        
        if (book.quantity==0) {
            System.out.println("book is not available"); 
            return;
        }
        else{
            
            if (reader.BorrowedBooks.contains(book)) {
                System.out.println(" You cannot borrow more than one book of the same type");
                return;
            } 
            else{book.quantity = book.quantity - 1;
                reader.BorrowedBooks.add(book);
                System.out.println(reader.ReaderName + " has borrowed the book: " + book.name);
        }
        }
    
        PrintAvailableBooks();
        DisplayReaders();
    }
          

    public void returnBook(Reader reader, Book book){

        book.quantity = book.quantity + 1;
        reader.BorrowedBooks.remove(book);
        System.out.println(reader.ReaderName + " has returned the book: " + book.name);

        PrintAvailableBooks();
        DisplayReaders();
     
    }


    public  void DoTransaction(Reader reader){

    System.out.println("Enter Book Id:");
    
    String BookId = vce.next();
    // Get/Convert Book 
    Book objBook = GetBookById(BookId);

    

     System.out.println("Do you want to borrow book or return book?");
     String choice = vce.next().toLowerCase();

     if(choice.equals("b") ){
        
           borrowBook(reader,objBook);}
     else {
         if (reader.BorrowedBooks.contains(objBook)) {
             returnBook(reader,objBook);
        
         }
         else{System.out.println("-------Invalid request:Please Borrow the given book before returning it-------");
     }
         return ;
     }
    }


    public Reader Login(int ReaderId, String password){
        //Library  objLibrary = new Library();
    
    Reader objReader = GetReaderById(ReaderId);
    if (objReader.Password.equals(password)) {
        System.out.println("Login Successful");
        return objReader;
           
    }
    else{
        System.out.println("Wrong Password, try again");
        return null;
        
    }   

 }
}


