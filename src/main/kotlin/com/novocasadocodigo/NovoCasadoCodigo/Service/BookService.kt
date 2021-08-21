package com.novocasadocodigo.NovoCasadoCodigo.Service

import com.novocasadocodigo.NovoCasadoCodigo.Model.Book
import com.novocasadocodigo.NovoCasadoCodigo.Model.Publisher
import com.novocasadocodigo.NovoCasadoCodigo.Repository.BookRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/book")
class BookService(
    private val bookrepository: BookRepository,
) {

    @PostMapping
    fun create(@RequestBody book: Book): Book = bookrepository.save(book)

    @GetMapping
    fun getAll(): List<Book> = bookrepository.findAll()

    @GetMapping("/findById/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Book> = bookrepository.findById(id).map {
        ResponseEntity.ok(it)
    }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/update/{id}")
    fun update(@PathVariable id: Long, @RequestBody book: Book): ResponseEntity<Book> =
        bookrepository.findById(id).map {
            val bookToUpdate = it.copy(
                title = book.title,
                isbn = book.isbn,
                description = book.description,
                publicationDate = book.publicationDate,
            )
            ResponseEntity.ok(bookrepository.save(bookToUpdate))
        }.orElse(ResponseEntity.notFound().build())
}