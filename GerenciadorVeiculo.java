import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorVeiculo {
   
    Scanner scanner;
    VeiculoDAO veiculoDAO;
    

    public GerenciadorVeiculo(){
        scanner = new Scanner(System.in); 
        veiculoDAO = new VeiculoDAO();
    }



    public void menu(){
        int opcao = -1; 
        while (opcao != 0) {
            System.out.println("------------------------------\n");
            System.out.println("MENU PRINCIPAL");            
            System.out.println("[1] Cadastrar");
            System.out.println("[2] Consultar");
            System.out.println("[3] Alterar");
            System.out.println("[4] Excluir");
            System.out.println("[5] Listar Todos");
            System.out.println("[0] Sair");
            System.out.println("\n------------------------------");

            try{
                opcao = Integer.parseInt(scanner.nextLine());
            }catch(Exception e){
                System.out.println("Informe um inteiro");
            }


            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2 : 
             
                    consultar();
                    break;
                case 3 : 
                    alterar();
                
                    break;
                case 4 : 
                excluir();
                
                    break;
                case  5: 
                    listarTodos();
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


    public void cadastrar(){
        Veiculo v = new Veiculo(); 
        System.out.println("------------------------------\n");
        System.out.println("[Cadastro de Veiculos]");            
        System.out.println("Marca: ");
        v.setMarca(scanner.nextLine());
        System.out.println("Modelo: ");
        v.setModelo(scanner.nextLine());
        System.out.println("Chassi: ");
        v.setChassi(scanner.nextLine());
        System.out.println("Ano: ");
        v.setAno(Integer.parseInt(scanner.nextLine()));
        System.out.println("\n------------------------------");

        boolean inserido = veiculoDAO.inserir(v);

        if(inserido){
            System.out.println("Cadastrado com sucesso");
        }else{
            System.out.println("Deu ruim");
        }
    }

    public void listarTodos(){
        
        System.out.println("------------------------");
        System.out.println("VEICULOS CADASTRADOS");


        
         for(Veiculo v: veiculoDAO.buscarTodos()){

         System.out.println("Codigo: "+v.getCodigo()+ " , Marca : "+ v.getMarca()+
         " , Modelo: "+v.getModelo()+" , Chassi: "+v.getChassi()+" , Ano : "+v.getAno());

         }
        
    }

    public void excluir(){
        System.out.println("------------------------");
        System.out.println("Exclusão de Veículo");
        System.out.println("Informe o codigo do veiculo: ");
        int id = Integer.parseInt((scanner.nextLine()));
        
        int qtde = veiculoDAO.excluir(id);

        if(qtde > 0){
            System.out.println("excluido com sucesso");
        }else{
            System.out.println("Nao foi possivel excluir");
        }
    }

    public void consultar(){
        System.out.println("------------------------");
        System.out.println("Consulta de Veículo");
        System.out.println("Informe o codigo do veiculo: ");
        int id = Integer.parseInt((scanner.nextLine()));

        Veiculo v = veiculoDAO.consultar(id);
        if(v != null){
        System.out.println("Codigo: "+v.getCodigo()+ 
                            "\nMarca : "+ v.getMarca()+
                            "\nModelo: "+v.getModelo()+
                            "\nChassi: "+v.getChassi()+
                            "\nAno : "+v.getAno());
        }else{
            System.out.println("Veiculo nao encontrado");
        }

    }

    public void alterar(){
        
        System.out.println("------------------------");
        System.out.println("Alteracao de Veículo");
        System.out.println("Informe o codigo do veiculo: ");
        int id = Integer.parseInt((scanner.nextLine()));
        Veiculo v = veiculoDAO.consultar(id);

        if(v != null){
            System.out.println("[Dados do veiculo]");
            System.out.println("[Codigo: "+v.getCodigo()+"]");
            System.out.println( "[Marca : "+ v.getMarca()+"]");
            String marca = scanner.nextLine(); 
            if(!marca.isEmpty()){
                v.setMarca(marca);
            }
            
            System.out.println( "[Modelo : "+ v.getModelo()+"]");
            String modelo = scanner.nextLine(); 
            if(!modelo.isEmpty()){
                v.setModelo(modelo);
            }
            
            System.out.println( "[Chassi : "+ v.getChassi()+"]");
            String chassi = scanner.nextLine(); 
            if(!chassi.isEmpty()){
                v.setMarca(chassi);
            }

            System.out.println( "[Ano : "+ v.getAno()+"]");
            String ano = scanner.nextLine(); 
            if(!ano.isEmpty()){
                v.setAno(Integer.parseInt(ano));
            }

           int qtdeAlterados = veiculoDAO.alterar(v);

           if(qtdeAlterados > 0){
            System.out.println("Atualizado com sucesso");
           }else{
            System.out.println("Nao foi possivel alterar o  registro ligar para o programado do numero: 459999911880)");
           }
            
        }else{
        System.out.println("Veiculo nao encontrado");
        }

    }

}
