package com.novocasadocodigo.NovoCasadoCodigo.Model

import javax.persistence.*

@Entity
@Table(name = "editora")
data class Editora(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Long,
    @Column(name = "nome")
    val nome: String,
)