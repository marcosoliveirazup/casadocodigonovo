package com.novocasadocodigo.NovoCasadoCodigo.Model

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "livro")
data class Livro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,
    @Column(name = "titulo")
    var titulo: String,
    @Column(name = "isbn")
    var isbn: String,
    @Column(name = "descricao")
    var descricao: String,
    @Column(name = "dataDePublicacao")
    var dataDePublicacao: String
){
//    @ManyToOne
//    @JoinColumn(name = "editora_id", nullable = false, insertable = false, updatable = false)
//    var editora: Editora? = null


//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "livro_autor",
//        joinColumns = [JoinColumn(name = "fk_autor")],
//        inverseJoinColumns = [JoinColumn(name = "fk_livro")]
//    )
//    var autor: MutableList<Autor> = mutableListOf()
}