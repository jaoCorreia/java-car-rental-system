public class Vendedor {
    

    private String nome;
    private String endereco; 
    private Float meta; 
    private Float venda;
    private int codigo;


    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public Float getMeta() {
        return meta;
    }
    public void setMeta(Float meta) {
        this.meta = meta;
    }
    public Float getVenda() {
        return venda;
    }
    public void setVenda(Float venda) {
        this.venda = venda;
    }
}
