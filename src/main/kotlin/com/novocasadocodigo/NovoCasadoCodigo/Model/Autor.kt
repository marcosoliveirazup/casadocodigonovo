package com.novocasadocodigo.NovoCasadoCodigo.Model

import javax.persistence.*

@Entity
@Table(name = "autor")
data class Autor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    var id: Long,
    @Column(name="nome")
    val nome: String
)