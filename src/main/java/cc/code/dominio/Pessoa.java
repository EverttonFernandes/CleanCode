package cc.code.dominio;

/**
 * Classe/objeto que representa a entidade Pessoa .
 *
 * @author Everton Oliveira Fernandes .
 */
public class Pessoa {
    private String nome;
    private String sobrenome;
    private String telefoneFixo;
    private String telefoneCelular;
    private String cpf = "000.000.000-00";

    /**
     * Metodo construtor .
     *
     * @param nome            .
     * @param sobrenome       .
     * @param telefoneFixo    .
     * @param telefoneCelular .
     * @param cpf             .
     */
    public Pessoa(String nome, String sobrenome, String telefoneFixo, String telefoneCelular, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.cpf = cpf;
    }

    /**
     * Construtor padrao .
     */
    public Pessoa() {

    }

    /**
     * getNome .
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * setNome(nome)
     *
     * @param nome .
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * getSobrenome() .
     *
     * @return sobrenome .
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * setSobrenome(String sobrenome) .
     *
     * @param sobrenome .
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * getTelefoneResidencial() .
     *
     * @return telefoneFixo .
     */
    public String getTelefoneResidencial() {
        return telefoneFixo;
    }

    /**
     * setTelefoneFixo(String telefoneFixo)
     *
     * @param telefoneFixo
     */
    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    /**
     * getTelefoneCelular() .
     *
     * @return telefoneCelular .
     */
    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    /**
     * setTelefoneCelular(String telefoneCelular) .
     *
     * @param telefoneCelular
     */
    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    /**
     * getCpf .
     *
     * @return cpf .
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * setCpf(String cpf)
     *
     * @param cpf .
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
