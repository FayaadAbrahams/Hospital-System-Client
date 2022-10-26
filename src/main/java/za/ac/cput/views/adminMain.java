package za.ac.cput.views;

import org.json.JSONObject;
import za.ac.cput.util.StringHelper;

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
    JComboBox<? extends String> menuComboBox = new JComboBox<>();
    String[] departments = {" ", "Nurse", "Cleaning Staff", "Room", "Patient", "Medical Aid", "Doctor", "Appointment", "Secretary", "Invoice", "Medicine", "Driver", "Supplier"};


    JButton createButton = new JButton("Create");
    JButton deleteButton = new JButton("Delete");
    JButton readByIdButton = new JButton("Read by ID");
    JButton backButton = new JButton("Back");

    JLabel readLabel = new JLabel("Entities on Database");
    JLabel adminLabel = new JLabel("Admin Control");

    public void showGUI() {
       menuComboBox = new JComboBox<>(departments);
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
<<<<<<< HEAD
                    break;
=======
                        break;

>>>>>>> 0105144f39923b5ef6527f62e10c7a4914d8b7c7
                    case "Nurse":
                        entity = "nurse";
                        try {
                            textArea.setText(Client.getAllNurses());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {
<<<<<<< HEAD
                                String id = StringHelper.generateUnqiueID();
                                String fname = JOptionPane.showInputDialog("Please enter the nurse's first name");
                                String lname = JOptionPane.showInputDialog("Please enter the nurse's last name");

                                try {
                                    Client.postNurse(id, fname, lname);
                                    JOptionPane.showMessageDialog(null, "Nurse entered successfully");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
=======
                                String nurseId = "";
                                String nurseFname = JOptionPane.showInputDialog("Please enter the nurse's first name");
                                String nurseLname = JOptionPane.showInputDialog("Please enter the nurse's last name");
>>>>>>> 0105144f39923b5ef6527f62e10c7a4914d8b7c7
                            }
                        });
                        readByIdButton.addActionListener(ae -> {
                            String nurseGetId = JOptionPane.showInputDialog("Please enter the ID of the nurse you're looking for.");
                            try {
                                if(nurseGetId != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, nurseGetId);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
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
                        entity = "cleaningStaff";
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
                            try {
                                if(cleanStaffGetId != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, cleanStaffGetId);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        deleteButton.addActionListener(ae -> {
                            String cleanStaffDeleteId = JOptionPane.showInputDialog(frame,"Please enter the ID of the staff member you would like to delete.");
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
                        entity = "hospitalroom";
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
                            try {
                                if(roomFloorGetId != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, roomFloorGetId);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        deleteButton.addActionListener(ae -> {
                            String roomFloorDeleteId = JOptionPane.showInputDialog(frame,"Please enter the ID of the room you would like to delete.");
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
                        entity = "medicalaid";
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
                            try {
                                if(medicalAidIdRead != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, medicalAidIdRead);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        deleteButton.addActionListener(ae -> {
                            String medicalAidIdDelete = JOptionPane.showInputDialog(frame,"Please enter the ID of the medical aid you would like to delete.");

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
                        entity = "doctor";
                        try {
                            textArea.setText(Client.getDoctors());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String id = StringHelper.generateUnqiueID();
                            String doctorFname = JOptionPane.showInputDialog("Please enter the doctor's first name.");
                            String doctorLname = JOptionPane.showInputDialog("Please enter the doctor's last name.");
                            String doctorCell = JOptionPane.showInputDialog("Please enter the doctor's cell number,");

                            try
                            {
                                Client.postDoctor(id, doctorFname, doctorLname, doctorCell);
                                JOptionPane.showMessageDialog(null, "Doctor entered successfully");
                            }
                            catch(Exception exception)
                            {
                                exception.printStackTrace();
                            }
                        });
                        readByIdButton.addActionListener(ae -> {
                            String doctorIdRead = JOptionPane.showInputDialog("Please enter the ID of the doctor you're looking for.");
                            try {
                                if(doctorIdRead != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, doctorIdRead);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        deleteButton.addActionListener(ae -> {
                            String doctorIdDelete = JOptionPane.showInputDialog(frame,"Please enter the ID of the doctor you would like to delete.");
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
                        entity = "appointment";
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
                            try {
                                if(appointmentIdRead != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, appointmentIdRead);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        deleteButton.addActionListener(ae -> {
                            String appointmentIdDelete = JOptionPane.showInputDialog(frame,"Please enter the id of the appointment.");
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
                        entity = "secretary";
                        try {
                            textArea.setText(Client.getSecretaries());
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                        createButton.addActionListener(ae -> {
                            String id = StringHelper.generateUnqiueID();
                            String secretaryFname = JOptionPane.showInputDialog("Please enter the secretary's first name.");
                            String secretaryLname = JOptionPane.showInputDialog("Please enter the secretary's last name.");
                            try
                            {
                                //Client.postDoctor(id, doctorFname, doctorLname, doctorCell);
                                JOptionPane.showMessageDialog(null, "Secretary entered successfully");
                            }
                            catch(Exception exception)
                            {
                                exception.printStackTrace();
                            }
                        });
                        readByIdButton.addActionListener(ae -> {
                            String secretaryIdRead = JOptionPane.showInputDialog("Please enter the id of the secretary you're looking for.");
                            try {
                                if(secretaryIdRead != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, secretaryIdRead);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        deleteButton.addActionListener(ae -> {
                            String secretaryIdDelete = JOptionPane.showInputDialog(frame,"Please enter the id of the secretary you would like to delete.");

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
                        entity = "invoice";
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
                            try {
                                if(invoiceNumRead != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, invoiceNumRead);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        deleteButton.addActionListener(ae -> {
                            String invoiceNumDelete = JOptionPane.showInputDialog(frame,"Please enter the invoice number you would like to delete.");
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
<<<<<<< HEAD

=======
>>>>>>> 0105144f39923b5ef6527f62e10c7a4914d8b7c7
                    case "Medicine":
                        entity = "medicine";
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
                            try {
                                if(medicineNumRead != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, medicineNumRead);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        deleteButton.addActionListener(ae -> {
                            String medicineNumDelete = JOptionPane.showInputDialog(frame,"Please enter the medicine ID you would like to delete.");

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
                        entity = "driver";
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
                            try {
                                if(driverIDRead != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, driverIDRead);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        deleteButton.addActionListener(ae -> {
                            String driverIDDelete = JOptionPane.showInputDialog(frame,"Please enter the ID of the driver you would like to delete.");
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
                        entity = "supplier";
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
                            try {
                                if(supplierIdRead != null) {
                                    String prettyString = HttpConnect.connectionREAD(entity, supplierIdRead);
                                    textArea.setText(prettyString);
                                }
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        });
                        deleteButton.addActionListener(ae -> {
                            String supplierIdDelete = JOptionPane.showInputDialog(frame,"Please enter the ID of the supplier you would like to delete.");
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
<<<<<<< HEAD
=======


>>>>>>> 0105144f39923b5ef6527f62e10c7a4914d8b7c7
                }
            }
        });
        frame.setVisible(true);
    }

}
