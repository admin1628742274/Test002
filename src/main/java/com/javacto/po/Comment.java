package com.javacto.po;


import java.sql.Date;

public class Comment {   //用户留言
    private  int id;
        private String name;
        private String content;
        private Date time;
        private String answer;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", answer='" + answer + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Comment() {
    }

    public Comment(int id, String name, String content, Date time, String answer) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.time = time;
        this.answer = answer;
    }
}
