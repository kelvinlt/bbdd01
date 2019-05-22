/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author x2382383c
 */
public class Alumnes {
    String dni;
    String nom;
    int edat;

    public Alumnes(String dni, String nom, int edat) {
        this.dni = dni;
        this.nom = nom;
        this.edat = edat;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "alumnes{" + "dni=" + dni + ", nom=" + nom + ", edat=" + edat + '}';
    }
    
    
}
