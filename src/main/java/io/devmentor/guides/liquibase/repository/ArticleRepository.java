package io.devmentor.guides.liquibase.repository;

import io.devmentor.guides.liquibase.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {}
