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
public class ListDijkstra {
    NodoDijkstra pFirstDijkstra = null;
    NodoDijkstra pLastDijkstra = null;

    public void showNodes(){
        NodoDijkstra pAux = pFirstDijkstra;
        if (pAux == null) {
            System.out.println("Lista vacía");
            return;
        }
        while (pAux != null){
            System.out.println(pAux.pInfo.nombreAlmacen+pAux.pInfo.distMinimaInicio+pAux.pInfo.visitado);
            pAux = pAux.pNext;
        }
    }
    
    public boolean isEmpty(){
        return pFirstDijkstra == null;
    }
    
    
    public void addFirst(Dijkstra pInfo){
        NodoDijkstra pNewDijkstra = new NodoDijkstra(pInfo);
        if (pFirstDijkstra == null){
            pFirstDijkstra = pLastDijkstra = pNewDijkstra;
        } else {
            pNewDijkstra.pNext = pFirstDijkstra;
            pLastDijkstra = pNewDijkstra;
        }
    }
    
    
    /**
     * agrega la información que va dentro de los nodos Dijkstra al final
     * @param pInfo
     */    
    
    
    public void addLast (Dijkstra pInfo){
        NodoDijkstra pNewDijkstra = new NodoDijkstra(pInfo);
        if (pFirstDijkstra == null) {
            pFirstDijkstra = pLastDijkstra = pNewDijkstra;
        } else{
            pLastDijkstra.pNext = pNewDijkstra;
            pLastDijkstra = pNewDijkstra;
        }
    }
    
    /**
     * Función para recorrer todos los Almacenes en la lista y verificar si queda alguno sin recorrer (visitar).
     * @param ListDijkstra (this). Son listas con pInfo = [NombreAlmacen, DistanciaMinimaDesdeInicio, Predecesor, Visitado].
     * @return true si quedan almacenes sin visitar.
     * @return false si ya se recorrieron todos los almacenes.
     */
    public boolean quedanAlmacenesSinVisitar(ListDijkstra this){
        NodoDijkstra pAuxDijkstra = pFirstDijkstra; //Nodo auxiliar
        while (pAuxDijkstra.pNext != null){
            if (pAuxDijkstra.pInfo.visitado == false) { 
                return true; //Si retorna verdadero todavía quedan Almacenes sin visitar (todavía hay alguno con visitado en falso)  
            } 
        } return false;  //Ya se recorrieron todos los Almacenes
    }
    
    /**
     * Función para recorrer todos los almacenes y encontrar el almacén más cercano en esa iteración
     * @param ListDijkstra (this). Son listas con pInfo = [NombreAlmacen, DistanciaMinimaDesdeInicio, Predecesor, Visitado].
     * @return índice. Este índice será utilizado para acceder a la fila de la matriz en la matriz de adyacencia
     */
    public int almacenMenorDistancia(ListDijkstra this){
        int menorDistancia = 999;
        int indiceAlmacenActual = 0;
        int index = -1;
        NodoDijkstra pAuxDijkstra = pFirstDijkstra;
        while (pAuxDijkstra.pNext != null){
            index++;
            if (pAuxDijkstra.pInfo.visitado == false) {
                if (pAuxDijkstra.pInfo.distMinimaInicio <= menorDistancia) {
                    menorDistancia = pAuxDijkstra.pInfo.distMinimaInicio;
                    indiceAlmacenActual = index;   
                }
            }
        } return indiceAlmacenActual;
    }
    
    /**
     * Esta función va modificando la Matriz de Adyacencia
     * @param miGrafo. El parámetro miGrafo se utiliza para acceder a la Matriz de Adyacencia que se encuentra dentro de grafo.
     * @param indiceAlmacenActual. Es el índice obtenido en la función nodoMenorDistancia y representa al Almacen más cercano al que estaba siendo recorrido. 
     */
//    public void actualizarTabla(ListDijkstra this, Grafo miGrafo, int indiceAlmacenActual){
//        for (int i = 0; i < miGrafo.laMatriz.mAdy[indiceAlmacenActual].length; i++) { //Se recorren las columnas de la fila correspondiente al Almacen actual en la Matriz de Adyacencia.
//            if (miGrafo.laMatriz.mAdy[indiceAlmacenActual][i] != -1) && ()  {
//                
//            }  
//        }
//             
//        
//    }
    
    public Dijkstra getInfoAlmacen(int indiceAlmacenActual){
        NodoDijkstra pAuxDijkstra = pFirstDijkstra;
        int contador = 0;
        if (pAuxDijkstra == null) {
            System.out.println("Lista vacía");
            return null;
        } 
        while (pAuxDijkstra != null){
            if (contador == indiceAlmacenActual) {
                return pAuxDijkstra.pInfo;
            } 
            pAuxDijkstra = pAuxDijkstra.pNext;
            contador++;
        }
        return null;
        
    }        
    
    public int getSize(){
        NodoDijkstra pAuxDijkstra = pFirstDijkstra;
        int contador = 0;
        while (pAuxDijkstra != null){
            pAuxDijkstra = pAuxDijkstra.pNext;
            contador ++;
        }
        return contador;
    }   
}
