public class Rectangulo implements CalculoFiguras {
    private double base;
    private double altura;
    private String color;

    // Constructor
    public Rectangulo(double base, double altura, String color) {
        this.base = base;
        this.altura = altura;
        this.color = color;
    }


    public double calcularArea() {
        return base * altura;
    }


    public double calcularPerimetro() {
        return 2 * (base + altura);
    }


    public void mostrarInformacion() {
        System.out.printf(
                "Rectángulo | base=%.2f | altura=%.2f | color=%s | área=%.2f | perímetro=%.2f%n",
                base, altura, color, calcularArea(), calcularPerimetro()
        );
    }
}
