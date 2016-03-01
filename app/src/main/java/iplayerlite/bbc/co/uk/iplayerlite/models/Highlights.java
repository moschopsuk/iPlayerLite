package iplayerlite.bbc.co.uk.iplayerlite.models;

public class Highlights {
    private String version;
    private String schema;
    private CategoryHighlights category_highlights;

    public CategoryHighlights getHighLights() {
        return category_highlights;
    }

    @Override
    public String toString() {
        return "Highlights{" +
                "version='" + version + '\'' +
                ", schema='" + schema + '\'' +
                ", category_highlights=" + category_highlights +
                '}';
    }
}
