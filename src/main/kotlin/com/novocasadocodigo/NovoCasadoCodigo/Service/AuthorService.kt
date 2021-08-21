package com.novocasadocodigo.NovoCasadoCodigo.Service

import com.novocasadocodigo.NovoCasadoCodigo.Model.Author
import com.novocasadocodigo.NovoCasadoCodigo.Repository.AuthorRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/author")
class AuthorService(private val authorrepository: AuthorRepository) {

    @PostMapping
    fun create(@RequestBody author: Author): Author = authorrepository.save(author)

    @GetMapping
    fun getAll(): List<Author> = authorrepository.findAll()

    @GetMapping("/findById/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Author> =
        authorrepository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody author: Author): ResponseEntity<Author> =
        authorrepository.findById(id).map {
            val authorToUpdate = it.copy(
                name = author.name
            )
            ResponseEntity.ok(authorrepository.save(authorToUpdate))
        }.orElse(ResponseEntity.notFound().build())

}
