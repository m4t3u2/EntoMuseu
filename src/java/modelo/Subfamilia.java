package modelo;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Subfamilia {
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
}
