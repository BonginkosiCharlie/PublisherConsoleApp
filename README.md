# App - RabbitMQ Publisher  

## Overview  
This Java application demonstrates how to publish messages to a RabbitMQ queue. It prompts the user to input their name, validates the input, and sends a formatted message to a queue named `send-name-queue`.

---

## What It Does  
1. **RabbitMQ Connection**: Establishes a connection to a RabbitMQ server.  
2. **Queue Declaration**: Declares a queue named `send-name-queue`.  
3. **User Input**: Prompts the user to enter their name.  
4. **Input Validation**:  
   - Ensures the input is not empty.  
   - Checks that the input is not a number.  
   - Verifies that the name is at least 3 characters long.  
5. **Message Publishing**: Sends a formatted message to the `send-name-queue` if validation passes.  

---

## Example Usage  

### Prerequisites  
1. Install and configure RabbitMQ on your system.  
2. Ensure RabbitMQ is running.  

### Running the Application  
1. Compile and run the application.  
2. Follow the on-screen prompt to enter your name.  
3. If valid, the application sends the message to RabbitMQ.  

### Example Input and Output  
- **Input**: `John`  
- **Output**:  
