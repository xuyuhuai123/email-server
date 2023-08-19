package com.email;

import com.email.receiver.ReceiverServer;

public class EmailApplication {
    public static void main(String[] args) {
        new ReceiverServer().startServer(8081);
    }
}
