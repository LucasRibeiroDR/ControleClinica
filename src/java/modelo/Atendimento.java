
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
@Table(name="atendimento")
public class Atendimento implements Serializable{



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
    
    @Column(length=50, name="causaTratamento")
    private String causaTratamento;
    
    @Column(length=50, name="anotacoes")
    private String anotacoes;
    
    @Column(length=50, name="dataRetorno")
    private String dataRetorno;
   
    @ManyToOne 
    @JoinColumn (name = "atendimento", referencedColumnName = "codigo")
    private Atendimento atendimento; 
    
    public Atendimento(){
        this.codigo = 0;
        this.nome = "";
        this.data = "";
        this.codigoPaciente=0;
        this.horario="";
        this.nome="";
        this.procedimento="";
        this.anotacoes="";
        this.causaTratamento="";
        this.dataRetorno="";
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
     * @return the causaTratamento
     */
    public String getCausaTratamento() {
        return causaTratamento;
    }

    /**
     * @param causaTratamento the causaTratamento to set
     */
    public void setCausaTratamento(String causaTratamento) {
        this.causaTratamento = causaTratamento;
    }

    /**
     * @return the anotacoes
     */
    public String getAnotacoes() {
        return anotacoes;
    }

    /**
     * @param anotacoes the anotacoes to set
     */
    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    /**
     * @return the dataRetorno
     */
    public String getDataRetorno() {
        return dataRetorno;
    }

    /**
     * @param dataRetorno the dataRetorno to set
     */
    public void setDataRetorno(String dataRetorno) {
        this.dataRetorno = dataRetorno;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.getCodigo());
        hash = 29 * hash + Objects.hashCode(this.getNome());
        hash = 29 * hash + Objects.hashCode(this.getCodigoPaciente());
        hash = 29 * hash + Objects.hashCode(this.getHorario());
        hash = 29 * hash + Objects.hashCode(this.getProcedimento());
        hash = 29 * hash + Objects.hashCode(this.getData());
        hash = 29 * hash + Objects.hashCode(this.getAnotacoes());
        hash = 29 * hash + Objects.hashCode(this.getCausaTratamento());
        hash = 29 * hash + Objects.hashCode(this.getDataRetorno());
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
        final Atendimento other = (Atendimento) obj;
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
        if (!Objects.equals(this.dataRetorno, other.dataRetorno)) {
            return false;
        }
        if (!Objects.equals(this.anotacoes, other.anotacoes)) {
            return false;
        }
        if (!Objects.equals(this.causaTratamento, other.causaTratamento)) {
            return false;
        }
        return true;
    }
}