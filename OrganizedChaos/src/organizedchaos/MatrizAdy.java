/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

/**
 *
 * @author Robert
 */
public class MatrizAdy {
    int numAlmacenes;
    
    //num maximo de Almacenes
    static int MaxN = 25;
    ListMaker almacenes;
    int[][] mAdy;
    
    
    //Inicializo la matriz con 0s
    public MatrizAdy(){
        this.mAdy = new int [MaxN][MaxN];
        this.almacenes = new ListMaker();
        this.numAlmacenes = 0;
        for (int i = 0; i < MaxN; i++){
            for (int j = 0; i < MaxN; i++){
                mAdy[i][j] = 0;
            }
        }
    }
    
    
    //Busca la posicion del almacen en la lista
    public int getNumAlmacen(String check){
        return this.almacenes.find(check);
    }
    
    // Recibe el nombre del almacen y su inventario
    public void nuevoAlmacen(String nombre, ListI inventario){
        if (this.numAlmacenes == MaxN){return;} // Si llegamos al numero maximo de almacenes, salgo
        
        if (!(this.getNumAlmacen(nombre) >= 0)){ // Si el almacen no esta en la lista
            Warehouse nuevo = new Warehouse(nombre, inventario);
            nuevo.assignNum(this.numAlmacenes); // Asigno su posicion
            this.almacenes.insertAt(this.numAlmacenes, nuevo.nombre()); //Agrego a la lista en la posicion
            this.numAlmacenes++; //Aumento el numero de almacenes
        }
        
    }
    
    //Pasamos un almacen para agregar a la matriz
    public void nuevoAlmacen(Warehouse nuevo){ 
        if (this.numAlmacenes == MaxN){return;} // Si llegamos al numero maximo de almacenes, salgo
        
        String nombre = nuevo.nombre();
        
        if (!(this.getNumAlmacen(nombre) >= 0)){ // Si el almacen no esta en la lista
            nuevo.assignNum(this.numAlmacenes); // Asigno su posicion
            this.almacenes.insertAt(this.numAlmacenes, nuevo.nombre()); //Agrego a la lista en la posicion
            this.numAlmacenes++; //Aumento el numero de almacenes
        }
        
    }
    
    
    // Le pasamos una lista de almacenes para inicializar cada almacen
    public void extractAlmacenes(ListW warehouseList){
        ListW.Nodo track = warehouseList.headW; //Nodo para recorrer la lista
        if (track == null) { //Si la lista esta vacia retorna
            System.out.println("No hay almacenes");
            return;
        }
        while (track != null){ //Agrega cada almaccen de la lista a la matriz
            this.nuevoAlmacen(track.info);
            track = track.sig;
        }
    }
    
    public void muestraMatriz(){ //imprime la matriz de adyacencia
        String linea = ""; //string de las lineas
        String columnas = "           "; //string para el nombre de las columnas
        for (int i=0; i<MaxN;i++){
            String nombreFila = "" + this.almacenes.getName(i); //Nombre de la fila
            if (nombreFila.length() > 1){linea += "[" + nombreFila + "]";} //Si el nombre de la fila es mas corto que un caracter, no es un almacen inicializado
            for (int j=0; j<MaxN;j++){
                String nombreColumna = "" + this.almacenes.getName(j); //nombre de las columnas
                if (nombreColumna.length() > 1 && nombreFila.length() > 1){ //Si el nombre de la columna y el nombre de la fila no son mas largos que un caracter, no es un almacen inicializado y no imprimimos su fila
                    columnas += "[" + this.almacenes.getName(j) + "]";
                    if (mAdy[i][j] < 10){
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
    
    
    
    //Recibe el nombre de los almacenes en cada borde del road y su longitud
    public void nuevaCalle(String almacen1, String almacen2, int longitud){
        int wa, wb; //posicion de cada uno de los warehouses
        wa = this.getNumAlmacen(almacen1);
        wb = this.getNumAlmacen(almacen2);
        if (wb < 0 || wa < 0){ // Si NumAlmacen retorna -1, ese almacen no existe
            System.out.println("Almacen no existe");
        }
        mAdy[wa][wb] = longitud; // Asigna el valor de la longitud a la matriz
    }
    
    public void extractRoads(ListS roadsList){ //Funciona como extractWarehouses pero con la lista de calles
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
            this.nuevaCalle(salida, destino, distancia);
            track = track.sig;
        }
    }
}
