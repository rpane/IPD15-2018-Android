package ca.masoudbozorgi.myapplication.file;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by masoud on 2017-10-04.
 */

public class FileManager {

    public static File createFile(File folder, String fileName) {
        return new File(folder,fileName);
    }

    // Implementing Serializable interface enables the Java serialization mechanism
    // to automate the process of storing objects and arrays.
    // object serialization, is implemented in ObjectOutputStream.

    // When a serializable object is stored, the class of the object is encoded;
    // this includes the class name and the signature of the class,
    // the values of the object’s instance variables,
    // and the closure of any other objects referenced by the object.
    // The values of the object’s static variables are not stored.

    // If an object is an instance of Serializable but contains nonserializable
    // instance data fields, can it be serialized? The answer is no.

    public static Object loadObject(File fileId){
        Object object = null;
        try {
            // FileInputStream associate a BINARY input
            FileInputStream fileInputStream = new FileInputStream(fileId);


            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            object = objectInputStream.readObject();
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
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

    public static StringBuilder loadByte(File fileId){

        int read = -1;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileId);

            // read() method read the next byte of data from the input stream.
            // The return type is an int between 0 to 255.
            // If no byte is available because the end of the stream has been reached,
            // the value -1 is returned
            while((read = fileInputStream.read()) != -1){
                stringBuilder.append((char) read);
            }
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuilder;
    }

    public static void saveByte(File fileId, String string){

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileId);

            // write() method writes all the bytes as an array of bytes to output stream
            fileOutputStream.write(string.getBytes());

            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}