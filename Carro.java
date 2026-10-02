public class Carro extends Veiculo{
    private int custo_base_manutencao;
    private int seguro_anual;

    public Carro(String matricula,String marca,String modelo,int custo_base_manutencao,int seguro_anual){
        super(matricula,marca,modelo);
        this.custo_base_manutencao=custo_base_manutencao;
        this.seguro_anual=seguro_anual;
    }

    @Override
    public double calcularCustoManutencao() {
        return custo_base_manutencao + seguro_anual;
    }

    @Override
    public String toString() {
        return "\nMatricula: " + matricula + "\nMarca: " + marca+ "\nModelo: " + modelo + "\nCusto base: " + custo_base_manutencao + "\nSeguro anual: " + seguro_anual + "\nCusto Manutenção: " + calcularCustoManutencao();
    }
}
