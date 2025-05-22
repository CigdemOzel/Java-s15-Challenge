package model;

import service.Reader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Bill {
    private static final double BOOK_PRICE = 10.0;

    private String billId;
    private Reader reader;
    private Book book;
    private LocalDateTime transactionDate;
    private boolean isRefunded;

    public Bill(String billId, Reader reader, Book book) {
        this.billId = billId;
        this.reader = reader;
        this.book = book;
        this.transactionDate = LocalDateTime.now();
        this.isRefunded = false;
    }

    public double getAmount() {
        return isRefunded ? 0.0 : BOOK_PRICE;
    }

    public boolean getAmountIsRefunded() {
        return isRefunded;
    }

    public void refund() {
        isRefunded = true;
        System.out.println("İade işlemi tamamlandı: " + book.getTitle() + " için " + BOOK_PRICE + " TL geri verildi.");
    }

    public void printBill() {
        System.out.println("Fatura Detayı:");
        System.out.println("Fatura ID: " + billId);
        System.out.println("Kullanıcı: " + reader.getName());
        System.out.println("Kitap: " + book.getTitle());
        System.out.println("Tarih: " + transactionDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")));
        System.out.println("Tutar: " + getAmount() + " TL");
        System.out.println("İade Edildi mi? " + (isRefunded ? "Evet" : "Hayır"));
    }

    public String getBillId() {
        return billId;
    }
}
