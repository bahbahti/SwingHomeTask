package Programm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.GregorianCalendar;

public class MyChangeDialog extends JDialog {
    private JTextField name;
    private JTextField price;
    private JTextField publishedAmount;
    private JTextField authorName;
    private JTextField authorEmail;
    private JTextField authorGender;
    private JTextField publicationDate;

    public void setName(String str) {
        name.setText(str);
    }

    public void setPrice(String str) {
        price.setText(str);
    }

    public void setPublishedAmount(String str) {
        publishedAmount.setText(str);
    }

    public void setAuthorName(String str) {
        authorName.setText(str);
    }

    public void setAuthorEmail(String str) {
        authorEmail.setText(str);
    }

    public void setAuthorGender(String str) {
        authorGender.setText(str);
    }
    public void setPublicationDate(String str) {
        publicationDate.setText(str);
    }

    public MyChangeDialog(JFrame owner) {
        super(owner, "Change the fields for the book", true);
        setBounds(780, 280, 400, 400);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JButton cancel = new JButton("cancel");
        JButton change = new JButton("change");

        panel4.setLayout(new GridLayout());
        panel4.add(change);
        panel4.add(cancel);

        panel3.setLayout(new BorderLayout());
        panel3.add(panel4, BorderLayout.EAST);

        panel1.setLayout(new BorderLayout());
        panel1.add(panel3, BorderLayout.SOUTH);

        add(panel1);

        name = new JTextField(15);
        price = new JTextField(15);
        publishedAmount = new JTextField(15);
        authorName = new JTextField(15);
        authorEmail = new JTextField(15);
        authorGender = new JTextField(15);
        publicationDate = new JTextField(15);

        JLabel textName = new JLabel("name of book");
        JLabel textPrice = new JLabel("price");
        JLabel textPublishedAmount = new JLabel("publishedAmount");
        JLabel textAuthorName = new JLabel("name of author");
        JLabel textAuthorEmail = new JLabel("email of author");
        JLabel textAuthorGender = new JLabel("gender of author");
        JLabel textPublicationDate = new JLabel("date of publication");

        panel2.setLayout(new GridBagLayout());
        add(panel2, BorderLayout.NORTH);
        panel2.add(textName, new GridBagConstraints(1, 0,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 20, 10, 1), 0, 0));
        panel2.add(textPrice, new GridBagConstraints(1, 1,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 20, 10, 1), 0, 0));
        panel2.add(textPublishedAmount, new GridBagConstraints(1, 2,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 20, 10, 1), 0, 0));
        panel2.add(textAuthorName, new GridBagConstraints(1, 3,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 20, 10, 1), 0, 0));
        panel2.add(textAuthorEmail, new GridBagConstraints(1, 4,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 20, 10, 1), 0, 0));
        panel2.add(textAuthorGender, new GridBagConstraints(1, 5,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 20, 10, 1), 0, 0));
        panel2.add(textPublicationDate, new GridBagConstraints(1, 6,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 20, 10, 1), 0, 0));


        panel2.add(name, new GridBagConstraints(2, 0,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 1, 10, 20), 0, 0));
        panel2.add(price, new GridBagConstraints(2, 1,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 1, 10, 20), 0, 0));
        panel2.add(publishedAmount, new GridBagConstraints(2, 2,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 1, 10, 20), 0, 0));
        panel2.add(authorName, new GridBagConstraints(2, 3,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 1, 10, 20), 0, 0));
        panel2.add(authorEmail, new GridBagConstraints(2, 4,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 1, 10, 20), 0, 0));
        panel2.add(authorGender, new GridBagConstraints(2, 5,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 1, 10, 20), 0, 0));
        panel2.add(publicationDate, new GridBagConstraints(2, 6,
                1, 1, 0.5, 0.5,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(10, 1, 10, 20), 0, 0));

        /////Listeners
        change.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                if (validFunction()) {
                    String[] subStr = new String[3];
                    String str = publicationDate.getText();
                    subStr = str.split("\\.");
                    GregorianCalendar calendar = new GregorianCalendar((int) Integer.parseInt(subStr[0]), (int) Integer.parseInt(subStr[1]), (int) Integer.parseInt(subStr[2]));
                    Author author = new Author(authorName.getText(), authorEmail.getText(), authorGender.getText());
                    Book row = new Book(name.getText(), (int) Integer.parseInt(publishedAmount.getText()), (double) Double.parseDouble(price.getText()), author, calendar);
                    Swing.bmt.changeBook(row);
                    setVisible(false);
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                setVisible(false);
            }
        });

        name.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                name.setText("");
                name.setForeground(Color.black);
            }
        });
        price.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                price.setText("");
                price.setForeground(Color.black);
            }
        });
        publishedAmount.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                publishedAmount.setText("");
                publishedAmount.setForeground(Color.black);
            }
        });
        authorName.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                authorName.setText("");
                authorName.setForeground(Color.black);
            }
        });
        authorEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                authorEmail.setText("");
                authorEmail.setForeground(Color.black);
            }
        });
        authorGender.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                authorGender.setText("");
                authorGender.setForeground(Color.black);
            }
        });
        publicationDate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                publicationDate.setText("");
                publicationDate.setForeground(Color.black);
            }
        });

    }

    public boolean validFunction() {
        if(name.getText().length() == 0 || name.getText().equals("Enter name of the book!")) {
            name.setText("Enter name of the book!");
            name.setForeground(Color.red);
            return false;
        }
        else if(price.getText().length() == 0 || price.getText().equals("Enter price of the book!")) {
            price.setText("Enter price of the book!");
            price.setForeground(Color.red);
            return false;
        }
        else if(!isParsableDouble(price.getText())) {
            price.setText("Invalid type");
            price.setForeground(Color.red);
            return false;
        }
        else if(publishedAmount.getText().length() == 0 || publishedAmount.getText().equals("Enter publishedAmount of the book!")) {
            publishedAmount.setText("Enter publishedAmount of the book!");
            publishedAmount.setForeground(Color.red);
            return false;
        }
        else if(!isParsableInt(publishedAmount.getText())) {
            publishedAmount.setText("Invalid type");
            publishedAmount.setForeground(Color.red);
            return false;
        }
        else if(authorName.getText().length() == 0 || authorName.getText().equals("Enter name of the author!")) {
            authorName.setText("Enter name of the author!");
            authorName.setForeground(Color.red);
            return false;
        }
        else if(authorEmail.getText().length() == 0 || authorEmail.getText().equals("Enter email of the author!")) {
            authorEmail.setText("Enter email of the author!");
            authorEmail.setForeground(Color.red);
            return false;
        }
        else if(authorGender.getText().length() == 0 || authorGender.getText().equals("Enter gender of the author!")) {
            authorGender.setText("Enter gender of the author!");
            authorGender.setForeground(Color.red);
            return false;
        }
        else if(publicationDate.getText().length() == 0 || publicationDate.getText().equals("Enter date of publication!")) {
            publicationDate.setText("Enter date of publication!");
            publicationDate.setForeground(Color.red);
            return false;
        }
///////////ЗДЕСЬ
        return true;
    }

    public static boolean isParsableDouble(String input){
        boolean parsable;
        try{
            Double.parseDouble(input);
            parsable = true;
        }catch(NumberFormatException e){
            parsable = false;
        }
        return parsable;
    }

    public static boolean isParsableInt(String input){
        boolean parsable;
        try{
            Integer.parseInt(input);
            parsable = true;
        }catch(NumberFormatException e){
            parsable = false;
        }
        return parsable;
    }
}
