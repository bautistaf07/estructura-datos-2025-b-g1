# COMPLEJIDAD DEL GRAFO Y BFS

## 1. Complejidad del algoritmo BFS

### Tiempo:
O(V + E)
- V = número de vértices
- E = número de aristas
- BFS visita cada vértice y cada arista **una sola vez**, por eso su costo total es lineal respecto al tamaño del grafo.

### Espacio:
O(V)
- Se necesita memoria para:
    - La **cola** del BFS.
    - El conjunto de **visitados**.
    - La lista del **orden de recorrido**.

## 2. Complejidad de operaciones del grafo
Usando lista de adyacencia:

| Operación         | Complejidad |
|------------------|-------------|
| Agregar vértice  | O(1)        |
| Agregar arista   | O(1)        |
| BFS              | O(V + E)    |

---

## 3. Ejemplo práctico

Si el grafo tiene:
- **6 nodos**
- **7 aristas**

El costo del BFS será:
V + E = 6 + 7 = 13 pasos

## 4. Razón de la eficiencia
- BFS es eficiente porque no repite visitas.
- Su orden es proporcional al tamaño real del grafo.
- Ideal para encontrar rutas más cortas en grafos **no ponderados**.


