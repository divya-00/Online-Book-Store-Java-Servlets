# Online Book Store Java

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

A web-based application that allows users to browse, search, and purchase books online. This project utilizes **Java Servlets** and **JDBC** concepts to provide a dynamic and interactive user experience.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Installation](#installation)
- [Usage](#usage)
- [Pages](#pages)
- [Tech Stack](#tech-stack)
- [Contributing](#contributing)
- [License](#license)

## Features

- **User Registration & Login:** Secure authentication system.
- **Browse & Search Books:** View available books and search by title or author.
- **Add to Cart:** Select books and add them to the shopping cart.
- **Checkout & Payment:** Complete the purchase and receive a payment receipt.


## Technologies Used

- **IDE:** NetBeans IDE (Oracle)  
- **Frontend:** HTML, CSS, JavaScript, Bootstrap  
- **Backend:** Java (JDK 8+), Servlets, JDBC  
- **Database:** MySQL  
- **Server:** Apache Tomcat  

---

## Installation

1. **Clone the Repository**
```bash
git clone https://github.com/divya-00/Online-Book-Store-Java-Servlets.git
```

2. **Open NetBeans IDE**
- Select `File > Open Project`.
- Browse to the cloned repository and open it as a NetBeans project.

3. **Database Configuration**
- Set up a MySQL database named `bookstore`.
- Import the provided SQL script to create necessary tables.
- Update database connection details in `DBConnection.java`.

4. **Deploy on Apache Tomcat**
- Right-click the project in NetBeans.
- Select `Run` or `Deploy`.
- Ensure Apache Tomcat is configured.

5. **Access the Application**
- Open a web browser and navigate to:  
  `http://localhost:8080/OnlineBookStore`

## Usage
- Browse and search for books by title or author.
- Add books to the cart and complete purchases.
- Admin can add, update, or remove books and view sales history.


## Pages
- **Home:** Browse available books and search.
- **Book Details:** View book information and add to cart.
- **Cart & Checkout:** Review selected books and complete purchases.
- **Admin Dashboard:** Add, update, or delete books; view sales history.
- **Login & Registration:** User authentication system.

## Tech Stack
- **IDE:** NetBeans IDE (Oracle)
- **Frontend:** HTML, CSS, JavaScript, Bootstrap
- **Backend:** Java Servlets, JDBC
- **Database:** MySQL
- **Server:** Apache Tomcat

## Contributing

Feel free to enhance this project by adding new features, improving UI, or integrating APIs. Fork the repository and create pull requests for any enhancements.

## License

This project is licensed under the terms of the [MIT license](LICENSE).
Copyright © rights are reserved, made with :heart: Devi Divya Sri Perni.
