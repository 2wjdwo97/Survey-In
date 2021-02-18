package com.survey_in.vo;

public class PageVO {

    private int page;            // 현재 페이지 번호
    private int surveyPerPage;      // 페이지 당 표시되는 설문 개수

    public PageVO() {
        this.page = 1;
        this.surveyPerPage = 5;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSurveyPerPage() {
        return surveyPerPage;
    }

    public void setSurveyPerPage(int surveyPerPage) {
        this.surveyPerPage = surveyPerPage;
    }

    public int getPageStart() {
        return (this.page - 1) * surveyPerPage;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "page=" + page +
                ", surveyPerPage=" + surveyPerPage +
                '}';
    }
}
