/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizedchaos;

/**
 *
 * @author Ignacio
 */
public class FloydWarshallAlgorithm {
    private int vertixNumber;
    private int [][] weightMatrix;
    private int [][] pathMatrix;
    private int [][] shortPath;
    int a;
    int b;
    


    public FloydWarshallAlgorithm (Grafo miGrafo, int size){
        this.weightMatrix = miGrafo.laMatriz.mAdy;
        this.vertixNumber = size;
        this.pathMatrix = new int [vertixNumber][vertixNumber];
        this.shortPath = new int [vertixNumber][vertixNumber];
    }
    
    /**
    * Genera la matriz de distancias minimas y de caminos.
    */
    public void createPathMatrix (){

        for (int j = 0; j < vertixNumber; j++) {
            for (int k = 0; k < vertixNumber; k++) {
                shortPath [j][k] = k;
            }    
        }
        for (int i = 0; i < vertixNumber; i++) {
            for (int j = 0; j < vertixNumber; j++) {
                if (weightMatrix [i][j] != -1) {   
                    pathMatrix [i][j] = weightMatrix [i][j];
                }
                else if (i == j) {
                    pathMatrix [i][j] = 0;
                    shortPath [i][j] = -1;
                }
                else {
                    pathMatrix [i][j] = 999; 
                }
            }
        }
        for (int i = 0; i < vertixNumber; i++) {
            for (int j = 0; j < vertixNumber; j++) {
                for (int k = 0; k < vertixNumber; k++) {
                    if (pathMatrix [j][k] > pathMatrix [j][i] + pathMatrix [i][k]) {
                        pathMatrix [j][k] = pathMatrix [j][i] + pathMatrix [i][k];
                        shortPath [j][k] = i;
                    }
                }
            }
        }   
    }
    
    /**
    * Retorna la distancia minima entre dos almacenes.
    * @param wareHouse1
    * @param wareHouse2
    * @return int distancia.
    */
    public int returnDistance (int wareHouse1, int wareHouse2){
        int distance = pathMatrix [wareHouse1][wareHouse2];
        return distance;
    }
    
    /**
    * Crea una lista con los almacenes que se visitan para llegar de un almacen a otro.
    * @param wareHouse1
    * @param wareHouse2
    * @return lista de almacenes visitados.
    */
    public VisitedWarehousesList showPath(int wareHouse1, int wareHouse2){
        VisitedWarehousesList list = new VisitedWarehousesList();
        list.addLast(wareHouse1);
        while((wareHouse1 != wareHouse2)){
           int first = shortPath [wareHouse1][wareHouse2]; 
           list.addFirst(first);
           wareHouse1 = first;
        }
        return list;
    }
    
    /**
    * Retorna la matriz de caminos.
    * @return matriz de caminos.
    */
    public int[][] getPathMatrix(){
        this.createPathMatrix();
        return pathMatrix;
    }

}