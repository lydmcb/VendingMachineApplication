package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

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
   /*     public void write(String ){
            try {
                writer.write( + "\n");  // write to a buffer
                writer.flush(); // write to the logfile - flush the buffer to the file
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        @Override
        public void close() throws IOException {
            writer.close();
        }*/

    }
}
