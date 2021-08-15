package com.novocasadocodigo.NovoCasadoCodigo.Repository

import com.novocasadocodigo.NovoCasadoCodigo.Model.Autor
import org.springframework.data.jpa.repository.JpaRepository

interface AutorRepository: JpaRepository<Autor,Long> {
}