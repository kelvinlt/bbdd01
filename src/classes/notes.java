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
public class notes {
    String dni;
    int codi;
    double nota;

    public notes(String dni, int codi, double nota) {
        this.dni = dni;
        this.codi = codi;
        this.nota = nota;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "notes{" + "dni=" + dni + ", codi=" + codi + ", nota=" + nota + '}';
    }
    
    
}
