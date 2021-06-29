/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalizableobjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author dikka.aditya
 */
public class ExternalizableObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        // TODO code application logic here
        Identitas iden = new Identitas(22, "Dikka Aditya");
        File f = new File("identitas.txt");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(iden);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            Identitas iden2 = (Identitas) ois.readObject();
        }
        System.out.println(iden.toString());
    }
    
}
