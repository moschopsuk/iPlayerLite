package iplayerlite.bbc.co.uk.iplayerlite.models;

public class CategoryItem {
    private String id;
    private String title;
    private String type;
    private String kind;

    public CategoryItem(String id, String title, String type, String kind) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.kind = kind;
    }

    public String getTitle() {
        return this.title;
    }

    public String getId() {
        return this.id;
    }
}
