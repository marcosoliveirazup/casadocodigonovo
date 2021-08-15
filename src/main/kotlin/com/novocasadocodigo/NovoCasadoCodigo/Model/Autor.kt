package com.novocasadocodigo.NovoCasadoCodigo.Model

import org.hibernate.annotations.Fetch
import javax.persistence.*

@Entity
@Table(name = "autor")
data class Autor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long,
    @Column(name = "nome")
    val nome: String
) {
////    @ManyToMany(mappedBy = "autor", fetch = FetchType.EAGER, cascade = [CascadeType.ALL])
////    var livro: MutableList<Livro> = mutableListOf()
////
////    override fun toString(): String {
////        return ("Autor(id=$id, nome=$nome, livro=$livro")
//    }
}