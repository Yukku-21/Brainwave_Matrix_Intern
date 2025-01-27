# 🌟 Hospital Management System 🌟

This **Hospital Management System** is a robust, Java-based application for managing hospitals, doctors, and patients. The system is connected to a **MySQL database** via **JDBC** for efficient data management. The application is designed to streamline hospital operations, making it easier for staff to manage hospital, doctor, and patient details in real-time.

---

### **✨ Key Features** ✨

#### 🏥 **Hospital Management**
- **📋 CRUD Operations**: Create, read, update, and delete hospital details with a simple interface.
- **🔍 Search & Filter**: Easily search hospitals by name or city.
- **📊 Dashboard Analytics**: Provides insights on hospital data, such as the number of doctors and patients.

#### 👩‍⚕️ **Doctor Management**
- **👨‍⚕️ Doctor Profile**: Add and manage doctor profiles, including their specialization, contact info, and associated hospital.
- **🔗 Doctor-Hospital Link**: Link doctors to specific hospitals for better organization.

#### 🏥 **Patient Management**
- **👨‍⚕️ Patient Records**: Add, view, and manage patient information, including medical history, disease details, and assigned doctor.
- **🔗 Doctor-Patient Link**: Associate each patient with a specific doctor for efficient tracking.
  
#### 📅 **Appointment Management**
- **🗓️ Manage Appointments**: Patients can book appointments with doctors, view available time slots, and confirm bookings.
- **🩺 Doctor Availability**: Doctors can update their available time slots for appointments.
- **💬 Notifications**: Automatic notifications for both patients and doctors for upcoming appointments.
- **🔄 Rescheduling**: Allows patients or admins to reschedule appointments based on doctor availability.

---

### **🔧 Advanced Technologies & Tools**

- **💻 Java 8+**: Utilizes the latest Java features for performance and scalability.
- **🗄️ MySQL Database**: Store hospital, doctor, and patient data securely in a relational database.
- **🔗 JDBC**: Efficient database connection for retrieving and updating data.
- **🖥️ Eclipse IDE**: Development environment used for building and running the application.

---

### **💎 System Workflow** 💎

1. **Login**: Admin can log in to the system with credentials.
2. **Hospital Management**: Admin can add new hospitals, view existing hospitals, edit details, or delete records.
3. **Doctor Management**: Admin can manage doctor information by adding, viewing, updating, or removing doctors. Each doctor can be associated with a specific hospital.
4. **Patient Management**: Admin can add new patients, view their records, update their details, or delete their profiles. Patients are linked to doctors for treatment management.

---

### **🖥️ Database Schema**

#### 🏥 **hospital_data**
| Column           | Data Type   | Description           |
|------------------|-------------|-----------------------|
| `h_id`           | INT         | Primary Key (Hospital ID) |
| `hospital_name`  | VARCHAR     | Hospital Name         |
| `contact_no`     | VARCHAR     | Contact Number        |
| `address`        | VARCHAR     | Hospital Address      |
| `city`           | VARCHAR     | City                  |

#### 👩‍⚕️ **doctor_data**
| Column           | Data Type   | Description           |
|------------------|-------------|-----------------------|
| `doctor_id`      | INT         | Primary Key (Doctor ID) |
| `name`           | VARCHAR     | Doctor's Name         |
| `specialization` | VARCHAR     | Doctor's Specialization |
| `contact`        | VARCHAR     | Contact Number        |
| `h_id`           | INT         | Associated Hospital ID |

#### 🏥 **patient_data**
| Column           | Data Type   | Description           |
|------------------|-------------|-----------------------|
| `id`             | VARCHAR     | Patient ID (Primary Key) |
| `name`           | VARCHAR     | Patient Name          |
| `age`            | INT         | Age                   |
| `gender`         | VARCHAR     | Gender                |
| `contact`        | VARCHAR     | Contact Number        |
| `disease`        | VARCHAR     | Disease Description   |
| `doctor_id`      | INT         | Associated Doctor ID  |

#### 📅 **appointment_data**
| Column           | Data Type   | Description           |
|------------------|-------------|-----------------------|
| `appointment_id` | INT         | Primary Key (Appointment ID) |
| `patient_id`     | VARCHAR     | Associated Patient ID |
| `doctor_id`      | INT         | Associated Doctor ID  |
| `appointment_date` | DATETIME  | Appointment Date & Time |
| `status`         | VARCHAR     | Status (Scheduled, Completed, Cancelled) |

---

### **📋 Project Details**

  #### **🖥️ Menu Options**

The program provides the following options in the main menu:

1. Add Hospital
2. Display All Hospitals
3. Edit Hospital
4. Delete Hospital
5. Add Doctor
6. Display All Doctors
7. Edit Doctor
8. Delete Doctor
9. Add Patient
10. Display All Patients
11. Edit Patient
12. Delete Patient
13. Exit

---

### **🔧 Future Enhancements**
- **Servlet Integration**: Implement **Servlets** for dynamic web content, allowing the application to be run as a web application.
- **User Authentication**: Add user authentication for different roles (Admin, Doctor, Patient).
- **UI Improvements**: Integrate **JavaFX** for a modern and interactive frontend.
- **Reporting**: Add reporting and data analysis features, such as patient statistics, doctor performance, etc.

---

### **🔗 Links**
- [GitHub Repository](<repository-url>)
- [MySQL Documentation](https://dev.mysql.com/doc/)
- [Java Documentation](https://docs.oracle.com/en/java/)

---

