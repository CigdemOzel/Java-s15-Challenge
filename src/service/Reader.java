package service;

import model.Bill;
import model.Book;
import model.Person;

import java.util.*;

public class Reader extends Person {

    private Set<Book> borrowedBooks;
    private static final int MAX_BOOK_LIMIT = 5;
    private Map<Book, Bill> bills;

    public Reader(String name, String id) {
        super(name, id);
        this.borrowedBooks = new HashSet<>();
        this.bills = new HashMap<>();
    }

    public boolean borrowBook(Book book) {
        if (book.isBorrowed()) {
            System.out.println(book.getTitle() + " zaten ödünç alınmış!");
            return false;
        }

        if (borrowedBooks.size() >= MAX_BOOK_LIMIT) {
            System.out.println("Kitap limiti doldu! En fazla 5 kitap alabilirsiniz.");
            return false;
        }

        borrowedBooks.add(book);
        book.borrowBook();
        String billId = UUID.randomUUID().toString();
        Bill bill = new Bill(billId, this, book);
        bills.put(book, bill);

        System.out.println("Kitap ödünç alındı: " + book.getTitle());
        bill.printBill();
        return true;
    }

    public void returnBook(Book book) {
        if(borrowedBooks.contains(book)) {
            borrowedBooks.remove(book);
            book.returnBook();
            Bill bill = bills.get(book);
            if (bill != null && !bill.getAmountIsRefunded()) {
                bill.refund();
            }
            System.out.println("Kitap iade edildi!");
        } else {
            System.out.println("Bu kitap bu kullanıcıya ait değil!");
        }
    }

    public void listBoroowedBooks() {
        if(borrowedBooks.isEmpty()) {
            System.out.println(getName() + " şu anda ödünç aldığı kitap yok.");
        } else {
            System.out.println(getName() + " tarafından ödünç alınan kitaplar: ");
            for(Book book : borrowedBooks) {
                System.out.println("- " + book.getTitle());
            }
        }
    }

    @Override
    public String toString() {
        return "Reader{" +
                "borrowedBooks=" + borrowedBooks +
                '}';
    }
}
