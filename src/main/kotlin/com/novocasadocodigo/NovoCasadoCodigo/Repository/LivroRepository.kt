package com.novocasadocodigo.NovoCasadoCodigo.Repository

import com.novocasadocodigo.NovoCasadoCodigo.Model.Livro
import org.springframework.data.jpa.repository.JpaRepository

interface LivroRepository:JpaRepository<Livro,Long> {

}