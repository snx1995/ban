package art.banyq.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import art.banyq.common.ReqResult;
import art.banyq.common.data.PageData;
import art.banyq.common.exception.ReqHandleException;

@Controller
@ResponseBody
@RequestMapping("/data")
public class TempController {
    
    @GetMapping("/getList")
    public ReqResult getList(Integer page, Integer size) {
        if (page == null || size == null) throw new ReqHandleException("page || size不能为空");
        if (page < 1) throw new ReqHandleException("page 必须大于1");
        List<TempData> result = new ArrayList<>(10);
        for (int i = 0;i < size;i ++) {
            result.add(new TempData("商品" + ((page - 1) * size + i)));
        }
        return ReqResult.succeeded(new PageData(size * 2, page, size, result));
    }
}

class TempData {
    private String name;
    private Integer price;
    private String detail;
    private String img;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public TempData(String name) {
        this.name = name;
        this.price = TempUtil.randomInteger(1000);
        this.detail = "这个是售价" + this.price + "的" + this.name;
        this.img = TempUtil.randomImgUrl();
    }
}

class TempUtil {
    private static final String[] imgUrls = {
        "http://res.banyq.art/0_compressed.JPG",
        "http://res.banyq.art/1_compressed.JPG",
        "http://res.banyq.art/2_compressed.JPG",
        "http://res.banyq.art/3_compressed.JPG",
        "http://res.banyq.art/4_compressed.JPG",
        "http://res.banyq.art/5_compressed.JPG",
        "http://res.banyq.art/6_compressed.JPG",
        "http://res.banyq.art/7_compressed.JPG",
        "http://res.banyq.art/8_compressed.JPG"
    };

    private static final Random random = new Random();

    static Integer randomInteger(Integer bound) {
        return random.nextInt(bound);
    }

    static String randomImgUrl() {
        return imgUrls[randomInteger(imgUrls.length)];
    }

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0;i < 40;i ++) {
            System.out.println(random.nextInt(10));
        }
    }
}