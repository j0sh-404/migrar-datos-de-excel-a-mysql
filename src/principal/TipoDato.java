
package principal;

public class TipoDato {
    private String datoCadena;
    private double datoNumber;

    public TipoDato(String datoCadena) {
        this.datoCadena = datoCadena;
    }

    public TipoDato(double datoNumber) {
        this.datoNumber = datoNumber;
    }

    public String getDatoCadena() {
        return datoCadena;
    }

    public double getDatoNumber() {
        return datoNumber;
    }
    
    
}
