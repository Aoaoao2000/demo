package com.itcast.springJDBC;

public class Dept {
    private Integer id;
    private String dname;
    private String loc;

    /**
     * 想要映射过来，必须要无参构造
     */
    public Dept() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public Integer getId() {
        return id;
    }

    public String getDname() {
        return dname;
    }

    public String getLoc() {
        return loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
