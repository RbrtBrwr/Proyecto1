/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;


import javax.swing.JOptionPane;



/**
 *Clase de grafo, contiene las listas de almacenes y calles, y la matriz de adyacencia.
 * @author Robert
 */
public class Grafo {
    
    ListW warehouseList;
    ListS roadsList;
    MatrizAdy laMatriz;
    int size;


    /**
     * 
     * @param warehouseList lista de almacenes
     * @param roadsList  lista de calles
     */
    
    public Grafo(){
        
    }
    
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
    public Grafo agregarAlmacen(Warehouse almacen, Street calle1, Street calle2){
        switch (this.laMatriz.nuevoAlmacen(almacen)) {
            case 1:
                System.out.println("Nodo ya existe");
                break;
            case 2:
                System.out.println("Maximo de nodos alcanzados");
                break;
            default:
                this.warehouseList.addLast(almacen);
                this.roadsList.addLast(calle2);
                this.roadsList.addLast(calle1);
                size ++;
                return new Grafo(warehouseList, roadsList);
        }
        return null;
    }
    
    /**
     * 
     * @param calle 
     */
    public void agregarCalle(Street calle){
        if (calle.distance < 1){
            System.out.println("Calle invalida");
            return;
        }
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
        size --;
        return new Grafo(this.warehouseList, this.roadsList);
    }
    
    /**
     * Chequea que todos los nodos tengan al menos una entrada y una salida.
     */
    public void checkStreets(){
        for (int i = 0; i < this.laMatriz.numAlmacenes; i++){
            int fila = 0;
            for (int j = 0; j < this.laMatriz.numAlmacenes; j++){
                if (0 < laMatriz.mAdy[i][j]){
                    fila += laMatriz.mAdy[i][j];
                }
                
            }
            if(fila < 1){
                System.out.println(this.warehouseList.getName(i) + " necesita una salida"); // aqui quiero que me pida un input para una calle, y despues vuelvo a chequear
                return;
            }
        }
        
        for (int i = 0; i < this.laMatriz.numAlmacenes; i++){
            int fila = 0;
            for (int j = 0; j < this.laMatriz.numAlmacenes; j++){
                if (0 < laMatriz.mAdy[j][i]){
                    fila += laMatriz.mAdy[j][i];
                }
                
            }
            if(fila < 1){
                System.out.println(this.warehouseList.getName(i) + " necesita una entrada"); // aqui quiero que me pida un input para una calle, y despues vuelvo a chequear
                return;
            }
        }
        
        System.out.println("Todo en orden");
    }
    
    /**
     * retorna todos los items del inventario con sus cantidades
     * @param info
     * @return String
     */
    public String mostrarTodos(Warehouse info){
        return info.mostrarInventario();
    }
    
    /**
     * Retorna solamente el producto especificado por almacen y su cantidad
     * @param info
     * @param producto
     * @return String
     */
    public String mostrarProducto(Warehouse info, String producto){
        return info.buscarProducto(producto);
    }
    
    /**
     * Breadth First Search todos los items, metodo inicial
     * Imprime el inventario de cada Warehouse en el orden del BFS
     * @return outString string con las cosas
     */
    public String BFSTodo(){
        String outString = "";
        Warehouse inicio = this.warehouseList.getWarehouse(0);
        inicio.setVisitado(true);
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
        outString += "\n----- BFS: -----\n" + this.mostrarTodos(inicio) + "\n" + BFSTodo(queue.pop(), queue);
        
        return outString;
    }
    
    /**
     * Breadth First Search todos los items metodo secundario, lo llama el metodo inicial
     * @param inicio
     * @param queue 
     * @return outString string con las cosas
     */
    public String BFSTodo(Warehouse inicio, ColaW queue){
        String outString = "";
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
        inicio.setVisitado(true);
        outString += this.mostrarTodos(inicio) + "\n";
        if (!queue.empty()){
            
            outString += BFSTodo(queue.pop(), queue); 
        } 
        this.resetVisitado();
        return outString;

        

    }
    
    /**
     * BFSItem inicial
     * Busca un item especifico mediante BFS
     * @param item 
     * @return  String con la diponibiliadad
     */
    public String BFSItem(String item){
        String outString = "";
        Warehouse inicio = this.warehouseList.getWarehouse(0);
        //outString += "\n----- BFS: -----\n";
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
        outString += this.mostrarProducto(inicio, item) + "\n";
        inicio.setVisitado(true);
        if (outString.length() < 3){
            outString = BFSItem(item, queue.pop(), queue);
        } else {
            outString += BFSItem(item, queue.pop(), queue);
        }
        outString = "\n----- DFS: -----\n" + outString; 
        return outString;
    }
    
    /**
     * BFSItem metodo secundario
     * @param item
     * @param inicio
     * @param queue 
     * @return  String con los items
     */
    public String BFSItem(String item, Warehouse inicio, ColaW queue){
        String outString = "";
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
        inicio.setVisitado(true);
        outString += this.mostrarProducto(inicio, item) + "\n";
        if (!queue.empty()){
            if (outString.length() < 3){
                outString = BFSItem(item, queue.pop(), queue);
            } else {
                outString += BFSItem(item, queue.pop(), queue);
            }
        }

        this.resetVisitado();
        return outString;

    }
    
    /**
     * Depth First Search todos los items, metodo inicial
     * Imprime el inventario de cada warehouse en orden del DFS, empezando por el primero de la lista
     * @return String con los inventarios
     */
    public String DFSTodo(){
        String outString = "";
        Warehouse inicio = this.warehouseList.getWarehouse(0);
        inicio.setVisitado(true);
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
        outString += this.mostrarTodos(inicio) + "\n" + DFSTodo(stack.pop(), stack);

        outString = "\n----- DFS: -----\n" + outString;
        return outString;
    }
    
