public class Carro extends Veiculo{
    private final double custo_base_manutencao;
    private final double seguro_anual;

    public Carro(String matricula,String marca,String modelo,double custo_base_manutencao,double seguro_anual){
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
        return "Carro;" + matricula + ";" + marca + ";" + modelo+ ";" + custo_base_manutencao + ";" + seguro_anual;
    }
}
