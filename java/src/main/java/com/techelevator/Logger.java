package com.techelevator;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger implements Closeable{

    private File userLog;
    private FileWriter writer;

    public Logger(String pathName) {
        userLog = new File(pathName);
        if (userLog.exists()) {

            try {
                writer = new FileWriter(userLog, true);
            } catch (IOException e) {
                System.out.println("Unable to append file");
            }
        } else {

            try {
                writer = new FileWriter(userLog);
            } catch (IOException e) {
                System.out.println("Unable to create file");
            }

        }


            }
    public void write(String message){
        try {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void close() throws IOException {
        writer.close();
    }
}




