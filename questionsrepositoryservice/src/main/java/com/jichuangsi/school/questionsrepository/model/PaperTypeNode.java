package com.jichuangsi.school.questionsrepository.model;

import java.io.Serializable;

public class PaperTypeNode implements Serializable{

    private String id;
    private String paper;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaper() {
        return paper;
    }

    public void setPaper(String paper) {
        this.paper = paper;
    }
}
