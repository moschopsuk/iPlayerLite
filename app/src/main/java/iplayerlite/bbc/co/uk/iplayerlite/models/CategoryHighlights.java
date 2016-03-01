package iplayerlite.bbc.co.uk.iplayerlite.models;


import java.util.ArrayList;

public class CategoryHighlights {
    private Category category;
    private ArrayList<IplayerItem> elements = new ArrayList<IplayerItem>();

    public ArrayList<IplayerItem> getMedia() {
        return elements;
    }

    @Override
    public String toString() {
        return "CategoryHighlights{" +
                "category=" + category +
                ", elements=" + elements +
                '}';
    }
}
