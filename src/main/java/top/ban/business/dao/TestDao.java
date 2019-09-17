package top.ban.business.dao;

import org.springframework.stereotype.Repository;
import top.ban.common.entity.vo.TestVO;

@Repository
public interface TestDao {
    TestVO selectById(Integer id);
}
