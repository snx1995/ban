package top.ban.service.dao;

import org.springframework.stereotype.Repository;
import top.ban.common.entity.vo.user.LoginParam;
import top.ban.common.entity.vo.user.RegisterParam;
import top.ban.common.entity.vo.user.UserVO;

@Repository
public interface UserMapper {
    UserVO selectIdPassword(LoginParam param);

    int insertUser(RegisterParam param);
}
