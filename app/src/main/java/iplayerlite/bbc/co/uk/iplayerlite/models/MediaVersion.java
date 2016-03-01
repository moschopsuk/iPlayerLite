package iplayerlite.bbc.co.uk.iplayerlite.models;

public class MediaVersion {
    private Boolean hd;
    private String id;
    private MediaDuration duration;
    private MediaAvailability availability;
    private String first_broadcast;

    public MediaDuration getDuration() {
        return duration;
    }

    public MediaAvailability getAvailability() {
        return availability;
    }

    public String getFirst_broadcast() {
        return first_broadcast;
    }
}
