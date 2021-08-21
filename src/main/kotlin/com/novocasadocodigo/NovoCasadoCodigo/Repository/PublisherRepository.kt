package com.novocasadocodigo.NovoCasadoCodigo.Repository

import com.novocasadocodigo.NovoCasadoCodigo.Model.Publisher
import org.springframework.data.jpa.repository.JpaRepository

interface PublisherRepository:JpaRepository<Publisher,Long> {
}