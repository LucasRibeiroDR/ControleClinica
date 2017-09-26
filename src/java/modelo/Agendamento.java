
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="agendamento")
public class Agendamento implements Serializable{

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Column(length=50, name="nome")
    private String nome;
    
    @Column(length=50, name="codigoPaciente")
    private Integer codigoPaciente;
    
    @Column(length=50, name="procedimento")
    private String procedimento;
    
    @Column(length=50, name="data")
    private String data;
    
    @Column(length=50, name="horario")
    private String horario;
    
    @ManyToOne 
    @JoinColumn (name = "agendamento", referencedColumnName = "codigo")
    private Agendamento agendamento; 
    
    public Agendamento(){
        this.codigo = 0;
        this.nome = "";
        this.data = "";
        this.codigoPaciente=0;
        this.horario="";
        this.nome="";
        this.procedimento="";
    }
     
    public Integer getAgendamento() {
        return getCodigo();
    }

    public void setAgendamento(Integer agendamento) {
        this.setCodigo(agendamento);
    }
    
/**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the codigoPaciente
     */
    public Integer getCodigoPaciente() {
        return codigoPaciente;
    }

    /**
     * @param codigoPaciente the codigoPaciente to set
     */
    public void setCodigoPaciente(Integer codigoPaciente) {
        this.codigoPaciente = codigoPaciente;
    }

    /**
     * @return the procedimento
     */
    public String getProcedimento() {
        return procedimento;
    }

    /**
     * @param procedimento the procedimento to set
     */
    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }

    /**
     * @return the horario
     */
    public String getHorario() {
        return horario;
    }

    /**
     * @param horario the horario to set
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * @return the agendamento
     */


    /**
     * @param agendamento the agendamento to set
     */



    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.getCodigo());
        hash = 29 * hash + Objects.hashCode(this.getNome());
        hash = 29 * hash + Objects.hashCode(this.getCodigoPaciente());
        hash = 29 * hash + Objects.hashCode(this.getHorario());
        hash = 29 * hash + Objects.hashCode(this.getProcedimento());
        hash = 29 * hash + Objects.hashCode(this.getData());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Agendamento other = (Agendamento) obj;
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.codigoPaciente, other.codigoPaciente)) {
            return false;
        }
        if (!Objects.equals(this.procedimento, other.procedimento)) {
            return false;
        }
        if (!Objects.equals(this.horario, other.horario)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
            return false;
        }

        return true;
    }
}
