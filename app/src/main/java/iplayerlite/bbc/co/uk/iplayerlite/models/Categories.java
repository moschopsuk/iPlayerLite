package iplayerlite.bbc.co.uk.iplayerlite.models;

import java.util.ArrayList;

public class Categories {
    private String version;
    private String schema;
    private ArrayList<CategoryItem> categories = new ArrayList<CategoryItem>();

    public ArrayList<CategoryItem> getCategoriesList() {
        return categories;
    }

    @Override
    public String toString() {
        return "Version:" + version + ", Catagories:" + categories.size();
    }
}
