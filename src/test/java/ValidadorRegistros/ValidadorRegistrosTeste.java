package ValidadorRegistros;

import cc.code.dominio.Pessoa;
import cc.code.exception.ValidadorRegistrosException;
import cc.code.validador.ValidadorRegistros;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ValidadorRegistrosTeste {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;
    private static final PrintStream originalErr = System.err;

    private Pessoa pessoa;

    private String nome;
    private String sobrenome;
    private String telefoneFixo;
    private String telefoneCelular;
    private String cpf;

    @BeforeEach
    void setUp() {
        this.nome = "Fulana";
        this.sobrenome = "Silva";
        this.telefoneFixo = "33445566";
        this.telefoneCelular = "11988997766";
        this.cpf = "9094469979";

        pessoa = new Pessoa(this.nome, this.sobrenome, this.telefoneFixo, this.telefoneCelular, this.cpf);

        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void deveriaCadastrarPessoaComInformacoesValidas() throws ValidadorRegistrosException {

        String saidaEsperada = "Nome: Fulano Silva\n" +
                "Fone: 11988997766\n" +
                "CPF: 9094469979\n";

        ValidadorRegistros.imprimirPessoasValidadasComSucesso(this.pessoa);

        assertEquals(saidaEsperada, outContent.toString());

    }

    @Test
    void deveriaLancarExececaoCasoNomeForNulo() {

        String saidaEsperada = "Nome inválido!\n";

        String nomeInvalido = null;
        final Pessoa pessoaComNomeInvalido = new Pessoa(nomeInvalido, this.sobrenome, this.telefoneFixo, this.telefoneCelular, this.cpf);

        ValidadorRegistrosException cadastroException = assertThrows(ValidadorRegistrosException.class, () -> {
            ValidadorRegistros.imprimirPessoasValidadasComSucesso(pessoaComNomeInvalido);
        });

        assertEquals(saidaEsperada, errContent.toString());
        assertEquals(ValidadorRegistros.MSG_NOME_INVALIDO, cadastroException.getMessage());
    }

    @Test
    void deveriaLancarExcecaoCasoNomeForVazio() {

        String saidaEsperada = "Nome inválido!\n";

        String nomeVazio = "";
        final Pessoa pessoaComNomeVazio = new Pessoa(nomeVazio, this.sobrenome, this.telefoneFixo, this.telefoneCelular, this.cpf);

        ValidadorRegistrosException cadastroException = assertThrows(ValidadorRegistrosException.class, () -> {
            ValidadorRegistros.imprimirPessoasValidadasComSucesso(pessoaComNomeVazio);
        });

        assertEquals(saidaEsperada, errContent.toString());
        assertEquals(ValidadorRegistros.MSG_NOME_INVALIDO, cadastroException.getMessage());
    }

    @Test
    void deveriaLancarExcecaoCasoTelefoneCelularTiverMenosDe10Digitos() {

        String saidaEsperada = "Telefone inválido!\n";

        String telefoneCelularInvalido = "988889999";
        final Pessoa pessoaComCelularInvalido = new Pessoa(this.nome, this.sobrenome, this.telefoneFixo, telefoneCelularInvalido, this.cpf);

        ValidadorRegistrosException cadastroException = assertThrows(ValidadorRegistrosException.class, () -> {
            ValidadorRegistros.imprimirPessoasValidadasComSucesso(pessoaComCelularInvalido);
        });

        assertEquals(saidaEsperada, errContent.toString());
        assertEquals(ValidadorRegistros.MSG_TELEFONE_CELULAR_INVALIDO, cadastroException.getMessage());
    }

    /**
     * Teste metodo imprimirPessoasValidadasComSucesso().
     *
     * @Test
     */
    void deveriaLancarExcecaoCasoCPFInvalido() {

        String saidaEsperada = "CPF inválido!\n";

        String cpfInvalido = "00000000000";
        final Pessoa pessoaComCPFInvalido = new Pessoa(this.nome, this.sobrenome, this.telefoneFixo, this.telefoneCelular, cpfInvalido);

        ValidadorRegistrosException validadorRegistrosException = assertThrows(ValidadorRegistrosException.class, () -> {
            ValidadorRegistros.imprimirPessoasValidadasComSucesso(pessoaComCPFInvalido);
        });

        assertEquals(saidaEsperada, errContent.toString());
        assertEquals(ValidadorRegistros.MSG_CPF_INVALIDO, validadorRegistrosException.getMessage());
    }
}

