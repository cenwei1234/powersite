package com.jialong.powersite.modular.system.model.request;

public class QuestionFeedbackAddReq {

    private  Integer level;

    private  Integer siteId;

    private  String description;

    private  String image;

    private  Integer reportor;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getReportor() {
        return reportor;
    }

    public void setReportor(Integer reportor) {
        this.reportor = reportor;
    }
}
