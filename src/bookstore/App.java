package bookstore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void borrowBook(String id_book,ArrayList<Book> bookstore){
        int id_w=Integer.parseInt(id_book);
        for (Book k:bookstore) {
            if(id_w==k.id){
                k.changeAccess(false);
                System.out.println("Borrow: " +k.getTitle());
                break;
            }
        }
    }

    public static void offset() {
        for (int i=0;i<=50;i++){
            System.out.println(".");
        }
    }
    public static void AddNewBook(ArrayList<bookstore.Book> tablica){
        Scanner input=new Scanner(System.in);
        String name,title,isbn,author;
        boolean access;
        int id;
        access=true;
        while(true) {
            System.out.println("ID:");
            id=input.nextInt();
            System.out.println("ISBN:");
            isbn=input.nextLine();
            System.out.println("Title:");
            title=input.nextLine();
            System.out.println("Author");
            author=input.nextLine();
            if(!isbn.equals("S") || !title.equals("S") || !author.equals("S") || !isbn.equals("S") ){
                tablica.add(new Book(id,isbn,title,author,access));
                System.out.println("Added. Type 'S' to stop.");
            }
            else{
                break;
            }
        }
    }

    public static void ShowAllBook(ArrayList<Book> tablica,String moder){
        int j=1;
        if(moder.equals("admin")){
            for (Book i: tablica ) {
                System.out.println(j+"  "+i.title);
                j++;
            }
        }
        else{
            for (Book i: tablica ) {
                if(i.access==true){
                    System.out.println(j+"  "+i.title+"  id: "+i.getId());
                }
                j++;
            }
        }
    }

    public static int yourChoice(String wybor){
        while(!wybor.equals("stop")){
            switch(wybor){
                case "1": System.out.println("");break;
                default: System.out.println("Nieznane polecenie");
            }
        }
        return 0;
    }


    public static void main(String[] args) throws IOException {
        Scanner input=new Scanner(System.in);
        ArrayList<Book> booksArray = new ArrayList<Book>();
        ArrayList<User> usersArray = new ArrayList<User>();
        booksArray.add(new Book(1,"123654asf","ksiazka1","ziom1",true));
        booksArray.add(new Book(2,"123654asfasfasf","ksiazka2","ziom2",true));
        usersArray.add(new User("ziomek1","ziomek1"));
        usersArray.add(new User("ziomek2","ziomek2"));
        String texter,psswd,lgn;
        System.out.println("--------------- Zaloguj się ---------------");
        System.out.println("login : ");
        lgn=input.nextLine();
        System.out.println("hasło : ");
        psswd=input.nextLine();
        if(psswd.equals("admin") && lgn.equals("admin")){
            System.out.println("zalogowano jako ADMIN ");
            System.out.println("Co chcesz zrobić ?");
            System.out.println("1. Dodaj nową Książkę | 2. Wylistuj Wsiążki | 3. Sprawdź ilość użytkowników | 4. " + "Zakończ");
            texter=input.nextLine();
            while(!texter.equals("4")){
                switch (texter){
                    case "1": AddNewBook(booksArray);break;
                    case "2": ShowAllBook(booksArray,psswd);break;
                }
                System.out.println("Co chcesz teraz zrobić ?");
                System.out.println("1. Dodaj nową Książkę | 2. Wylistuj Wsiążki | 3. Sprawdź ilość użytkowników | 4. " + "Zakończ");
                texter=input.nextLine();
            }
        }
        else{
            User momentUser=new User(lgn,psswd);
            offset();
            System.out.println("zalogowano jako użytkownik: "+lgn);
            System.out.println("Co chcesz zrobić ?");
            System.out.println("1. Pożycz książkę | 2. Wylistuj dostępne ksiązki | 3. zasil portfel | 4. piniondz w " +
                    "portfelu" +" 5. Zakończ");
            texter=input.nextLine();
            while(!texter.equals("5")) {
                switch (texter){
                    case "1":
                        System.out.println("Wpisz ID danej książki");
                        texter=input.nextLine();
                        borrowBook(texter,booksArray);break;
                    case "2": ShowAllBook(booksArray,psswd);break;
                    case  "3":
                        System.out.println("jaka Kwota  ?");
                        texter=input.nextLine();

                        momentUser.upgradeWallet(texter);break;
                    case "4": System.out.println("Na koncie masz : "+momentUser.getMoney()); break;
                }
                System.out.println("Co chcesz teraz zrobić ?");
                System.out.println("1. Pożycz książkę | 2. Wylistuj dostępne ksiązki | 3. zasil portfel | 4. piniondz w " +
                        "portfelu" +" 5. Zakończ");
                texter=input.nextLine();
            }
        }
    }
}
