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
    static int MaxN = 15;
    Warehouse[] almacenes;
    int[][] mAdy;
    
    
    //Inicializo la matriz con 0s
    public MatrizAdy(){
        this.mAdy = new int [MaxN][MaxN];
        this.almacenes = new Warehouse[MaxN];
        this.numAlmacenes = 0;
        for (int i = 0; i < MaxN; i++){
            for (int j = 0; i < MaxN; i++){
                mAdy[i][j] = 0;
            }
        }
    }
    
    public void nuevoAlmacen(String nombre, ListMaker inventario){
        if (this.numAlmacenes == MaxN){return;}
        Warehouse nuevo = new Warehouse(nombre, inventario);
        for (int t = 0; t < MaxN; t++){
            if(nuevo.iguales(this.almacenes[t])){return;}
            nuevo.assignNum(this.numAlmacenes);
            this.almacenes[this.numAlmacenes++] = nuevo;
        }
    }
}
