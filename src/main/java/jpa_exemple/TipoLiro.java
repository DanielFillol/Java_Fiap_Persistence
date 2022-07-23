package jpa_exemple;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Tipo_Liro", schema = "Banco_Teste")
public class TipoLiro {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "tipo_livro")
    private String tipoLivro;

    @OneToMany(mappedBy = "livroTipo")
    private Collection<LivrosTr> Livros;

    public Collection<LivrosTr> getLivros(){
        return Livros;
    }

    public void setLivros(Collection<LivrosTr> livros){
        this.Livros = livros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoLivro() {
        return tipoLivro;
    }

    public void setTipoLivro(String tipoLivro) {
        this.tipoLivro = tipoLivro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoLiro tipoLiro = (TipoLiro) o;

        if (id != tipoLiro.id) return false;
        if (tipoLivro != null ? !tipoLivro.equals(tipoLiro.tipoLivro) : tipoLiro.tipoLivro != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (tipoLivro != null ? tipoLivro.hashCode() : 0);
        return result;
    }
}
