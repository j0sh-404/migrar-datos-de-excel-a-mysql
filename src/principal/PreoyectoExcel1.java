
package principal;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.internal.util.xml.impl.Input;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFChartSheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PreoyectoExcel1 {
    static Scanner entrada = new Scanner(System.in); 
    private static ArrayList<Materia>materia = new ArrayList<>();
    static String nombreMateria;
    static int contadorMatria=0;
    static Materia m = new Materia();
    private static Modelo modelo = new Modelo();
    private static ArrayList<String> tipoDato;
    private static ArrayList<String>datosCadena;
    public static void main(String[] args) {
       /* int opcionPrincipal;
        materia.add(new Materia("Matematicas"));
        materia.add(new Materia("Español"));
        materia.add(new Materia("Ciencias N"));
        materia.get(0).insertarAlumno(new Alumno("Jose",9));
        materia.get(0).insertarAlumno(new Alumno("Juan",8));
        materia.get(0).insertarAlumno(new Alumno("Pedro",7));
        materia.get(0).insertarAlumno(new Alumno("Alicia",9));
        materia.get(0).insertarAlumno(new Alumno("Itzel",8));
        materia.get(0).insertarAlumno(new Alumno("Juana",7));
        materia.get(0).insertarAlumno(new Alumno("Armando",3));
        materia.get(0).insertarAlumno(new Alumno("Aracali",2));
        materia.get(0).insertarAlumno(new Alumno("Berta",2));
        materia.get(0).insertarAlumno(new Alumno("Antonio",4));
        materia.get(0).insertarAlumno(new Alumno("Roberto",3));
        
        materia.get(1).insertarAlumno(new Alumno("Roberto",10));
        materia.get(1).insertarAlumno(new Alumno("Jorge",9));
        materia.get(1).insertarAlumno(new Alumno("Asunción",8));
        materia.get(1).insertarAlumno(new Alumno("Marbin",7));
        
        materia.get(2).insertarAlumno(new Alumno("Alfonso",10));
        materia.get(2).insertarAlumno(new Alumno("Raymundo",9));
        materia.get(2).insertarAlumno(new Alumno("Myreydi",8));
        materia.get(2).insertarAlumno(new Alumno("Belen",7));
        
        do {
            opcionPrincipal=Integer.parseInt(entradaDatos("Seleccioa 1 opcion\n1->Inserta una nueva materia\n2->Salir\nAñadir datos a mysql"));
            switch(opcionPrincipal){
                case 1:
                    nuevaMateria();
                  
                break;
                case 2:
                     mostrarDatos();
                    break;
                    case 3:
                  guardarDatos();
                    break;
                default:
                    mensaje("Por favor selecciona una opcion valida");
                    break;
            }
        } while (opcionPrincipal!=2);
        */
          guardarDatos();     
    }
    public static void nuevaMateria(){
    
    int menuAgregarAlumno;
    nombreMateria=entradaDatos("Nombre de la materia:");
    materia.add(new Materia(nombreMateria));
    contadorMatria++;
        do {
            menuAgregarAlumno=Integer.parseInt(entradaDatos("Selecciona una opcion:\n1->Agrega un nuevo alumno para la materia "+nombreMateria+"\n2->Salir al menú principal\n\nPara agregar una materia minimo debe tener 1 alumno"));
            switch(menuAgregarAlumno){
                case 1:
                    
                    agregarAlumno();
                    break;
                case 2:
                   
                    break;
      
                default:
                    mensaje("Por favor seleccione una opcion valida");
                    break;
            }
        } while (menuAgregarAlumno!=2);
    }
    
    public static void agregarAlumno(){
        String nombreAlumno;
        float calificacionAlumno;
        nombreAlumno=entradaDatos("Nombre del alumno");
        calificacionAlumno=Float.parseFloat(entradaDatos("Calificación para el alumno "+ nombreAlumno+" de la materia "+nombreMateria));
        materia.get(contadorMatria-1).insertarAlumno(new Alumno(nombreAlumno, calificacionAlumno));
        
    }
    public static  String entradaDatos(String mensaje){
    return JOptionPane.showInputDialog(null, mensaje);
    }
    
    public static void mensaje(String mensaje){
     JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static void mostrarDatos(){
        int pos;
        if(materia.size()>0){
            Workbook excel = new XSSFWorkbook();
         for (int i = 0; i <materia.size(); i++) {
             Sheet hoja = excel.createSheet(materia.get(i).getNombreMateria());
              Row fila= hoja.createRow(0);
              fila.createCell(0).setCellValue("Nombre alumno");
              fila.createCell(1).setCellValue("Calificación");
              
             for (int j = 0; j <materia.get(i).getListaAlumno().size(); j++) {
                 Row filaB = hoja.createRow(j+1);
                 filaB.createCell(0).setCellValue(materia.get(i).getListaAlumno(j).getNombreAlumno());
                 filaB.createCell(1).setCellValue(materia.get(i).getListaAlumno(j).getCalificacionMateria());
                 
             
             }
            
         }
            try {
            FileOutputStream archivo;  archivo = new FileOutputStream("sede.xlsx");
            excel.write(archivo);
            archivo.close();
            } catch (Exception e) {
                    System.err.println("Error "+e);
            }
            
         
         
     }else{
     System.exit(0);
     }
    }

    //Guardar datos de un archivo excel a una base de datos
    public static void guardarDatos(){
        System.out.println("guardando datos..");
        try {
            FileInputStream archivo = new FileInputStream(new File("sede.xlsx"));//obtenemos el archivo
            XSSFWorkbook leerLibro= new XSSFWorkbook(archivo);//añadimos el archivo a la libreria de workBook para poder ver el contenido
            int cantidadHojas=leerLibro.getNumberOfSheets();//Obtenemos la cantidad total de las hojas en el archivo
            String columnas="";
            String rescatarColumnas="";
            int contador=0;
            boolean numeros;
            String celdaXfila="";
            String rescatarCeldaXfila="";
            for (int i = 0; i <cantidadHojas; i++) {
                //Ciclo para realizar una iteración por cada hoja
                int celdas=-1;
                XSSFSheet  hoja = leerLibro.getSheetAt(i);
                Cell celda;
                Row fila;
                datosCadena= new ArrayList<>();
                int contadorB=0;
                for (int j = 0; j <=hoja.getLastRowNum(); j++) {
                    //ciclo para obtener cada una de las filas
                    tipoDato= new ArrayList<>();
                    
                    fila = hoja.getRow(j);
                    celdas=fila.getLastCellNum();

                    for (int k = 0; k <celdas; k++) {
                        
                          if(j==0){
                          Cell c =fila.getCell(k);
                          columnas=c.getStringCellValue();
                              for (int l = 0; l <columnas.length(); l++) {
                                if(columnas.charAt(l)==' '){
                                  rescatarColumnas+="_";
                                  }else{
                                  rescatarColumnas+=columnas.charAt(l);
                                  }
                              }
                              if(k==(celdas-1)){
                              rescatarColumnas+="";//añadir una separación por columna hacia la
                              }else{
                              rescatarColumnas+=",";
                              }
                          }else{
                          
                          celda =fila.getCell(k);
                              System.out.println(celda);
                          switch(celda.getCellTypeEnum().toString()){
                          case"NUMERIC":
                               tipoDato.add(" decimal(10,2)");
                               if(k==(celdas-1)){
                               celdaXfila+=celda.getNumericCellValue();
                               contadorB++;
                               }else{
                               celdaXfila+=celda.getNumericCellValue()+",";
                               contadorB++;
                               }
                              break;
                          case "STRING":
                               tipoDato.add(" varchar(200)");
                               if(k==(celdas-1)){
                                celdaXfila+="'"+celda.getStringCellValue()+"'";
                                contadorB++;
                               }else{
                               celdaXfila+="'"+celda.getStringCellValue()+"',";
                               contadorB++;
                               }
                               
                              break;
                          }
                          
                          }
                         
                         
                    }
                    char comaValores=',';
                    if (j>0) {
                         if(j==(hoja.getLastRowNum())){
                         rescatarCeldaXfila+="("+celdaXfila+");";
                         }else{
                         rescatarCeldaXfila+="("+celdaXfila+")"+comaValores;
                         }
                         celdaXfila="";
                    }
                   
                    
                    
                }
                
               //insertar las tablas y columnas con su tipo de dato
               String separar[]=rescatarColumnas.split(",");
               String datosObtenidos="";
                for (int j = 0; j <separar.length; j++) {
                    char coma=',';
                    if(j==(separar.length-1)){
                    datosObtenidos+=separar[j]+tipoDato.get(j);
                    }else{
                    datosObtenidos+=separar[j]+tipoDato.get(j)+coma;
                    
                    }
                }
               
                 modelo.crearTabla("create table "+leerLibro.getSheetName(i)+"(id_"+leerLibro.getSheetName(i)+" int primary key not null auto_increment,"+datosObtenidos+");");
                 modelo.insertarDatos("insert into "+leerLibro.getSheetName(i)+"("+rescatarColumnas+") values"+rescatarCeldaXfila);
                 
                 rescatarCeldaXfila="";
               
               tipoDato.clear();
               columnas="";
               rescatarColumnas="";
               datosObtenidos="";
               
               
            }  
             
            System.exit(0);
            
        } catch (Exception ex) {
            System.err.println("Error we"+ex); 
            ex.printStackTrace();
        }
    }
    
}

