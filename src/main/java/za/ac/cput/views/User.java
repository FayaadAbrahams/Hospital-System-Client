package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

public class User extends JFrame {
    private static final String[] entities = {" ", "Appointments", "Cleaning Staff", "Doctors", "Drivers", "Hospital Rooms", "Invoices", "Medical Aid", "Medicine", "Nurses", "Patients", "Secretaries", "Suppliers"};
    private static JFrame userFrame;
    private static JPanel userPanel;
    private static JTextArea userArea;
    private static JScrollPane sp;
    private static JLabel entityLabel;
    private static JComboBox<? extends String> comboBox;

    public void setGUI() {
        userFrame = new JFrame("Hospital Management - Client");
        userPanel = new JPanel();

        userFrame.setSize(450, 670);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);

        userFrame.add(userPanel);
        userPanel.setLayout(null);
        userPanel.setBackground(Color.black);

        entityLabel = new JLabel("Entities");
        entityLabel.setForeground(Color.WHITE);
        entityLabel.setFont(new Font("Arial", Font.BOLD, 20));
        entityLabel.setBounds(180, 20, 80, 25);

        comboBox = new JComboBox<>(entities);
        comboBox.setBounds(150, 50, 130, 25);

        comboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String comboSelect = comboBox.getSelectedItem().toString();
                    userArea.setText(comboSelect);
                    switch (comboSelect) {
                        case "Appointment":
                            try {
                                userArea.append(Client.getAllAppointments());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            break;
                        case "Cleaning Staff":
                            try {
                                userArea.append(Client.getAllCleaningStaff());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            break;
                        case "Doctors":
                            System.out.println();
                            break;
                        case "Drivers":
                            try {
                                userArea.append(Client.getAllDrivers());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            System.out.println();
                            break;
                        case "Hospital Rooms":
                            try {
                                userArea.append(Client.getAllHospitalRooms());
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                            break;
                        case "Invoices":
                            System.out.println();
                            break;
                        case "Medical Aid":
                            System.out.println();
                            break;
                        case "Medicine":
                            System.out.println();
                            break;
                        case "Nurses":
                            System.out.println();
                            break;
                        case "Patients":
                            System.out.println();
                            break;
                        case "Secretaries":
                            System.out.println();
                            break;
                        case "Suppliers":
                            System.out.println();
                            break;
                    }
                }
            }
        });
        userArea = new JTextArea("================ Please Select an Item from the Drop down ================");
        userArea.setEditable(false);
        userArea.setBounds(20, 120, 390, 500);
        sp = new JScrollPane();
        sp.setBounds(20, 120, 390, 500);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.getViewport().setBackground(Color.WHITE);
        sp.getViewport().add(userArea);
       /* userArea.add(sp);*/

        userPanel.add(entityLabel);
        userPanel.add(comboBox);
        userPanel.add(sp);
        userFrame.setVisible(true);
    }

}

