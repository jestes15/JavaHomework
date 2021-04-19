import javax.swing.*;
import java.awt.*;

class rectQ3 {
    static Rectangle ID_RECT = new Rectangle(5, 5, 75, 25);
    static Rectangle comboBox_RECT = new Rectangle(5, 35, 75, 25);
    static Rectangle MAKE_RECT = new Rectangle(5, 65, 250, 25);
    static Rectangle MODEL_RECT = new Rectangle(5, 95, 150, 25);
    static Rectangle amntOfOwners_RECT = new Rectangle(5, 125, 75, 25);

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

        frame.setSize(700,500);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setTitle("Car Inventory");
        frame.setVisible(true);
    }

    private static void createParentUI(JFrame frame) {
        JTextField fieldID = new JTextField();
        fieldID.setBounds(rectQ3.ID_RECT);

        JComboBox<Integer> box = new JComboBox<Integer>(rectQ3.years);
        box.setBounds(rectQ3.comboBox_RECT);

        JComboBox<String> MakeBox = new JComboBox<String>(rectQ3.make);
        MakeBox.setBounds(rectQ3.MAKE_RECT);

        JTextField modelField = new JTextField();
        modelField.setBounds(rectQ3.MODEL_RECT);

        JTextField amntOfOwnersField = new JTextField();
        amntOfOwnersField.setBounds(rectQ3.amntOfOwners_RECT);

        frame.add(fieldID);
        frame.add(box);
        frame.add(MakeBox);
        frame.add(modelField);
        frame.add(amntOfOwnersField);
    }
}

class car {
    int ID;
    Integer year;
    String make;
    String model;
    int amntOfOwners;
    String Condition;
    int MPG;
}