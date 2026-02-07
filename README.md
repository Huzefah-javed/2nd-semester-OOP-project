# Smart Store System 🛒

A Java-based store management system developed as a 2nd semester OOP project. This application demonstrates core object-oriented programming concepts including inheritance, polymorphism, abstraction, and encapsulation.

## 📋 Project Overview

The Smart Store System is a console-based application that allows employees to manage products and customers to browse and purchase items. It uses MySQL database (hosted on Aiven cloud) for data persistence.

## ✨ Features

### For Customers:
- Browse available products
- Add products to cart
- Place orders with quantity selection
- View order history
- Multiple payment options (Cash/Card)
- Guest browsing mode

### For Employees:
- Add new products to inventory
- Increase product stock
- Decrease product stock
- Product management dashboard

## 🏗️ Project Structure

```
├── DB/
│   └── ConnectionDb.java          # Database connection handler
├── Orders/
│   ├── OrderHistory.java          # Customer order history
│   ├── OrderItem.java             # Individual order item
│   └── PlaceOrder.java            # Order placement logic
├── Payments/
│   ├── Payment.java               # Payment interface
│   ├── CardPayment.java           # Card payment implementation
│   └── CashPayment.java           # Cash payment implementation
├── Product/
│   └── Product.java               # Product model
├── Store/
│   └── Store.java                 # Store operations
├── Users/
│   ├── Person.java                # Abstract base class
│   ├── Customer.java              # Customer class
│   ├── Employee.java              # Employee class
│   └── Authentication.java        # User authentication
└── Main.java                      # Application entry point
```

## 🔑 OOP Concepts Implemented

1. **Inheritance**: `Customer` and `Employee` classes extend the abstract `Person` class
2. **Polymorphism**: `Payment` interface implemented by `CardPayment` and `CashPayment`
3. **Abstraction**: Abstract `Person` class with abstract `showMenu()` method
4. **Encapsulation**: Private fields with public getters in all model classes
5. **Interfaces**: `Payment` interface for different payment strategies

## 🗄️ Database Schema

### Tables Used:

**users**
- id (INT, PRIMARY KEY)
- name (VARCHAR)
- email (VARCHAR)
- password (VARCHAR)
- role (VARCHAR) - 'customer' or 'employee'

**products**
- productId (INT, PRIMARY KEY)
- name (VARCHAR)
- category (VARCHAR)
- price (DOUBLE)
- stock (INT)
- description (VARCHAR)

**orderDetails**
- customerId (INT, FOREIGN KEY)
- productId (INT, FOREIGN KEY)
- quantity (INT)

## 🚀 Setup Instructions

### Prerequisites:
- Java JDK 8 or higher
- MySQL database
- Aiven cloud account (or any MySQL hosting service)

### Steps:

1. **Clone or download the project**
   ```bash
   git clone <your-repo-link>
   cd SmartStoreSystem
   ```

2. **Set up the database**
   - Create a MySQL database on Aiven cloud
   - Execute the database schema (create the tables mentioned above)
   - Note down your connection details

3. **Configure database connection**
   
   Open `DB/ConnectionDb.java` and update:
   ```java
   final String URL = "your-aiven-mysql-url";
   final String USER = "your-username";
   final String PASSWORD = "your-password";
   ```

4. **Compile the project**
   ```bash
   javac Main.java
   ```

5. **Run the application**
   ```bash
   java Main
   ```

## 💻 How to Use

### Customer Login:
1. Select option 2 from main menu
2. Enter your email and password
3. Choose to view order history or browse store
4. Add products to cart and checkout

### Employee Login:
1. Select option 1 from main menu
2. Enter employee credentials
3. Manage products and inventory

### Guest Mode:
1. Select option 3 from main menu
2. Browse products without logging in

## 🎓 Learning Outcomes

Through this project, I learned:
- How to design and implement a multi-class Java application
- Working with MySQL databases using JDBC
- Implementing OOP principles in a real-world scenario
- User authentication and role-based access control
- MVC-like pattern separation (though simplified)
- Exception handling and input validation

## 🐛 Known Limitations

- Passwords are stored in plain text (in a real application, should be hashed)
- No input validation for SQL injection
- Limited error messages
- No GUI (console-based only)
- Database connections are not pooled

## 📊 Grade Achieved

**25/25** ✅

## 👨‍💻 Author

Developed as part of Object-Oriented Programming course - 2nd Semester

## 📄 License

This is a student project created for educational purposes.

---

*Note: This project was created as part of academic coursework to demonstrate understanding of OOP concepts in Java.*
