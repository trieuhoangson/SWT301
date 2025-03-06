/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;


/**
 *
 * @author Acer Nitro Tiger
 */
public class News {
    public int news_id,staff_id;
    public String content,title,status;
    public Date created_at,updated_at;

    public News(String content, String title) {
        this.content = content;
        this.title = title;
    }

   
    public News() {
    }

    public News(int news_id, int staff_id, String content, String title, String status, Date created_at, Date updated_at) {
        this.news_id = news_id;
        this.staff_id = staff_id;
        this.content = content;
        this.title = title;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getNews_id() {
        return news_id;
    }

    public void setNews_id(int news_id) {
        this.news_id = news_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
    
}
