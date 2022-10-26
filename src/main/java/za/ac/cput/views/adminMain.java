package za.ac.cput.views;

import org.json.JSONObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.util.Objects;

public class adminMain extends JFrame{
    String entity = " ";
    JTextField deleteText = new JTextField();

    JFrame frame = new JFrame("Administrator - Hospital Management");
    JComboBox menuComboBox = new JComboBox();
    String[] departments = {" ", "Nurse", "Cleaning Staff", "Room", "Patient", "Medical Aid", "Doctor", "Appointment", "Secretary", "Invoice", "Medicine", "Driver", "Supplier"};


    JButton createButton = new JButton("Create");
    JButton deleteButton = new JButton("Delete");
    JButton readByIdButton = new JButton("Read by ID");
    JButton backButton = new JButton("Back");

    JLabel readLabel = new JLabel("Entities on Database");
    JLabel adminLabel = new JLabel("Admin Control");

    public void showGUI() {
        for (String item : departments) {
            menuComboBox.addItem(item);
        }
        menuComboBox.setBounds(200, 50, 150, 30);
        createButton.setBounds(20, 130, 100, 25);
        deleteButton.setBounds(420, 130, 100, 25);
        readByIdButton.setBounds(220, 130, 100, 25);
        backButton.setBounds(220, 545, 100, 25);

        readLabel.setBounds(200, 180, 200, 25);

        createButton.setForeground(Color.BLACK);
        createButton.setBackground(Color.white);

        deleteButton.setForeground(Color.BLACK);
        deleteButton.setBackground(Color.white);

        readByIdButton.setForeground(Color.BLACK);
        readByIdButton.setBackground(Color.white);

        backButton.setForeground(Color.WHITE);
        backButton.setBackground(Color.RED);

        JTextArea textArea = new JTextArea();
        JScrollPane sp = new JScrollPane();
        sp.setBounds(60, 220, 430, 320);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.getViewport().setBackground(Color.WHITE);
        sp.getViewport().add(textArea);

        textArea.setEditable(false);
        textArea.setText("==================== Please Select an Entity ====================");
        textArea.setBounds(60, 220, 430, 320);

        frame.setSize(560, 620);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);

        adminLabel.setForeground(Color.WHITE);
        adminLabel.setFont(new Font("Arial", Font.BOLD, 20));
        adminLabel.setBounds(210, 10, 150, 25);

        readLabel.setForeground(Color.WHITE);
        readLabel.setFont(new Font("Arial", Font.BOLD, 16));


        frame.add(adminLabel);
        frame.add(sp);
        frame.add(menuComboBox);
        frame.add(createButton);
        frame.add(readLabel);
        frame.add(readByIdButton);
        frame.add(deleteButton);
        frame.add(backButton);

