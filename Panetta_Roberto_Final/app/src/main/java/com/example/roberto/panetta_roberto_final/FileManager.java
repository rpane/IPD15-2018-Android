package com.example.roberto.panetta_roberto_final;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileManager {
    public static File createFile(File folder, String fileName) {
        return new File(folder,fileName);
    }

    public static void saveObject(File fileId, Object object) {

        try {
            // FileOutputStream associate a BINARY output
            FileOutputStream fileOutputStream = new FileOutputStream(fileId);

            // ObjectOutputStream enables us to perform I/O for objects
            // in addition for primitive type values and strings
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(object);

            fileOutputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
