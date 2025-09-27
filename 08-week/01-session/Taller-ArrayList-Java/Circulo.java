public class Circulo implements CalculoFiguras {
    private double radio;
    private String color;

    // Constructor
    public Circulo(double radio, String color) {
        this.radio = radio;
        this.color = color;
    }


    public double calcularArea() {
        return Math.PI * radio * radio;
    }


    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }


    public void mostrarInformacion() {
        System.out.printf(
                "Círculo | radio=%.2f | color=%s | área=%.2f | perímetro=%.2f%n",
                radio, color, calcularArea(), calcularPerimetro()
        );
    }
}
