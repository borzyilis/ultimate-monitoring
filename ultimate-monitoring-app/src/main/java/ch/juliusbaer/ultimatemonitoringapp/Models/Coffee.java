package ch.juliusbaer.ultimatemonitoringapp.Models;

public class Coffee {

    private int id;
    private String uid;
    private String blend_name;
    private String origin;
    private String variety;
    private String notes;
    private String intensifier;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getBlend_name() {
        return blend_name;
    }

    public void setBlend_name(String blend_name) {
        this.blend_name = blend_name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getIntensifier() {
        return intensifier;
    }

    public void setIntensifier(String intensifier) {
        this.intensifier = intensifier;
    }
}
