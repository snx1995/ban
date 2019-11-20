package art.banyq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import art.banyq.common.entity.po.ArticlePO;
import art.banyq.persistent.dao.ArticleDAO;

@Controller
@RequestMapping("/article")
public class ArticleController {
    private ArticleDAO articleDAO;

    public ArticleController(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @GetMapping("/select")
    public ArticlePO select(Integer id) {
        return articleDAO.select(id);
    }
}