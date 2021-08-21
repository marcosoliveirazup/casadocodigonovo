package com.novocasadocodigo.NovoCasadoCodigo.Model

import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "book")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,
    @Column(name = "title")
    var title: String,
    @Column(name = "isbn")
    var isbn: String,
    @Column(name = "description")
    var description: String,
    @Column(name = "publicationDate")
    var publicationDate: String,


    @ManyToOne
    @JoinColumn(name = "publisher_id")
    val publisher: Publisher,
//    val quantity: Int = 0,
//    val value: BigDecimal = BigDecimal(0),

//    @ManyToOne
//    val books: Book
) {


//    @ManyToMany(fetch = Fe    tchType.EAGER)
//    @JoinTable(name = "livro_autor",
//        joinColumns = [JoinColumn(name = "fk_autor")],
//        inverseJoinColumns = [JoinColumn(name = "fk_livro")]
//    )
//    var autor: MutableList<Autor> = mutableListOf()
}