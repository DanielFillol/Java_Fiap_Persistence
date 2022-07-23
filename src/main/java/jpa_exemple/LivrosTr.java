package jpa_exemple;

import javax.persistence.*;

@Entity
@Table(name = "Livros_TR", schema = "Banco_Teste")
public class LivrosTr {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "BookName")
    private String bookName;
    @Basic
    @Column(name = "ISBN")
    private String isbn;
    @Basic
    @Column(name = "Data_Disponibilizacao")
    private String dataDisponibilizacao;
    @Basic
    @Column(name = "Numero_Paginas")
    private String numeroPaginas;
    @Basic
    @Column(name = "Ano_Pub")
    private String anoPub;
    @Basic
    @Column(name = "Link")
    private String link;
    @Basic
    @Column(name = "Error")
    private String error;
    @Basic
    @Column(name = "Status")
    private String status;

    @JoinColumn(name = "livro_tipo")
    @ManyToOne
    private  TipoLiro livroTipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDataDisponibilizacao() {
        return dataDisponibilizacao;
    }

    public void setDataDisponibilizacao(String dataDisponibilizacao) {
        this.dataDisponibilizacao = dataDisponibilizacao;
    }

    public String getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(String numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getAnoPub() {
        return anoPub;
    }

    public void setAnoPub(String anoPub) {
        this.anoPub = anoPub;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LivrosTr livrosTr = (LivrosTr) o;

        if (id != livrosTr.id) return false;
        if (bookName != null ? !bookName.equals(livrosTr.bookName) : livrosTr.bookName != null) return false;
        if (isbn != null ? !isbn.equals(livrosTr.isbn) : livrosTr.isbn != null) return false;
        if (dataDisponibilizacao != null ? !dataDisponibilizacao.equals(livrosTr.dataDisponibilizacao) : livrosTr.dataDisponibilizacao != null)
            return false;
        if (numeroPaginas != null ? !numeroPaginas.equals(livrosTr.numeroPaginas) : livrosTr.numeroPaginas != null)
            return false;
        if (anoPub != null ? !anoPub.equals(livrosTr.anoPub) : livrosTr.anoPub != null) return false;
        if (link != null ? !link.equals(livrosTr.link) : livrosTr.link != null) return false;
        if (error != null ? !error.equals(livrosTr.error) : livrosTr.error != null) return false;
        if (status != null ? !status.equals(livrosTr.status) : livrosTr.status != null) return false;
        if (livroTipo != null ? !livroTipo.equals(livrosTr.livroTipo) : livrosTr.livroTipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (bookName != null ? bookName.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (dataDisponibilizacao != null ? dataDisponibilizacao.hashCode() : 0);
        result = 31 * result + (numeroPaginas != null ? numeroPaginas.hashCode() : 0);
        result = 31 * result + (anoPub != null ? anoPub.hashCode() : 0);
        result = 31 * result + (link != null ? link.hashCode() : 0);
        result = 31 * result + (error != null ? error.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (livroTipo != null ? livroTipo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return id + " - " + bookName + " - " + livroTipo.getTipoLivro();
    }
}
