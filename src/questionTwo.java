import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Stack;
import javax.swing.*;
import java.awt.*;

final class rect {
    static Rectangle r1 = new Rectangle(5, 5, 75, 25);
    static Rectangle r2 = new Rectangle(5, 35, 75, 25);
    static Rectangle r3 = new Rectangle(5, 65, 75, 25);
    static Rectangle r4 = new Rectangle(5, 100, 300, 300);

    static Rectangle TITLE_RECT = new Rectangle(350, 35, 115, 25);
    static Rectangle AUTHOR_RECT = new Rectangle(350, 65, 115, 25);
    static Rectangle PRICE_RECT = new Rectangle(350, 95, 115, 25);
    static Rectangle ISBN_RECT = new Rectangle(350, 125, 115, 25);

    static Rectangle SUBMIT = new Rectangle(470, 125, 85, 25);
}

public class questionTwo {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JTextArea field = createParentUI(frame);
        addBookUI(frame, field);

        frame.setSize(700,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Library");
        frame.setVisible(true);
    }
    private static JTextArea createParentUI(JFrame frame) {

        JTextArea field = new JTextArea(30,1);
        field.setBounds(rect.r4);
        field.setEditable(false);

        frame.add(field);

        JButton push = new JButton("push");
        push.setBounds(rect.r1);
        push.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.append("Push Append works\n");
            }
        });

        JButton pop = new JButton("pop");
        pop.setBounds(rect.r2);
        pop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.append("Pop works\n");
            }
        });

        JButton peek = new JButton("peek");
        peek.setBounds(rect.r3);
        peek.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.append("Peek works\n");
            }
        });

        frame.add(push);
        frame.add(pop);
        frame.add(peek);

        return field;
    }
    private static void addBookUI(JFrame frame, JTextArea field) {
        JTextField title = new JTextField("Title");
        JTextField author = new JTextField("Author");
        JTextField price = new JTextField("Price");
        JTextField ISBN = new JTextField("ISBN");

        makeActive(title);
        makeActive(author);
        makeActive(price);
        makeActive(ISBN);

        title.setBounds(rect.TITLE_RECT);
        author.setBounds(rect.AUTHOR_RECT);
        price.setBounds(rect.PRICE_RECT);
        ISBN.setBounds(rect.ISBN_RECT);

        frame.add(title);
        frame.add(author);
        frame.add(price);
        frame.add(ISBN);

        JButton submit = new JButton("Submit");
        submit.setBounds(rect.SUBMIT);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = title.getText() + "\n" +
                        author.getText() + "\n" +
                        price.getText() + "\n" +
                        ISBN.getText() + "\n";
                field.append(info);
            }
        });

        frame.add(submit);
    }
    // TODO Fix this to make it permanent
    private static void makeActive(JTextField field) {
        field.setForeground(Color.GRAY);
        field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals("Title")) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.GRAY);
                    field.setText("Title");
                }
            }
        });
    }
}

class Book {
    public String[] createBook() {
        return new String[]{"Hello", "Hello"};
    }
}
