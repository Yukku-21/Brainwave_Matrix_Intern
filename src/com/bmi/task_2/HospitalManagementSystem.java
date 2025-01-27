package com.bmi.task_2;

import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {
    private Connection connection;

    public HospitalManagementSystem() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "admin");
            System.out.println("Database connection established successfully.");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    // Hospital Management
    public void addHospital(Hospital hospital) {
        try {
            String query = "INSERT INTO hospital_data (h_id, hospital_name, contact_no, address, city) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, hospital.getHId());
            stmt.setString(2, hospital.getHospitalName());
            stmt.setString(3, hospital.getContactNo());
            stmt.setString(4, hospital.getAddress());
            stmt.setString(5, hospital.getCity());

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Hospital added successfully." : "Failed to add hospital.");
        } catch (SQLException e) {
            System.out.println("Error: Could not add hospital. " + e.getMessage());
        }
    }

    public void displayHospitals() {
        try {
            String query = "SELECT * FROM hospital_data";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (!rs.isBeforeFirst()) {
                System.out.println("No hospitals found.");
            } else {
                while (rs.next()) {
                    System.out.println("Hospital ID: " + rs.getInt("h_id") +
                            ", Name: " + rs.getString("hospital_name") +
                            ", Contact No: " + rs.getString("contact_no") +
                            ", Address: " + rs.getString("address") +
                            ", City: " + rs.getString("city"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: Could not retrieve hospitals. " + e.getMessage());
        }
    }

    public void updateHospital(int hospitalId, String hospitalName, String contactNo, String address, String city) {
        try {
            String query = "UPDATE hospital_data SET hospital_name = ?, contact_no = ?, address = ?, city = ? WHERE h_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, hospitalName);
            stmt.setString(2, contactNo);
            stmt.setString(3, address);
            stmt.setString(4, city);
            stmt.setInt(5, hospitalId);

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Hospital details updated successfully." : "Hospital with ID " + hospitalId + " not found.");
        } catch (SQLException e) {
            System.out.println("Error: Could not update hospital. " + e.getMessage());
        }
    }

    public void deleteHospital(int hospitalId) {
        try {
            String query = "DELETE FROM hospital_data WHERE h_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, hospitalId);

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Hospital deleted successfully." : "Hospital with ID " + hospitalId + " not found.");
        } catch (SQLException e) {
            System.out.println("Error: Could not delete hospital. " + e.getMessage());
        }
    }

    // Doctor Management
    public void addDoctor(Doctor doctor) {
        try {
            String query = "INSERT INTO doctor_data (doctor_id, name, specialization, contact, h_id) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, doctor.getId());
            stmt.setString(2, doctor.getName());
            stmt.setString(3, doctor.getSpecialization());
            stmt.setString(4, doctor.getContact());
            stmt.setInt(5, doctor.getHospitalId());

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Doctor added successfully." : "Failed to add doctor.");
        } catch (SQLException e) {
            System.out.println("Error: Could not add doctor. " + e.getMessage());
        }
    }

    public void displayDoctors() {
        try {
            String query = "SELECT d.doctor_id, d.name, d.specialization, d.contact, h.hospital_name " +
                    "FROM doctor_data d " +
                    "JOIN hospital_data h ON d.h_id = h.h_id";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (!rs.isBeforeFirst()) {
                System.out.println("No doctors found.");
            } else {
                while (rs.next()) {
                    System.out.println("Doctor ID: " + rs.getInt("doctor_id") +
                            ", Name: " + rs.getString("name") +
                            ", Specialization: " + rs.getString("specialization") +
                            ", Contact: " + rs.getString("contact") +
                            ", Hospital: " + rs.getString("hospital_name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: Could not retrieve doctors. " + e.getMessage());
        }
    }

    public void updateDoctor(int doctorId, String name, String specialization, String contact) {
        try {
            String query = "UPDATE doctor_data SET name = ?, specialization = ?, contact = ? WHERE doctor_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, specialization);
            stmt.setString(3, contact);
            stmt.setInt(4, doctorId);

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Doctor details updated successfully." : "Doctor with ID " + doctorId + " not found.");
        } catch (SQLException e) {
            System.out.println("Error: Could not update doctor. " + e.getMessage());
        }
    }

    public void deleteDoctor(int doctorId) {
        try {
            String query = "DELETE FROM doctor_data WHERE doctor_id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, doctorId);

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Doctor deleted successfully." : "Doctor with ID " + doctorId + " not found.");
        } catch (SQLException e) {
            System.out.println("Error: Could not delete doctor. " + e.getMessage());
        }
    }

    // Patient Management
    public void addPatient(Patient patient, int doctorId) {
        try {
            String query = "INSERT INTO patient_data (id, name, age, gender, contact, doctor_id, disease) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, patient.getId());
            stmt.setString(2, patient.getName());
            stmt.setInt(3, patient.getAge());
            stmt.setString(4, patient.getGender());
            stmt.setString(5, patient.getContact());
            stmt.setInt(6, doctorId);
            stmt.setString(7, patient.getDisease());

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Patient added successfully." : "Failed to add patient.");
        } catch (SQLException e) {
            System.out.println("Error: Could not add patient. " + e.getMessage());
        }
    }

    public void displayPatients() {
        try {
            String query = "SELECT p.id, p.name, p.age, p.gender, p.contact, p.disease, d.name AS doctor_name " +
                    "FROM patient_data p " +
                    "JOIN doctor_data d ON p.doctor_id = d.doctor_id";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            if (!rs.isBeforeFirst()) {
                System.out.println("No patients found.");
            } else {
                while (rs.next()) {
                    System.out.println("Patient ID: " + rs.getString("id") +
                            ", Name: " + rs.getString("name") +
                            ", Age: " + rs.getInt("age") +
                            ", Gender: " + rs.getString("gender") +
                            ", Contact: " + rs.getString("contact") +
                            ", Disease: " + rs.getString("disease") +
                            ", Doctor: " + rs.getString("doctor_name"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: Could not retrieve patients. " + e.getMessage());
        }
    }

    public void updatePatient(String patientId, String name, int age, String gender, String contact, String disease) {
        try {
            String query = "UPDATE patient_data SET name = ?, age = ?, gender = ?, contact = ?, disease = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, gender);
            stmt.setString(4, contact);
            stmt.setString(5, disease);
            stmt.setString(6, patientId);

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Patient details updated successfully." : "Patient with ID " + patientId + " not found.");
        } catch (SQLException e) {
            System.out.println("Error: Could not update patient. " + e.getMessage());
        }
    }

    public void deletePatient(String patientId) {
        try {
            String query = "DELETE FROM patient_data WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, patientId);

            int rows = stmt.executeUpdate();
            System.out.println(rows > 0 ? "Patient deleted successfully." : "Patient with ID " + patientId + " not found.");
        } catch (SQLException e) {
            System.out.println("Error: Could not delete patient. " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Hospital Management System ---");
            System.out.println("1. Add Hospital");
            System.out.println("2. Display All Hospitals");
            System.out.println("3. Edit Hospital");
            System.out.println("4. Delete Hospital");
            System.out.println("5. Add Doctor");
            System.out.println("6. Display All Doctors");
            System.out.println("7. Edit Doctor");
            System.out.println("8. Delete Doctor");
            System.out.println("9. Add Patient");
            System.out.println("10. Display All Patients");
            System.out.println("11. Edit Patient");
            System.out.println("12. Delete Patient");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Hospital ID: ");
                    int hospitalId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Hospital Name: ");
                    String hospitalName = scanner.nextLine();
                    System.out.print("Enter Contact No: ");
                    String contactNo = scanner.nextLine();
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();
                    hms.addHospital(new Hospital(hospitalId, hospitalName, contactNo, address, city));
                    break;
                case 2:
                    hms.displayHospitals();
                    break;
                case 3:
                    System.out.print("Enter Hospital ID to edit: ");
                    int editHospitalId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Hospital Name: ");
                    String newHospitalName = scanner.nextLine();
                    System.out.print("Enter New Contact No: ");
                    String newContactNo = scanner.nextLine();
                    System.out.print("Enter New Address: ");
                    String newAddress = scanner.nextLine();
                    System.out.print("Enter New City: ");
                    String newCity = scanner.nextLine();
                    hms.updateHospital(editHospitalId, newHospitalName, newContactNo, newAddress, newCity);
                    break;
                case 4:
                    System.out.print("Enter Hospital ID to delete: ");
                    int deleteHospitalId = scanner.nextInt();
                    hms.deleteHospital(deleteHospitalId);
                    break;
                case 5:
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter Specialization: ");
                    String specialization = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String doctorContact = scanner.nextLine();
                    System.out.print("Enter Hospital ID: "); // Input for h_id
                    int associatedHospitalId = scanner.nextInt(); // Rename variable here
                    hms.addDoctor(new Doctor(doctorId, doctorName, specialization, doctorContact, associatedHospitalId));
                    break;
                case 6:
                    hms.displayDoctors();
                    break;
                case 7:
                    System.out.print("Enter Doctor ID to edit: ");
                    int editDoctorId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Doctor Name: ");
                    String newDoctorName = scanner.nextLine();
                    System.out.print("Enter New Specialization: ");
                    String newSpecialization = scanner.nextLine();
                    System.out.print("Enter New Contact: ");
                    String newDoctorContact = scanner.nextLine();
                    hms.updateDoctor(editDoctorId, newDoctorName, newSpecialization, newDoctorContact);
                    break;
                case 8:
                    System.out.print("Enter Doctor ID to delete: ");
                    int deleteDoctorId = scanner.nextInt();
                    hms.deleteDoctor(deleteDoctorId);
                    break;
                case 9:
                    System.out.print("Enter Patient ID: ");
                    String patientId = scanner.nextLine();
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Patient Age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter Contact: ");
                    String patientContact = scanner.nextLine();
                    System.out.print("Enter Disease: ");
                    String disease = scanner.nextLine();
                    System.out.print("Enter Doctor ID: ");
                    int assignedDoctorId = scanner.nextInt();
                    hms.addPatient(new Patient(patientId, patientName, patientAge, gender, patientContact, disease), assignedDoctorId);
                    break;
                case 10:
                    hms.displayPatients();
                    break;
                case 11:
                    System.out.print("Enter Patient ID to edit: ");
                    String editPatientId = scanner.nextLine();
                    System.out.print("Enter New Patient Name: ");
                    String newPatientName = scanner.nextLine();
                    System.out.print("Enter New Patient Age: ");
                    int newPatientAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Gender: ");
                    String newGender = scanner.nextLine();
                    System.out.print("Enter New Contact: ");
                    String newPatientContact = scanner.nextLine();
                    System.out.print("Enter New Disease: ");
                    String newDisease = scanner.nextLine();
                    hms.updatePatient(editPatientId, newPatientName, newPatientAge, newGender, newPatientContact, newDisease);
                    break;
                case 12:
                    System.out.print("Enter Patient ID to delete: ");
                    String deletePatientId = scanner.nextLine();
                    hms.deletePatient(deletePatientId);
                    break;
                case 13:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 13);

        scanner.close();
    }
}
