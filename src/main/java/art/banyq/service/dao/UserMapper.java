package art.banyq.service.dao;

import org.springframework.stereotype.Repository;
import art.banyq.common.entity.vo.user.LoginParam;
import art.banyq.common.entity.vo.user.RegisterParam;
import art.banyq.common.entity.vo.user.UserVO;

@Repository
public interface UserMapper {
    UserVO selectIdPassword(LoginParam param);

    int insertUser(RegisterParam param);
}
