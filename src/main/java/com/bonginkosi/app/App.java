package com.bonginkosi.app;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
public class App {
	
    public static void main( String[] args ) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        
        try (Connection connection = factory.newConnection()) {
        	Channel channel = connection.createChannel();
        	channel.queueDeclare("send-name-queue", false, false, false, null);
        	
        	Scanner input = new Scanner(System.in);
        	System.out.println("Please enter your name...");
        	String name = input.nextLine();
        	if (name.isEmpty()) {
        		System.out.println("Please insert something !!");
        	} else {
            	if (!App.isNotANumber(name)) {
            		System.out.println("Please enter a valid name !!");
            	} else {
                	if (name.length() < 3) {
                		System.out.println("Please enter a name at least having 3 characters !!");
                	} else {
                    	String msg = "Hello my name is, " + name;
                    	channel.basicPublish("", "send-name-queue", false, null, msg.getBytes());
                    	input.close();
                    	System.out.println(">>> Message has been sent!! <<<");        		
                	}        		
            	}
        	}
        }
    }
    
    public static boolean isNotANumber(String name) {
    	try {
    		Integer.parseInt(name);
    		return false;
    	}catch(NumberFormatException e) {
    		return true;
    	}
    }
}
