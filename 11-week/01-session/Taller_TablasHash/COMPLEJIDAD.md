
# COMPLEJIDAD.md

# Análisis de complejidad — Tabla Hash

## Operaciones y rendimiento

| Operación      | Complejidad promedio | Peor caso (colisiones totales) |
|----------------|----------------------|--------------------------------|
| put()          | O(1)                 | O(n)                           |
| get()          | O(1)                 | O(n)                           |
| remove()       | O(1)                 | O(n)                           |
| containsKey()  | O(1)                 | O(n)                           |
| size(),isEmpty() | O(1)               | O(1)                           |

## Explicación
La función hash reparte las claves de forma más o menos pareja entre los espacios o “buckets” de la tabla. 
En la que Cada bucket tiene una lista enlazada, así que normalmente solo hay que recorrer unos pocos elementos
para encontrar o guardar algo. 
Algunas claves caen en el mismo bucket (por ejemplo, porque el hash no es muy bueno),
el tiempo de las operaciones puede volverse O(n), ya que tocaría recorrer toda la lista.

La tabla hash permite realizar búsquedas, inserciones y eliminaciones rápidas con complejidad promedio constante.  
Es una de las estructuras más eficientes para manejar grandes volúmenes de datos clave-valor.
