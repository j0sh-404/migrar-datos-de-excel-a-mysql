
package principal;

import java.util.ArrayList;

public class Materia {
    private String nombreMateria;
    private  ArrayList<Alumno>listaAlumno = new ArrayList<>();
    public Materia(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
   public Materia(){
   }
   
   public void insertarAlumno(Alumno alumno){
   listaAlumno.add(alumno);
   }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public ArrayList<Alumno> getListaAlumno() {
        return listaAlumno;
    }
 
    
   
    public Alumno getListaAlumno(int i) {
        return listaAlumno.get(i);
    }
    

   
   
}
