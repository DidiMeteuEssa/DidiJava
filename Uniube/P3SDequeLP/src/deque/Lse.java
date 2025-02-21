/*
 * Projeto.: Lista Simplesmente Ligada/Encadeada
 * Autor...: Professor Dreco
 * Classe..: Lse
 * Objetivo: Criação e manutenção dos elementos na deque simplesmente encadeada
 */
package deque;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lse {

    // Objetivo: atributos de determinação do primeiro e do último elemento da
    //           deque, para que seja realizada a sua gestão
    //
    public Noh primeiro;
    public Noh ultimo;

    // Objetivo: método para receber e tratar a digitação de um atributo dados
    //           (do tipo Object) quando de uma inserção ou consulta por conteúdo
    //
    public String digitacao(String tipo) {
        Scanner s = new Scanner(System.in);
        String dados = " ";

        do {
            Msg.limpatela();

            try {
                Msg.msg_pl("Digite o [" + tipo + "] para o elemento - não pode ser vazio: ");
                dados = s.nextLine();
            } catch (Exception e) {
                Msg.msg_pl("Erro de digitação, não deixe a informação [" + tipo + "] vazia:");
            }
        } while (dados.isEmpty());

        return dados;
    }

    // Objetivo: método para receber e tratar a digitação do atributo codigo
    //           quando de uma inserção ou consulta por conteúdo
    //
    public Integer D_Id() {
        Msg.limpatela();

        Scanner s = new Scanner(System.in);
        Integer cod = 0;
        String texto = "Digite o valor para o Id do cliente (inteiro maior que zero): ";
        Integer erro = 0;

        do {
            try {
                Msg.msg_pl(texto);
                cod = Integer.parseInt(s.nextLine());
            } catch (Exception e) {
                texto = "Erro de digitação, o ID é obrigatório e inteiro maior que zero: ";
                erro = 1;
            }
            if ((cod <= 0) && (erro == 0)) {
                texto = "Erro de digitação, o ID é obrigatório e inteiro maior que zero: ";
            }
            erro = 0;
            Msg.limpatela();

        } while (cod <= 0);

        return cod;
    }

    // Objetivo: método para receber e tratar a digitação de um atributo dados
    //           Nome
    //
    public String D_Nome() {
        Msg.limpatela();

        Scanner s = new Scanner(System.in);
        String nome = " ";
        String texto = "Digite o NOME do cliente (obrigatório): ";

        do {
            Msg.limpatela();

            try {
                Msg.msg_pl(texto);
                nome = s.nextLine();
            } catch (Exception e) {
                texto = "Erro de digitação, o NOME é obrigatório: ";
            }

            Msg.limpatela();

        } while (nome.isEmpty());

        return nome;
    }

    // Objetivo: método para receber e tratar a digitação do atributo sexo
    //           quando de uma inserção ou consulta por conteúdo
    //
    public Integer D_Sexo() {
        Scanner s = new Scanner(System.in);
        int sexo = 0;
        String texto = "Digite o valor para o SEXO do cliente (1.Mas 2.Fem): ";
        Integer erro = 0;

        do {
            Msg.limpatela();

            try {
                Msg.msg_pl(texto);
                sexo = Integer.parseInt(s.nextLine());
            } catch (Exception e) {
                texto = "Erro de digitação, o SEXO é obrigatório: ";
                erro = 1;
            }
            if ((sexo < 1) || (sexo > 2) || (erro == 0)) {
                texto = "Erro de digitação, o SEXO é obrigatório (1.Mas 2.Fem): ";
            }

            erro = 0;

            Msg.limpatela();

        } while ((sexo < 1) || (sexo > 2));

        return sexo;
    }

    // Objetivo: método para quantificar e informar a quantidade de
    //           elementos da deque, ou seja, seu tamanho
    //
    public int tamanho() {
        int t = 0;
        //
        // Aguarde a implementação do cálculo de tamanho da lista
        //
        return t;
    }

    // Objetivo: método para verificar se a deque está vazia (true)
    //           ou não (false)
    //
    public boolean vazia() {
        boolean r = true;

        if (this.primeiro != null) {
            r = false;
        }

        return r;
    }

    // Objetivo: método para inserir um novo elemento no início da deque
    //
    //
    public void inserir_inicio() {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE INSERÇÃO NO INÍCIO - Aguarde implementação");

        Noh novo = new Noh();
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE INSERÇÃO NO FINAL");
        Noh aux = null;

        int id = this.D_Id();

        if (this.primeiro == null) {
            novo.setId(id);
            novo.setNome(this.D_Nome());
            novo.setSexo(this.D_Sexo());

            this.primeiro = this.ultimo = novo;
        } else {

            for (aux = this.primeiro; id != aux.getId() && aux.getProximo() != null; aux = aux.getProximo()) {
            }
            if (id == aux.getId()) {
                Msg.msg_central("INSERÇÃO NÃO REALIZADA - O ID [" + id + "] já existe.");
            } else {
                if (novo == null) {
                    Msg.msg_central("Memória indisponível.");
                } else {
                    novo.setId(id);
                    novo.setNome(this.D_Nome());
                    novo.setSexo(this.D_Sexo());

                    novo.setProximo(this.primeiro);
                    this.primeiro = novo;

                }
            }
        }

    }

    // Objetivo: método para inserir um novo elemento no final da deque
    //
    //
    public void inserir_final() {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE INSERÇÃO NO FINAL");
        Noh aux = null;
        Noh novo = new Noh();
        int id = this.D_Id();

        if (this.primeiro == null) {
            novo.setId(id);
            novo.setNome(this.D_Nome());
            novo.setSexo(this.D_Sexo());

            this.primeiro = this.ultimo = novo;
        } else {

            for (aux = this.primeiro; id != aux.getId() && aux.getProximo() != null; aux = aux.getProximo()) {
            }
            if (id == aux.getId()) {
                Msg.msg_central("INSERÇÃO NÃO REALIZADA - O ID [" + id + "] já existe.");
            } else {
                if (novo == null) {
                    Msg.msg_central("Memória indisponível.");
                } else {
                    novo.setId(id);
                    novo.setNome(this.D_Nome());
                    novo.setSexo(this.D_Sexo());

                    this.ultimo.setProximo(novo);
                    this.ultimo = novo;

                }
            }
        }
    }

    // Objetivo: método para remover um elemento da primeira posição
    //           da deque
    //
    public void remover_inicio() {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE REMOÇÃO NO INÍCIO - Aguarde implementação");

        Noh aux = this.primeiro.getProximo();

        this.primeiro.setProximo(null);
        this.primeiro = aux;

        Msg.msg_central("Primeiro removido!");
        System.gc();
    }

    // Objetivo: método para remover um elemento da primeira posição
    //           da deque
    //
    public void remover_final() {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE REMOÇÃO NO FINAL - Aguarde implementação");

        Noh remover = this.primeiro;
        if (remover == this.ultimo) {
            this.primeiro = this.ultimo = remover = null;
        } else {
            while (remover.getProximo() != this.ultimo) {
                remover = remover.getProximo();
            }
            remover.setProximo(null);
            this.ultimo = remover;
        }
        Msg.msg_central("Ultimo removido!");
        System.gc();
    }

    // Objetivo: método para remover todos os elementos que estão
    //           presentes na deque, inicializando-a. Tornando-a vazia.
    //
    public void inicializar() {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE INICIALIZAÇÃO - Aguarde implementação");
        Noh aux;
        while (this.primeiro != null) {
            aux = this.primeiro;
            this.primeiro = this.primeiro.getProximo();
            aux.setProximo(null);
        }
        this.ultimo = null;
        Msg.msg_central("Lista inicializada!");
        System.gc();
    }

    // Objetivo: método para consultar todos os elementos que estão
    //           presentes na deque
    //
    public void consultar_geral() {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE CONSULTA GERAL - Aguarde implementação");
        Msg.limpatela();

        Noh aux = null;
        int pos = 0;

        for (aux = this.primeiro, pos = 1;
                aux != null;
                aux = aux.getProximo(), pos++) {
            aux.mostra_noh(pos);
        }
    }

    // Objetivo: método para consultar se uma determinada posição está
    //           presente na deque e, se sim, qual elemento a ocupa
    //
    public void consultar_posicao(int posicao) {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE CONSULTA POR POSIÇÃO");

        Noh aux = null;
        int pos = 0;

        for (aux = this.primeiro, pos = 1;
                aux != null && pos != posicao;
                aux = aux.getProximo(), pos++) {
        }

        if (aux == null) {
            Msg.msg_central("Posicao [" + posicao + "] não encontrada.");
        } else {
            aux.mostra_noh(posicao);
        }
    }

    // Objetivo: método para consultar se um determinado elemento com conteúdo INT está
    //           presente na deque e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo_int(int conteudo) {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE CONSULTA POR CONTEÚDO - INT - Aguarde implementação");

        Noh aux = null;
        int pos = 0;

        for (aux = this.primeiro, pos = 1;
                aux != null && conteudo != aux.getId();
                aux = aux.getProximo(), pos++) {
        }

        if (aux == null) {
            Msg.msg_central("ID [" + conteudo + "] não encontrada.");
        } else {
            aux.mostra_noh(pos);
        }
    }

    // Objetivo: método para consultar se um determinado elemento com conteúdo STR está
    //           presente na deque e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo_str(String conteudo) {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE CONSULTA POR CONTEÚDO - STR - Aguarde implementação");

        Noh aux = null;
        int pos = 0;

        for (aux = this.primeiro, pos = 1;
                aux != null && !aux.getNome().equals(conteudo);
                aux = aux.getProximo(), pos++) {
        }
        if (aux == null) {
            Msg.msg_central("Nome '" + conteudo + "' nao encontrado!");
        } else {
            aux.mostra_noh(pos);
        }
    }

    public void especial_11() {
        Noh aux1 = this.primeiro;
        Noh aux2 = this.ultimo;
        Noh aux3 = this.primeiro;
        int pos = 0;

        if (this.primeiro == this.ultimo) {
            Msg.msg_central("Erro na alteração!");
        } else {
            this.primeiro = aux2;
            aux2.setProximo(aux1.getProximo());

            for (aux3 = this.primeiro, pos = 1; aux3 != null && pos != 4; aux3 = aux3.getProximo(), pos++) {
            }

            aux1.setProximo(null);
            aux3.setProximo(aux1);
            this.ultimo = aux1;

            Msg.msg_central("Elementos trocados!");
        }
    }

    public void especial_12() {
        Noh aux1 = this.primeiro;
        Noh aux2 = this.primeiro;
        Noh aux3 = this.primeiro.getProximo();
        Noh aux4 = this.primeiro;

        int pos = 0;

        for (aux2 = this.primeiro, pos = 1; aux2 != null && pos != 3; aux2 = aux2.getProximo(), pos++) {
        }
        for (aux4 = this.primeiro, pos = 1; aux4 != null && pos != 4; aux4 = aux4.getProximo(), pos++) {
        }

        if (aux2 == null) {
            Msg.msg_central("Erro na alteração!");
        } else {

            this.primeiro = aux2;

            aux2.setProximo(aux3);
            aux3.setProximo(aux1);
            aux1.setProximo(aux4);

            Msg.msg_central("Elementos trocados!");
        }
    }

    public void especial_13() {
        Noh analise = this.primeiro;
        Noh anterior = null;
        Noh comparacao = analise.getProximo();
        int cont = 0;

        while (analise != null && analise.getProximo() != null) {
            comparacao = analise.getProximo();
            anterior = analise;
            while (comparacao != null) {
                if (analise.getId().equals(comparacao.getId()) && analise.getNome().equals(comparacao.getNome())
                        && analise.getSexo().equals(comparacao.getSexo())) {
                    anterior.setProximo(comparacao.getProximo());
                    cont++;
                    if (comparacao == this.ultimo) {
                        this.ultimo = anterior;
                    }
                } else {
                    anterior = comparacao;
                }
                comparacao = comparacao.getProximo();
            }
            analise = analise.getProximo();
        }

        if (cont > 0) {
            Msg.msg_central("[" + cont + "] elementos duplicados REMOVIDOS!");
        } else {
            Msg.msg_central("Nenhum elemento duplicado encontrado!");
        }

        System.gc();
    }

    public void especial_15() {

        Noh aux = null;
        Noh prox = null;
        int cont = 0;
        int id = 0;

        for (aux = this.primeiro; aux != null; aux = aux.getProximo()) {
            prox = aux.getProximo();
            id = aux.getId();

            if (id % 2 == 0) {
                Noh duplicar = new Noh();

                duplicar.setId(aux.getId());
                duplicar.setNome(aux.getNome());
                duplicar.setSexo(aux.getSexo());

                duplicar.setProximo(prox);
                aux.setProximo(duplicar);

                if (aux == this.ultimo) {
                    this.ultimo = duplicar;
                }

                aux = duplicar;
                cont++;
            }
        }

        if (cont > 0) {
            Msg.msg_central("[" + cont + "] elementos DUPLICADOS com SUCESSO!");
        } else {
            Msg.msg_central("Nenhum ID PAR encontrado!");
        }

    }

    // Objetivo: método construtor da deque e que determina que ela
    //           está, inicialmente, vazia
    //
    public Lse() {
        this.primeiro = this.ultimo = null;
    }
}
