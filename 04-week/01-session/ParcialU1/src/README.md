# Estructura de datos - Unidad 1

## Descripción del sistema: 
Este programa en Java permite administrar un catálogo de libros con operaciones de alta, baja, búsqueda y actualización de stock, 
además de gestionar préstamos activos y un historial de operaciones.  
Este sistema funciona desde el menú de consola y está implementado usando los temas abordados en clase, como
arrays, listas enlazadas simples y listas doblemente enlazadas.

## Razones de elección de cada estructura y complejidad de operacionesclave.
- **Catálogo (Array + Matriz 2D)**  
  Se eligió un array unidimensional de libros por su sencillez y acceso rápido a posiciones, junto con una matriz para registrar disponibilidad en sucursales.
    - Alta, baja, búsqueda lineal → O(n)
    - Actualización de stock → O(1)

- **Préstamos (Lista Enlazada Simple)**  
  Permite manejar dinámicamente los préstamos sin necesidad de desplazar elementos como en un array.
    - Insertar al final → O(n)
    - Eliminar préstamo → O(n)

- **Historial (Lista Doblemente Enlazada)**  
  Permite recorrer operaciones tanto hacia adelante como hacia atrás, lo cual no sería posible con una lista simple.
    - Insertar al final → O(1)
    - Recorrer adelante/atrás → O(n)

---

## Cómo compilar y ejecutar
1. Abrir la carpeta con los archivos `.java`.
2. Compilar todos los archivos