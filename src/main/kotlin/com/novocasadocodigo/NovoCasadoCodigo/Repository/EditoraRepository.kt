package com.novocasadocodigo.NovoCasadoCodigo.Repository

import com.novocasadocodigo.NovoCasadoCodigo.Model.Editora
import org.springframework.data.jpa.repository.JpaRepository

interface EditoraRepository:JpaRepository<Editora,Long> {
}