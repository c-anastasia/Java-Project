import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Frota {
    List<Veiculo> veiculo =Collections.synchronizedList(new ArrayList<>());

    public void listarVeiculos() {
        for (Veiculo v:veiculo) {
            System.out.println(v);
        }
    }

    public void adicionarVeiculo(Veiculo v) {
        for (Veiculo v2:veiculo) {
            if (v2.getMatricula().equals(v.getMatricula())) {
                System.out.println("Já existe um veículo com a matrícula " + v.getMatricula());
                return;
            }
        }
        veiculo.add(v);
        System.out.println(v);
    }

    public void removerVeiculo(String matricula) {
        for (Veiculo v:veiculo) {
            if (v.getMatricula().equals(matricula)) {
                veiculo.remove(v);
                System.out.println("O veículo com a matrícula "+ matricula +" foi removido");
                return;
            }
        }
        System.out.println("Não existe veículo com a matrícula "+ matricula);
    }

    public void listarPorMarca(String marca) {
        for (Veiculo v:veiculo) {
            if (v.getMarca().equalsIgnoreCase(marca)) {
                System.out.println(v);
            }
            System.out.println("Não existe veículo com a matrícula "+ marca);
        }
    }

    public void mostrarCustoTotalManutencao() {
        double total = 0;
        for (Veiculo v:veiculo) {
            total += v.calcularCustoManutencao();
        }
        System.out.println("Custo total de manutenção é "+ total);
    }

    public void guardarVeiculosTxt() {
        Thread thread = new Thread(() -> {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("veículos.txt"));
                for (Veiculo v:veiculo) {
                    bw.write(v.toString());
                    bw.newLine();
                }
                bw.close();
            } catch (IOException e) {
                System.out.println("Erro ao guardar o ficheiro");
            }
        });
        thread.start();
    }

    public void lerVeiculosTxt() {
        Thread thread = new Thread(() -> {
            try {
                BufferedReader br = new BufferedReader(new FileReader("veículos.txt"));
                String linha;
                while ((linha = br.readLine()) != null) {
                    System.out.println(linha);
                }
                br.close();
            } catch (IOException e) {
                System.out.println("Erro ao ler o ficheiro");
            }
        });
        thread.start();
    }
}