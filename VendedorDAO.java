import java.sql.Statement;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VendedorDAO {

    private Connection conn; 
    private Statement st; 



    private void conectar(){

        try{

            this.conn = GerenciarConexao.pegarConexao();
            this.st = conn.createStatement();
        
        }catch(ClassNotFoundException | SQLException e1){

            System.out.println("Erro: "+e1.getMessage());

        }
    }

    private void desconectar(){
        
        try{
            this.st.close();
            this.conn.close();
    
        }catch(SQLException e1){

            System.out.println("ERRO: "+e1.getMessage());

        }

}





public boolean inserir(Vendedor v){
    boolean res = false; 

    try{
        this.conectar(); 
        String comando = "INSERT INTO tb_vendedor (nome,endereco,meta,venda) VALUES"+
        " ('"+v.getNome()+"', '"+v.getEndereco()+"', '"+v.getMeta()+"','"+v.getVenda()+"');"; 
        st.executeUpdate(comando);
        res = true;
    }catch (Exception e){

        System.out.println("Erro ao inserir registro: "+ 
        e.getMessage());

    }finally{
        this.desconectar();
    }

    return res;

}


public ArrayList<Vendedor> buscaTodos(){
    
    ArrayList<Vendedor> listaVendedor= new ArrayList<Vendedor>();

    try{
        this.conectar();
        ResultSet rs = st.executeQuery("SELECT * FROM tb_vendedor ORDER BY nome");

        while (rs.next()) {
            Vendedor v = new Vendedor(); 
            v.setCodigo(rs.getInt("codigo"));
            v.setMeta(rs.getFloat("meta"));
            v.setVenda(rs.getFloat("venda"));
            v.setEndereco("endereco");
            v.setNome("nome");

            listaVendedor.add(v)
        }
    }catch(Exception e1){
        System.out.println("Erro: " + e1.getMessage());
    }finally{
        this.desconectar();
    }

    return listaVendedor;
}


public int excluir(int id){
    int qtde= 0;

    try{
        this.conectar();
        String comando = "DELETE FROM tb_vendedor WHERE codigo= "+id+" ;";
        st.executeUpdate(comando);
        qtde = st.getUpdateCount(); 
    
    }catch(Exception e1){
        System.out.println("Erro: "+ e1.getMessage());
    
    }finally{
        this.desconectar();
    }


    return qtde;

}

public Vendedor consultar(int id){
    Vendedor v = null;

    try{
        this.conectar(); 
        ResultSet rs = st.executeQuery("SELECT * FROM tb_vendedor WHERE codigo= "+id+";");

        if(rs.next()){
            v = new Vendedor(); 
            v.setCodigo(rs.getInt("codigo"));
            v.setMeta(rs.getFloat("meta"));
            v.setVenda(rs.getFloat("venda"));
            v.setEndereco("endereco");
            v.setNome("nome");

        }


    }catch(Exception e1){
        System.out.println("Erro"+ e1.getMessage());
    }finally{
        this.desconectar();
    }

    return v;

}


public int alterar(Vendedor v){

    int qtde = 0;
    try{
        String comando = "UPDATE tb_vendedor SET nome= '"+v.getNome()+"',"+
                        "meta= '"+v.getMeta()+"', venda='"+v.getVenda()+"',endereco= '"+
                        v.getEndereco()+"' WHERE codigo= "+v.getCodigo()+";";
        st.executeUpdate(comando); 
        qtde = st.getUpdateCount(); 
    }catch(Exception e1){
        System.out.println("Erro: "+ e1.getMessage());
    
    }finally{
        this.desconectar();
    }

    return qtde; 
}



}
