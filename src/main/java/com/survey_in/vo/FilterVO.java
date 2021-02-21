package com.survey_in.vo;

import org.springframework.web.bind.annotation.RequestParam;

public class FilterVO {
    private String tar; // target
    private String cat; // category
    private String age;

    public FilterVO() {
        this.tar = "survey";
        this.cat = "all";
        this.age = "all";
    }

    public String getTar() {
        return tar;
    }

    public void setTar(String tar) {
        this.tar = tar;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
