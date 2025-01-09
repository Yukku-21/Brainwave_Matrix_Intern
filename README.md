# 💳 **Fully Functional ATM Interface** 🏧

## 🚀 **Overview**
Welcome to the **ATM Interface System**! This **ATM simulation** provides you with the ability to perform **basic banking operations** such as **checking balances**, **depositing funds**, **withdrawing money**, and **viewing transaction history**. Built with **Java**, this project simulates a real-world ATM experience with a **user-friendly console interface**.

---

## ✨ **Key Features**
Here’s what you can do with the ATM System:

- 🔒 **Secure Authentication**: Log in using your **account number** and **PIN**.
- 💰 **Balance Checking**: Instantly check your **current balance** in real-time.
- 💸 **Deposit Funds**: Effortlessly deposit money into your account.
- 💵 **Withdraw Funds**: Withdraw cash whenever you need it.
- 📜 **Transaction History**: Keep track of all your **transactions** (deposits, withdrawals, balance checks).
- 🔐 **Enhanced Security**: Built with **secure login** and **user authentication** for top-notch security.

---

## 🛠 **Technologies Used**
This system is powered by a few amazing technologies:
- **Java**: A powerful object-oriented programming language for system implementation.
- **Scanner**: To handle user input and guide you through the system.
- **Collections Framework**: For managing user information and transaction logs with efficiency.

---

## 🗂 **Project Structure**
### 1. `ATMInterface.java`
- **checkBalance()**: Displays the current account balance.
- **deposit()**: Deposits money into your account.
- **withdraw()**: Withdraws cash from your account.
- **showTransactionHistory()**: Displays your transaction history.

### 2. `User.java`
Represents a user and includes:
- **Account Number**
- **PIN**
- **Balance**
- **Transaction History**: A detailed record of all your transactions.

### 3. `ATMImplementation.java`
Implements the **ATM operations** and interacts with the `User` class for balance updates and transaction logs.

### 4. `ATMSystem.java` (Main Program)
The **entry point** where:
- Users are **authenticated** using their account number and PIN.
- The **ATM menu** is shown to interact with the system.

---

## 🔧 **How It Works**

### 1. **Authentication** 🔑
   - Users log in by entering their **account number** and **PIN**.
   - After successful authentication, they are taken to the **ATM menu**.

### 2. **ATM Menu Options** 💻
Once logged in, users can choose to:
- **Check Balance** 💰: View your **current balance**.
- **Deposit Funds** 💸: Add money to your account.
- **Withdraw Funds** 💵: Withdraw cash from your account.
- **View Transaction History** 📜: Review past transactions.
- **Exit** 🚪: Logout from the system.

### 3. **Transaction History** 📚
Each transaction is **logged**, ensuring you have access to your past activities such as deposits, withdrawals, and balance checks.

---

## 📂 **Setup & Usage**

### **Prerequisites** 🚨
Before you start, ensure you have **Java 8+** installed on your machine.

### **Steps to Run the Program:**

1. **Clone the Repository** from GitHub:
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

---

## 📥 **Install Java** 💻
To run the program, you’ll need **Java 8+**. Follow the steps below to install it:
- **Official Oracle JDK**: [Download Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

---

## 📚 **Contributions & Support**
If you encounter any issues or have suggestions, feel free to open an **issue** or submit a **pull request** on GitHub.

---

> *Built with 💻 and created by [Yukku-21](https://github.com/Yukku-21)*
