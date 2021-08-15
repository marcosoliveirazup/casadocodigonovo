package com.novocasadocodigo.NovoCasadoCodigo.Service

import com.novocasadocodigo.NovoCasadoCodigo.Model.Editora
import com.novocasadocodigo.NovoCasadoCodigo.Repository.EditoraRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/editora")
class CrudEditoraService(private val repository: EditoraRepository) {

    @PostMapping
    fun create(@RequestBody editora: Editora): Editora = repository.save(editora)

    @GetMapping
    fun getAll(): List<Editora> = repository.findAll()

    @GetMapping("/findById/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Editora> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody editora: Editora): ResponseEntity<Editora> =
        repository.findById(id).map {
            val autorToUpdate = it.copy(
                nome = editora.nome
            )
            ResponseEntity.ok(repository.save(autorToUpdate))
        }.orElse(ResponseEntity.notFound().build())


}
