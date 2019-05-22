package bd;

public class Gestio {
   String url = "jdbc:mysql://hosting-ng.infomerce.es:3306/x2382383c_daw";
   String usuari = "x2382383c";
   String pass = "x2382383c";

    public Gestio() {
    }

    public Gestio(String url, String usuari, String pass) {
        this.url = url;
        this.usuari = usuari;
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
}
