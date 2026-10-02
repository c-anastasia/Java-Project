import java.io.*;

void main() {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Frota frota = new Frota();

    int escolha;
    do {
        System.out.println("\nMenu");
        System.out.println("1-Listar veículos");
        System.out.println("2-Adicionar veículo");
        System.out.println("3-Remover veículo");
        System.out.println("4-Listar por marca");
        System.out.println("5-Mostrar custo total manutenção");
        System.out.println("0-Sair");
        System.out.print("Escolha uma opção: ");

        try {
            escolha = Integer.parseInt(br.readLine());

            switch (escolha) {
                case 1:
                    frota.listarVeiculos();
                    break;

                case 2:
                    System.out.print("\nTipo de veículo\n1-Carro ou 2-Mota: ");
                    int tipo = Integer.parseInt(br.readLine());

                    if (tipo !=1 && tipo !=2){
                        System.out.println("Tipo inválido");
                        break;
                    }

                    System.out.print("Matrícula: ");
                    String matricula = br.readLine();

                    System.out.print("Marca: ");
                    String marca = br.readLine();

                    System.out.print("Modelo: ");
                    String modelo = br.readLine();

                    if (tipo == 1) {
                        System.out.print("Custo Base: ");
                        int custo_base_manutencao = Integer.parseInt(br.readLine());

                        System.out.print("Seguro: ");
                        int seguro_anual = Integer.parseInt(br.readLine());

                        frota.adicionarVeiculo(new Carro(matricula,marca,modelo,custo_base_manutencao,seguro_anual));

                    } else if (tipo == 2) {
                        System.out.print("Custo por km: ");
                        int custo_por_km = Integer.parseInt(br.readLine());

                        System.out.print("Km rodados: ");
                        int km_rodados = Integer.parseInt(br.readLine());

                        frota.adicionarVeiculo(new Mota(matricula,marca,modelo,custo_por_km,km_rodados));

                    }
                    break;

                case 3:
                    System.out.print("Matrícula: ");
                    String matriculaRemover = br.readLine();

                    frota.removerVeiculo(matriculaRemover);
                    break;

                case 4:
                    System.out.print("Marca: ");
                    String marcaPesquisar = br.readLine();

                    frota.listarPorMarca(marcaPesquisar);
                    break;

                case 5:
                    frota.mostrarCustoTotalManutencao();
                    break;

                case 0:
                    frota.guardarVeiculosTxt();
                    System.out.println("Veiculo guardado");
                    break;

                default:
                    System.out.println("Opção inválida");
            }

        } catch (NumberFormatException | IOException e) {
            System.out.println("Valor inválido.");
            escolha = -1;
        }

    } while (escolha != 0);
}