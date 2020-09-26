package cc.code.dominio;

public class Pessoa{
    private String name;
    private String cpf;
    private int idade;
    private String telefoneCelular;
    private String telefoneFixo;

    public Pessoa(String name, String cpf, int idade, String telefoneCelular, String telefoneFixo) {
        this.name = name;
        this.cpf = cpf;
        this.idade = idade;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
    }

    public Pessoa(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }
}
