package com.novocasadocodigo.NovoCasadoCodigo.Repository

import com.novocasadocodigo.NovoCasadoCodigo.Model.Book
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository:JpaRepository<Book,Long> {

}