package com.novocasadocodigo.NovoCasadoCodigo.Repository

import com.novocasadocodigo.NovoCasadoCodigo.Model.Author
import org.springframework.data.jpa.repository.JpaRepository

interface AuthorRepository: JpaRepository<Author,Long> {
}