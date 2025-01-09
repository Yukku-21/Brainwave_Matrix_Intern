# 💳 Fully Functional ATM Interface

## 🚀 Overview
Welcome to the **ATM Intrface System**! This simple yet **ATM simulation** allows you to perform **basic banking operations** such as **checking balance**, **depositing**, **withdrawing**, and **viewing transaction history**. Built with **Java**, this project simulates a real-world ATM experience with a **user-friendly console interface**.

---

## ✨ Key Features
- **🔒 Secure Authentication**: Log in using your **account number** and **PIN**.
- **💰 Balance Checking**: Easily check your **current balance** at any time.
- **💸 Deposit Funds**: Deposit money into your account with ease.
- **💵 Withdraw Funds**: Withdraw cash from your ATM account.
- **📜 Transaction History**: Keep track of all **transactions** (deposits, withdrawals, etc.).
- **🔐 Enhanced Security**: Built with **secure login** and **user authentication**.

---

## 🛠 Technologies Used
- **Java**: Object-Oriented Programming language used to implement the system.
- **Scanner**: For user input to navigate through the system.
- **Collections Framework**: To manage data such as user information and transaction logs.

---

## Project Structure
### 1. `ATMInterface.java`
Defines the core ATM operations that users can perform:
- **checkBalance()**: Displays the current balance.
- **deposit()**: Deposits money into the account.
- **withdraw()**: Withdraws money from the account.
- **showTransactionHistory()**: Shows a list of transactions.

### 2. `User.java`
Represents a user of the ATM system with:
- **Account number**
- **PIN**
- **Balance**
- **Transaction History**: A list of transactions for the user.

### 3. `ATMImplementation.java`
This class implements the `ATMInterface` and provides the functionality for the ATM operations. It interacts with the `User` class to manage balance and transactions.

### 4. `ATMSystem.java` (Main Program)
The entry point of the ATM system where:
- Users are authenticated.
- A menu of ATM options is displayed.
- Users interact with the ATM interface.

## How It Works

1. **Authentication**: 
   - Users are asked to enter their account number and PIN.
   - If authentication is successful, they can proceed to the ATM menu.

2. **ATM Menu**: Once logged in, users can:
   - Check Balance
   - Deposit Funds
   - Withdraw Funds
   - View Transaction History
   - Exit the system

3. **Transaction History**: All transactions (deposit, withdrawal, balance check) are logged for future reference.

---

## 📂 Setup & Usage
### **Prerequisites:**
- **Java 8+** installed on your computer.

### **Steps to Run the Program:**
1. **Clone the Repository**:
    ```bash
    git clone https://github.com/Yukku-21/ATM-System.git
    cd ATM-System
    ```

2. **Compile the Program**:
    ```bash
    javac ATMSystem.java
    ```

3. **Run the Program**:
    ```bash
    java ATMSystem
    ```

## 📥 Install Java
To run this program, you will need **Java 8+**. Follow the steps below:

- **Official Oracle JDK**: [Download Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
