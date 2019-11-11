package top.ban.common.entity.vo.article;

import java.util.HashMap;

public class IndexPageArticleVO {
    private Style0ArticleVO art0;
    private Style1ArticleVO art1;
    private Style2ArticleVO art2;

    public static class Style0ArticleVO {
        private HashMap<String, Object> data = new HashMap<>();

        public Style0ArticleVO(String slogan, String title, String subTitle, String body) {
            data.put("slogan", slogan);
            data.put("title", title);
            data.put("subTitle", subTitle);
            data.put("body", body);
        }

        public int getStyle() {
            return 0;
        }

        public HashMap<String, Object> getData() {
            return data;
        }
    }

    public static class Style1ArticleVO {
        private HashMap<String, Object> data = new HashMap<>();

        public Style1ArticleVO(String[] imgs, String body) {
            data.put("imgs", imgs);
            data.put("body", body);
        }

        public int getStyle() {
            return 1;
        }

        public HashMap<String, Object> getData() {
            return data;
        }
    }

    public static class Style2ArticleVO {
        private HashMap<String, Object> data = new HashMap<>();

        public Style2ArticleVO(String[] title, String[] body, String[] img) {
            data.put("title", title);
            data.put("body", body);
            data.put("img", img);
        }

        public int getStyle() {
            return 2;
        }

        public HashMap<String, Object> getData() {
            return data;
        }
    }

    /**
     * @return Style0ArticleVO return the art0
     */
    public Style0ArticleVO getArt0() {
        return art0;
    }

    /**
     * @param art0 the art0 to set
     */
    public void setArt0(Style0ArticleVO art0) {
        this.art0 = art0;
    }

    /**
     * @return Style1ArticleVO return the art1
     */
    public Style1ArticleVO getArt1() {
        return art1;
    }

    /**
     * @param art1 the art1 to set
     */
    public void setArt1(Style1ArticleVO art1) {
        this.art1 = art1;
    }

    /**
     * @return Style2ArticleVO return the art2
     */
    public Style2ArticleVO getArt2() {
        return art2;
    }

    /**
     * @param art2 the art2 to set
     */
    public void setArt2(Style2ArticleVO art2) {
        this.art2 = art2;
    }
}
