/*
 * Projeto.: Lista Simplesmente Ligada/Encadeada
 * Autor...: Professor Dreco
 * Classe..: Lse
 * Objetivo: Criação e manutenção dos elementos na lista simplesmente encadeada
 */
package lista;

import java.util.Scanner;

public class Lse {

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
                texto = "Erro na digitação, o ID é obrigatório e inteiro maior que zero: ";
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
        Noh aux = null;
        int t = 0;
        //
        for (aux = this.primeiro, t = 1;
                aux != null;
                aux = aux.getProximo(), t++);
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
        Msg.msg_central("PROCESSO DE INSERÇÃO POR POSIÇÃO");

        if (pos == 1) {
            Noh novo = new Noh(this.D_Id(), this.D_Nome(), this.D_Sexo(), null);

            if (novo == null) {
                Msg.msg_central("Memória indisponível para a inserção.");
            } else {
                if (this.primeiro == null) {
                    this.primeiro = this.ultimo = novo;
                } else {
                    novo.setProximo(this.primeiro);
                    this.primeiro = novo;
                }
            }
        } else {
            int posicao = 0;
            int parada = pos - 1;

            Noh aux = null;

            for (aux = this.primeiro, posicao = 1;
                    (aux != null) && (posicao != parada);
                    aux = aux.getProximo(), posicao++);

            if (aux == null) {
                posicao--;
                Msg.msg_central("A posição [" + pos + "] não pode ser inserida.\nA lista tem [" + posicao + "] elementos.");
            } else {
                Noh novo = new Noh(this.D_Id(), this.D_Nome(), this.D_Sexo(), null);

                if (novo == null) {
                    Msg.msg_central("Memória indisponível para a inserção.");
                } else {
                    if (aux == this.ultimo) {
                        this.ultimo.setProximo(novo);
                        this.ultimo = novo;
                    } else {
                        novo.setProximo(aux.getProximo());
                        aux.setProximo(novo);
                    }
                }
            }
        }
    }

    // Objetivo: método para remover um elemento por posição na lista
    //           
    //
    public void remover_posicao(int pos) {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE REMOÇÃO POR POSIÇÃO");

        Noh liberar = null;

        if (this.primeiro == this.ultimo) {
            liberar = this.primeiro;

            if (pos == 1) {
                this.primeiro = this.ultimo = null;
            } else {
                Msg.msg_central("A posição [" + pos + "] não existe, logo, não pode ser removida.");
            }
        } else {
            if (pos == 1) {
                liberar = this.primeiro;

                this.primeiro = this.primeiro.getProximo();
            } else {
                Noh aux = null;
                int posicao = 0;
                int parada = pos - 1;

                for (aux = this.primeiro, posicao = 1;
                        (aux != null) && (posicao != parada);
                        aux = aux.getProximo(), posicao++) {
                }

                if ((aux == null) || (aux.getProximo() == null)) {
                    Msg.msg_central("A posição [" + pos + "] não existe, logo, não pode ser removida.");
                } else {
                    liberar = aux.getProximo();

                    if (aux.getProximo() == this.ultimo) {
                        this.ultimo = aux.getProximo();
                        aux.setProximo(null);
                    } else {
                        aux.setProximo(aux.getProximo().getProximo());
                        liberar.setProximo(null);
                    }
                }
            }
        }
        if (liberar != null) {
            Msg.msg_nl("Elemento removido da lista:");
            liberar.mostra_noh(1, 1);
        }
    }

    // Objetivo: método para remover todos os elementos que estão
    //           presentes na lista, inicializando-a. Tornando-a vazia.
    //
    public void inicializar() {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE INICIALIZAÇÃO");

        Noh liberar = this.primeiro;

        do {
            this.primeiro = this.primeiro.getProximo();
            liberar.setProximo(null);
            liberar = this.primeiro;
        } while (this.primeiro != null);

        this.ultimo = null;

        System.gc();
    }

    // Objetivo: método para consultar todos os elementos que estão
    //           presentes na lista
    //
    public void consultar_geral() {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE CONSULTA GERAL");

        Noh aux = null;
        int pos = 0;

        for (aux = this.primeiro, pos = 1;
                aux != null;
                aux = aux.getProximo(), pos++) {
            aux.mostra_noh(pos, pos);
        }
    }

    // Objetivo: método para consultar se uma determinada posição está
    //           presente na lista e, se sim, qual elemento a ocupa
    //
    public void consultar_posicao(int posicao) {
        Msg.limpatela();
        Msg.msg_central("PROCESSO DE CONSULTA POR POSIÇÃO");

        Noh aux = null;
        int pos = 0;

        for (aux = this.primeiro, pos = 1;
                (aux != null) && (pos != posicao);
                aux = aux.getProximo(), pos++);

        if (aux == null) {
            Msg.msg_central("A posição [" + posicao + "] não existe na fila.");
        } else {
            aux.mostra_noh(posicao, 1);
        }
    }

    // Objetivo: método para consultar se um determinado elemento com conteúdo INT está
    //           presente na lista e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo_int(int conteudo) {
        // Neste processo, será apresentado o primeiro elemento que possui o conteúdo procurado.

        Msg.limpatela();
        Msg.msg_central("PROCESSO DE CONSULTA POR POSIÇÃO");

        Noh aux = null;
        int pos = 0;

        for (aux = this.primeiro, pos = 1;
                (aux != null) && (aux.getId() != conteudo);
                aux = aux.getProximo(), pos++);

        if (aux == null) {
            Msg.msg_central("O conteúdo [" + conteudo + "] não existe na fila.");
        } else {
            aux.mostra_noh(pos, 1);
        }
    }

    // Objetivo: método para consultar se um determinado elemento com conteúdo STR está
    //           presente na lista e, se sim, qual posição ele ocupa
    //
    public void consultar_conteudo_str(String conteudo) {
        // Neste processo, será apresentado o primeiro elemento que possui o conteúdo procurado.

        Msg.limpatela();
        Msg.msg_central("PROCESSO DE CONSULTA POR CONTEÚDO");

        Noh aux = null;
        int pos = 0;

        for (aux = this.primeiro, pos = 1;
                (aux != null) && (aux.getNome().compareTo(conteudo) != 0);
                aux = aux.getProximo(), pos++);

        if (aux == null) {
            Msg.msg_central("O conteúdo [" + conteudo + "] não existe na fila.");
        } else {
            aux.mostra_noh(pos, 1);
        }
    }

    // Especial 16
    // O usuário deverá escolher uma posição de origem e uma posição de destino, que
    // deverão ser validadas. Assim, por meio de meio dos ajustes nas ligações, 
    // você deverá alterar o elemento da posição de origem
    // para ficar na posição de destino escolhida.
    public void troca_de_prioridade() {
        Msg.msg_central("PROCESSO DE TROCA DE PRIORIDADE");
        int pos1 = Msg.solicita_conteudo_int();
        int pos2 = Msg.solicita_conteudo_int();

        int pos = 1;
        Noh aux1 = null, aux2 = null;
        Noh anteriorAux1 = null, anteriorAux2 = null;

        for (aux1 = this.primeiro, pos = 1; aux1 != null && pos != pos1; aux1 = aux1.getProximo(), pos++) {
        }

        for (aux2 = this.primeiro, pos = 1; aux2 != null && pos != pos2; aux2 = aux2.getProximo(), pos++) {
        }

        if (aux1 == null || aux2 == null) {
            Msg.msg_central("A posição não existe");
        } else {
            anteriorAux1 = this.primeiro;
            while (anteriorAux1 != null && anteriorAux1.getProximo() != aux1) {
                anteriorAux1 = anteriorAux1.getProximo();
            }

            anteriorAux2 = this.primeiro;
            while (anteriorAux2 != null && anteriorAux2.getProximo() != aux2) {
                anteriorAux2 = anteriorAux2.getProximo();
            }

            if (aux1 != aux2) {
                if (anteriorAux1 != null) {
                    anteriorAux1.setProximo(aux2);
                } else {
                    this.primeiro = aux2;
                }

                if (anteriorAux2 != null) {
                    anteriorAux2.setProximo(aux1);
                } else {
                    this.primeiro = aux1;
                }

                Noh temp = aux1.getProximo();
                aux1.setProximo(aux2.getProximo());
                aux2.setProximo(temp);
            } else {
                Msg.msg_central("As posições são iguais.");
            }
        }
    }

    // Especial 17
    // Faça um processo que remova da lista os elementos que possuírem o maior valor de ID
    // encontrado nela.
    public void remover_maior_id() {
        Msg.msg_central("PROCESSO DE REMOÇÃO DOS MAIORES IDs");
        int maior = 0;

        Noh aux = this.primeiro;
        while (aux != null) {
            if (aux.getId() > maior) {
                maior = aux.getId();
            }
            aux = aux.getProximo();
        }

        Noh anterior = null;
        aux = this.primeiro;

        while (aux != null) {
            if (aux.getId() == maior) {
                if (aux == this.primeiro) {
                    this.primeiro = aux.getProximo();
                    aux.setProximo(null);
                    aux = this.primeiro;
                } else {
                    anterior.setProximo(aux.getProximo());
                    aux.setProximo(null);
                    aux = anterior.getProximo();
                }

                if (aux == null) {
                    this.ultimo = anterior;
                }
            } else {
                anterior = aux;
                aux = aux.getProximo();
            }
        }
    }

    // Objetivo: método construtor da lista e que determina que ela
    //           está, inicialmente, vazia
    //
    public Lse() {
        this.primeiro = this.ultimo = null;
    }
}
