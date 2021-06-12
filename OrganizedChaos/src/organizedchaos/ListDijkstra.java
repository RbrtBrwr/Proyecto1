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
    
    public boolean quedanNodosSinVisitar(ListDijkstra this){
        for (int i = 0; i < this.getSize(); i++) {
            System.out.println(this.getSize());
            System.out.println(i);
            this.showNodes();
            
        }
//        this.pFirstDijkstra.pInfo.nombreAlmacen
        return true;
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
