
package principal;
public class Alumno {
    private String nombreAlumno;
    private float calificacionMateria;

    public Alumno(String nombreAlumno, float calificacionMateria) {
        this.nombreAlumno = nombreAlumno;
        this.calificacionMateria = calificacionMateria;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public float getCalificacionMateria() {
        return calificacionMateria;
    }
    
    
}
