package com.example.roberto.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileManager {

    public static File createFile(File folder, String fileName){
        return  new File(folder, fileName);
    }

    public static Object loadObject(File field){
        Object obj = null;
        try{
            FileInputStream fileInputStream = new FileInputStream(field);

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            obj = objectInputStream.readObject();
            fileInputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return  obj;
    }

    public static void saveObject(File fileId, Object obj){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileId);

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(obj);
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static StringBuilder loadByte(File fileId){
        int read = -1;
        StringBuilder stringBuilder = new StringBuilder();
        try{
            FileInputStream fileInputStream = new FileInputStream(fileId);

            while((read = fileInputStream.read())!= -1){
                stringBuilder.append((char)read);
            }
            fileInputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return stringBuilder;
    }

    public static void saveByte(File fileId, String str){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream(fileId);
            fileOutputStream.write(str.getBytes());

            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
