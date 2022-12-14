package za.ac.cput.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.Objects;

public class User extends JFrame implements ActionListener {
    private static final String[] entities = {" ", "Appointments", "Cleaning Staff", "Doctors", "Drivers", "Hospital Rooms", "Invoices", "Medical Aid", "Medicine", "Nurses", "Patients", "Secretaries", "Suppliers"};
    private static JFrame userFrame;
    private static JPanel userPanel;
    private static JTextArea userArea;
    private static JButton backButton;
    private static JScrollPane sp;
    private static JLabel entityLabel;
    private static JComboBox<? extends String> comboBox;

    public void setGUI() {
        userFrame = new JFrame("Hospital Management - Client");
        userPanel = new JPanel();

        userFrame.setSize(450, 620);
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setLocationRelativeTo(null);

        userFrame.add(userPanel);
        userPanel.setLayout(null);
        userPanel.setBackground(Color.black);

        entityLabel = new JLabel("User Control");
        entityLabel.setForeground(Color.WHITE);
        entityLabel.setFont(new Font("Arial", Font.BOLD, 20));
        entityLabel.setBounds(150, 20, 120, 25);

        comboBox = new JComboBox<>(entities);
        comboBox.setBounds(150, 50, 130, 25);

        comboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String comboSelect = Objects.requireNonNull(comboBox.getSelectedItem()).toString();
                userArea.setText(comboSelect);
                switch (comboSelect) {
                    case " ":
                        System.out.println("Nothing Selected");
                        break;
                    case "Appointments":
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
                        try {
                            userArea.append(Client.getDoctors());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
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
                        try {
                            userArea.append(Client.getInvoices());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "Medical Aid":
                        try {
                            userArea.append(Client.getMedicalAids());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "Medicine":
                        try {
                            userArea.append(Client.getMedicines());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "Nurses":
                        try {
                            userArea.append(Client.getAllNurses());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "Patients":
                        try {
                            userArea.append(Client.getPatients());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "Secretaries":
                        try {
                            userArea.append(Client.getSecretaries());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                    case "Suppliers":
                        try {
                            userArea.append(Client.getSuppliers());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        break;
                }
            }
        });
        userArea = new JTextArea("========= Please Select an Item from the Drop down =========");
        userArea.setEditable(false);
        userArea.setBounds(20, 120, 390, 400);
        sp = new JScrollPane();
        sp.setBounds(20, 120, 390, 400);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.getViewport().setBackground(Color.WHITE);
        sp.getViewport().add(userArea);
        /* userArea.add(sp);*/

        backButton = new JButton("Back");
        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.RED);
        backButton.setBounds(170, 540, 80, 25);
        backButton.addActionListener(new User());

        userPanel.add(entityLabel);
        userPanel.add(backButton);
        userPanel.add(comboBox);
        userPanel.add(sp);
        userFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        userFrame.dispose();
        Login login = new Login();
        login.setGUI();
    }
}

