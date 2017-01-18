package bookstore;

public class Book {
    public int id;
    public String isbn,title,author;
    public boolean access;

    public Book(int id,String isbn, String title, String author, boolean access) {
        this.id=id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.access = access;
    }

    public String getISBN(){
        return this.isbn;
    }
    public String getTitle(){
        return this.title;
    }
    public String getAuthor(){
        return this.author;
    }

    public void changeAccess(boolean status){
        this.access=status;
    }
    public int getId(){
        return this.id;
    }
}
