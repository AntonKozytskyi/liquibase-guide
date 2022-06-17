package io.devmentor.guides.liquibase.controller;

import io.devmentor.guides.liquibase.model.Article;
import io.devmentor.guides.liquibase.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ArticleController {

  private final ArticleService articleService;

  @GetMapping("/")
  public String index(
      @RequestParam(name = "page", required = false, defaultValue = "1") int page,
      @RequestParam(name = "size", required = false, defaultValue = "10") int size,
      Model model) {

    Page<Article> articlePage = articleService.getArticles(page - 1, size);
    model.addAttribute("articlePage", articlePage);
    model.addAttribute("currentPageNumber", page);

    return "index";
  }

  @GetMapping("/articles/{id}")
  public String singleArticle(@PathVariable("id") long id, Model model) {
    Article article = articleService.getArticle(id);
    model.addAttribute("article", article);

    return "article";
  }
}
