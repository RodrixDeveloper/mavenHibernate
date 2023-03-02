package com.springsimplespasos.hibernate.entidades.manyToOne;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "telefonos")
public class Telefono implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    @Column(unique = true,nullable = false,length = 10)
    private String nombre;

    @ManyToOne(optional = false)
    @JoinColumn(name = "persona_id",foreignKey = @ForeignKey(name="FK_PERSONA_ID"))
    private Persona persona;

    public Telefono() {
    }

    public Telefono(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
