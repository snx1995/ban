package art.banyq.persistent.dao;

import art.banyq.common.entity.po.ArticlePO;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleDAO {
    ArticlePO select(Integer id);
}