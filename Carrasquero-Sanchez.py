#Universidad Metropolitana
#Modelación de Sistemas en Redes

#Estudiantes: 
#- Esther Sánchez, carnet: 20171110245, correo: esther.sanchez@correo.unimet.edu.ve, número telefónico: 04242196743
#- Carlos H. Carrasquero, carnet: 20161110271, correo: ccarrasquero@correo.unimet.edu.ve, número telefónico: 04141181358

#Profesor: Rafael Matienzo

#Proyecto N° 1


class Nodo:
    def __init__(self, i): 
        self.id = i
        self.vecinos = []
        self.visitado = False
        self.padre = None
        self.peso = float('inf')
        self.distancia = float('inf')
        
    def agregarVecino(self, v, p,saltos):
        if v not in self.vecinos:
            self.vecinos.append([v, p])
            
    def agregarVecinoRutaCorta(self, v, p, saltos):
        if v not in self.vecinos:
            self.vecinos.append([v, saltos])

class Grafo:
    def __init__(self):
        self.nodos = {}
        self.viajes = {}
        self.ruta = []
        self.saltos = []

        
    def agregarNodo(self, id):
        if id not in self.nodos:
            self.nodos[id] = Nodo(id)
            
    def agregarArista(self, a, b, p, saltos):
        if a in self.nodos and b in self.nodos:
            self.nodos[a].agregarVecino(b, p, saltos)
            self.nodos[b].agregarVecino(a, p, saltos)
            
    def agregarAristaRutaCorta(self, a, b, p, saltos):
        if a in self.nodos and b in self.nodos:
            self.nodos[a].agregarVecinoRutaCorta(b, p, saltos)
            self.nodos[b].agregarVecinoRutaCorta(a, p, saltos)

    def agregarAristaDirigida(self, a, b, p, saltos):
        if a in self.nodos and b in self.nodos:
            self.nodos[a].agregarVecino(b, p, saltos)
                                        
    def agregarAristaRutaCortaDirigida(self, a, b, p, saltos):
        if a in self.nodos and b in self.nodos:
            self.nodos[a].agregarVecinoRutaCorta(b, p, saltos)

    def camino(self, b):
        camino = []
        actual = b
        while actual != None:    
            camino.insert(0, actual)
            actual = self.nodos[actual].padre
        return camino
            
    def minimo(self, lista):
        if len(lista) > 0:
            m = self.nodos[lista[0]].peso
            v = lista[0]
            for e in lista:
                if m > self.nodos[e].peso:
                    m = self.nodos[e].peso
                    v = e
            return v

    def minimo_ruta_corta(self, lista):
        if len(lista) > 0:
            m = self.nodos[lista[0]].distancia
            v = lista[0]
            for e in lista:
                if m > self.nodos[e].distancia:
                    m = self.nodos[e].distancia
                    v = e
            return v
        
    def dijkstra(self, a, b):
        if a in self.nodos:
            self.nodos[a].peso = 0
            actual = a 
            noVisitados = []
            
            for v in self.nodos:
                if v != a:
                    self.nodos[v].peso = float('inf')
                self.nodos[v].padre = None
                noVisitados.append(v)
                
            while self.nodos[b].visitado == False:
                for vecino in self.nodos[actual].vecinos:
                    if self.nodos[vecino[0]].visitado == False:
                        if self.nodos[actual].peso + vecino[1] < self.nodos[vecino[0]].peso:
                            self.nodos[vecino[0]].peso = self.nodos[actual].peso + vecino[1]
                            self.nodos[vecino[0]].padre = actual
                            
                self.nodos[actual].visitado = True
                noVisitados.remove(actual)
                
                actual = self.minimo(noVisitados)
            return self.nodos[b].peso           
        else:
            return False
        
    def dijkstra_ruta_corta(self, a, b):
        if a in self.nodos:
            self.nodos[a].distancia = 0
            actual = a 
            noVisitados = []
            
            for v in self.nodos:
                if v != a:
                    self.nodos[v].distancia = float('inf')
                self.nodos[v].padre = None
                noVisitados.append(v)
                
            while self.nodos[b].visitado == False:
                for vecino in self.nodos[actual].vecinos:
                    if self.nodos[vecino[0]].visitado == False:
                        if self.nodos[actual].distancia + vecino[1] < self.nodos[vecino[0]].distancia: #Pilas con el igual
                            self.nodos[vecino[0]].distancia = self.nodos[actual].distancia + vecino[1]
                            self.nodos[vecino[0]].padre = actual
                            
                self.nodos[actual].visitado = True
                noVisitados.remove(actual)
                
                actual = self.minimo_ruta_corta(noVisitados)
            return self.nodos[b].distancia           
        else:
            return False


