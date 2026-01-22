# CodeAlpha_StockTradingPlatform

A simulation of a stock trading platform built in Java. This console-based application allows users to simulate buying and selling stocks, tracking their portfolio, and saving their progress using File I/O.

## 🚀 Features
* **Market Simulation:** Real-time simulation of stock prices and market data.
* **Buy & Sell Logic:** Validates transactions based on user balance and stock availability.
* **Portfolio Management:** Tracks owned stocks and quantities using `HashMap` for efficient lookup.
* **Data Persistence:** Uses File I/O (`user_data.txt`) to save user balance and portfolio data between sessions.
* **Error Handling:** Prevents invalid actions like overdrawing funds or selling stocks not owned.

## 🛠️ Concepts Demonstrated
* **Object-Oriented Programming (OOP):** Encapsulation, Classes, and Objects.
* **Data Structures:** `ArrayList` for market data, `HashMap` for portfolio management.
* **Java I/O:** Reading and writing text files for data persistence.
* **Algorithms:** Logic for transaction validation and financial calculations.

## 💻 How to Run
1.  Ensure you have Java installed.
2.  Clone this repository.
3.  Compile the files:
    ```bash
    javac *.java
    ```
4.  Run the main application:
    ```bash
    java StockMarket
    ```

## 📂 Project Structure
* `Stock.java`: Blueprint for stock objects (Symbol, Price, Name).
* `User.java`: Manages user state (Balance, Portfolio logic).
* `StockMarket.java`: Main entry point, handles menu loop and File I/O.

## 🔗 Author
* **Quazi Naqibul Alam**
* *Project completed as part of the CodeAlpha Internship Program.*
