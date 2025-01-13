package es.educastur.ikerfm.biblioteca_2025;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Biblioteca_2025 {
    private ArrayList <Libro> libros;
    private ArrayList <Usuario> usuarios;
    private ArrayList <Prestamo> prestamos ;

    public Biblioteca_2025() {
        this.libros = new ArrayList();
        this.usuarios = new ArrayList();
        this.prestamos = new ArrayList();
    }
    

    public static void main(String[] args) {
        Biblioteca_2025 b= new Biblioteca_2025();
        b.cargaDatos();
        b.menu();
    }
    
    //<editor-fold defaultstate="collapsed" desc="MENUS">
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tMENU DE  LA BIBLIOTECA\n");
            System.out.println("\t\t\t\t1 - LIBROS");
            System.out.println("\t\t\t\t2 - USUARIOS");
            System.out.println("\t\t\t\t3 - PRESTAMOS");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    menuLibros();
                    break;
                }
                case 2: {
                    menuUsuarios();
                    break;
                    }
                case 3: {
                    menuPrestamos();
                    break;
                }
            }
        } while (opcion != 9);
    }
    
    public void menuLibros() {
     Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tLIBROS\n");
            System.out.println("\t\t\t\t1 - NUEVO LIBRO");
            System.out.println("\t\t\t\t2 - ELIMINAR LIBRO");
            System.out.println("\t\t\t\t3 - MODIFICAR LIBRO");
            System.out.println("\t\t\t\t4 - LISTADO");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    nuevoLibro();
                    break;
                }
                case 2: {
                    eliminarLibro();
                    break;
                    }
                case 3: {
                    modificarLibro();
                    break;
                }
                case 4: {
                    listadoLibros();
                }
            }
        }while (opcion != 9);
    }
        
    public void menuUsuarios() {
     Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tUSUARIOS\n");
            System.out.println("\t\t\t\t1 - NUEVO USUARIO");
            System.out.println("\t\t\t\t2 - ELIMINAR USUARIO");
            System.out.println("\t\t\t\t3 - LISTADO");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    nuevoUsuario();
                    break;
                }
                case 2: {
                    eliminarUsuario();
                    break;
                    }
                case 3: {
                    listadoUsuario();
                }
            }
        }while (opcion != 9);
    }    
        
    public void menuPrestamos() {
     Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("\n\n\n\n\n\t\t\t\tPRESTAMOS\n");
            System.out.println("\t\t\t\t1 - NUEVO PRESTAMO");
            System.out.println("\t\t\t\t2 - DEVOLUCIONES");
            System.out.println("\t\t\t\t3 - PRÓRROGAS");
            System.out.println("\t\t\t\t4 - LISTADO");
            System.out.println("\t\t\t\t9 - SALIR");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    nuevoPrestamo();
                    break;
                }
                case 2: {
                    devolucion();
                    break;
                    }
                case 3: {
                    prorroga();
                    break;
                }
                case 4: {
                    listadoPrestamos();
                }
            }
        }while (opcion != 9);
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTION LIBROS">
    private void nuevoLibro() {
        
    }

    private void listadoLibros() {
        System.out.println("A continuación les mostraremos los libros disponibles:");
        for (Libro l:libros) {
            System.out.println(l);
        }
    }

    private void modificarLibro() {
        Scanner sc = new Scanner(System.in);
            int opcion = 0;
            do {
                System.out.println("\n\n\n\n\n\t\t\t\t¿QUÉ DESEA MODIFICAR?\n");
                System.out.println("\t\t\t\t1 - AUTOR");
                System.out.println("\t\t\t\t2 - TITULO");
                System.out.println("\t\t\t\t3 - EJEMPLARES");
                System.out.println("\t\t\t\t9 - SALIR");
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1: {
                        modificaAutor();
                        break;
                    }
                    case 2: {
                        modificaTitulo();
                        break;
                        }
                    case 3: {
                        modificaEjemplares();
                        break;
                    }
                }
            }while (opcion != 9);  
    }

    private void eliminarLibro() {
        
    }
    
    private void modificaAutor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Identificación del libro:");
        System.out.println("¿De qué libro desea modificar el autor?");
        int posLibro = buscaIsbn(solicitaIsbn());
        if (posLibro==-1){
            System.out.println("No es ningun libro de la biblioteca");
        }else{
            System.out.println("EL libro seleccionado es " + libros.get(posLibro).getTitulo());
            System.out.println("");
            System.out.println("¿Cuál es el nuevo nombre del autor?");
            libros.get(posLibro).setAutor(sc.nextLine());
        }
    }
    

    private void modificaTitulo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Identificación del libro:");
        System.out.println("¿De qué libro desea modificar el titulo?");
        int posLibro = buscaIsbn(solicitaIsbn());
        if (posLibro==-1){
            System.out.println("No es ningun libro de la biblioteca");
        }else{
            System.out.println("EL libro seleccionado es " + libros.get(posLibro).getTitulo());
            System.out.println("");
            System.out.println("¿Cuál es el nuevo titulo del libro?");
            libros.get(posLibro).setAutor(sc.nextLine());
        }
    }
    

    private void modificaEjemplares() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Identificación del libro:");
        System.out.println("¿De qué libro desea modificar el nº de ejemplares?");
        int posLibro = buscaIsbn(solicitaIsbn());
        if (posLibro==-1){
            System.out.println("No es ningun libro de la biblioteca");
        }else{
            System.out.println("EL libro seleccionado es " + libros.get(posLibro).getTitulo());
            System.out.println("");
            System.out.println("¿Cuál es el nuevo nº de ejemplares?");
            libros.get(posLibro).setAutor(sc.nextLine());
        }
        }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTION USUARIOS">
    private void nuevoUsuario() {
        String  dni, nombre, email, telefono;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Nuevo Contacto:");
        //Entrada del Nombre del nuevo contacto - SIN VALIDACIÓN
        System.out.println("Nombre:");
        nombre=sc.nextLine();
        //Entrada del TELEFONO del nuevo contacto - CON VALIDACIÓN MEDIANTE EXPRESIÓN REGULAR
        do{
                System.out.println("TELEFONO:");
                telefono=sc.next();
        }while(!telefono.matches("[6-7][0-9]{8}")); 
        //Entrada del EMAIL del nuevo contacto - CON VALIDACIÓN MEDIANTE EXPRESIÓN REGULAR
        do{
                System.out.println("EMAIL:");
                email=sc.next();
        }while(!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")); 
         //Entrada de LA FECHA de nacimiento del nuevo contacto - CON VALIDACIÓN MEDIANTE EXPRESIÓN REGULAR
        do{
            System.out.println("DNI: ");
            //SI QUEREMOS USAR OTRO FORMATO DE FECHA DISTINTO (Dia-mes-año) hay que usar un DateTimeFormatter
            dni = sc.next();
        }while(!dni.matches("[0-9]{2}"));      

        usuarios.add(new Usuario(dni,nombre,email,telefono));
        Collections.sort(usuarios);
    }

    private void listadoUsuario() {
     for (Usuario u:usuarios) {
            System.out.println("A continuación les mostraremos los usuarios de nuestra biblioteca:");
            System.out.println(u);
        }   
    }

    private void eliminarUsuario() {
        int posLibro = buscaIsbn(solicitaIsbn());
        if(posLibro == -1){
            System.out.println("No es ningun libro de la biblioteca");
        }else{
            usuarios.remove(posLibro);
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="GESTION PRESTAMOS">
    private void nuevoPrestamo() {
        System.out.println("Identificación del usuario:");
        int posUsuario = buscaDni(solicitaDni());
        if (posUsuario==-1){
            System.out.println("No es aún usuario de la biblioteca");
        }else{
            System.out.println("Identificación del libro:"); 
            int posLibro=buscaIsbn(solicitaIsbn());
            if (posLibro==-1){
                System.out.println("El ISBN pertenece a un libro inexistente");
            } else if (libros.get(posLibro).getEjemplares()>0){
                LocalDate hoy=LocalDate.now();
                prestamos.add(new Prestamo(libros.get(posLibro),usuarios.get(posUsuario),hoy,hoy.plusDays(15)));
                libros.get(posLibro).setEjemplares(libros.get(posLibro).getEjemplares()-1);
                }else{
                    System.out.println("No quedan unidades disponibles del libro");
                }
        }
    }

    private void listadoPrestamos() {
        for (Prestamo p:prestamos) {
            System.out.println("A continuación les mostraremos los prestamos realizados:");
            System.out.println(p);
        }    
    }

    
    private void devolucion(){
        System.out.println("Datos para la prórroga del préstamo: ");
        String isbnLibro=solicitaIsbn();
        int pos = buscaPrestamo(solicitaDni(), isbnLibro);
        if (pos==-1) {
            System.out.println("No hay ningún préstamo con esos datos");
        } else {
            prestamos.get(pos).setFechaDev(LocalDate.now());
        }
    }
    private void prorroga(){
        System.out.println("Datos para la prórroga del préstamo: ");
        int pos = buscaPrestamo(solicitaDni(), solicitaIsbn());
        if (pos==-1) {
            System.out.println("No hay ningún préstamo con esos datos");
        } else {
            prestamos.get(pos).setFechaDev(prestamos.get(pos).getFechaDev().plusDays(15));
        }
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="METODOS AUXILIARES">
    public void cargaDatos(){
        libros.add(new Libro("1-11","El Hobbit","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-22","El Silmarillon","JRR Tolkien","Aventuras",3)); 
        libros.add(new Libro("1-33","El Médico","N. Gordon","Aventuras",4)); 
        libros.add(new Libro("1-44","Chamán","N. Gordon","Aventuras",3)); 
        libros.add(new Libro("1-55","Momo","M. Ende","Aventuras",2)); 
        libros.add(new Libro("1-66","Paraíso inhabitado","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-77","Olvidado Rey Gudú","A.M.Matute","Aventuras",2)); 
        libros.add(new Libro("1-88","El último barco","D.Villar","Novela Negra",3)); 
        libros.add(new Libro("1-99","Ojos de agua","D.Villar","Novela Negra",2)); 

        usuarios.add(new Usuario("11","Ana","ana@email.com","621111111")); 
        usuarios.add(new Usuario("22","David","david@email.com","622222222")); 
        usuarios.add(new Usuario("33","Bea","bea@email.com","623333333")); 
        usuarios.add(new Usuario("44","Lucas","lucas@email.com","624444444")); 
        usuarios.add(new Usuario("55","Carlota","carlota@email.com","625555555")); 
        usuarios.add(new Usuario("66","Juan","juan@email.com","626666666"));
        
        LocalDate hoy= LocalDate.now();
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(8),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(4), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(5),usuarios.get(0), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(6),usuarios.get(2), hoy,hoy.plusDays(15)));
        prestamos.add(new Prestamo(libros.get(2),usuarios.get(1), hoy,hoy.plusDays(15)));        
    }
    
    /**
     * Método para buscar un libro en la colección libros
     * @param isbn (String) del libro a buscar en la colección
     * @return posición (int) del libro el Arraylist, valor -1 si no se encuentra
     */
    public int buscaIsbn(String isbn){
        int pos=-1;
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getIsbn().equals(isbn)){
                pos=i;
                break;
            }
        }
        return pos;       
    }
    
    /**
     * Método para buscar un dni en la colección usuarios
     * @param dni (String) del usuario a buscar en la colección
     * @return posición (int) del usuario en el Arraylist, valor -1 si no se encuentra
     */
    public int buscaDni(String dni){
        int pos=-1;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getDni().equals(dni)){
                pos=i;
                break;
            }
        }
        return pos;       
    }
    
    /**
     * Método para solicitar por teclado el ISBN de un libro. pdte de validación
     * @return (String) isbn del libro tecleado
     */
    public String solicitaIsbn(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Teclea el isbn del libro:");
        String isbn=sc.next();
        return isbn;
    }
    
    /**
     * Método para solicitar por teclado el DNI de un usuario, pdte de validación
     * @return (String) dni del usuario tecleado
     */
    public String solicitaDni(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Teclea el dni del usuario:");
        String dni=sc.next();
        return dni;
    }
    
    public int buscaPrestamo(String dni, String isbn){
        int pos=-1;
        for (int i = 0; i < prestamos.size(); i++){
            if (prestamos.get(i).getUsuarioPrest().getDni().equals(dni) 
                && prestamos.get(i).getLibroPrest().getIsbn().equals(isbn)) {
                pos=i;
                break;
            }
        }
        return pos;
    }
    
        
    //</editor-fold>
}

