/* Projeto...: Lista Simplesmente Ligada
 * Autor.....: Professor Dreco
 * Biblioteca: Noh
 * Classe....: Noh
 * Objetivo..: Criação do nó (elemento) que será utilizado nos projetos
 */
package fila;

public class Noh
{
    // Objetivo: atributo de determinação do objeto para servir de referência
    //           no armazenamento dos dados de um elemento da lista
    //
    private Integer id;
    private String  nome;
    private Integer sexo;
    
    // Objetivo: atributo de determinação do objeto para expressar a ligação
    //           do elemento para um outr elemento da lista
    //
    private Noh proximo;

    // Objetivo: método para registrar o preenchimento do atributo
    //           de ligação de um elemento da lista a outro elemento
    //
    public void setProximo(Noh proximo)
    {
        this.proximo = proximo;
    }

    // Objetivo: método para registrar as informações do atributo de
    //           codigo de um elemento da lista
    //
    public void setId (Integer id)
    {
        this.id = id;
    }

    // Objetivo: método para registrar as informações do atributo de
    //           nome de um elemento da lista
    //
    public void setNome(String nome)
    {
        this.nome = nome;
    }

    // Objetivo: método para registrar as informações do atributo de
    //           sexo de um elemento da lista
    //
    public void setSexo(Integer sexo)
    {
        this.sexo = sexo;
    }

    // Objetivo: método para buscar informações sobre o atributo de
    //           ligação do elemento atual a um outro da lista
    //
    public Noh getProximo()
    {
        return proximo;
    }

    // Objetivo: método para buscar informações sobre o atributo
    //           codigo do elemento atual
    //
    public Integer getId()
    {
        return id;
    }

    // Objetivo: método para buscar informações sobre o atributo
    //           nome do elemento atual
    //
    public String getNome()
    {
        return nome;
    }

    // Objetivo: método para buscar informações sobre o atributo
    //           sexo do elemento atual
    //
    public Integer getSexo()
    {
        return sexo;
    }

    // Objetivo: método para mostrar os dados de um elemento
    //
    //
    public void mostra_noh (int posicao)
    {
        if (posicao == 1)
        {
            System.out.println();
            System.out.println("+---------+----------+--------------------------------+------+----------+--------------------------------+");
            System.out.println("| Posicao | Id       | Nome                           | Sexo | Próximo  | Nome do Próximo                |");
            System.out.println("+---------+----------+--------------------------------+------+----------+--------------------------------+");
        }
        if (this.getProximo() == null)
        {
            System.out.format ("| %7d | %8d | %-30s |   %1d  |     null | - - - - - - - - - - - - - - -  |",
                posicao, this.getId(), this.getNome(), this.getSexo());
            System.out.println();
        }
        else
        {
            System.out.format ("| %7d | %8d | %-30s |   %1d  | %8d | %-30s |",
                posicao, this.getId(), this.getNome(), this.getSexo(),
                this.getProximo().getId(), this.getProximo().getNome());
            System.out.println();
        }
        System.out.println("+---------+----------+--------------------------------+------+----------+--------------------------------+");
    }

    // Objetivo: método de apoio da construção do NOH e que registra o
    //           preenchimento dos dados e da ligação de um elemento da lista
    //
    public Noh (Integer id, String nome, Integer sexo, Noh proximo)
    {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.proximo = proximo;
    }
    
    // Objetivo: método responsável pela construção de objetos desta classe
    //
    public Noh()
    {
        this.id = 0;
        this.nome = " ";
        this.sexo = 0;
        this.proximo = null;
    }
}
