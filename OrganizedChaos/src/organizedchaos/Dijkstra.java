/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

/**
 *
 * @author CATATO
 */
public class Dijkstra {
    String nombreAlmacen; //Almacena el nombre del almacen
    Integer distMinimaInicio; //Se inicializa la distancia en 999
    String predecesor; //Guarda la información del nodo padre
    Boolean visitado; //Para verificar si está o no visitado

    public Dijkstra(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
        this.distMinimaInicio = 999;
        this.predecesor = null;
        this.visitado = false;
    }
    
    
 
    

}