continuar = "s"

print("¡Bienvenido a la plataforma de la agencia de viajes Metro Travel!\n")
while (continuar == "s"):
    
    g = Grafo()
    h = Grafo()
    i = Grafo()
    j = Grafo()
                                            
    g.agregarNodo("CCS")
    g.agregarNodo("AUA")
    g.agregarNodo("BON")
    g.agregarNodo("CUR")
    g.agregarNodo("SXM")
    g.agregarNodo("SDQ")
    g.agregarNodo("SBH")
    g.agregarNodo("POS")
    g.agregarNodo("BGI")
    g.agregarNodo("FDF")
    g.agregarNodo("PTP")

    h.agregarNodo("CCS")
    h.agregarNodo("AUA")
    h.agregarNodo("BON")
    h.agregarNodo("CUR")
    h.agregarNodo("SXM")
    h.agregarNodo("SDQ")
    h.agregarNodo("SBH")
    h.agregarNodo("POS")
    h.agregarNodo("BGI")
    h.agregarNodo("FDF")
    h.agregarNodo("PTP")

    i.agregarNodo("CCS")
    i.agregarNodo("AUA")
    i.agregarNodo("BON")
    i.agregarNodo("CUR")
    i.agregarNodo("SXM")
    i.agregarNodo("SDQ")
    i.agregarNodo("SBH")
    i.agregarNodo("POS")
    i.agregarNodo("BGI")
    i.agregarNodo("FDF")
    i.agregarNodo("PTP")

    j.agregarNodo("CCS")
    j.agregarNodo("AUA")
    j.agregarNodo("BON")
    j.agregarNodo("CUR")
    j.agregarNodo("SXM")
    j.agregarNodo("SDQ")
    j.agregarNodo("SBH")
    j.agregarNodo("POS")
    j.agregarNodo("BGI")
    j.agregarNodo("FDF")
    j.agregarNodo("PTP")
    
    g.agregarArista("CCS", "AUA", 40, 1)
    g.agregarArista("CCS", "CUR", 35, 1)
    g.agregarArista("CCS", "BON", 60, 1)
    g.agregarArista("AUA", "CUR", 15, 1)
    g.agregarArista("AUA", "BON", 15, 1)
    g.agregarArista("CUR", "BON", 15, 1)
    g.agregarArista("CCS", "SDQ", 180, 1)
    g.agregarArista("SDQ", "SXM", 50, 1)
    g.agregarArista("SXM", "SBH", 45, 1)
    g.agregarArista("CCS", "POS", 150, 1)
    g.agregarArista("CCS", "BGI", 180, 1)
    g.agregarArista("POS", "BGI", 35, 1)
    g.agregarArista("POS", "SXM", 90, 1)
    g.agregarArista("BGI", "SXM", 70, 1)
    g.agregarArista("POS", "PTP", 80, 1)
    g.agregarArista("POS", "FDF", 75, 1)
    g.agregarArista("PTP", "SXM", 100, 1)
    g.agregarArista("PTP", "SBH", 80, 1)
    g.agregarArista("CUR", "SXM", 80, 1)
    g.agregarArista("AUA", "SXM", 85, 1)

    h.agregarAristaDirigida("CCS", "POS", 150, 1)
    h.agregarAristaDirigida("POS", "CCS", 150, 1)
    h.agregarAristaDirigida("CCS", "BGI", 180, 1)
    h.agregarAristaDirigida("BGI", "CCS", 180, 1)
    h.agregarAristaDirigida("AUA", "CCS", 40, 1)
    h.agregarAristaDirigida("CUR", "CCS", 35, 1)
    h.agregarAristaDirigida("BON", "CCS", 60, 1)
    h.agregarAristaDirigida("SDQ", "CCS", 180, 1)
    h.agregarAristaDirigida("POS", "BGI", 35, 1)
    h.agregarAristaDirigida("BGI", "POS", 35, 1)
    h.agregarAristaDirigida("POS", "PTP", 80, 1)
    h.agregarAristaDirigida("PTP", "POS", 80, 1)
    h.agregarAristaDirigida("POS", "FDF", 75, 1)
    h.agregarAristaDirigida("FDF", "POS", 75, 1)
    h.agregarAristaDirigida("PTP", "SBH", 80, 1)
    h.agregarAristaDirigida("SBH", "PTP", 80, 1)
    h.agregarAristaDirigida("SXM", "POS", 90, 1)
    h.agregarAristaDirigida("SXM", "SBH", 45, 1)
    h.agregarAristaDirigida("SXM", "PTP", 100, 1)
    h.agregarAristaDirigida("SXM", "BGI", 70, 1)

    i.agregarAristaRutaCorta("CCS", "AUA", 40, 1)
    i.agregarAristaRutaCorta("CCS", "CUR", 35, 1)
    i.agregarAristaRutaCorta("CCS", "BON", 60, 1)
    i.agregarAristaRutaCorta("AUA", "CUR", 15, 1)
    i.agregarAristaRutaCorta("AUA", "BON", 15, 1)
    i.agregarAristaRutaCorta("CUR", "BON", 15, 1)
    i.agregarAristaRutaCorta("CCS", "SDQ", 180, 1)
    i.agregarAristaRutaCorta("SDQ", "SXM", 50, 1)
    i.agregarAristaRutaCorta("SXM", "SBH", 45, 1)
    i.agregarAristaRutaCorta("CCS", "POS", 150, 1)
    i.agregarAristaRutaCorta("CCS", "BGI", 180, 1)
    i.agregarAristaRutaCorta("POS", "BGI", 35, 1)
    i.agregarAristaRutaCorta("POS", "SXM", 90, 1)
    i.agregarAristaRutaCorta("BGI", "SXM", 70, 1)
    i.agregarAristaRutaCorta("POS", "PTP", 80, 1)
    i.agregarAristaRutaCorta("POS", "FDF", 75, 1)
    i.agregarAristaRutaCorta("PTP", "SXM", 100, 1)
    i.agregarAristaRutaCorta("PTP", "SBH", 80, 1)
    i.agregarAristaRutaCorta("CUR", "SXM", 80, 1)
    i.agregarAristaRutaCorta("AUA", "SXM", 85, 1)

    j.agregarAristaRutaCortaDirigida("CCS", "POS", 150, 1)
    j.agregarAristaRutaCortaDirigida("POS", "CCS", 150, 1)
    j.agregarAristaRutaCortaDirigida("CCS", "BGI", 180, 1)
    j.agregarAristaRutaCortaDirigida("BGI", "CCS", 180, 1)
    j.agregarAristaRutaCortaDirigida("AUA", "CCS", 40, 1)
    j.agregarAristaRutaCortaDirigida("CUR", "CCS", 35, 1)
    j.agregarAristaRutaCortaDirigida("BON", "CCS", 60, 1)
    j.agregarAristaRutaCortaDirigida("SDQ", "CCS", 180, 1)
    j.agregarAristaRutaCortaDirigida("POS", "BGI", 35, 1)
    j.agregarAristaRutaCortaDirigida("BGI", "POS", 35, 1)
    j.agregarAristaRutaCortaDirigida("POS", "PTP", 80, 1)
    j.agregarAristaRutaCortaDirigida("PTP", "POS", 80, 1)
    j.agregarAristaRutaCortaDirigida("POS", "FDF", 75, 1)
    j.agregarAristaRutaCortaDirigida("FDF", "POS", 75, 1)
    j.agregarAristaRutaCortaDirigida("PTP", "SBH", 80, 1)
    j.agregarAristaRutaCortaDirigida("SBH", "PTP", 80, 1)
    j.agregarAristaRutaCortaDirigida("SXM", "POS", 90, 1)
    j.agregarAristaRutaCortaDirigida("SXM", "SBH", 45, 1)
    j.agregarAristaRutaCortaDirigida("SXM", "PTP", 100, 1)
    j.agregarAristaRutaCortaDirigida("SXM", "BGI", 70, 1)

    ciudades_codigos = {"CCS" : False, "AUA": True,"BON" : True, "CUR" : True, "SXM": True, "SDQ" : True, "SBH" : False, "POS" : False, "BGI": False, "FDF": False, "PTP" : False, }
    
    print("Los destinos disponibles son:", "CCS - CARACAS", "AUA - ARUBA", "BON - BONAIRE", "CUR - CURAZAO", "SXM - SAN MARTÍN", "SDQ - SANTO DOMINGO", "SBH - SAN BARTOLOMÉ", "POS - PUERTO ESPAÑA, TRINIDAD", "BGI - BARBADOS", "FDF - FORT DE FRANCE, MARTINICA", "PTP - POINT A PITRE, GUADALUPE", sep = '\n')
    print()
    
    
    print('Ciudad de origen')
    print("------------------")
    codOrigen = input("Ingrese el código del aeropuerto de origen: ").upper()
    print()
    while (not codOrigen.upper() in ciudades_codigos.keys()):
        print("Ingreso inválido.\n")
        codOrigen = input("Ingrese el código del aeropuerto de origen: ").upper()
        print()
    
    print('Status de visa')  
    print('-----------------')
    print("¿Posee una visa?", "(s) Sí", "(n) No", sep = '\n')
    visa = input(" ")
    while (not visa.isalpha()) or ((visa.lower() != "s") and (visa.lower() != "n")):
        print('Ingreso inválido.\n')
        print("¿Posee una visa?", "(s) Sí", "(n) No", sep = '\n')
        visa = input(" ")
    print()
    
    print('Ciudad de destino')  
    print('-----------------')
    codDestino = input("Ingrese el código del aeropuerto destino: ").upper()
    print()
    while (not codDestino.upper() in ciudades_codigos.keys()) or (codDestino == codOrigen) or (visa == "n" and ciudades_codigos[codDestino.upper()] == True):
        print("Ingreso inválido.\n")
        codDestino = input("Ingrese el código del aeropuerto destino: ").upper()
        print()
    
    
    print('Preferencia de viaje')
    print('-----------------')
    print("Especifique el criterio deseado para viajar:", "(a) Costo mínimo", "(b) Número de vuelos mínimo", "Por favor ingrese la letra correspondiente a la acción que desea realizar: ", sep = '\n')
    criterio = input(" ")
    print()
    while (not criterio.isalpha()) or ((not criterio.lower() == "a") and (not criterio.lower() == "b")):
        print('Ingreso inválido.\n')
        print("Especifique el criterio deseado para viajar:", "(a) Costo mínimo", "(b) Número de vuelos mínimo", "Por favor ingrese la letra correspondiente a la acción que desea realizar: ", sep = '\n')
        criterio = input(" ")
    print()
    
    if visa == "s":
        if criterio == "a":
            print("El costo total es:")
            print(g.dijkstra(codOrigen, codDestino))
            print()
            print("Recorriendo la siguiente ruta:")
            print(g.camino(codDestino))
        else:
            print("El cantidad de escalas es:")
            print(i.dijkstra_ruta_corta(codOrigen, codDestino))
            print()
            print("Recorriendo la siguiente ruta:")
            print(i.camino(codDestino))

            contador = 0
            costo = 0
            for codigo_camino in i.camino(codDestino): #i.camino(codDestino) es una lista [CCS, AUA, SXM]
                contador += 1
                for codigos_grafo, objeto_nodo in g.nodos.items(): #Revisa los keys del diccionario del grafo no direccionado
                    if codigos_grafo == codigo_camino and (not codigo_camino == i.camino(codDestino)[-1]): #Si el del camino es igual al del grafo revisa sus vecinos
                        for vecinos in objeto_nodo.vecinos: #Encuentra el vecino que sea igual al siguiente de la lista camino
                            if vecinos[0] == i.camino(codDestino)[contador]:
                                costo += vecinos[1]
                                break
            
            print(f'El costo de la ruta es: {costo}')
    else:
        if criterio == "a":
            print("El costo total es:")
            print(h.dijkstra(codOrigen, codDestino))
            print()
            print("Recorriendo la siguiente ruta:")
            print(h.camino(codDestino))
        else:
            print("La cantidad de escalas es de:")
            print(j.dijkstra_ruta_corta(codOrigen, codDestino))
            print()
            print("Recorriendo la siguiente ruta:")
            print(j.camino(codDestino))
                        
            contador = 0
            costo = 0
            for codigo_camino in j.camino(codDestino): #i.camino(codDestino) es una lista
                contador += 1
                for codigos_grafo, objeto_nodo in h.nodos.items(): #Revisa los keys del diccionario del grafo direccionado
                    if codigos_grafo == codigo_camino and (not codigo_camino == j.camino(codDestino)[-1]): #Si el del camino es igual al del grafo revisa sus vecinos
                        for vecinos in objeto_nodo.vecinos: #Encuentra el vecino que sea igual al siguiente de la lista camino
                            if vecinos[0] == j.camino(codDestino)[contador]:
                                costo += vecinos[1]
                                break
                
            print(f'El costo de la ruta es de: {costo}')
    print()
    print("¿Desea realizar otra consulta de viaje? (s) Sí (n) No")
    continuar = input(" ")
    while (not continuar.isalpha()) or ((not continuar == "s") and (not continuar == "n")):
        print('Error.')
        print("¿Desea realizar otra consulta de viaje? (s) Sí (n) No")
        continuar = input(" ")
        print()
    
    if continuar == "n":
        print('\nMuchas gracias por elegir Metro Travel. Esperamos haya sido de su agrado.')
        break
    print()