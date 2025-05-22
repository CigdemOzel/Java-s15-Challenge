package model;

import java.util.List;

public class Librarian extends Person{

    public Librarian(String name, String id) {
        super(name, id);
    }

    public void addBook(Book book, List<Book> libraryBooks) {
        libraryBooks.add(book);
        System.out.println("Kitap eklendi: " + book.getTitle());
    }

    public void removeBook(Book book, List<Book> libraryBooks) {
        if(libraryBooks.remove(book)) {
            System.out.println("Kitap silindi: " + book.getTitle());
        } else {
            System.out.println("Kitap bulunamadı: " + book.getTitle());
        }
    }

    public void listAllBook(List<Book> libraryBooks) {
        System.out.println("Kütühanedeki tüm kitaplar: ");
        if(libraryBooks.isEmpty()) {
            System.out.println("Kütüphanede kitap bulunmamaktadır.");
        } else {
            for(Book book : libraryBooks) {
                System.out.println(book.getTitle());
            }
        }
    }

    public void updateBook(Book book, String newTitle, Author newAuthor, String newCategory) {
        book.updateBookInfo(newTitle, newAuthor, newCategory);
    }
}
