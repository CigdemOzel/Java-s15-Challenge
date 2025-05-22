package model;

public class Book {

    private String bookId;
    private String title;
    private Author author;
    private String category;
    private boolean isBorrowed;

    public Book(String bookId, String title, Author author, String category) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrowed = false;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if(!isBorrowed) {
            isBorrowed=true;
            System.out.println("Kitap ödünç alındı. İyi okumalar!");
        } else {
            System.out.println("Bu kitap daha önce ödünç alınmış!");
        }
    }

    public void returnBook() {
        if(isBorrowed) {
            isBorrowed = false;
            System.out.println("Kitap iadesi oldu. Teşekkürler!");
        } else {
            System.out.println("Bu kitap şu an kütüphanede!");
        }
    }

     void updateBookInfo(String newTitle, Author newAuthor, String newCategory) {
        if (newTitle != null && !newTitle.isBlank()) {
            this.title = newTitle;
        }
        if (newAuthor != null) {
            this.author = newAuthor;
        }
        if (newCategory != null && !newCategory.isBlank()) {
            this.category = newCategory;
        }
        System.out.println("Kitap bilgileri güncellendi: " + this);
    }

    @Override
    public String toString() {
        return "Book{ID='" + bookId + "', title='" + title + "', author=" + author.getName() +
                ", category='" + category + "', isBorrowed=" + isBorrowed + "}";
    }
}
