package com.springsimplespasos.hibernate.entidades.onetoone;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="carnets")
public class Carnet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer codigo;
    @Column(length = 10, unique = true)
    private String numero;

    //relacion de tabla
    @OneToOne()
    @JoinColumn(name = "id_socio", foreignKey = @ForeignKey(name = "FK_ID_SOCIO"))
    private Socio socio;
    public Carnet() {
    }

    public Carnet(Integer codigo, String numero) {
        this.codigo = codigo;
        this.numero = numero;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Socio getSocio() {
        return socio;
    }

    public void setSocio(Socio socio) {
        this.socio = socio;
    }
}
