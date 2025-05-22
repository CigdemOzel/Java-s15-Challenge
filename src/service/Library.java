package service;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Reader> readers;

    public Library() {
        this.books = new ArrayList<>();
        this.readers = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Kitap kütüphaneye eklendi: " + book.getTitle());
    }

    public void addReader(Reader reader) {
        readers.add(reader);
        System.out.println("Yeni kullanıcı eklendi: " + reader.getName());
    }

    public Book findBookById(String id) {
        for(Book book : books) {
            if(book.getBookId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for(Book book : books) {
            if(book.getAuthor().getName().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return result;
    }

    public List<Book> findBooksByCategory(String category) {
        List<Book> result = new ArrayList<>();
        for(Book book : books) {
            if(book.getCategory().equalsIgnoreCase(category)) {
                result.add(book);
            }
        }
        return result;
    }

    public void listAllReaders() {
        System.out.println("Kayıtlı kullanıcılar: ");
        for(Reader reader : readers) {
            System.out.println(reader.getName());
        }
    }

    public void listAllBooks() {
        System.out.println("Kütühanedeki kitaplar: ");
        if(books.isEmpty()) {
            System.out.println("Henüz kitap eklenmemiş.");
        } else {
            for(Book book : books) {
                System.out.println(book);
            }
        }
    }


}
