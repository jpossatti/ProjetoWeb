
package br.com.projetowebfinal.model;

/**
 *
 * @author jpossatti
 */
public class SubCategoria {
    private int id_sub_categoria;
    private String nome_sub_categoria;
    private int id_categoria;
    private int sequencia_subcategoria;

    public SubCategoria (){
    }

    public SubCategoria(int id_sub_categoria, String nome_sub_categoria, int id_categoria, int sequencia_subcategoria) {
        this.id_sub_categoria = id_sub_categoria;
        this.nome_sub_categoria = nome_sub_categoria;
        this.id_categoria = id_categoria;
        this.sequencia_subcategoria = sequencia_subcategoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_sub_categoria() {
        return id_sub_categoria;
    }

    public void setId_sub_categoria(int id_sub_categoria) {
        this.id_sub_categoria = id_sub_categoria;
    }

    public String getNome_sub_categoria() {
        return nome_sub_categoria;
    }

    public void setNome_sub_categoria(String nome_sub_categoria) {
        this.nome_sub_categoria = nome_sub_categoria;
    }

    public int getSequencia_subcategoria() {
        return sequencia_subcategoria;
    }

    public void setSequencia_subcategoria(int sequencia_subcategoria) {
        this.sequencia_subcategoria = sequencia_subcategoria;
    }
    
}