        backButton.addActionListener(ae ->{
            frame.setVisible(false);
            frame.dispose();
            Login login = new Login();
            login.setGUI();
        });
        menuComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String comboSelect = Objects.requireNonNull(menuComboBox.getSelectedItem().toString());
                switch (comboSelect) {
                    case " ":
                        textArea.setText(" ");
                        textArea.setText("==================== Please Select an Entity ====================");
                        break;

                    case "Nurse":
                        entity = "nurse";
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
                                String nurseId = "";
                                String nurseFname = JOptionPane.showInputDialog("Please enter the nurse's first name");
                                String nurseLname = JOptionPane.showInputDialog("Please enter the nurse's last name");
                            }
                        });
                        readByIdButton.addActionListener(ae -> {
                            String nurseGetId = JOptionPane.showInputDialog("Please enter the ID of the nurse you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String nurseDeleteId = JOptionPane.showInputDialog(frame, "Please enter the ID of the nurse you would like to delete.");
                            try {
                                HttpConnect.connectionDELETE(entity, nurseDeleteId);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getAllNurses());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }

                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;

                    case "Cleaning Staff":
                        try {
                            textArea.setText(Client.getAllCleaningStaff());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String cleanStaffFname = JOptionPane.showInputDialog("Please enter the staff member's first name");
                            String cleanStaffLname = JOptionPane.showInputDialog("Please enter the staff member's last name");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String cleanStaffGetId = JOptionPane.showInputDialog("Please enter the ID of the cleaning staff member you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String cleanStaffDeleteId = JOptionPane.showInputDialog(frame,"Please enter the ID of the staff member you would like to delete.");
                            entity = "cleaningStaff";
                            try {
                                HttpConnect.connectionDELETE(entity, cleanStaffDeleteId);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getAllCleaningStaff());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }

                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;

                    case "Room":
                        try {
                            textArea.setText(Client.getAllHospitalRooms());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String roomFloor = JOptionPane.showInputDialog("Please enter the room floor");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String roomFloorGetId = JOptionPane.showInputDialog("Please enter the ID of the room you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String roomFloorDeleteId = JOptionPane.showInputDialog(frame,"Please enter the ID of the room you would like to delete.");

                            entity = "hospitalroom";
                            try {
                                HttpConnect.connectionDELETE(entity, roomFloorDeleteId);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getAllHospitalRooms());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;

                    case "Patient":
                        try {
                            textArea.setText(Client.getPatients());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String patientFname = JOptionPane.showInputDialog("Please enter the patient's first name.");
                            String patientLname = JOptionPane.showInputDialog("Please enter the patient's last name.");
                            String patientAddress = JOptionPane.showInputDialog("Please enter the patient's address.");
                            String patientCell = JOptionPane.showInputDialog("Please enter the patient's cell number,");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String patientIdRead = JOptionPane.showInputDialog("Please enter the ID of the patient you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String patientIdDelete = JOptionPane.showInputDialog(frame,"Please enter the ID of the patient you would like to delete.");
                            entity = "patient";
                            try {
                                HttpConnect.connectionDELETE(entity, patientIdDelete);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getPatients());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;

                    case "Medical Aid":
                        try {
                            textArea.setText(Client.getMedicalAids());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String medicalAidName = JOptionPane.showInputDialog("Please enter the medical aid name.");
                            String medicalAidAddress = JOptionPane.showInputDialog("Please enter the medical aid address.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String medicalAidIdRead = JOptionPane.showInputDialog("Please enter the ID of the medical aid you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String medicalAidIdDelete = JOptionPane.showInputDialog(frame,"Please enter the ID of the medical aid you would like to delete.");
                            entity = "medicalaid";
                            try {
                                HttpConnect.connectionDELETE(entity, medicalAidIdDelete);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getMedicalAids());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;

                    case "Doctor":
                        try {
                            textArea.setText(Client.getDoctors());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String doctorFname = JOptionPane.showInputDialog("Please enter the doctor's first name.");
                            String doctorLname = JOptionPane.showInputDialog("Please enter the doctor's last name.");
                            String doctorCell = JOptionPane.showInputDialog("Please enter the doctor's cell number,");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String doctorIdRead = JOptionPane.showInputDialog("Please enter the ID of the doctor you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String doctorIdDelete = JOptionPane.showInputDialog(frame,"Please enter the ID of the doctor you would like to delete.");
                            entity = "doctor";
                            try {
                                HttpConnect.connectionDELETE(entity, doctorIdDelete);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getDoctors());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;

                    case "Appointment":
                        try {
                            textArea.setText(Client.getAllAppointments());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String appointmentTime = JOptionPane.showInputDialog("Please enter the time of the appointment.");
                            String appointmentDuration = JOptionPane.showInputDialog("Please enter the appointment duration.");
                            String appointmentDate = JOptionPane.showInputDialog("Please enter the appointment date.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String appointmentIdRead = JOptionPane.showInputDialog("Please enter the id of the appointment.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String appointmentIdDelete = JOptionPane.showInputDialog(frame,"Please enter the id of the appointment.");
                            entity = "appointment";
                            try {
                                HttpConnect.connectionDELETE(entity, appointmentIdDelete);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getAllAppointments());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;

                    case "Secretary":
                        try {
                            textArea.setText(Client.getSecretaries());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String secretaryFname = JOptionPane.showInputDialog("Please enter the secretary's first name.");
                            String secretaryLname = JOptionPane.showInputDialog("Please enter the secretary's last name.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String secretaryIdRead = JOptionPane.showInputDialog("Please enter the id of the secretary you're looking for.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String secretaryIdDelete = JOptionPane.showInputDialog(frame,"Please enter the id of the secretary you would like to delete.");
                            entity = "secretary";
                            try {
                                HttpConnect.connectionDELETE(entity, secretaryIdDelete);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getSecretaries());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;

                    case "Invoice":
                        try {
                            textArea.setText(Client.getInvoices());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String invoiceType = JOptionPane.showInputDialog("Please enter the invoice type.");
                            String invoiceDate = JOptionPane.showInputDialog("Please enter the invoice date.");
                            String invoiceAmount = JOptionPane.showInputDialog("Please enter the invoice amount.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String invoiceNumRead = JOptionPane.showInputDialog("Please enter the invoice number.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String invoiceNumDelete = JOptionPane.showInputDialog(frame,"Please enter the invoice number you would like to delete.");
                            entity = "invoice";
                            try {
                                HttpConnect.connectionDELETE(entity, invoiceNumDelete);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getInvoices());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;
                    case "Medicine":
                        try {
                            textArea.setText(Client.getMedicines());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String medicineAmount = JOptionPane.showInputDialog("Please enter the amount for this medicine.");
                            String medicineType = JOptionPane.showInputDialog("What type of medicine is this?.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String medicineNumRead = JOptionPane.showInputDialog("Please enter the ID of the medicine you would like to find.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String medicineNumDelete = JOptionPane.showInputDialog(frame,"Please enter the medicine ID you would like to delete.");
                            entity = "medicine";
                            try {
                                HttpConnect.connectionDELETE(entity, medicineNumDelete);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getMedicines());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;

                    case "Driver":
                        try {
                            textArea.setText(Client.getAllDrivers());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String driverFname = JOptionPane.showInputDialog("Please enter the driver's first name.");
                            String driverLname = JOptionPane.showInputDialog("Please enter the driver's last name.");
                            String driverlicenseNum = JOptionPane.showInputDialog("Please enter the license number.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String driverIDRead = JOptionPane.showInputDialog("Please enter the ID of the driver.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String driverIDDelete = JOptionPane.showInputDialog(frame,"Please enter the ID of the driver you would like to delete.");
                            entity = "driver";
                            try {
                                HttpConnect.connectionDELETE(entity, driverIDDelete);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getAllDrivers());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;

                    case "Supplier":
                        try {
                            textArea.setText(Client.getSuppliers());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String supplierAddress = JOptionPane.showInputDialog("Please enter the supplier's address.");
                            String supplierRegNum = JOptionPane.showInputDialog("Please enter the supplier's registration number.");
                        });
                        readByIdButton.addActionListener(ae -> {
                            String supplierIdRead = JOptionPane.showInputDialog("Please enter the ID of the supplier.");
                        });
                        deleteButton.addActionListener(ae -> {
                            String supplierIdDelete = JOptionPane.showInputDialog(frame,"Please enter the ID of the supplier you would like to delete.");
                            entity = "supplier";
                            try {
                                HttpConnect.connectionDELETE(entity, supplierIdDelete);
                                textArea.setText(" ");
                                //Set the text area again
                                try {
                                    textArea.setText(Client.getSuppliers());
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        break;


                }
            }
        });
        frame.setVisible(true);
    }

}
