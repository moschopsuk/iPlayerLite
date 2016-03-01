package iplayerlite.bbc.co.uk.iplayerlite.models;

import java.util.ArrayList;

public class IplayerItem {
    private String id;
    private Boolean live;
    private String type;
    private String title;
    private Ichef images;
    private Boolean signed;
    private String status;

    public Brand getMasterBrand() {
        return master_brand;
    }

    private String tleo_id;
    private Boolean guidance;
    private String subtitle;
    private Synopses synopses;

    public ArrayList<MediaVersion> getVersions() {
        return versions;
    }

    private ArrayList<MediaVersion> versions = new ArrayList<MediaVersion>();


    private String parent_id;
    private Brand master_brand;

    private Boolean audio_described;
    private Boolean release_date_time;
    private Boolean promoted;

    public String getTitle() {
        return title;
    }

    public String getSubTitle() {
        return subtitle;
    }

    public Synopses getSynopses() {
        return synopses;
    }

    public Ichef getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "IplayerItem{" +
                "id='" + id + '\'' +
                ", live=" + live +
                ", type='" + type + '\'' +
                ", title='" + title + '\'' +
                ", images=" + images +
                ", signed=" + signed +
                ", status='" + status + '\'' +
                ", tleo_id='" + tleo_id + '\'' +
                ", guidance=" + guidance +
                ", subtitle='" + subtitle + '\'' +
                ", synopses=" + synopses +
                ", parent_id='" + parent_id + '\'' +
                ", master_brand=" + master_brand +
                ", audio_described=" + audio_described +
                ", release_date_time=" + release_date_time +
                ", promoted=" + promoted +
                '}';
    }
}
