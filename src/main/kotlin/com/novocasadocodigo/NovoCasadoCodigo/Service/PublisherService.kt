package com.novocasadocodigo.NovoCasadoCodigo.Service

import com.novocasadocodigo.NovoCasadoCodigo.Model.Publisher
import com.novocasadocodigo.NovoCasadoCodigo.Repository.PublisherRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/publisher")
class PublisherService(private val publisherrepository: PublisherRepository) {

    @PostMapping
    fun create(@RequestBody publisher: Publisher): Publisher = publisherrepository.save(publisher)

    @GetMapping
    fun getAll(): List<Publisher> = publisherrepository.findAll()

    @GetMapping("/findById/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Publisher> =
        publisherrepository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody publisher: Publisher): ResponseEntity<Publisher> =
        publisherrepository.findById(id).map {
            val publisherToUpdate = it.copy(
                name = publisher.name
            )
            ResponseEntity.ok(publisherrepository.save(publisherToUpdate))
        }.orElse(ResponseEntity.notFound().build())


}
