package com.sxl.sbm.entity;


/**
 * @author SxL
 */
public class Example {

    private int id;
    private String name;
    private ServletName servletName;

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

    public ServletName getServletName() {
        return servletName;
    }

    public void setServletName(ServletName servletName) {
        this.servletName = servletName;
    }

    @Override
    public String toString() {
        return "Example{" +
                "id=" + id +
                '}';
    }
}
