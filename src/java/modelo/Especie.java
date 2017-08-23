package modelo;

import java.io.Serializable;
import java.util.Objects;
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
@Table(name = "especie")
@NamedQueries({
    @NamedQuery(name="Especie.listarTodos", query ="SELECT e FROM Especie e ORDER BY e.nome"),
    @NamedQuery(name="Especie.buscarPorGenero", query ="SELECT e FROM Especie e WHERE e.genero.codigo = :codigo ORDER BY e.nome"),
    @NamedQuery(name="Especie.listarPorNome", query ="SELECT e FROM Especie e WHERE e.nome = :nome")
})
public class Especie implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Column(length=50, name="nome")
    private String nome;
    
    @Column(name="descricao", columnDefinition = "TEXT")
    private String descricao;
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "genero", referencedColumnName = "codigo")
    private Genero genero; 

    public Integer getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Genero getGenero() {
        return genero;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.getCodigo());
        hash = 53 * hash + Objects.hashCode(this.getNome());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Especie other = (Especie) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        return true;
    }
    
    
}