    /**
     * Depth First Search todos los items, metodo secundario
     * @param inicio
     * @param stack 
     * @return  String con el inventario
     */
    public String DFSTodo(Warehouse inicio, PilaW stack){
        String outString = "";
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
        
        inicio.setVisitado(true);
        outString += this.mostrarTodos(inicio) + "\n";
        if (!stack.empty()){
            if (outString.length() < 3){
                outString = DFSTodo(stack.pop(), stack);
            } else {
                outString += DFSTodo(stack.pop(), stack);
            }
        }
        this.resetVisitado();
        return outString;
    }
    
    /**
     * Metodo DFS item inicial
     * Busca item especificado com DFS
     * @param item 
     * @return  String con los warehouses que tienen el item
     */
    public String DFSItem(String item){
        String outString = "";
        Warehouse inicio = this.warehouseList.getWarehouse(0);
        //outString += "\n----- DFS: -----\n";
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
        outString += this.mostrarProducto(inicio, item) + "\n";
        inicio.setVisitado(true);
        if (outString.length() < 3){
            outString = DFSItem(item, stack.pop(), stack);
        } else {
            outString += DFSItem(item, stack.pop(), stack);
        }
        
        outString = "\n----- DFS: -----\n" + outString; 
        return outString;
    }
    
    /**
     * Metodo DFS item secundario
     * @param item
     * @param inicio
     * @param stack 
     * @return  String con los warehouses que tienene el item
     */
    public String DFSItem(String item, Warehouse inicio, PilaW stack){
        String outString = "";
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
        
        outString += this.mostrarProducto(inicio, item) + "\n";
        inicio.setVisitado(true);
        if (!stack.empty()){
            if (outString.length() < 3){
                outString = DFSItem(item, stack.pop(), stack);
            } else {
                outString += DFSItem(item, stack.pop(), stack);
            }
            
        }
        this.resetVisitado();
        return outString;
    }
    
    /**
     * FloydWarshall temporal.
     * @return 
     */
    public MatrizAdy FWtemp(){
        MatrizAdy floydW = new MatrizAdy();
        for (int e = 0; e < laMatriz.numAlmacenes; e++){
            for (int f = 0; f < laMatriz.numAlmacenes; f++){
                if (e == f){
                    floydW.mAdy[e][f] = 0;
                }
                else if (laMatriz.mAdy[e][f] == -1){
                    floydW.mAdy[e][f] = 999;
                }
                else {
                    floydW.mAdy[e][f] = laMatriz.mAdy[e][f];
                }
            }
        }
        
        for (int k = 0; k < laMatriz.numAlmacenes; k++){
            for (int i = 0; i < laMatriz.numAlmacenes; i++){
                for (int j = 0; j < laMatriz.numAlmacenes; j++){
                    if (floydW.mAdy[i][j] > floydW.mAdy[i][k] + floydW.mAdy[k][j]){
                        System.out.println(warehouseList.getName(i) + " - " + floydW.mAdy[i][k] + " -> " + warehouseList.getName(k) + " - " + floydW.mAdy[k][j] + " -> " + warehouseList.getName(j) + " = " + (floydW.mAdy[k][j] + floydW.mAdy[i][k]));
                        floydW.mAdy[i][j] = floydW.mAdy[i][k] + floydW.mAdy[k][j];
                    }
                }
            }
        }
        
        floydW.almacenes = this.laMatriz.almacenes;
        return floydW;
    }

     /**
     * Realiza el pedido de la lista.
     * @param pedido
     * @param almacen
     * @param floyd
     * @param itemList
     * @return 
     */
    public ListI realizarPedido(ListI pedido, Warehouse almacen, FloydWarshallAlgorithm floyd, ListI itemsList){
        ListI envio = new ListI();
        envio = almacen.envios(pedido, envio, itemsList);
        if (pedido.empty()){
            return envio;
        } else {
            Warehouse cercano = warehouseList.getWarehouse(almacen.getNearest(floyd.getPathMatrix(), warehouseList.getSize()));
            VisitedWarehousesList path = floyd.showPath(cercano.numAlmacen, almacen.numAlmacen);
            String pathW = "";
            for (int i = 0; i < path.getSize(); i++) {
                int wN = path.getInfo(i).info;
                if (i == path.getSize() - 1){
                   pathW += warehouseList.getName(wN); 
                }
                else{
                    pathW += warehouseList.getName(wN) + " <==== ";
                }

            }
            JOptionPane.showMessageDialog(null, "Se visitaron los siguientes almacenes para completar su pedido: \n" + pathW + "\n Se recorrió una distancia de: " + floyd.returnDistance(cercano.numAlmacen, almacen.numAlmacen));
            envio.juntar(this.realizarPedido(pedido, cercano, floyd, itemsList));
        }
        return envio;
    }
    
    /**
     * Agrega un pedido a la lista.
     * @param pedido
     * @param cantidad
     * @return 
     */
    public void agregarPedido(ListI pedido, String item, int cantidad){
        Inventory nuevo = new Inventory(item, cantidad);
        pedido.agregarItem(nuevo);
    }
    
    /**
     * Agrega al inventario.
     * @param almacen
     * @param item
     * @param cantidad
     * @return 
     */
    public void agregarInventario(Warehouse almacen, String item, int cantidad){
        almacen.agregarProducto(item, cantidad);
    }
    
    /**
     * Genera String para guardar los Cambios.
     * @return 
     */
    public String paraGuardar(){
        String almacenes = this.warehouseList.guardarArchivo();
        String rutas = this.roadsList.guardarArchivo();
        String archivo = almacenes + rutas;
        return archivo;
    }

}
