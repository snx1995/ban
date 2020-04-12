package art.banyq.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import art.banyq.common.ReqResult;
import art.banyq.common.entity.message.Msg;
import art.banyq.common.entity.param.MsgPageParam;
import art.banyq.common.entity.param.dao.MsgDaoParam;
import art.banyq.common.exception.ReqHandleException;
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

    @PostMapping("/publish")
    public ReqResult publish(@RequestBody Msg msg) {
        int result = msgDao.insertOne(msg);
        if (result < 1) throw new ReqHandleException("发布失败");
        return ReqResult.succeeded(msg);
    }

}