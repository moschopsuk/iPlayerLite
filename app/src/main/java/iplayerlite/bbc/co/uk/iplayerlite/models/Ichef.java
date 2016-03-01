package iplayerlite.bbc.co.uk.iplayerlite.models;

public class Ichef {
    private String type;
    private String standard;
    private String inherited_from;

    public String getStandard(String size) {
        return standard.replace("{recipe}", size);
    }
}
