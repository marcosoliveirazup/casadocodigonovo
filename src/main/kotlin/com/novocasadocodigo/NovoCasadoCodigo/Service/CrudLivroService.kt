package com.novocasadocodigo.NovoCasadoCodigo.Service

import com.novocasadocodigo.NovoCasadoCodigo.Model.Editora
import com.novocasadocodigo.NovoCasadoCodigo.Model.Livro
import com.novocasadocodigo.NovoCasadoCodigo.Repository.EditoraRepository
import com.novocasadocodigo.NovoCasadoCodigo.Repository.LivroRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/livro")
class CrudLivroService(
    private val livrorepository: LivroRepository,
) {

    @PostMapping
    fun create(@RequestBody livro: Livro): Livro = livrorepository.save(livro)

    @GetMapping
    fun getAll(): List<Livro> = livrorepository.findAll()

    @GetMapping("/findById/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Livro> = livrorepository.findById(id).map {
        ResponseEntity.ok(it)
    }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody livro: Livro): ResponseEntity<Livro> =
        livrorepository.findById(id).map {
            val livroToUpdate = it.copy(
                titulo = livro.titulo,
                isbn = livro.isbn,
                descricao = livro.descricao,
                dataDePublicacao = livro.dataDePublicacao,
            )
            ResponseEntity.ok(livrorepository.save(livroToUpdate))
        }.orElse(ResponseEntity.notFound().build())
}