# 📚 Library API - Java Spring Project

This project is a RESTful API for managing a library, created with Java and Spring Boot. The API allows the control of books, users and loans, offering registration, query, update and deletion functionalities.

## ✨ Functionalities

- **Book Management**: Add, update, list and remove books.
- **User Management**: Add, update, list and remove users.
- **Book Loans**: Register, list and return borrowed books.
- **Book Session Management**: Add, update, list and remove sessions.

## 🚀 Technologies

- **Java**: Main language of the project.
- **Spring Boot**: Framework for creating RESTful APIs.
- **Spring Data JPA**: Interface with the database.
- **PostgreSQL**: Relational database used for data storage.
- **Maven**: Dependency management and build.

## ⚙️ Prerequisites

- **Java 17** or higher
- **Maven 3.6+**
- **PostgreSQL** installed and configured

## 📥 Installation and Execution

1. **Clone the repository**:

```
git clone https://github.com/leo3210k/Library.git
```

2. **Navigate to the project directory**:

```
cd library
```

3. **Configure the PostgreSQL Database**:

- Create a PostgreSQL database for the project, for example, library.

- Update the database connection settings in the application.properties or application.yml file, using the name, username and password configured in PostgreSQL:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/library
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

4. **Install the project dependencies**:

```
mvn install
```

5. **Start the application**:

```
mvn spring-boot:run
```

6. **Access the API at http://localhost:8080**

## 🗃️ API Endpoints

### Users
* GET /user: Lists all users. * GET /user/{id}: Displays information for a specific user.
* POST /user: Adds a new user.
* PUT /user/{id}: Updates information for a user.
* DELETE /user/{id}: Deletes a user.

### Books
* GET /books: Lists all books.
* GET /books/{id}: Displays information for a specific book.
* POST /books: Adds a new book.
* PUT /books/{id}: Updates information for a book.
* DELETE /books/{id}: Deletes a book.

### Loans
* GET /loan: Lists all loans.
* GET /loan/{id}: Displays details for a specific loan.
* POST /loan: Registers a new loan.
* PUT /loan/{id}/devolver: Marks a loan as returned. * DELETE /loan/{id}: Deletes a loan.

### Sessions
* GET /session: Lists all book sessions (categories).
* GET /session/{id}: Displays details of a specific session.
* POST /session: Adds a new session.
* PUT /session/{id}: Updates information about a session.
* DELETE /session/{id}: Deletes a session.
