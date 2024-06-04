    import java.sql.Connection;
    import java.util.Scanner;

    public class Locadora {
        public static void main(String[] args) throws Exception {
            Locadora loc = new Locadora(); 
            loc.menuPrincipal();
        }

        public void menuPrincipal(){
            int opcao = -1; 
            Scanner scanner = new Scanner(System.in);
            while (opcao != 0) {
                System.out.println("------------------------------\n");
                System.out.println("MENU PRINCIPAL");            
                System.out.println("[1] Gerenciar Veiculos");
                System.out.println("[2] Gerenciar Vendedores");
                System.out.println("[0] Sair");
                System.out.println("\n------------------------------");

                try{
                    opcao = Integer.parseInt(scanner.nextLine());
                }catch(Exception e){
                    System.out.println("Informe um inteiro");
                }

                GerenciadorVeiculo gv = new GerenciadorVeiculo();
                GerenciadoVendedor gve = new GerenciadoVendedor();

                switch (opcao) {
                    case 1:
                    
                        gv.menu();
                        break;
                    case 2 : 
                        gve.menu();
                    
                        break;
                    case 0: 
                        System.out.println("Ate mais parceiro");
                        break; 
                    default:
                        System.out.println("opcao invalida");
                        break;
                }

                

    }
        }
    }
