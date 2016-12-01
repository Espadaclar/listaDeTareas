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
	

    /**
     * Constructor for objects of class ListaTareas
     */
    public ListaTareas()
    {
		listaDeTareas = new ArrayList<String>();
    }
    
    /**
     * Imprime por pantalla todas las tareas guardadas
     */
    public void verTareas()
    {
    	System.out.println(listaDeTareas);
    }
    
	/**
	 * Permite añadir una nueva tarea
	 */
	 public void addTarea(String nuevaTarea)
	 {
		listaDeTareas.add(nuevaTarea);
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
	  */
	 public void eliminaTarea(int posicion) 
	 {
	     listaDeTareas.remove(posicion);
	 }

	 

}