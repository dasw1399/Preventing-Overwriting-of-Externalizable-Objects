/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalizableobjects;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

/**
 *
 * @author dikka.aditya
 */
public class Identitas implements Serializable, Externalizable{
    private String nama;
    private int umur;
    
    private final Object lock = new Object();
    private boolean initialized = false;

     @Override
    public String toString() {
        return "Identitas{" + "Umur = " + umur + ", nama=" + nama + '}';
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }
    
    public Identitas() {
        this.nama = null;
        this.umur = 0;
    }

    public Identitas(int umur, String nama) {
        this.umur = umur;
        this.nama = nama;
    }
    
   
    
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(nama);
        out.writeInt(umur);
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        synchronized(lock) {
            if(!initialized) {
                this.nama = (String) in.readObject();
                this.umur = in.readInt();
                initialized = true;
                System.out.println(this.toString());
            } else {
                throw new IllegalStateException();
            }
        }
        //throw new UnsupportedOperationException("Not supported yet."); 
        //To change body of generated methods, choose Tools | Templates.
    }
}
