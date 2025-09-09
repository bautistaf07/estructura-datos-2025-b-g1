# Taller — Listas enlazadas en Java
**Autor:** Francisco Bautista Vanegas

**Fecha:** 2025-09-08  

**Versión:** 1.0

## Descripción general
En este taller implementé en Java listas enlazadas 
como las simples, dobles y circulares a través de una
estructura base de nodos, en este caso (Nodo.java) 
que permiten almacenar un dato y apuntar al siguiente 
(y en el caso doble también al anterior), con clases
específicas (ListaSimple, ListaDoble, ListaCircular) 
que contienen las operaciones de inserción y eliminación 
en diferentes posiciones, y programas de prueba
(Ejercicio1 a Ejercicio6) que verifican su funcionamiento
según lo solicitado: insertar al final y mostrar elementos,
insertar en cualquier posición, eliminar con control de
errores, manejar una lista doble con eliminaciones en
extremos, convertir la lista en circular con inserción
y eliminación, y simular un caso práctico de cola en un
consultorio. También incluye un análisis de complejidad 
de cada operación en notación O(), control de casos borde
como listas vacías o posiciones inválidas, y está documentado 
con comentarios y ejemplos de ejecución para reforzar la
comprensión de la manipulación dinámica de nodos.

## Analisis de cada ejercicio

El análisis del taller muestra que la lista simple cumple 
con las operaciones mínimas (insertar al inicio, al final y
en una posición específica, así como eliminar en una posición),
insertarFinal y eliminarFinal tienen costo O(n) porque
requieren recorrer toda la lista, ya que no se mantiene un
puntero al último nodo; en contraste, la lista doble incluye
referencias tanto a cabeza como a cola, lo que permite que las 
operaciones en los extremos se realicen en O(1), manteniendo un
mayor costo solo en inserciones o eliminaciones en posiciones
intermedias (O(n)); la lista circular aprovecha la referencia
al último nodo para enlazar de manera cíclica y facilitar recorridos
continuos, controlando casos como la eliminación del único 
nodo existente; cada ejercicio ilustra y prueba estas operaciones 
en escenarios específicos: el primero con inserción y recorrido
básicos, el segundo con inserciones en posiciones arbitrarias, 
el tercero con eliminaciones controladas y validación de errores,
el cuarto demostrando la doble conexión de nodos, el quinto 
validando la circularidad, y el sexto modelando un caso práctico
de cola en un consultorio; en todos los casos se añadieron 
validaciones de lista vacía y posiciones inválidas, y se documentaron
salidas esperadas, lo que garantiza que el código cumple con los
criterios de modularidad, control de errores y análisis de complejidad
establecidos en el taller.