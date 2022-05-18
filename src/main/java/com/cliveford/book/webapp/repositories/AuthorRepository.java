package com.cliveford.book.webapp.repositories;

import com.cliveford.book.webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
