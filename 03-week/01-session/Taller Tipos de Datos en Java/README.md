# Taller - Tipos de datos en Java

## Autor
- Nombre: Francisco Bautista Vanegas
- Ingeniería en sistemas
- Tercer semestre

## Objetivo del taller
El objetivo de este taller es **aplicar conceptos básicos de programación
y estructuras de datos** por medio de resolución de problemas prácticos en Java.  
Cada ejercicio busca reforzar habilidades como el manejo de cadenas, compresión,
conversión de unidades y manipulación de números en distintas bases.

## Ejercicios con explicación
### Ejercicio 1: Validador de ISBN-13
- **Explicación:**
  Este programa valida un número ISBN-13, el cual es un identificador 
único para libros.  
  Para verificar si un ISBN-13 es correcto, el programa calcula el **dígito verificador**
aplicando la fórmula que combina los demás dígitos con pesos alternados (1 y 3).  
  Si el resultado coincide con el dígito final, el ISBN es válido.  
  Se practican operaciones con arreglos y aritmética modular, muy comunes en la validación
de datos reales.
- **Evidencia:** `src/evidencias/Ejercicio1_ISBN13.png`


### Ejercicio 2: Compresión Run-Length(RLE)
- **Descripción:**  
  El ejercicio usa el algoritmo **Run-Length Encoding (RLE)**, que consiste en comprimir 
cadenas repitiendo un carácter junto con la cantidad de veces que aparece consecutivamente.  
  Por ejemplo: `"aaabbc"` se comprime como `"a3b2c1"`.  La idea es reducir el tamaño de una
cadena detectando secuencias repetidas de caracteres y representándolas con el carácter seguido
de la cantidad de repeticiones.
  
- **Evidencia:** `src/evidencias/Ejercicio2_RLE.png`


### Ejercicio 3: Estadísticas de temperaturas
- **Descripción:**  
  En este ejercicio se convierten valores de temperatura entre **Celsius, Fahrenheit y Kelvin**.  
  El usuario puede introducir un valor en una escala y obtener automáticamente el equivalente 
en las demás.  
  Se utilizan las fórmulas de conversión estándar entre las diferentes unidades.  
  
- **Evidencia:** `src/evidencias/Ejercicio3_Temperaturas.png`

### Ejercicio 4: Conversor de bases y control de overflow
- **Descripción:**  
  En este ejercicio se convierten números entre diferentes sistemas numéricos: **binario, octal,
decimal y hexadecimal**.  
  El usuario puede ingresar un número en una base determinada y obtener su representación en las
otras.  
  Para ello se emplean tanto métodos propios de Java (`Integer.parseInt`, `Integer.toString`) 
algoritmos básicos de división y módulo.  
  
- **Evidencia:** `src/evidencias/Ejercicio4_ConversorBases.png`

### Ejercicio 5.Agregación de tiempos de ejecución
- **Descripción:**  
  El programa recibe tres tiempos (horas, minutos, segundos) y calcula la diferencia entre ellos.  
  Para lograrlo, convierte los tiempos a segundos totales, realiza la resta y luego transforma 
el resultado nuevamente a horas, minutos y segundos.  
  Este ejercicio es útil porque refuerza el trabajo con **operaciones aritméticas, modularidad** 
y el manejo de entradas del usuario en distintos formatos.
- **Evidencia:** `src/evidencias/Ejercicio5_Tiempos.png`
