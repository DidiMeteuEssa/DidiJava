/*
 * Projeto.: Lista Simplesmente Ligada/Encadeada
 * Autor...: Professor Dreco
 * Classe..: Lse
 * Objetivo: Criação e manutenção dos elementos na deque simplesmente encadeada
 */
package deque;
import java.util.Scanner;

public class Lde
{
    // Objetivo: atributos de determinação do primeiro e do último elemento da
    //           deque, para que seja realizada a sua gestão
    //
    public Noh primeiro;
    public Noh ultimo;

    // Objetivo: método para receber e tratar a digitação de um atributo dados
    //           (do tipo Object) quando de uma inserção ou consulta por conteúdo
    //
    public String digitacao (String tipo)
    {
        Scanner s = new Scanner(System.in);
        String dados = " ";

        do
        {
            Msg.limpatela();

            try
            {
                Msg.msg_pl("Digite o ["+tipo+"] para o elemento - não pode ser vazio: ");
                dados = s.nextLine();
            }
            catch(Exception e)
            {
                Msg.msg_pl ("Erro de digitação, não deixe a informação ["+tipo+"] vazia:");
            }
        } while (dados.isEmpty());

        return dados;
    }


    // Objetivo: método para receber e tratar a digitação do atributo codigo
    //           quando de uma inserção ou consulta por conteúdo
    //
    public Integer D_Id ()
    {
        Msg.limpatela();
            
        Scanner s = new Scanner(System.in);
        Integer cod = 0;
        String texto = "Digite o valor para o Id do cliente (inteiro maior que zero): ";
        Integer erro = 0;

        do
        {
            try
            {
                Msg.msg_pl(texto);
                cod = Integer.parseInt(s.nextLine());
            }
            catch(Exception e)
            {
                texto = "Erro de digitação, o ID é obrigatório e inteiro maior que zero: ";
                erro = 1;
            }
            if((cod <= 0) && (erro == 0))
            {
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
    public String D_Nome ()
    {
        Msg.limpatela();
            
        Scanner s = new Scanner(System.in);
        String nome = " ";
        String texto = "Digite o NOME do cliente (obrigatório): ";

        do
        {
            Msg.limpatela();

            try
            {
                Msg.msg_pl(texto);
                nome = s.nextLine();
            }
            catch(Exception e)
            {
                texto = "Erro de digitação, o NOME é obrigatório: ";
            }

            Msg.limpatela();
            
        } while (nome.isEmpty());

        return nome;
    }

    // Objetivo: método para receber e tratar a digitação do atributo sexo
    //           quando de uma inserção ou consulta por conteúdo
    //
    public Integer D_Sexo ()
    {
        Scanner s = new Scanner(System.in);
        int sexo  = 0;
        String texto = "Digite o valor para o SEXO do cliente (1.Mas 2.Fem): ";
        Integer erro = 0;

        do
        {
            Msg.limpatela();

            try
            {
                Msg.msg_pl(texto);
                sexo = Integer.parseInt(s.nextLine());
            }
            catch(Exception e)
            {
                texto = "Erro de digitação, o SEXO é obrigatório: ";
                erro = 1;
            }
            if((sexo < 1) || (sexo > 2) || (erro == 0))
            {
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
    public int tamanho()
    {
        int t = 0;
        //
        // Aguarde a implementação do cálculo de tamanho da lista
        //
        return t;
    }

    // Objetivo: método para verificar se a deque está vazia (true)
    //           ou não (false)
    //
    public boolean vazia()
    {
        boolean r = true;

        if (this.primeiro != null)
        {
            r = false;
        }
        
        return r;
    }

    // Objetivo: método para inserir um novo elemento no início da deque
    //
    //
    public void inserir_inicio() {
        Msg.limpatela();

        Noh novo = new Noh();

        if (novo == null) {
            Msg.msg_central("Memória não disponível.");
        } else {
            novo.setId(this.D_Id());
            novo.setNome(this.D_Nome());
            novo.setSexo(this.D_Sexo());

            if (this.vazia()) {
                this.primeiro = this.ultimo = novo;
            } else {
                this.primeiro.setAnterior(novo);
                novo.setProximo(this.primeiro);
                this.primeiro = novo;
            }
        }
    }

     // Objetivo: método para inserir um novo elemento no final da deque
    //
    //
    public void inserir_final() {
        Msg.limpatela();

        Noh novo = new Noh();

        if (novo == null) {
            Msg.msg_central("Memória não disponível.");
        } else {
            novo.setId(this.D_Id());
            novo.setNome(this.D_Nome());
            novo.setSexo(this.D_Sexo());

            if (this.vazia()) {
                this.primeiro = this.ultimo = novo;
            } else {
                novo.setAnterior(this.ultimo);
                this.ultimo.setProximo(novo);
                this.ultimo = novo;
            }
        }
    }

   // Objetivo: método para remover um elemento da primeira posição
    //           da deque
    //
    public void remover_inicio()
    {
        Msg.limpatela();
        Msg.msg_central ("PROCESSO DE REMOÇÃO NO INÍCIO");
        
        Noh liberar = this.primeiro;
        
        this.primeiro = this.primeiro.getProximo();
        
        liberar.mostra_noh(1);
        
        if (this.primeiro == null)
        {
            this.ultimo = null;
        }
        else
        {
            this.primeiro.setAnterior(null);
            liberar.setProximo(null);
        }
        
        System.gc();
    }

    // Objetivo: método para remover um elemento da última posição
    //           da deque
    //
    public void remover_final() {
        Msg.limpatela();
        Noh aux = this.ultimo;

        if (aux == this.primeiro) {
            this.primeiro = this.ultimo = null;
        } else {
            Noh anterior = this.ultimo.getAnterior();

            anterior.setProximo(null);
            aux.setAnterior(null);
            this.ultimo = anterior;
        }

        Msg.msg_central("Ultimo removido!");
        System.gc();
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
        Msg.msg_central("Deque inicializada!");
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

    // Objetivo: método construtor da deque e que determina que ela
    //           está, inicialmente, vazia
    //
    public Lde()
    {
        this.primeiro = this.ultimo = null;
    }
}