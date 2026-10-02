public abstract class Veiculo {
    protected String matricula;
    protected String marca;
    protected String modelo;

    public Veiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public abstract double calcularCustoManutencao();

    @Override
    public String toString() {
        return "\nMatricula: " + matricula + "\nMarca: " + marca + "\nModelo: " + modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }
}
