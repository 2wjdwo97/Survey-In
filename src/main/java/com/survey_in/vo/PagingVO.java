package com.survey_in.vo;

public class PagingVO {
    private int total;          // 전체 설문 개수
    private int btnPerPage = 5; // 페이지 당 표시되는 버튼의 개수

    private int startPage;      // 현재 화면에 표시되는 페이지 시작 번호
    private int endPage;        // 현재 화면에 표시되는 페이지 끝 번호

    private boolean prev;       // 이전 버튼 활성화 여부
    private boolean next;       // 다음 버튼 활성화 여부

    private PageVO page;


    public PagingVO(PageVO page, int total) {
        this.total = total;
        this.page = page;

        endPage = (int) (Math.ceil(page.getPage() / (double) btnPerPage) * btnPerPage);
        startPage = (endPage - btnPerPage) + 1;

        int tempEndPage = (int) (Math.ceil(total / (double) page.getSurveyPerPage()));
        if (endPage > tempEndPage)
            endPage = tempEndPage;

        prev = (startPage == 1) ? false : true;
        next = (endPage * page.getSurveyPerPage() >= total) ? false : true;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBtnPerPage() {
        return btnPerPage;
    }

    public void setBtnPerPage(int btnPerPage) {
        this.btnPerPage = btnPerPage;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isPrev() {
        return prev;
    }

    public void setPrev(boolean prev) {
        this.prev = prev;
    }

    public boolean isNext() {
        return next;
    }

    public void setNext(boolean next) {
        this.next = next;
    }

    public PageVO getPage() {
        return page;
    }

    public void setPage(PageVO page) {
        this.page = page;
    }

    @Override
    public String toString() {
        return "PagingVO{" +
                "total=" + total +
                ", btnPerPage=" + btnPerPage +
                ", startPage=" + startPage +
                ", endPage=" + endPage +
                ", prev=" + prev +
                ", next=" + next +
                ", page=" + page +
                '}';
    }
}
