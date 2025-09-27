public class Triangulo implements CalculoFiguras {
    private double lado1;
    private double lado2;
    private double lado3;
    private String color;

    // Constructor
    public Triangulo(double lado1, double lado2, double lado3, String color) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.color = color;
    }


    public double calcularArea() {
        // Fórmula de Herón
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }


    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }


    public void mostrarInformacion() {
        System.out.printf(
                "Triángulo | lados=(%.2f, %.2f, %.2f) | color=%s | área=%.2f | perímetro=%.2f%n",
                lado1, lado2, lado3, color, calcularArea(), calcularPerimetro()
        );
    }
}

