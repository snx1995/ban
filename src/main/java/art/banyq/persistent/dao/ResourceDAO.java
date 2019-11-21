package art.banyq.persistent.dao;

import art.banyq.common.entity.po.ResourcePO;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDAO {
    ResourcePO select(Integer id);

    Integer insert(ResourcePO resourcePO);
}
