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
public class moduls {
    int codi;
    String nom;
    int curs;

    public moduls(int codi, String nom, int curs) {
        this.codi = codi;
        this.nom = nom;
        this.curs = curs;
    }

    public int getCodi() {
        return codi;
    }

    public void setCodi(int codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCurs() {
        return curs;
    }

    public void setCurs(int curs) {
        this.curs = curs;
    }

    @Override
    public String toString() {
        return "moduls{" + "codi=" + codi + ", nom=" + nom + ", curs=" + curs + '}';
    }
    
}
