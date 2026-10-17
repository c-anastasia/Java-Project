import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Frota {
    List<Veiculo> veiculo =Collections.synchronizedList(new ArrayList<>());

    public void listarVeiculos() {
        try (Scanner sc = new Scanner(new File("veiculos.txt"))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro.");
        }
    }

    public void adicionarVeiculo(Veiculo v) {
        for (Veiculo v2 : veiculo) {
            if (v2.getMatricula().equalsIgnoreCase(v.getMatricula())) {
                System.out.println("Já existe um veículo com a matrícula "+ v.getMatricula());
                return;
            }
        }
        veiculo.add(v);
        System.out.println(v);

        try (PrintWriter pw = new PrintWriter(new FileWriter("veiculos.txt", true))) {
            pw.println(v+"\n");
        } catch (IOException e) {
            System.out.println("Erro ao guardar o veículo no ficheiro.");
        }
    }

    public void removerVeiculo(String matricula) {
        List<String> linhas = new ArrayList<>();
        boolean encontrado = false;

        try (Scanner sc = new Scanner(new File("veiculos.txt"))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");

                if (dados.length > 1
                        && dados[1].equalsIgnoreCase(matricula)) {
                    encontrado = true;
                } else {
                    linhas.add(linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro.");
            return;
        }
        if (encontrado) {
            try (PrintWriter pw = new PrintWriter(
                    new FileWriter("veiculos.txt"))) {
                for (String linha : linhas) {
                    pw.println(linha);
                }

                System.out.println("O veículo com a matrícula " + matricula + " foi removido.");
            } catch (IOException e) {
                System.out.println("Erro ao guardar o ficheiro.");
            }
        } else {
            System.out.println("Não existe veículo com a matrícula "+ matricula);
        }
    }

    public void listarPorMarca(String marca) {
        boolean encontrado = false;
        try (Scanner sc = new Scanner(new File("veiculos.txt"))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");

                if (dados.length >= 4 && dados[2].trim().equalsIgnoreCase(marca.trim())) {
                    System.out.println(linha);
                    encontrado = true;
                }
            }
            if (!encontrado) {
                System.out.println("Não existem veículos da marca " + marca);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro");
        }
    }

    public void mostrarCustoTotalManutencao() {
        double total = 0;

        try (Scanner sc = new Scanner(new File("veiculos.txt"))) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine().trim();
                if (linha.isEmpty()) {
                    continue;
                }
                String[] dados = linha.split(";");

                if (dados.length < 6) {
                    continue;
                }
                if (dados[0].equalsIgnoreCase("Carro")) {
                    Carro c = new Carro(dados[1], dados[2], dados[3], Double.parseDouble(dados[4]), Double.parseDouble(dados[5]));
                    total += c.calcularCustoManutencao();
                } else if (dados[0].equalsIgnoreCase("Moto") || dados[0].equalsIgnoreCase("Mota")) {
                    Mota m = new Mota(dados[1], dados[2], dados[3], Double.parseDouble(dados[4]), Double.parseDouble(dados[5]));
                    total += m.calcularCustoManutencao();
                }
            }
            System.out.println("Custo total de manutenção é " + total);
        } catch (IOException e) {
            System.out.println("Erro ao ler o ficheiro.");
        }
    }

    public void guardarVeiculosTxt() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("veiculos.txt"));
                for (Veiculo v:veiculo) {
                    bw.write(v.toString());
                }
                bw.close();
            } catch (IOException e) {
                System.out.println("Erro ao guardar o ficheiro");
            }
        });
        thread.start();
        thread.join();
    }

    public void lerVeiculosTxt() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                BufferedReader br = new BufferedReader(new FileReader("veiculos.txt"));
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
        thread.join();
    }
}
