package io.devmentor.guides.liquibase.service;

import io.devmentor.guides.liquibase.model.Article;
import org.springframework.data.domain.Page;

public interface ArticleService {

  Page<Article> getArticles(int page, int size);
  Article getArticle(long id);
}
