package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "familia")
@NamedQueries({
    @NamedQuery(name="Familia.listarTodos", query ="SELECT f FROM Familia f ORDER BY f.nome"),
    @NamedQuery(name="Familia.buscarPorOrdem", query ="SELECT f FROM Familia f WHERE f.ordem.codigo = :codigo ORDER BY f.nome")
})
public class Familia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Column(length=50, name="nome")
    private String nome;
    
    @Column(name="descricao", columnDefinition = "TEXT")
    private String descricao;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "ordem", referencedColumnName = "codigo")
    private Ordem ordem;
    
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Ordem getOrdem() {
        return ordem;
    }

    public void setOrdem(Ordem ordem) {
        this.ordem = ordem;
    }
}
