import java.util.ArrayList;
/**
 * Write a description of class ListaTareas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaTareas
{
    // Coleccion que almacena todas las tareas
    private  ArrayList<String> listaDeTareas;
    private ArrayList<Boolean> tareaHecha;

    /**
     * Constructor for objects of class ListaTareas
     */
    public ListaTareas()
    {
        listaDeTareas = new ArrayList<String>();
        tareaHecha = new ArrayList<Boolean>();
    }

    /**
     * Permite añadir una nueva tarea
     */
    public void addTarea(String nuevaTarea)
    {
        listaDeTareas.add(nuevaTarea); // se almacenan las tareas que vamos teniendo
        tareaHecha.add(false);        //  se almacena "false" al mismo tiempo porque al crear una tarea, la tarea no está hecha. 
    }

    /**
     * Devuelve el numero de tareas existentes
     */   
    public int getNumeroTareas()
    {
        return listaDeTareas.size();
    }

    /**
     * Elimina la tarea que ocupa la posicion indicada.
     * Si la posicion indicada no es valida, no hace nada
     * El mt supone que un valor de 1 en el parámetro indica la primera tarea, 2 la segunda, etc.
     */
    public void eliminaTarea(int posicion) 
    {
        int valor = posicion -1;
        if(esValidoElIndice(valor)){
            listaDeTareas.remove(valor);
        }
    }

    /**
     * mt para comprobar si un índice es válido y devuelve true en caso de afirmativo
     * o false en otro caso
     */
    public boolean  esValidoElIndice(int valor){
        boolean esValido = false;
        if(valor < listaDeTareas.size()  && valor >= 0){
            esValido = true;
        }
        return esValido;
    }

    /**
     * mt que devuelve true en caso de que  haya tareas por hacer, false en otro caso.
     */
    public boolean hayTareasPendientes(){
        boolean tareasPendientes = false;
        if(listaDeTareas.size() > 0){
            tareasPendientes = true;
        }
        return tareasPendientes;
    } 

    /**
     * Imprime por pantalla todas las tareas guardadas
     */
    public void verTareas()
    {
        System.out.println(listaDeTareas);
    }

    /**
     * mt para imprimir todas las tareas existentes, una por una.
     */
    public void mostraTareas(){
        for(String tarea: listaDeTareas){
            System.out.println(tarea);            
        }
    }

    /**
     * mt para imprimir todas las tareas existentes, una por una.
     * el metodo imprime las tareas numeradas.
     */
    public void mostraTareas2(){
        int cont = 1;
        for(String tarea: listaDeTareas){
            System.out.println(cont+ ". " +tarea);  
            cont++;
        }
    }

    /**
     * mt que muestra todas las tareas que tengan un determinado texto pasado como parámetro
     * con su numeración  asociada correcta. Si no hay ninguna tarea que contenga el texto indicado,
     * muestra mensaje de error.
     * Si hay tareas coincidentes se muestra detrás de la lista el nº de coincidencias 
     */ 
    public void mostrarTareasConIncidentes(String texto){
        int cont = 1;
        int valor = 0;
        int coincidentes = 0; //suma el nº de tareas coincidentes con texto
        for(String tarea2: listaDeTareas){
            if(tarea2.contains(texto)){
                System.out.println(cont+ "." +tarea2);
                valor++; //si una tarea conincide con la busqueda la sumo.
                coincidentes++;
            }            
            cont++;
        }
        //si no hay tareas conincide con el parámetro texto, valor vale 0 y entra en el if.
        if(valor == 0){
            System.out.println("No tiene tareas con el texto " +texto);
        }
        else{
            System.out.println( coincidentes+ " tareas coincidentes con el texto " +texto); 
        }
    }

    /**
     * muestra las primeras n tareas indicadas como parámetro. En caso de que 
     * haya menos tareas de n tareas se muestran todas.
     */
    public void mostrarPrimerasTareas(int numTareas){
        int cont = 0; 
        while(cont < numTareas && cont < listaDeTareas.size()){
            System.out.println((cont +1)+ ". " +listaDeTareas.get(cont));
            cont++;
        }
    }

    /**
     * devuelve la posición(desde 0) de la primera tarea que contiene el texto indicado como parámetro.
     * -1 en caso contrario.  NO MUESTRA NADA POR PANTALLA.
     */
    public int hayTareasCoincidentes(String textoABuscar){
        int cont2 = -1;        
        int cont = 0;
        boolean igualTexto = false;
        while(cont < getNumeroTareas() && !igualTexto){
            if(listaDeTareas.contains(textoABuscar)){
                igualTexto = true;
                cont2 = cont;
            }                        
            cont++;
        }
        return cont2;
    }

    /**
     * muestra todas las tareas con un bucle while. (las muestra numeradas.)
     */
    public void mostrarTarea22(){
        int cont = 0;
        while(cont < listaDeTareas.size()){
            String sol = (cont +1)+ ". " +listaDeTareas.get(cont)+ " ----------------- HECHA";
            if(tareaHecha.get(cont) == true ){
                System.out.println(sol);
            }
            else{
                System.out.println((cont +1)+ ". " +listaDeTareas.get(cont));
            }
            cont++;
        }
        System.out.println("======================");
        System.out.println("");
    }

    /**
     * mt que marca una tarea como completada.
     */
    public void marcaComoCompletada(int numeroTarea){
        numeroTarea = numeroTarea -1;
        if(numeroTarea >= 0 && numeroTarea < listaDeTareas.size()){
            int cont = 0;
            while(cont < listaDeTareas.size() && numeroTarea < listaDeTareas.size()){
                if(cont == numeroTarea){
                    tareaHecha.set(cont, true);
                }  
                cont ++;
            }
        }
        else{
            System.out.println("Herror, solo es válido el intervalo [ 1 / " +listaDeTareas.size()+ " ].");
            System.out.println("======================");
            System.out.println("");
        }
    }
}

