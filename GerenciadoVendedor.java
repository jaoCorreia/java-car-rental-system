import java.util.Scanner;

public class GerenciadoVendedor {

    Scanner scanner; 
    VendedorDAO vendedorDAO;
    
    
    public GerenciadoVendedor(){
        scanner = new Scanner(System.in);
        vendedorDAO = new VendedorDAO();

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
        Vendedor v = new Vendedor(); 
        System.out.println("------------------------------\n");
        System.out.println("[Cadastro de Vendedor]");            
        System.out.println("Nome: ");
        v.setNome(scanner.nextLine());
        System.out.println("endereco: ");
        v.setEndereco(scanner.nextLine());
        System.out.println("meta: ");
        v.setMeta(Float.parseFloat(scanner.nextLine()));
        System.out.println("venda: ");
        v.setVenda(Float.parseFloat(scanner.nextLine()));
        System.out.println("\n------------------------------");

        boolean inserido = vendedorDAO.inserir(v);

        if(inserido){
            System.out.println("Cadastrado com sucesso");
        }else{
            System.out.println("Deu ruim");
        }

    }


    public listarTodos(){

        System.out.println("-------------------");
        System.out.println("Vendedores Cadastrados");


        for(Vendedor v : VendedorDAO.buscarTodos()){
            
          
         System.out.println("Codigo: "+v.getCodigo()+ " , Nome : "+ v.getNome()+
         " , Meta: "+v.getMeta()+" , Venda: "+v.getVenda());

        }

    }


    public void excluir(){
        System.out.println("---------------------");
        System.out.println("Exclusão de Vendedor");
        System.out.println("Informe o codigo do vendedor: ");
        int id  = Integer.parseInt(scanner.nextLine());

        int qtde = vendedorDAO.excluir(id); 

        if(qtde > 0){
            System.out.println("Excluido com sucesso");
        }else{
            System.out.println("Deu ruim");
        }

    }


    public void consultar(){
        System.out.println("---------------------");
        System.out.println("Busca de Vendedor");
        System.out.println("Informe o codigo do vendedor: ");
        int id  = Integer.parseInt(scanner.nextLine());

        Vendedor v = vendedorDAO.consultar(id); 

        if(v != null){
            System.out.println("Nome: "+v.getNome()+ 
                                "\nEndereco : "+ v.getEndereco()+
                                "\nMeta: "+v.getMeta()+
                                "\nVenda: "+v.getVenda();
            }else{
                System.out.println("Veiculo nao encontrado");
            }


    }


    public void alterar(){
        System.out.println("---------------------");
        System.out.println("Alterar Vendedor");
        System.out.println("Informe o codigo do vendedor: ");
        int id  = Integer.parseInt(scanner.nextLine());

        Vendedor v = vendedorDAO.consultar(id); 

        if(v != null){
            System.out.println("[DADOS VENDEDOR]");
            System.out.println("[codigo: "+v.getCodigo()+"]");
            System.out.println("[nome: "+v.getNome()+"]");
            String nome = scanner.nextLine(); 
            if(!nome.isEmpty()){
                v.setNome(nome);
            }


            System.out.println("[endereco: "+v.getEndereco()+"]");
            String endereco = scanner.nextLine(); 
            if(!endereco.isEmpty()){
                v.setEndereco(endereco);
            }


            System.out.println("[meta: "+v.getMeta()+"]");
            Float meta = Float.parseFloat(scanner.nextLine()); 
            if(!meta.isEmpty()){
                v.setMeta(meta);
            }

            System.out.println("[nome: "+v.getVenda()+"]");
            Float venda = Float.parseFloat(scanner.nextLine()); 

            if(!venda.isEmpty()){

                v.setMeta(venda);
            }


            }else{
                System.out.println("Vendedor nao encontrado");
            }



    }
    
 }