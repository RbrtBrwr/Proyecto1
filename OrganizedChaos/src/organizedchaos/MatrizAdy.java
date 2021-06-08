/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

/**
 * Matriz de adyacencia del grafo.
 * @author Robert
 */
public class MatrizAdy {
    int numAlmacenes;
    
    //num maximo de Almacenes
    static int MaxN = 25;
    ListMaker almacenes;
    int[][] mAdy;
    
    
    //Inicializo la matriz con -1s
    public MatrizAdy(){
        this.mAdy = new int [MaxN][MaxN];
        this.almacenes = new ListMaker();
        this.numAlmacenes = 0;
        for (int i = 0; i < MaxN; i++){
            for (int j = 0; j < MaxN; j++){
                mAdy[i][j] = -1;
            }
        }
    }
    
    /**
     * Retorna la posicion del almacen en la lista.
     * @param check
     * @return -1 si no lo encuentra.
     */
    
    public int getNumAlmacen(String check){
        return this.almacenes.find(check);
    }
    
    /**
     * Recibe el nombre del almacen y su inventario para agregarlo a la matriz.
     * @param nombre
     * @param inventario 
     * @return  int, 1 si ya existe, 2 si ya estamos en maximo almacenes, 0 si se agrego exitosamente;
     */
    public int nuevoAlmacen(String nombre, ListI inventario){
        if (this.numAlmacenes == MaxN){return 2;} // Si llegamos al numero maximo de almacenes, salgo
        
        if (!(this.getNumAlmacen(nombre) >= 0)){ // Si el almacen no esta en la lista
            Warehouse nuevo = new Warehouse(nombre, inventario);
            nuevo.assignNum(this.numAlmacenes); // Asigno su posicion
            this.almacenes.insertAt(this.numAlmacenes, nuevo.nombre()); //Agrego a la lista en la posicion
            this.numAlmacenes++; //Aumento el numero de almacenes
            return 0;
        }
        return 1;
        
    }
    
    /**
     * Pasamos un almacen para agregar a la matriz
     * @param nuevo 
     * @return  int, 1 si ya existe, 2 si ya estamos en maximo almacenes, 0 si se agrego exitosamente;
     */
    public int nuevoAlmacen(Warehouse nuevo){ 
        if (this.numAlmacenes == MaxN){return 2;} // Si llegamos al numero maximo de almacenes, salgo
        
        String nombre = nuevo.nombre();
        
        if (!(this.getNumAlmacen(nombre) >= 0)){ // Si el almacen no esta en la lista
            nuevo.assignNum(this.numAlmacenes); // Asigno su posicion
            this.almacenes.insertAt(this.numAlmacenes, nuevo.nombre()); //Agrego a la lista en la posicion
            this.numAlmacenes++; //Aumento el numero de almacenes
            return 0;
        }
        
        return 1;
        
    }
    
    
    /**
     * Le pasamos una lista de almacenes para inicializar cada almacen
     * @param warehouseList 
     */
    public void extractAlmacenes(ListW warehouseList){
        NodoW track = warehouseList.headW; //Nodo para recorrer la lista
        if (track == null) { //Si la lista esta vacia retorna
            System.out.println("No hay almacenes");
            return;
        }
        while (track != null){ //Agrega cada almaccen de la lista a la matriz
            this.nuevoAlmacen(track.info);
            track = track.sig;
        }
    }
    
    /**
     * imprime la matriz de adyacencia
     */
    public void muestraMatriz(){
        String linea = ""; //string de las lineas
        String columnas = "           "; //string para el nombre de las columnas
        for (int i=0; i<MaxN;i++){
            String nombreFila = "" + this.almacenes.getName(i); //Nombre de la fila
            if (nombreFila.length() > 1){linea += "[" + nombreFila + "]";} //Si el nombre de la fila es mas corto que un caracter, no es un almacen inicializado
            for (int j=0; j<MaxN;j++){
                String nombreColumna = "" + this.almacenes.getName(j); //nombre de las columnas
                if (nombreColumna.length() > 1 && nombreFila.length() > 1){ //Si el nombre de la columna y el nombre de la fila no son mas largos que un caracter, no es un almacen inicializado y no imprimimos su fila
                    columnas += "[" + this.almacenes.getName(j) + "]";
                    if (mAdy[i][j] < 0){
                        linea += "[   " + mAdy[i][j] + "    ]";                    
                    } else if (mAdy[i][j] < 10){
                        linea += "[    " + mAdy[i][j] + "    ]";
                    } else if (nombreColumna.length() < 100){
                        linea += "[    " + mAdy[i][j] + "   ]";
                    } else {
                        linea += "[   " + mAdy[i][j] + "   ]";
                    }
                    
                }
            }
            if (i == 0){System.out.println(columnas);} //Si estamos en el primer ciclo imprimimos el nombre de las columnas
            if (linea.length() > 0){
                System.out.println(linea);
                linea = "";
            }
        }
    }
    
    
    
    /**
     * Recibe el nombre de los almacenes en cada borde del road, su longitud y la lista de calles del grafo.
     * @param almacen1
     * @param almacen2
     * @param longitud
     * @param listRoads 
     */
    public void nuevaCalle(String almacen1, String almacen2, int longitud, ListS listRoads){
        int wa, wb; //posicion de cada uno de los warehouses
        wa = this.getNumAlmacen(almacen1);
        wb = this.getNumAlmacen(almacen2);
        if (wb < 0 || wa < 0){ // Si NumAlmacen retorna -1, ese almacen no existe
            //System.out.println("Almacen no existe");

            listRoads.removeRd(almacen1, almacen2, longitud);
            return;
            //Eliminar esa calle de la listaI?
        } else if (wa == wb){ // Si son iguales no lo meto porque no quiero calles a si mismo

            listRoads.removeRd(almacen1, almacen2, longitud);
            return;
        }
        mAdy[wa][wb] = longitud; // Asigna el valor de la longitud a la matriz
    }
    
    /**
     * Funciona como extractWarehouses pero con la lista de calles
     * @param roadsList 
     */
    public void extractRoads(ListS roadsList){ 
        ListS.Nodo track = roadsList.headS;
        if (track == null) {
            System.out.println("No hay almacenes");
            return;
        }
        while (track != null){
            String salida = track.info.out;
            String destino = track.info.in;
            int distancia = track.info.distance;
            if (distancia == 0){distancia = -1;}
            this.nuevaCalle(salida, destino, distancia, roadsList);
            track = track.sig;
        }
    }
    
    
}
