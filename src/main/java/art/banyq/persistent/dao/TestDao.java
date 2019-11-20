package art.banyq.persistent.dao;

import org.springframework.stereotype.Repository;
import art.banyq.common.entity.vo.TestVO;

@Repository
public interface TestDao {
    TestVO selectById(Integer id);
}
