public class Mota extends Veiculo{
    private final int custo_por_km;
    private final int km_rodados;

    public Mota(String matricula,String marca,String modelo,int custo_por_km,int km_rodados){
        super(matricula,marca,modelo);
        this.custo_por_km=custo_por_km;
        this.km_rodados=km_rodados;
    }

    @Override
    public double calcularCustoManutencao() {
        return custo_por_km * km_rodados;
    }

    @Override
    public String toString() {
        return "\nMatricula: "+ matricula + "\nMarca: " + marca + "\nModelo: " + modelo +  "\nKm rodados: " +km_rodados+ "\nCusto por km: "+custo_por_km+"\nCusto Manutenção: " + calcularCustoManutencao();
    }
}