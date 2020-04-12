package art.banyq.persistent.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import art.banyq.common.entity.message.Msg;
import art.banyq.common.entity.param.dao.MsgDaoParam;

@Repository
public interface MsgDao {
    Integer insertOne(Msg msg);

    List<Msg> selectList(MsgDaoParam param);
}