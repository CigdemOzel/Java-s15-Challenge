import model.Author;
import model.Book;
import model.Librarian;
import service.Reader;
import service.Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Author author1 = new Author("Matt Haig");
        Author author2 = new Author("Irvin D. Yalom");
        Reader reader1 = new Reader("Çiğdem", "8");
        Reader reader2 = new Reader("Tahsin", "33");
        List<Book> libraryBooks = new ArrayList<>();
        Librarian librarian = new Librarian("Numan", "17");
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);


        Book book1 = new Book("1", "Gece Yarısı Kütüphanesi", author1, "Fantastik Kurgu");
        Book book2 = new Book("2", "Nietzsche Ağladığında", author2, "Edebi Kurgu");
        Book book3 = new Book("3", "İnsanlar", author1, "Bilim Kurgu");
        Book book4 = new Book("4", "Günübirlik Hayatlar", author2, "Kurgu");
        Book book5 = new Book("5", "Bir Psikiyatristin Anıları", author2, "Biyografi");
        Book book6 = new Book("6", "Hayat İmkansız", author1, "Fantastik Kurgu");


        author1.addBook(book1);
        author2.addBook(book2);
        author1.addBook(book3);

        System.out.println("Kitap Listesi: ");
        System.out.println(book1);
        System.out.println(book2);
        System.out.println(book3);

        System.out.println("Ödünç Testi: ");
        book1.borrowBook();
        book1.borrowBook();

        System.out.println("İade Testi ");
        book1.returnBook();
        book1.returnBook();

        System.out.println("Güncel");
        System.out.println(book1);

        System.out.println("Okuyucu kitap ödünç alıyor.");
        reader1.borrowBook(book1);
        reader1.borrowBook(book2);
        reader1.borrowBook(book3);
        reader1.borrowBook(book4);
        reader1.borrowBook(book5);
        reader1.borrowBook(book6);

        System.out.println("Okuyucu Bilgileri:");
        System.out.println(reader1);

        System.out.println("Kitao iade testi:");
        reader1.returnBook(book1);
        reader1.returnBook(book6);

        System.out.println("Okuyucu kitap ödünç alıyor:");
        reader1.borrowBook(book1);
        reader1.borrowBook(book2);
        reader1.borrowBook(book3);

        System.out.println("Okuyucunun ödünç aldığı kitaplar:");
        reader1.listBoroowedBooks();

        System.out.println("Kitap iade testi");
        reader1.returnBook(book2);

        System.out.println("Güncellenmiş ödünç alınan kitaplar:");
        reader1.listBoroowedBooks();

        librarian.addBook(book1, libraryBooks);
        librarian.addBook(book2, libraryBooks);

        librarian.listAllBook(libraryBooks);

        librarian.removeBook(book2, libraryBooks);
        librarian.removeBook(book2, libraryBooks);

        librarian.listAllBook(libraryBooks);

        library.addReader(reader1);
        library.addReader(reader2);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);
        library.addBook(book6);

        System.out.println("ID'ye göre kitap arama:");
        Book found = library.findBookById("2");
        System.out.println(found != null ? found : "Kitap bulunamadı!");

        System.out.println("Matt Haig kitapları:");
        List<Book> haigBooks = library.findBooksByAuthor("Matt Haig");
        haigBooks.forEach(book -> System.out.println(book.getTitle()));

        System.out.println("Fantastik Kurgu kategorisindeki kitaplar:");
        List<Book> fantasyBooks = library.findBooksByCategory("Fantastik Kurgu");
        fantasyBooks.forEach(book -> System.out.println(book.getTitle()));

        library.listAllReaders();
        library.listAllBooks();

        System.out.println("Kitap Ödünç Alma İşlemi:");
        reader1.borrowBook(book1);
        reader1.borrowBook(book2);

        System.out.println("Kitap İade İşlemi:");
        reader1.returnBook(book1);

        System.out.println("Aynı Kitabı Tekrar Ödünç Almayı Dene:");
        reader1.borrowBook(book2);


        boolean isRunning = true;

        while (isRunning) {
            System.out.println("KÜTÜPHANE SİSTEMİ MENÜSÜ");
            System.out.println("1 - Yeni kitap ekle");
            System.out.println("2 - Tüm kitapları listele");
            System.out.println("3 - Kitap ödünç al");
            System.out.println("4 - Kitap iade et");
            System.out.println("5 - Yazara göre kitapları listele");
            System.out.println("6 - Kategoriye göre kitapları listele");
            System.out.println("7 - Kitap bilgisi güncelle");
            System.out.println("0 - Çıkış");

            System.out.print("Seçiminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1 -> {
                    System.out.print("Kitap başlığı: ");
                    String title = scanner.nextLine();

                    System.out.print("Kategori: ");
                    String category = scanner.nextLine();

                    System.out.print("Yazar Seçimi: ");
                    System.out.println("1-Matt Haig");
                    System.out.println("2-Irvin D. Yalom");
                    System.out.println("3-Yeni bir yazar ekle.");
                    System.out.println("Seçiminiz: ");
                    int yazarSecimi = scanner.nextInt();
                    scanner.nextLine();
                    Author selectedAuthor;

                    switch (yazarSecimi) {
                        case 1 -> selectedAuthor = author1;
                        case 2 -> selectedAuthor = author2;
                        case 3 -> {
                            System.out.println("Yeni yazarın adını giriniz: ");
                            String yeniYazarAdi = scanner.nextLine();
                            selectedAuthor = new Author(yeniYazarAdi);

                        }
                        default -> {
                            System.out.println("Geçersiz Seçim!");
                            selectedAuthor = null;
                        }
                    }
                    System.out.print("Kitap ID: ");
                    String id = scanner.nextLine();

                    Book newBook = new Book(id, title, selectedAuthor, category);
                    library.addBook(newBook);
                    }





                case 2 -> library.listAllBooks();

                case 3 -> {
                    System.out.print("Ödünç alınacak kitabın ID'si: ");
                    String bookId = scanner.nextLine();
                    Book bookToBorrow = library.findBookById(bookId);
                    if (bookToBorrow != null) {
                        reader1.borrowBook(bookToBorrow);
                    } else {
                        System.out.println("Kitap bulunamadı!");
                    }
                }

                case 4 -> {
                    System.out.print("İade edilecek kitabın ID'si: ");
                    String bookId = scanner.nextLine();
                    Book bookToReturn = library.findBookById(bookId);
                    if (bookToReturn != null) {
                        reader1.returnBook(bookToReturn);
                    } else {
                        System.out.println("Kitap bulunamadı!");
                    }
                }

                case 5 -> {
                    System.out.print("Yazar adı: ");
                    String authorName = scanner.nextLine();
                    List<Book> booksByAuthor = library.findBooksByAuthor(authorName);
                    booksByAuthor.forEach(book -> System.out.println("- " + book.getTitle()));
                }

                case 6 -> {
                    System.out.print("Kategori adı: ");
                    String category = scanner.nextLine();
                    List<Book> booksByCategory = library.findBooksByCategory(category);
                    booksByCategory.forEach(book -> System.out.println("- " + book.getTitle()));
                }

                case 7 -> {
                    System.out.print("Güncellenecek kitabın ID'si: ");
                    String updateId = scanner.nextLine();
                    Book bookToUpdate = library.findBookById(updateId);
                    if (bookToUpdate != null) {
                        System.out.print("Yeni başlık (boş bırakılırsa değişmez): ");
                        String newTitle = scanner.nextLine();

                        System.out.print("Yeni kategori (boş bırakılırsa değişmez): ");
                        String newCategory = scanner.nextLine();

                        System.out.print("Yeni yazar (1: Matt Haig, 2: Irvin D. Yalom, 0: değişme): ");
                        int newAuthorInput = scanner.nextInt();
                        scanner.nextLine();
                        Author newAuthor = switch (newAuthorInput) {
                            case 1 -> author1;
                            case 2 -> author2;
                            default -> null;
                        };

                        bookToUpdate.updateBookInfo(newTitle, newAuthor, newCategory);
                    } else {
                        System.out.println("Kitap bulunamadı!");
                    }
                }

                case 0 -> {
                    System.out.println("👋 Programdan çıkılıyor. Güle güle!");
                    isRunning = false;
                }

                default -> System.out.println("⚠️ Geçersiz seçim! Lütfen 0-7 arasında bir sayı giriniz.");
            }
        }

        scanner.close();
    }
}