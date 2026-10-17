import java.util.Scanner;

void main() throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    Frota frota = new Frota();
    frota.lerVeiculosTxt();

    int escolha = 0;
    do {
        System.out.println("\nMenu");
        System.out.println("1 - Listar veículos");
        System.out.println("2 - Adicionar veículo");
        System.out.println("3 - Remover veículo");
        System.out.println("4 - Listar por marca");
        System.out.println("5 - Mostrar custo total manutenção");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        try {
            escolha = Integer.parseInt(sc.nextLine());

            switch (escolha) {
                case 1:
                    frota.listarVeiculos();
                    break;

                case 2:
                    System.out.print("Tipo de veículo\n1-Carro ou 2-Mota: ");
                    int tipo = Integer.parseInt(sc.nextLine());

                    if (tipo != 1 && tipo != 2) {
                        System.out.println("Tipo inválido");
                        break;
                    }

                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();

                    System.out.print("Marca: ");
                    String marca = sc.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();

                    if (tipo == 1) {
                        System.out.print("Custo base de manutenção: ");
                        double custoBase = Double.parseDouble(sc.nextLine());

                        System.out.print("Seguro anual: ");
                        double seguro = Double.parseDouble(sc.nextLine());

                        frota.adicionarVeiculo(
                                new Carro(matricula, marca, modelo, custoBase, seguro)
                        );
                    } else {
                        System.out.print("Custo por km: ");
                        double custoKm = Double.parseDouble(sc.nextLine());

                        System.out.print("Km rodados: ");
                        double km = Double.parseDouble(sc.nextLine());

                        frota.adicionarVeiculo(
                                new Mota(matricula, marca, modelo, custoKm, km)
                        );
                    }
                    break;

                case 3:
                    System.out.print("Matrícula a remover: ");
                    String matriculaRemover = sc.nextLine();
                    frota.removerVeiculo(matriculaRemover);
                    break;

                case 4:
                    System.out.print("Marca a pesquisar: ");
                    String marcaPesquisar = sc.nextLine();
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
                    System.out.println("Opção inválida.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Valor inválido");
        }
    } while (escolha != 0);
    sc.close();
}
