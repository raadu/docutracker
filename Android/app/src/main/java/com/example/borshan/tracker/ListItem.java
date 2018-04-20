package com.example.borshan.tracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ListItem {

    private String pdf_name;
    private String pdf_link;
    private String teacher_id;
    private String course_name;

    public ListItem(String pdf_name, String pdf_link, String teacher_id, String course_name) {
        this.pdf_name = pdf_name;
        this.pdf_link = pdf_link;
        this.teacher_id = teacher_id;
        this.course_name = course_name;
    }

    public String getPdf_name() {
        return pdf_name;
    }

    public String getPdf_link() {
        return pdf_link;
    }

    public String getTeacher_id() {
        return teacher_id;
    }

    public String getCourse_name() {
        return course_name;
    }
}
