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
    
    public void createPathMatrix (Grafo miGrafo, int size){
        weightMatrix = miGrafo.laMatriz.mAdy;
        vertixNumber = size;
        pathMatrix = new int [vertixNumber][vertixNumber];
        shortPath = new int [vertixNumber][vertixNumber];
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
    public int returnDistance (int wareHouse1, int wareHouse2){
        int distance = pathMatrix [wareHouse1][wareHouse2];
        return distance;
    }
    public VisitedWarehousesList showPath(int wareHouse1, int wareHouse2){
        VisitedWarehousesList list = new VisitedWarehousesList();
        while((shortPath [wareHouse1][wareHouse2] != -1)){
           int first = shortPath [wareHouse1][wareHouse2]; 
           list.addFirst(first);
           wareHouse1 = first;
        }
        return list;
    }
    public int[][] getPathMatrix(){
        return pathMatrix;
    }
}