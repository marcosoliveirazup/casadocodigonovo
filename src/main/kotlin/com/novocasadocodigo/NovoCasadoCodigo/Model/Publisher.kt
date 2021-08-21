package com.novocasadocodigo.NovoCasadoCodigo.Model

import javax.persistence.*

@Entity
@Table(name = "publisher")
data class Publisher(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
    @Column(name = "name")
    val name: String,

    @OneToMany(mappedBy = "publisher", cascade = arrayOf(CascadeType.ALL))
    val books: List<Book> = mutableListOf(),
) {

    override fun toString(): String {
        return "Publisher(id=$id, name=$name)"
    }

}