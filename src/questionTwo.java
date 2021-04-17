import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;
import javax.swing.*;
import java.awt.*;

final class rect {
    static Rectangle r1 = new Rectangle(5, 5, 75, 25);
    static Rectangle r2 = new Rectangle(5, 35, 75, 25);
    static Rectangle r3 = new Rectangle(5, 65, 75, 25);
    static Rectangle r4 = new Rectangle(5, 100, 300, 300);

    static Rectangle ISBN_RECT = new Rectangle(350, 35, 115, 25);
    static Rectangle SUBMIT_ISBN = new Rectangle(470, 35, 85, 25);
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
        JTextField ISBN = new JTextField("XXX-X-XX-XXXXXX-X");
        ISBN.setBounds(rect.ISBN_RECT);
        frame.add(ISBN);

        JButton submit = new JButton("Submit");
        submit.setBounds(rect.SUBMIT_ISBN);
        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.append(ISBN.getText() + "\n");
            }
        });

        frame.add(submit);
    }
}

class Book {
    public String[] createBook() {
        return new String[]{"Hello", "Hello"};
    }
}
