package za.ac.cput.views;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.Objects;

public class adminMain extends JFrame implements ActionListener {
    JFrame frame = new JFrame("Administrator - Hospital Management");
    JComboBox menuComboBox = new JComboBox();
    String[] departments = {" ", "Nurse", "Cleaning Staff", "Room", "Patient", "Medical Aid", "Doctor", "Appointment", "Secretary", "Invoice", "Medicine", "Driver", "Supplier"};


    JButton createButton = new JButton("Create");
    JButton deleteButton = new JButton("Delete");
    JButton readAllButton = new JButton("Read all");
    JButton readByIdButton = new JButton("Read by ID");
    JButton backButton = new JButton("Back");

    JLabel adminLabel = new JLabel("Admin Control");

    public void showGUI() {
        for (String item : departments) {
            menuComboBox.addItem(item);
        }
        menuComboBox.setBounds(200, 50, 150, 30);
        createButton.setBounds(20, 120, 100, 25);
        deleteButton.setBounds(420, 120, 100, 25);
        readByIdButton.setBounds(220, 120, 100, 25);
        readAllButton.setBounds(220, 160, 100, 25);
        backButton.setBounds(220, 535, 100, 25);

        createButton.setForeground(Color.BLACK);
        createButton.setBackground(Color.white);

        deleteButton.setForeground(Color.BLACK);
        deleteButton.setBackground(Color.white);

        readByIdButton.setForeground(Color.BLACK);
        readByIdButton.setBackground(Color.white);

        readAllButton.setForeground(Color.BLACK);
        readAllButton.setBackground(Color.white);

        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.RED);
        backButton.addActionListener(new adminMain());

        JTextArea textArea = new JTextArea();
        JScrollPane sp = new JScrollPane();
        sp.setBounds(60, 200, 430, 320);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.getViewport().setBackground(Color.WHITE);
        sp.getViewport().add(textArea);

        textArea.setEditable(false);
        textArea.setBounds(60, 200, 430, 320);

        frame.setSize(560, 610);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        adminLabel.setForeground(Color.WHITE);
        adminLabel.setFont(new Font("Arial", Font.BOLD, 20));
        adminLabel.setBounds(210, 10, 150, 25);

        frame.add(adminLabel);
        frame.add(sp);
        frame.add(menuComboBox);
        frame.add(createButton);
        frame.add(readAllButton);
        frame.add(readByIdButton);
        frame.add(deleteButton);
        frame.add(backButton);

        menuComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String comboSelect = Objects.requireNonNull(menuComboBox.getSelectedItem().toString());
                switch (comboSelect) {
                    case " " -> {
                        textArea.setText(" ");
                        textArea.setText("==================== Please Select an Entity ====================");
                    }
                    case "Nurse" -> { //Nurse
                        try {
                            textArea.setText(Client.getAllNurses());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(new ActionListener() {

                            public JSONObject prepJson(String str1, String str2, String str3) {
                                JSONObject jObject = new JSONObject();
                                jObject.put("nurseID", str1);
                                jObject.put("nurseFirstName", str2);
                                jObject.put("nurseLastName", str3);
                                return jObject;
                            }

                            @Override
                            public void actionPerformed(ActionEvent ae) {
                                String id = "";
                                String fname = JOptionPane.showInputDialog("Please enter the nurse's first name");
                                String lname = JOptionPane.showInputDialog("Please enter the nurse's last name");

//                        String json = "{"+"nurseID"+":"+"'"+id+"'"+","
//                            +"nurseFirstName"+":"+"'"+fname+"'"+","
//                            +"nurseLastName"+":"+"'"+lname+"'"+"}";
//                        System.out.println(json);

                                JSONObject sendObj = prepJson(id, fname, lname);
                                String reqString = sendObj.toString();
                                String url = "http://localhost:8080/hospital system/nurse";

                                String response = HttpConnect.post(url, reqString);
                            }
                        });
                        readByIdButton.addActionListener(ae -> {
                            String nurseGetId = JOptionPane.showInputDialog("Please enter the id of the nurse you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String nurseDeleteId = JOptionPane.showInputDialog("Please enter the id of the nurse you would like to delete.");
                        });
                    }
                    case "Cleaning Staff" -> {
                        try {
                            textArea.setText(Client.getAllCleaningStaff());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String fname = JOptionPane.showInputDialog("Please enter the staff member's first name");
                            String lname = JOptionPane.showInputDialog("Please enter the staff member's last name");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String staffGetId = JOptionPane.showInputDialog("Please enter the id of the cleaning staff member you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String staffDeleteId = JOptionPane.showInputDialog("Please enter the id of the staff member you would like to delete.");
                        });
                    }
                    case "Room" -> {
                        try {
                            textArea.setText(Client.getAllHospitalRooms());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String roomFloor = JOptionPane.showInputDialog("Please enter the room floor");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String roomFloorGetId = JOptionPane.showInputDialog("Please enter the id of the room you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String roomFloorDeleteId = JOptionPane.showInputDialog("Please enter the id of the room you would like to delete.");
                        });
                    }
                    case "Patient" -> {
                        try {
                            textArea.setText(Client.getPatients());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String fname = JOptionPane.showInputDialog("Please enter the patient's first name.");
                            String lname = JOptionPane.showInputDialog("Please enter the patient's last name.");
                            String address = JOptionPane.showInputDialog("Please enter the patient's address.");
                            String cell = JOptionPane.showInputDialog("Please enter the patient's cell number,");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String patientId = JOptionPane.showInputDialog("Please enter the id of the patient you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String patientId = JOptionPane.showInputDialog("Please enter the id of the patient you would like to delete.");
                        });
                    }
                    case "Medical Aid" -> {
                        try {
                            textArea.setText(Client.getMedicalAids());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String name = JOptionPane.showInputDialog("Please enter the medical aid name.");
                            String address = JOptionPane.showInputDialog("Please enter the medical aid address.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String medicalAidId = JOptionPane.showInputDialog("Please enter the id of the medical aid you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String medicalAidId = JOptionPane.showInputDialog("Please enter the id of the medical aid you would like to delete.");
                        });
                    }
                    case "Doctor" -> {
                        try {
                            textArea.setText(Client.getDoctors());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String fname = JOptionPane.showInputDialog("Please enter the doctor's first name.");
                            String lname = JOptionPane.showInputDialog("Please enter the doctor's last name.");
                            String cell = JOptionPane.showInputDialog("Please enter the doctor's cell number,");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String doctorId = JOptionPane.showInputDialog("Please enter the id of the doctor you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String doctorId = JOptionPane.showInputDialog("Please enter the id of the doctor you would like to delete.");
                        });
                    }
                    case "Appointment" -> {
                        try {
                            textArea.setText(Client.getAllAppointments());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String time = JOptionPane.showInputDialog("Please enter the time of the appointment.");
                            String duration = JOptionPane.showInputDialog("Please enter the appointment duration.");
                            String date = JOptionPane.showInputDialog("Please enter the appointment date.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String appointmentId = JOptionPane.showInputDialog("Please enter the id of the appointment.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String appointmentId = JOptionPane.showInputDialog("Please enter the id of the appointment.");
                        });
                    }
                    case "Secretary" -> {
                        try {
                            textArea.setText(Client.getSecretaries());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String fname = JOptionPane.showInputDialog("Please enter the secretary's first name.");
                            String lname = JOptionPane.showInputDialog("Please enter the secretary's last name.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String secretaryId = JOptionPane.showInputDialog("Please enter the id of the secretary you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String secretaryId = JOptionPane.showInputDialog("Please enter the id of the secretary you would like to delete.");
                        });
                    }
                    case "Invoice" -> {
                        try {
                            textArea.setText(Client.getInvoices());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String type = JOptionPane.showInputDialog("Please enter the invoice type.");
                            String date = JOptionPane.showInputDialog("Please enter the invoice date.");
                            String amount = JOptionPane.showInputDialog("Please enter the invoice amount.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String invoiceNum = JOptionPane.showInputDialog("Please enter the invoice number.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String invoiceNum = JOptionPane.showInputDialog("Please enter the invoice number you would like to delete.");
                        });
                    }
                    case "Medicine" -> {
                        try {
                            textArea.setText(Client.getMedicines());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String amount = JOptionPane.showInputDialog("Please enter the amount for this medicine.");
                            String type = JOptionPane.showInputDialog("What type of medicine is this?.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String medicineId = JOptionPane.showInputDialog("Please enter the ID of the medicine you would like to find.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String medicineNum = JOptionPane.showInputDialog("Please enter the medicine ID you would like to delete.");
                        });
                    }
                    case "Driver" -> {
                        try {
                            textArea.setText(Client.getAllDrivers());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String fname = JOptionPane.showInputDialog("Please enter the driver's first name.");
                            String lname = JOptionPane.showInputDialog("Please enter the driver's last name.");
                            String licenseNum = JOptionPane.showInputDialog("Please enter the license number.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String driverID = JOptionPane.showInputDialog("Please enter the ID of the driver.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String driverID = JOptionPane.showInputDialog("Please enter the ID of the driver you would like to delete.");
                        });
                    }
                    case "Supplier" -> {
                        try {
                            textArea.setText(Client.getSuppliers());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String address = JOptionPane.showInputDialog("Please enter the supplier's address.");
                            String regNum = JOptionPane.showInputDialog("Please enter the supplier's registration number.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String supplier = JOptionPane.showInputDialog("Please enter the ID of the supplier.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String supplierID = JOptionPane.showInputDialog("Please enter the ID of the supplier you would like to delete.");
                        });
                    }
                }
            }
        });
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.setVisible(false);
        frame.dispose();
        Login login = new Login();
        login.setGUI();
    }
}
