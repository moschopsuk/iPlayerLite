package iplayerlite.bbc.co.uk.iplayerlite;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import iplayerlite.bbc.co.uk.iplayerlite.models.CategoryItem;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private ArrayList<CategoryItem> categoriesList;
    private static MyClickListener myClickListener;

    public static class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView label;
        TextView id;

        public CategoryViewHolder(View v) {
            super(v);
            label = (TextView) itemView.findViewById(R.id.textView);
            id = (TextView) itemView.findViewById(R.id.textView2);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public CategoryAdapter(ArrayList<CategoryItem> categories) {
        categoriesList = categories;
    }

    public void updateCategories(ArrayList<CategoryItem> categories) {
        categoriesList = categories;
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_list_item, parent, false);

        CategoryViewHolder categoryViewHolder = new CategoryViewHolder(v);

        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.label.setText(categoriesList.get(position).getTitle());
        holder.id.setText(categoriesList.get(position).getId());
    }

    @Override
    public int getItemCount() {
        return categoriesList.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
