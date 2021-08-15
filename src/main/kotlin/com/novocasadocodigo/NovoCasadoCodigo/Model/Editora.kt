package com.novocasadocodigo.NovoCasadoCodigo.Model

import javax.persistence.*

@Entity
@Table(name = "editora")
data class Editora(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,
    @Column(name = "nome")
    val nome: String
){
////    override fun toString(): String {
////        return "Editora(id=$id, name=$nome)"
//    }
}