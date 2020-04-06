package art.banyq.persistent.dao;

import org.springframework.stereotype.Repository;
import art.banyq.common.entity.vo.user.LoginParam;
import art.banyq.common.entity.vo.user.RegisterParam;
import art.banyq.common.entity.vo.user.UserVO;

@Repository
public interface UserDAO {
    UserVO loginSelect(LoginParam param);

    int insertUser(RegisterParam param);

    int updateToken(String token);
}
