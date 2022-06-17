package io.devmentor.guides.liquibase.service.impl;

import io.devmentor.guides.liquibase.exception.PageNotFoundException;
import io.devmentor.guides.liquibase.model.Article;
import io.devmentor.guides.liquibase.repository.ArticleRepository;
import io.devmentor.guides.liquibase.service.ArticleService;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

  private final ArticleRepository articleRepository;

  @Override
  public Page<Article> getArticles(int page, int size) {
    Pageable pageRequest = PageRequest.of(page, size);
    return articleRepository.findAll(pageRequest);
  }

  @Override
  public Article getArticle(long id) {
    return articleRepository.findById(id).orElseThrow(PageNotFoundException::new);
  }
}
