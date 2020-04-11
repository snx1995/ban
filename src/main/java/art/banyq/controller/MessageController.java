package art.banyq.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import art.banyq.common.ReqResult;
import art.banyq.common.entity.message.Msg;
import art.banyq.common.entity.param.MsgPageParam;
import art.banyq.common.entity.param.dao.MsgDaoParam;
import art.banyq.persistent.dao.MsgDao;

@Controller
@ResponseBody
@RequestMapping("/message")
public class MessageController {
    private MsgDao msgDao;

    public MessageController(MsgDao msgDao) {
        this.msgDao = msgDao;
    }

    @GetMapping("/getList")
    public ReqResult getList(MsgPageParam param) {
        List<Msg> result = msgDao.selectList(new MsgDaoParam(param));
        return ReqResult.succeeded(result);
    }

}