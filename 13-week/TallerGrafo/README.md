Autores: <br>
Francisco Bautista Vanegas <br>
Jose Gabriel David Mendez Roncancio <br>
Docente: Jesus Ariel Gonzalez Bonilla
Asignatura: Estructura de datos
Fecha: 14 de noviembre de 2025

# Taller: Grafo y Recorrido BFS

## Objetivo
Implementar un grafo utilizando una lista de adyacencia y el algoritmo Breadth-First Search (BFS) usando una cola.  
Luego aplicar el grafo y BFS en cuatro ejercicios prácticos.

## Contenido del trabajo

### 1. `Graph.java`
Implementa:
- Estructura del grafo con lista de adyacencia.
- Métodos:
    - `addVertex(String v)`
    - `addEdge(String v1, String v2)`
    - `bfs(String start)`
    - `getNeighbors(String v)` (para DFS del ejercicio 4)

### 2. `BFSExample.java`
Ejemplo básico del uso de BFS:
- Crea un grafo pequeño.
- Ejecuta `bfs("A")`.
- Muestra un recorrido esperado como:  
  `A → B → C → D`

### 3. Ejercicios

#### **Ejercicio1 — Red social**
- Modela usuarios como nodos.
- Amistades como aristas.
- BFS desde un usuario inicial.

#### **Ejercicio2 — Mapa de ciudades**
- Ciudades como nodos.
- Conexiones como aristas.
- BFS desde una ciudad origen.

#### **Ejercicio3 — Componentes conexos**
- Construir un grafo no conexo.
- Comparar BFS desde diferentes nodos.

#### **Ejercicio4 — Comparación BFS vs DFS**
- Usar BFS del grafo.
- Implementar DFS y comparar el orden de recorrido.

