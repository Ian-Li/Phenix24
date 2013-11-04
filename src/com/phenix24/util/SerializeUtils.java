package com.phenix24.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeUtils {

    /**
     * Serialize object to file.
     * 
     * @param obj
     *            <code>Serializable</code> object
     * @param path
     *            file path
     * @return true serialize success,when an error occured return false.
     */
    public static boolean serialize(Serializable obj, String path) {
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(path));
            out.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (out != null)
                try {
                    out.close();
                } catch (IOException e) {
                }
        }
        return true;
    }

    /**
     * Deserialize object from file.
     * 
     * @param path
     *            file path
     * @return <code>Serializable</code> object.when an error occured,return
     *         NULL.
     */
    public static Serializable deserialize(String path) {
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(new FileInputStream(path));
            return (Serializable) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
}
