package Programm;

import MyListeners.ActionListenerList0;
import MyListeners.ActionListenerList1;
import MyListeners.ActionListenerList2;
import MyListeners.ActionListenerList3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;

public class Swing extends JFrame {
    private MyAddDialog addBookDialog;
    private MyChangeDialog changeBookDialog;
    public static BookModel bmt;
    public Swing() {
        JFrame jFrame = new JFrame("Library");
        JPanel jPanel = new JPanel();

        jFrame.setPreferredSize(new Dimension(600, 300));
        jFrame.setLocation(750, 250);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu lists = new JMenu("Lists");
        JMenu edit = new JMenu("Edit");

        bmt = new BookModel();
        Book b = new Book("hgjjgk", 340, 343, new Author("Tolkin", "fdsf", "fdsf"), new GregorianCalendar(1996, 10, 21));
        bmt.addBook(b);
        JTable table = new JTable(bmt);
        table.getColumnModel().getColumn(1).setMinWidth(250);
        JScrollPane jScrollPane = new JScrollPane(table);

        table.setBackground(Color.LIGHT_GRAY);
        table.setForeground(Color.BLACK);
        Font font  = new Font("", 9, 14);
        table.setFont(font);
        table.setRowHeight(30);


        JButton addButton = new JButton("addBook");
        JButton deleteButton = new JButton("deleteBook");
        JButton changeButton = new JButton("changeBook");


     ////////////////////////////////////////////////////////

        jMenuBar.add(lists);
        jMenuBar.add(edit);
        JMenuItem list0 = new JMenuItem("List of book`s names");
        JMenuItem list1 = new JMenuItem("List of authors");
        JMenuItem list2 = new JMenuItem("List of prices");
        JMenuItem list3 = new JMenuItem("List of published amount");
        lists.add(list0);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.addSeparator();

        JMenuItem exit = lists.add(new JMenuItem("Exit"));
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        exit.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
        JMenuItem clear = edit.add(new JMenuItem("clearTable"));
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bmt.clearTable();
            }
        });


        jFrame.setJMenuBar(jMenuBar);
        jFrame.add(jPanel);
        jPanel.setLayout(new GridBagLayout());

        jPanel.add(jScrollPane, new GridBagConstraints(0, 0,
                3, 3, 1, 10,
                GridBagConstraints.NORTH, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));

        jPanel.add(addButton, new GridBagConstraints(0, 3,
                1, 1, 1, 0.2,
                 GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                 new Insets(1, 1, 1, 1), 0, 0));

        jPanel.add(deleteButton, new GridBagConstraints(1, 3,
                1, 1, 1, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));

        jPanel.add(changeButton, new GridBagConstraints(2, 3,
                1, 1, 1, 0.2,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(1, 1, 1, 1), 0, 0));


        ////ActionListeners
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table.getSelectedRow() >= 0) {
                    bmt.delBook(table.getSelectedRow());
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(addBookDialog == null) {
                    addBookDialog = new MyAddDialog(jFrame);
                }
                addBookDialog.setVisible(true);
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowIndex = table.getSelectedRow();
                bmt.setRowIndex(rowIndex);
                changeBookDialog = new MyChangeDialog(jFrame);
                changeBookDialog.setName(bmt.getValueAt(rowIndex, 0).toString());
                Author author = (Author) bmt.getValueAt(rowIndex, 1);
                changeBookDialog.setAuthorName(author.getName());
                changeBookDialog.setAuthorEmail(author.getEmail());
                changeBookDialog.setAuthorGender(author.getGender());
                changeBookDialog.setPrice(bmt.getValueAt(rowIndex, 2).toString());
                changeBookDialog.setPublishedAmount(bmt.getValueAt(rowIndex, 3).toString());
                //GregorianCalendar publishedData = (GregorianCalendar) bmt.getValueAt(rowIndex, 4);
                changeBookDialog.setPublicationDate(bmt.getValueAt(rowIndex, 4).toString());


            }
        });

        changeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(table.getSelectedRow() >= 0) {
                    changeBookDialog.setVisible(true);
                }
            }
        });

        list0.addActionListener(new ActionListenerList0());
        list1.addActionListener(new ActionListenerList1());
        list2.addActionListener(new ActionListenerList2());
        list3.addActionListener(new ActionListenerList3());

        jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                Object[] options = { "Да", "Нет!" };
                int n = JOptionPane.showOptionDialog(event.getWindow(), "Сохранить данные таблицы в файл?",
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    WriteToFile writeToFile = new WriteToFile();
                    //writeToFile.creationFunc("fdsfsd");
                    for(int i = 0; i < bmt.getRowCount(); i++) {
                            writeToFile.creationFunc("Name of the book: " + bmt.getValueAt(i, 0).toString() + ", ");
                            writeToFile.creationFunc("Author: " + bmt.getValueAt(i, 1).toString() + ", ");
                            writeToFile.creationFunc("Price of the book: " + bmt.getValueAt(i, 2).toString() + ", ");
                            writeToFile.creationFunc("PublishedAmount of the book: " + bmt.getValueAt(i, 3).toString() + ", ");
                            writeToFile.creationFunc("PublishedDate of the book: " + bmt.getValueAt(i, 4).toString() + ";");
                            writeToFile.creationFunc("\n");
                    }
                    event.getWindow().setVisible(false);
                    System.exit(0);
                }
                else {
                    System.exit(0);
                }
            }
        });
        jFrame.setVisible(true);
        jFrame.pack();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing();
                WriteToFile wr = new WriteToFile();
                try {
                    wr.deleteFunc();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

