/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

import Estructuras.ListaSimple;

/**
 *
 * @author Robert
 */
public class Grafo {
    class NodoGrafo{
        Warehouse almacen;
        ListaSimple salidas;
        
        public NodoGrafo(Warehouse almacen, ListaSimple salidas){
            this.almacen = almacen;
            this.salidas = salidas;
        }
    }
    
    NodoGrafo[][] matrizAdy;

    
    public Grafo(ListaSimple almacenes){ //Lista que tenga nombre de almacen, inventario, y calles de salida
        
    }
}
