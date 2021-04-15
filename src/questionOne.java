import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class string_info {
    public double val1;
    public double val2;
    public String operatorID;
}

public class questionOne {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        r.x = 5; r.y = 5; r.width = 330; r.height = 90;

        JFrame frame = new JFrame();

        JTextField field = new JTextField();
        field.setBounds(r);
        field.setEditable(false);
        Font font = new Font(Font.SERIF, Font.PLAIN, 54);
        field.setFont(font);

        addEventListener(createNumberPad(frame), field);

        frame.add(field);

        addMenuBar(frame);

        frame.setSize(350,307);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Calculator");
        frame.setVisible(true);
    }
    public static void addEventListener(JButton[] buttons, JTextField field) {

        string_info stringInfo = new string_info();

        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "0");
            }
        });

        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "1");
            }
        });

        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "2");
            }
        });

        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "3");
            }
        });

        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "4");
            }
        });

        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "5");
            }
        });

        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "6");
            }
        });

        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "7");
            }
        });

        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "8");
            }
        });

        buttons[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "9");
            }
        });

        buttons[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + ".");
            }
        });

        buttons[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "^");
                stringInfo.operatorID = "2235";
            }
        });

        buttons[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "+");
                stringInfo.operatorID = "3476";
            }
        });

        buttons[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "-");
                stringInfo.operatorID = "3931";
            }
        });

        buttons[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "*");
                stringInfo.operatorID = "2204";
            }
        });

        buttons[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "/");
                stringInfo.operatorID = "2201";
            }
        });

        buttons[16].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText(field.getText() + "%");
                stringInfo.operatorID = "6793";
            }
        });

        buttons[17].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double val = enterActionListener(stringInfo, field);
                DecimalFormat format = new DecimalFormat("0.########");

                if ((stringInfo.operatorID).equals("2201") || (stringInfo.operatorID).equals("6793")) {
                    if (stringInfo.val2 == 0)
                        field.setText(field.getText() + " = Cannot Divide by Zero. Please try again");
                    else
                        field.setText(field.getText() + " = " + format.format(val));
                }
                else
                    field.setText(field.getText() + " = " + format.format(val));
            }
        });

        buttons[18].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field.setText("");
            }
        });
    }
    public static JButton[] createNumberPad(JFrame frame) {
        JButton button1 = new JButton("1"),
                button2 = new JButton("2"),
                button3 = new JButton("3"),
                button4 = new JButton("4"),
                button5 = new JButton("5"),
                button6 = new JButton("6"),
                button7 = new JButton("7"),
                button8 = new JButton("8"),
                button9 = new JButton("9"),
                button0 = new JButton("0"),
                buttonDot = new JButton("."),
                buttonCarat = new JButton("<html>x<sup>a</sup></html>"),
                buttonAdd = new JButton("+"),
                buttonSub = new JButton("-"),
                buttonMult = new JButton("<html><span>&#215;</span></html>"),
                buttonDiv = new JButton("<html><span>&#247;</span></html>"),
                buttonModulo = new JButton("%"),
                buttonEqual = new JButton("="),
                buttonC = new JButton("C");

        button1.setBounds(5,100,75, 25);
        button2.setBounds(85,100,75, 25);
        button3.setBounds(165,100,75, 25);

        button4.setBounds(5,130,75, 25);
        button5.setBounds(85,130,75, 25);
        button6.setBounds(165,130,75, 25);

        button7.setBounds(5,160,75, 25);
        button8.setBounds(85,160,75, 25);
        button9.setBounds(165,160,75, 25);

        buttonDot.setBounds(5, 190, 75, 25);
        button0.setBounds(85,190,75, 25);
        buttonCarat.setBounds(165,190,75, 25);

        buttonAdd.setBounds(260, 100, 75, 25);
        buttonSub.setBounds(260, 130, 75, 25);
        buttonMult.setBounds(260, 160, 75, 25);
        buttonDiv.setBounds(260, 190, 75, 25);
        buttonModulo.setBounds(260, 220, 75, 25);
        buttonEqual.setBounds(5, 220, 155, 25);

        buttonC.setBounds(165, 220, 75, 25);

        JButton[] buttonArray = {
                button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonDot, buttonCarat,
                buttonAdd, buttonSub, buttonMult, buttonDiv, buttonModulo, buttonEqual, buttonC
        };


        for (JButton jButton : buttonArray) {
            frame.add(jButton);
        }
        return buttonArray;
    }
    public static double enterActionListener(string_info s, JTextField field) {
        String txt = field.getText();
        String pattern = "[-+*%/]";
        Pattern pattern1 = Pattern.compile(pattern);
        Matcher matcher = pattern1.matcher(txt);

        int num = 1;
        if(matcher.find()){

            num = matcher.start();
        }
        s.val1 = Double.parseDouble(field.getText().substring(0, num));
        s.val2 = Double.parseDouble(field.getText().substring(num+1));

        return performOperation(s);
    }
    private static double performOperation(string_info s) {
        switch (s.operatorID) {
            case "2235" -> {
                return Math.pow(s.val1, s.val2);
            }
            case "3476" -> {
                return s.val1 + s.val2;
            }
            case "3931" -> {
                return s.val1 - s.val2;
            }
            case "2204" -> {
                return s.val1 * s.val2;
            }
            case "2201" -> {
                return s.val1 / s.val2;
            }
            case "6793" -> {
                return s.val1 % s.val2;
            }
            default -> {
                return 0;
            }
        }
    }
    private static void addMenuBar(JFrame frame) {
        final JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        final JMenu aboutMenu = new JMenu("About");

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setActionCommand("Exit");

        JMenuItem aboutMenuItem = new JMenuItem("About");

        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String info = """
                        This work is the intellectual property of Joshua Estes
                        Any form of copy and use is prohibited unless authorization is given by Mr. Estes.""";
                JOptionPane.showMessageDialog(null, info, "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        final JCheckBoxMenuItem showWindowMenu = new JCheckBoxMenuItem("Show About", true);
        showWindowMenu.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                if(showWindowMenu.getState()){
                    menuBar.add(aboutMenu);
                } else {
                    menuBar.remove(aboutMenu);
                }
            }
        });


        fileMenu.add(showWindowMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        aboutMenu.add(aboutMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(aboutMenu);

        frame.setJMenuBar(menuBar);
    }
}