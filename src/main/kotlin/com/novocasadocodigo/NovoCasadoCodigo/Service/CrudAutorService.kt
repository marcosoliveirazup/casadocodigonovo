package com.novocasadocodigo.NovoCasadoCodigo.Service

import com.novocasadocodigo.NovoCasadoCodigo.Model.Autor
import com.novocasadocodigo.NovoCasadoCodigo.Repository.AutorRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/autor")
class CrudAutorService(private val repository: AutorRepository) {

    @PostMapping
    fun create(@RequestBody autor: Autor): Autor = repository.save(autor)

    @GetMapping
    fun getAll(): List<Autor> = repository.findAll()

    @GetMapping("/findById/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Autor> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody autor: Autor): ResponseEntity<Autor> =
        repository.findById(id).map {
            val autorToUpdate = it.copy(
                nome = autor.nome
            )
            ResponseEntity.ok(repository.save(autorToUpdate))
        }.orElse(ResponseEntity.notFound().build())

}
