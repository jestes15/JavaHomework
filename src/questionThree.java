import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.*;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Objects;

import static java.lang.Integer.parseInt;

class rectQ3 {
    static Rectangle ID_RECT = new Rectangle(5, 5, 250, 25);
    static Rectangle comboBox_RECT = new Rectangle(5, 35, 250, 25);
    static Rectangle MAKE_RECT = new Rectangle(5, 65, 250, 25);
    static Rectangle MODEL_RECT = new Rectangle(5, 95, 250, 25);
    static Rectangle amountOfOwners_RECT = new Rectangle(5, 125, 250, 25);
    static Rectangle CONDITION_NEW_RECT = new Rectangle(5, 155, 250, 25);
    static Rectangle CONDITION_USED_RECT = new Rectangle(5, 185, 250, 25);
    static Rectangle MPG_RECT = new Rectangle(5, 215, 250, 25);
    static Rectangle submitButton = new Rectangle(5, 250, 100, 25);

    static Integer[] years = new Integer[]{2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012,
            2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020};
    static String[] make = new String[]{"Abarth", "Alfa Romeo", "Aston Martin", "Audi", "Bentley", "Bayerische Motoren Werke AG (BMW)", "Bugatti",
            "Cadillac", "Caparo", "Caterham", "Chevrolet", "Chrysler", "Citroen", "Corvette", "Dacia", "Daihatsu", "Dodge", "Ferrari",
            "Fiat", "Fisker", "Ford", "Honda", "Hummer", "Hyundai", "Infiniti", "Jaguar", "Jeep", "Kia", "Koenigsegg", "Kronreif Trunkenpolz Mattighofen (KTM)",
            "Lamborghini", "Lancia", "Land Rover", "Lexus", "Lotus", "Maserati", "Maybach", "Mazda", "McLaren", "Mercedes-Benz",
            "Milton Greasley (MG)", "Mini", "Mitsubishi", "Morgan", "Nissan", "Noble", "Pagani", "Peugeot", "Porsche", "Proton", "Renault",
            "Rolls-Royce", "Saab", "Seat", "Skoda", "Smart", "Subaru", "Suzuki", "Tata", "Toyota", "Vaushall", "Volkswagen", "Volvo"};
}

public class questionThree {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        createParentUI(frame);
        frame.setSize(700, 500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Car Inventory");
        frame.setVisible(true);
    }

    private static void createParentUI(JFrame frame) {
        JTextField fieldID = new JTextField();
        makeActive(fieldID, "Car ID");
        fieldID.setBounds(rectQ3.ID_RECT);

        JComboBox<Integer> box = new JComboBox<Integer>(rectQ3.years);
        box.setBounds(rectQ3.comboBox_RECT);

        JComboBox<String> MakeBox = new JComboBox<String>(rectQ3.make);
        MakeBox.setBounds(rectQ3.MAKE_RECT);

        JTextField modelField = new JTextField();
        makeActive(modelField, "Model of vehicle");
        modelField.setBounds(rectQ3.MODEL_RECT);

        JTextField amountOfOwnersField = new JTextField();
        makeActive(amountOfOwnersField, "# of owners");
        amountOfOwnersField.setBounds(rectQ3.amountOfOwners_RECT);

        JRadioButton condition_new = new JRadioButton("New");
        JRadioButton condition_used = new JRadioButton("Used");
        condition_new.setBounds(rectQ3.CONDITION_NEW_RECT);
        condition_used.setBounds(rectQ3.CONDITION_USED_RECT);

        ButtonGroup group = new ButtonGroup();
        group.add(condition_new);
        group.add(condition_used);

        JTextField MPG = new JTextField();
        makeActive(MPG, "Miles per gallon");
        MPG.setBounds(rectQ3.MPG_RECT);

        JButton submit = new JButton("Submit");
        submit.setBounds(rectQ3.submitButton);

        frame.add(fieldID);
        frame.add(box);
        frame.add(MakeBox);
        frame.add(modelField);
        frame.add(amountOfOwnersField);
        frame.add(condition_new);
        frame.add(condition_used);
        frame.add(MPG);

        frame.repaint();

        submit.addActionListener(e -> {
            String fileData = MessageFormat.format("ID:::{0}\nYEAR::{1}\nMAKE:::{2}\nMODEL:::{3}\nAOO:::{4}\nCONDITION:::{5}\nMPG:::{6}",
                    fieldID.getText(), box.getSelectedItem(), MakeBox.getSelectedItem(), modelField.getText(), amountOfOwnersField.getText(),
                    getSelection(group), MPG.getText());
            Integer val = parseInt(box.getSelectedItem().toString());
            System.out.println(val);
            car vehicle = new car(parseInt(fieldID.getText()), val, (String) Objects.requireNonNull(MakeBox.getSelectedItem()),
                    modelField.getText(), parseInt(amountOfOwnersField.getText()), getSelection(group), parseInt(MPG.getText()));
            writeInfoToFile(fileData, vehicle);
        });
        frame.add(submit);

    }
    private static void writeInfoToFile(String data, car records) {
        System.out.println(data);
        String dir = "/cars/";
        try {
            writeBufferedWriter(data, dir, String.valueOf(records.ID()));
        } catch (IOException e) {
            String message = "An error has occurred, please try again.";
            e.printStackTrace();
            JOptionPane.showMessageDialog(new JFrame(), message, "ERROR",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
    private static void writeBufferedWriter(String data, String getDirectory, String getFileName) throws IOException {
        String errorPath = System.getProperty("user.dir") + "\\ERROR-CACHE\\ERROR-1.txt";
        String path = System.getProperty("user.dir") + getDirectory + getFileName + ".txt";
        File dir = new File(System.getProperty("user.dir"), "car");
        if (!dir.exists()) {
            dir.mkdir();
        }
        createFile(getFileName);

        File file = new File(path);
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter br = new BufferedWriter(fr);
        try {
            br.write(data + "\r\n");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            FileWriter fw = new FileWriter(errorPath, true);
            fw.write(String.valueOf(e));
            fw.close();
        } finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
                FileWriter fw = new FileWriter(errorPath, true);
                fw.write(String.valueOf(e));
                fw.close();
            }
        }
    }
    private static String createFile(String getName) throws IOException {
        String errorPath = System.getProperty("user.dir") + "\\ERROR-CACHE\\ERROR-1.txt";

        try {
            File myOBJ = new File(System.getProperty("user.dir") + "/cars/" + getName + ".txt");
            if (myOBJ.createNewFile()) {
                System.out.println("File created: " +  myOBJ.getName());
                return "File Created";
            }
            else {
                return "File Exists";
            }
        }
        catch (IOException e) {
            e.printStackTrace();

            FileWriter fw = new FileWriter(errorPath, true); //Writes the error code to the error cache file
            fw.write(String.valueOf(e));
            fw.close();
            return "An error has occurred";
        }
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
    private static String getSelection(ButtonGroup group) {
        for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }
        return "NULL";
    }
}
record car(int ID, Integer year, String make, String model, int amountOfOwners, String condition, int milesPerGallon) { }