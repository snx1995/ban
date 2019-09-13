package top.ban.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.ban.common.annotation.Required;
import top.ban.common.exception.InvalidParamException;

import java.util.HashMap;

@RestController
@RequestMapping("/learn")
class FirstController {

    @GetMapping("/{name}")
    public HashMap<String, Object> test(@PathVariable @Required String name) {
        if ("error".equals(name)) throw new InvalidParamException(name);
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", name);
        result.put("age", 11);
        return result;
    }
}
