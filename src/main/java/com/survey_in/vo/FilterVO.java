package com.survey_in.vo;

import org.apache.tiles.autotag.core.runtime.annotation.Parameter;

public class FilterVO {

    private String tar;     // target
    private String cat;     // category
    private String ord;        // order
    private String age;     // ageLimit
    private String gen;     // gender

    public FilterVO() {
        this.tar = "survey";
        this.cat = "all";
        this.ord = "latest";
        this.age = "all";
        this.gen = "all";
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

    public String getOrd() {
        return ord;
    }

    public void setOrd(String ord) {
        this.ord = ord;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }
}
