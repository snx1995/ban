package top.ban.business.dao;

import org.apache.ibatis.annotations.Mapper;
import top.ban.common.entity.vo.TestVO;

@Mapper
public interface TestDao {
    TestVO selectById();
}
