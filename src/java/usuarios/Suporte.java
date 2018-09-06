package usuarios;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Suporte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 500)
    private String erro;
    @ManyToOne(optional=false )       // MUITOS comprovantes para UM aluno
    @JoinColumn(name="Status")
    private Status status;
    @Column
    @Temporal(TemporalType.DATE)
    private Date solicitacao;
    @ManyToOne(optional=false )       // MUITOS comprovantes para UM aluno
    @JoinColumn(name="Usuario")
    private Usuario usuario;
    

    public Suporte(){
        id=0;
        erro = "";
        status = new Status();
        solicitacao = new Date();
        usuario = new Usuario();
    }
    
    public Suporte(String erro,Date solicitacao,Status status ,Usuario usuario){
        this.erro = erro;
        this.solicitacao = solicitacao;
        this.status = status;
        this.usuario = usuario; 
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Date solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        hash = 71 * hash + Objects.hashCode(this.erro);
        hash = 71 * hash + Objects.hashCode(this.status);
        hash = 71 * hash + Objects.hashCode(this.solicitacao);
        hash = 71 * hash + Objects.hashCode(this.usuario);
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
        final Suporte other = (Suporte) obj;
        if (!Objects.equals(this.erro, other.erro)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.solicitacao, other.solicitacao)) {
            return false;
        }
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return true;
    }

}