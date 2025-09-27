import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Creamos un ArrayList de figuras
        ArrayList<CalculoFiguras> figuras = new ArrayList<>();

        // Agregamos círculos
        figuras.add(new Circulo(3.0, "Rojo"));
        figuras.add(new Circulo(5.5, "Azul"));

        // Agregamos rectángulos
        figuras.add(new Rectangulo(4.0, 6.0, "Verde"));
        figuras.add(new Rectangulo(2.5, 3.5, "Amarillo"));

        // Agregamos triángulos
        figuras.add(new Triangulo(3.0, 4.0, 5.0, "Morado"));
        figuras.add(new Triangulo(6.0, 6.0, 6.0, "Rosa"));

        // Recorremos la lista y mostramos la información
        for (CalculoFiguras f : figuras) {
            f.mostrarInformacion();
        }
    }
}

