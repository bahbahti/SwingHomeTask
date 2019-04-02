package Programm;

import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class BookModel extends AbstractTableModel {
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY.MM.dd");
    private int rowIndex;
    private List<Book> books = new ArrayList<>();

    public void setRowIndex(int rowIndex) {
        this.rowIndex = rowIndex;
    }
    GregorianCalendar cal = new GregorianCalendar(2096, 9, 21);
    public BookModel() {
        books.add(new Book("Harry Potter",1000, 20.5,
                  new Author("JR","jr@yax.rfsdf","m"),
                  new GregorianCalendar(1999, 02, 11)));

        books.add(new Book("Lord of the rings", 340, 343,
                  new Author("Tolkin", "fdsf", "fdsf"), new GregorianCalendar(2096, 9, 21)));
        GregorianCalendar cal = new GregorianCalendar(2096, 9, 21);
    }

    public void addBook(Book b){
       books.add(b);
        fireTableDataChanged();
    }
    public void delBook(int row) {
        books.remove(row);
        fireTableDataChanged();
    }
    public void clearTable() {
        books.clear();
        fireTableDataChanged();
    }
    public void changeBook(Book b) {
        books.remove(rowIndex);
        books.add(rowIndex, b);
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Book cur=books.get(rowIndex);
        switch (columnIndex){
            case 0:
                return cur.getName();
            case 1:
                return cur.getAuthor();
            case 2:
                return cur.getPrice();
            case 3:
                return cur.getPublishedAmount();
            case 4:
                return sdf.format(cur.getPublicationDate().getTime());
        }
        return null;
    }

    public String getColumnName(int column) {
        switch (column){
            case 0:
                return "Book name";
            case 1:
                return "Author";
            case 2:
                return "Price";
            case 3:
                return "PublishedAmount";
            case 4:
                return "PublishedDate";
        }
        return "";
    }
}
