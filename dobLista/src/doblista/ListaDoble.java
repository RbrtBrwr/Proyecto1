/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doblista;

/**
 *
 * @author Robert
 */

public class ListaDoble {

    /**
     * @param args the command line arguments
     */
    
    class Nodo {
        int cedula;
        String nombre;
        Nodo prev;
        Nodo sig;

        public Nodo(String nombre, int cedula){
            this.cedula = cedula;
            this.nombre = nombre; 
            this.prev = this.sig = null;
        }
    }
    Nodo head = null;
    Nodo tail = null;
    
    
    public void addLast(String nombre, int cedula){
        Nodo nuevo = new Nodo(nombre, cedula);
        if (head == null){
            head = tail = nuevo;
        } else {
            nuevo.prev = tail;
            nuevo.sig = null;
            tail.sig = nuevo;
            tail = nuevo;
        }
    }
    
    public void addFirst(String nombre, int cedula){
        Nodo nuevo = new Nodo(nombre, cedula);
        if (head == null){
            head = tail = nuevo;
        } else {
            nuevo.sig = head;
            nuevo.prev = null;
            head.prev = nuevo;
            head = nuevo;
        }
    }
     
    public void showNodes(boolean reverse){
        if (reverse){
            
            Nodo track = tail;
            if (track == null) {
                System.out.println("Lista vacia");
                return;
            }
            while (track != null){
                System.out.println(track.nombre + ": " + track.cedula);
                track = track.prev;
            }
            
        } else {
            
            Nodo track = head;
            if (track == null) {
                System.out.println("Lista vacia");
                return;
            }
            while (track != null){
                System.out.println(track.nombre + ": " + track.cedula);
                track = track.sig;
            }
        }
    }
    
    public void eliminar(int cedula){
        if (head == null) {return;}
        Nodo trackNode = head;
        while (trackNode != null){
            if (trackNode.cedula == cedula){
                Nodo previo = trackNode.prev;
                Nodo siguiente = trackNode.sig;
                
                if (trackNode.prev == null && trackNode.sig == null){
                    head = tail = null;
                    return;
                } else if (trackNode.prev == null){
                    head = siguiente;
                    siguiente.prev = null;
                    return;
                } else if (trackNode.sig == null){
                    tail = previo;
                    previo.sig = null;
                    return;
                } else {
                    siguiente.prev = previo;
                    previo.sig = siguiente;
                    return;
                }

            } 
            if (trackNode.sig == null){return;}
            else {
                trackNode = trackNode.sig;
            }
        }
    }
    
    public void ordenar(boolean creciente){
        /*
        Recursiva, busca la cedula mas grande de la lista, la elimina, llama la funcion nuevamente
        y luego dependiendo de si queremos ordenar en orden creciente o decreciente va agregando los nodos nuevamente
        al final o al inicio de la lista respectivamente.
        */
        
        Nodo trackNode = head;
        
        if (trackNode == null){ return; }
        
        

            Nodo testNode = trackNode.sig;
            Nodo highest = trackNode;
            while (testNode != null){
                if (testNode.cedula > highest.cedula){
                    highest = testNode;
                }
                testNode = testNode.sig;
            }
            String nombre = highest.nombre;
            int cedula = highest.cedula;
            this.eliminar(cedula);
            this.ordenar(creciente);
            if (creciente){
                this.addLast(nombre, cedula);
            } else {
                this.addFirst(nombre, cedula);
            }
    }
    

    


    public static void main(String[] args) {
    // TODO code application logic here
    //create a DoublyLinkedList object
        ListaDoble testList = new ListaDoble();  
        //Add nodes to the list  
        testList.addFirst("a",1);  
        testList.addFirst("b",2);  
        testList.addFirst("c",3);  
        testList.addFirst("d",4);  
        testList.addFirst("e",5);  
        testList.addLast("prueba", 0);
        testList.addLast("Hombre", 45678);
   
        //print the nodes of DoublyLinkedList  
        testList.showNodes(false); 
        testList.showNodes(true); 
        
    }
}



