/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;


/**
 *Clase de grafo, contiene las listas de almacenes y calles, y la matriz de adyacencia.
 * @author Robert
 */
public class Grafo {
    
    ListW warehouseList;
    ListS roadsList;
    MatrizAdy laMatriz;

    /**
     * 
     * @param warehouseList lista de almacenes
     * @param roadsList  lista de calles
     */
    public Grafo(ListW warehouseList, ListS roadsList){ //Lista que tenga nombre de almacen, inventario, y calles de salida
        this.warehouseList = warehouseList;
        this.roadsList = roadsList;
        this.laMatriz = new MatrizAdy();
        this.laMatriz.extractAlmacenes(warehouseList);
        this.laMatriz.extractRoads(roadsList);
    }
    
    /**
     * Imprime la matriz en consola.
     * 
     * FALTA ADAPTAR A INTERFAZ
     * 
     */
    public void mostrarMatriz(){
        this.laMatriz.muestraMatriz();
    }
    
    /**
     * Agrega un nuevo almacen a la matriz de adyacencia.
     * @param almacen Almacen que queremos agregar.
     * @param calle1 Calle que entra o sale, debe haber por lo menos una entrada y una salida, pero podemos inicializar con solo salidas o entradas y despues nos pedira la que falte.
     * @param calle2 
     */
    public void agregarAlmacen(Warehouse almacen, Street calle1, Street calle2){
        this.laMatriz.nuevoAlmacen(almacen);
        this.laMatriz.nuevaCalle(calle1.out, calle1.in, calle1.distance, this.roadsList);
        this.laMatriz.nuevaCalle(calle2.out, calle2.in, calle2.distance, this.roadsList);
        
    }
    
    
    /**
     * 
     * @param calle 
     */
    public void agregarCalle(Street calle){
        
        this.laMatriz.nuevaCalle(calle.out, calle.in, calle.distance, this.roadsList);
        this.roadsList.addLast(calle);
    }
    
    
    /**
     * cambia el atributo visitado de todos los nodos a false.
     * lo utilizamos despues del BFS y DFS
     */
    public void resetVisitado(){
        for (int i = 0; i < this.warehouseList.getSize(); i++){
            this.warehouseList.setVisitado(i, false);
        }
    }
    
    /**
     * Elimina el nodo nombreNodo del grafo e inicializa un grafo nuevo con los nodos existentes.
     * @param nombreNodo
     * @return 
     */
    public Grafo eliminarNodo(String nombreNodo){
        this.warehouseList.removeNode(nombreNodo);
        return new Grafo(this.warehouseList, this.roadsList);
    }
    
    /**
     * Chequea que todos los nodos tengan al menos una entrada y una salida.
     */
    public void checkStreets(){
        for (int i = 0; i < this.laMatriz.numAlmacenes; i++){
            int fila = 0;
            for (int j = 0; j < this.laMatriz.numAlmacenes; j++){
                fila += laMatriz.mAdy[i][j];
            }
            if(fila < 1){
                System.out.println(this.warehouseList.getName(i) + " necesita una salida"); // aqui quiero que me pida un input para una calle, y despues vuelvo a chequear
                return;
            }
        }
        
        for (int i = 0; i < this.laMatriz.numAlmacenes; i++){
            int fila = 0;
            for (int j = 0; j < this.laMatriz.numAlmacenes; j++){
                fila += laMatriz.mAdy[j][i];
            }
            if(fila < 1){
                System.out.println(this.warehouseList.getName(i) + " necesita una entrada"); // aqui quiero que me pida un input para una calle, y despues vuelvo a chequear
                return;
            }
        }
    }
    
    public void BFS(Warehouse inicio){
        ColaW queue = new ColaW();
        int almacen = this.warehouseList.getPos(inicio);
        if (almacen >= 0){
            for (int i = 0; i <= laMatriz.numAlmacenes; i ++){
                if (laMatriz.mAdy[almacen][i] > 0){
                    Warehouse nuevo = this.warehouseList.getWarehouse(i);
                    if (!nuevo.getVisitado()){queue.push(nuevo);}
                    nuevo.setVisitado(true);
                }
            }
        }
        inicio.cambiarVisitado(true);
        System.out.println(inicio.name);
        BFS(queue.pop(), queue);        
    }
    
    public void BFS(Warehouse inicio, ColaW queue){

        int almacen = this.warehouseList.getPos(inicio);
        if (almacen >= 0){
            for (int i = 0; i <= laMatriz.numAlmacenes; i ++){
                if (laMatriz.mAdy[almacen][i] > 0){
                    Warehouse nuevo = this.warehouseList.getWarehouse(i);
                    if (!nuevo.getVisitado()){queue.push(nuevo);}
                    nuevo.setVisitado(true);
                }
            }
        }
        try {
            inicio.cambiarVisitado(true);
            System.out.println(inicio.name);
            BFS(queue.pop(), queue); 
        } catch (Exception e){
            this.resetVisitado();
        }
    }
    

    public void DFS(Warehouse inicio){
        PilaW stack = new PilaW();
        int almacen = this.warehouseList.getPos(inicio);
        if (almacen >= 0){
            for (int i = 0; i <= laMatriz.numAlmacenes; i ++){
                if (laMatriz.mAdy[almacen][i] > 0){
                    Warehouse nuevo = this.warehouseList.getWarehouse(i);
                    if (!nuevo.getVisitado()){stack.push(nuevo);}
                    nuevo.setVisitado(true);
                }
            }
        }
        inicio.cambiarVisitado(true);
        System.out.println(inicio.name);
        DFS(stack.pop(), stack);        
    }
    
    public void DFS(Warehouse inicio, PilaW stack){
        int almacen = this.warehouseList.getPos(inicio);
        if (almacen >= 0){
            for (int i = 0; i <= laMatriz.numAlmacenes; i ++){
                if (laMatriz.mAdy[almacen][i] > 0){
                    Warehouse nuevo = this.warehouseList.getWarehouse(i);
                    if (!nuevo.getVisitado()){stack.push(nuevo);}
                    nuevo.setVisitado(true);
                }
            }
        }
        try {
            inicio.cambiarVisitado(true);
            System.out.println(inicio.name);
            DFS(stack.pop(), stack); 
        } catch (Exception e){
            this.resetVisitado();
        }
    }

}
