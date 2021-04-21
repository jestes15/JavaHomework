/**
 * Author: Joshua Estes
 * Date April 21 2021
 * Status: COMPLETE
 */

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Stack;
import javax.swing.*;
import java.awt.*;

final class rect {
    static Rectangle r1 = new Rectangle(470, 95, 150, 25);
    static Rectangle r2 = new Rectangle(5, 35, 75, 25);
    static Rectangle r3 = new Rectangle(90, 35, 75, 25);
    static Rectangle r4 = new Rectangle(5, 100, 300, 303);
    static Rectangle TITLE_RECT = new Rectangle(350, 35, 115, 25);
    static Rectangle AUTHOR_RECT = new Rectangle(350, 65, 115, 25);
    static Rectangle PRICE_RECT = new Rectangle(350, 95, 115, 25);
    static Rectangle ISBN_RECT = new Rectangle(350, 125, 115, 25);
    static Rectangle SUBMIT = new Rectangle(470, 125, 85, 25);
    static Rectangle PEEK_DATA_RECT = new Rectangle(350, 160, 150, 150);
}

record Book(String title, String author, String price, String ISBN) {
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getPrice() {
        return price;
    }
    public String getISBN() {
        return ISBN;
    }
}

public class questionTwo {
    public static void main(String[] args) {
        Stack<Book> bookStack = new Stack<>();

        JFrame frame = new JFrame();
        JTextArea field = createParentUI(frame, bookStack);
        addBookUI(frame, field, bookStack);

        frame.setSize(700,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Library");
        frame.setVisible(true);
    }
    private static JTextArea createParentUI(JFrame frame, Stack<Book> bookStack) {

        JTextArea field = new JTextArea(20, 1);
        JTextArea fieldBookInfo = new JTextArea(4, 1);
        field.setBounds(rect.r4);
        fieldBookInfo.setBounds(rect.PEEK_DATA_RECT);
        field.setEditable(false);
        fieldBookInfo.setEditable(false);
        frame.add(field);
        frame.add(fieldBookInfo);

        JButton pop = new JButton("pop");
        pop.setBounds(rect.r2);
        pop.addActionListener(e -> {
            bookStack.pop();
            updateUI(field, bookStack);
        });

        JButton peek = new JButton("peek");
        peek.setBounds(rect.r3);
        peek.addActionListener(e -> {
            Book obj = bookStack.peek();
            showBookInfo(fieldBookInfo, obj);
        });

        frame.add(pop);
        frame.add(peek);

        return field;
    }
    private static void addBookUI(JFrame frame, JTextArea field, Stack<Book> bookStack) {
        JTextField title = new JTextField("Title");
        JTextField author = new JTextField("Author");
        JTextField price = new JTextField("Price");
        JTextField ISBN = new JTextField("ISBN");

        JTextField errorField = new JTextField();

        makeActive(title, "Title");
        makeActive(author, "Author");
        makeActive(price, "Price");
        makeActive(ISBN, "ISBN");

        errorField.setBounds(rect.r1);
        errorField.setEditable(false);

        title.setBounds(rect.TITLE_RECT);
        author.setBounds(rect.AUTHOR_RECT);
        price.setBounds(rect.PRICE_RECT);
        ISBN.setBounds(rect.ISBN_RECT);

        frame.add(title);
        frame.add(author);
        frame.add(price);
        frame.add(ISBN);
        frame.add(errorField);

        JButton submit = new JButton("Push");
        submit.setBounds(rect.SUBMIT);
        submit.addActionListener(e -> {
            Book b = new Book(title.getText(), author.getText(), price.getText(), ISBN.getText());
            if (bookStack.size() < 20)
                bookStack.push(b);
            else
                errorField.setText("Error, too many books!");
            updateUI(field, bookStack);
        });

        frame.add(submit);
    }
    private static void makeActive(JTextField field, String tempText) {
        field.setForeground(Color.GRAY);
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(tempText)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText(tempText);
                }
            }
        });
    }
    private static void updateUI(JTextArea field, Stack<Book> bookStack) {
        field.setText("");
        for (Book book : bookStack) {
            field.append(book.getTitle() + "\n");
        }
    }
    private static void showBookInfo(JTextArea field, Book obj) {
        field.setText("");
        String text = obj.getTitle() + "\n" +
                obj.getAuthor() + "\n" +
                obj.getPrice() + "\n" +
                obj.getISBN();
        field.append(text);
    }
}