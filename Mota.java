public class Mota extends Veiculo{
    private final double custo_por_km;
    private final double km_rodados;

    public Mota(String matricula,String marca,String modelo,double custo_por_km,double km_rodados){
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
        return "Moto;" + matricula + ";" + marca + ";" + modelo + ";" + custo_por_km + ";" + km_rodados;
    }
}
