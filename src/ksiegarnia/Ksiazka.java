package ksiegarnia;

/**
 * Created by Adam on 17.12.2016.
 */
public class Ksiazka {
    public int id;
    public String isbn,title,author;
    public boolean access;



    public Ksiazka(int id,String isbn, String title, String author, boolean access) {
        this.id=id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.access = access;
//        this.id++;
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
