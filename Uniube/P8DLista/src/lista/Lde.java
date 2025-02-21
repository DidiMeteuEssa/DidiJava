/*
 * Projeto.: Lista Simplesmente Ligada/Encadeada
 * Autor...: Professor Dreco
 * Classe..: Lse
 * Objetivo: Criação e manutenção dos elementos na lista simplesmente encadeada
 */
package lista;

import java.util.Scanner;

public class Lde {

    // Objetivo: atributos de determinação do primeiro e do último elemento da
    //           lista, para que seja realizada a sua gestão
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
    //           elementos da lista, ou seja, seu tamanho
    //
    public int tamanho() {
        int t = 0;
        //
        // Aguarde a implementação do cálculo de tamanho da lista
        //
        return t;
    }

    // Objetivo: método para verificar se a lista está vazia (true)
    //           ou não (false)
    //
    public boolean vazia() {
        boolean r = true;

        if (this.primeiro != null) {
            r = false;
        }

        return r;
    }

    // Objetivo: método para inserir um novo elemento pos posição na lista
    //
    //
    public void inserir_posicao(int pos) {
        Msg.limpatela();

        Noh novo = new Noh();
        String texto = "Posição não disponível";

        novo.setId(this.D_Id());
        novo.setNome(this.D_Nome());
        novo.setSexo(this.D_Sexo());

        if (pos == 1) {
            if (this.vazia()) {
                this.primeiro = this.ultimo = novo;
            } else {
                this.primeiro.setAnterior(novo);
                novo.setProximo(this.primeiro);
                this.primeiro = novo;
            }
            texto = "Elemento inserido na primeira posição!";
        } else {
            Noh aux = null;
            int posicao = 0;

            for (aux = this.primeiro, posicao = 1; aux != null && posicao != (pos - 1);
                    aux = aux.getProximo(), posicao++) {
            }

            if (aux != null) {
                novo.setProximo(aux.getProximo());
                novo.setAnterior(aux);
                aux.setProximo(novo);

                texto = "Elemento inserido na [" + pos + "º] posição";

                if (aux == this.ultimo) {
                    this.ultimo = novo;
                    texto = "Elemento inserido na última posição!";
                }

            } 
             
        }

        Msg.msg_central(texto);
    }
    // Objetivo: método para remover um elemento por posição na lista
    //           
    //

    public void remover_posicao(int pos) {
        Msg.limpatela();

        Noh remover = null;
        String texto = "Posição não encontrada";

        if (pos == 1) {
            Msg.limpatela();

            remover = this.primeiro;
            
            this.primeiro = this.primeiro.getProximo();

            if (this.primeiro == null) {
                this.ultimo = null;
            } else {
                this.primeiro.setAnterior(null);
                remover.setProximo(null);
            }
            texto = "Primeiro elemento removido";
        } else {
            Noh anterior = null;
            int posicao = 0;

            for (remover = this.primeiro, posicao = 1; remover != null && posicao != pos;
                    remover = remover.getProximo(), posicao++) {
            }
            
            if(remover != null){
                anterior = remover.getAnterior();
                anterior.setProximo(remover.getProximo());
                
                remover.setProximo(null);
                
                texto = "Elemento da posição ["+pos+"] removido";
                
                if(remover == this.ultimo){
                    this.ultimo = anterior;
                    texto = "Último elemento removido";
                }
            }
        }

        System.gc();
        Msg.msg_central(texto);

    }

    // Objetivo: método para remover todos os elementos que estão
    //           presentes na fila, inicializando-a. Tornando-a vazia.
    //
    public void inicializar() {
        Msg.limpatela();
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
    //           presente na fila e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo_int(int conteudo) {
        Msg.limpatela();

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

    // Objetivo: método construtor da lista e que determina que ela
    //           está, inicialmente, vazia
    //
    public Lde() {
        this.primeiro = this.ultimo = null;
    }
}
