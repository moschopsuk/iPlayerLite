package iplayerlite.bbc.co.uk.iplayerlite.highlights;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import iplayerlite.bbc.co.uk.iplayerlite.R;
import iplayerlite.bbc.co.uk.iplayerlite.models.IplayerItem;
import iplayerlite.bbc.co.uk.iplayerlite.utils.ImageCacheManager;

public class HighlightsAdapter extends RecyclerView.Adapter<HighlightsAdapter.HighlightsViewHolder> {
    private ArrayList<IplayerItem> highlightsList;
    private static MyClickListener myClickListener;
    private ImageLoader imageLoader;

    public static class HighlightsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView title;
        TextView subtitle;
        TextView synopses;
        NetworkImageView thumbnail;

        public HighlightsViewHolder(View v) {
            super(v);
            title = (TextView) itemView.findViewById(R.id.title);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
            synopses = (TextView) itemView.findViewById(R.id.synopses);
            thumbnail = (NetworkImageView) itemView.findViewById(R.id.thumbnail);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            myClickListener.onItemClick(getPosition(), v);
        }
    }

    public HighlightsAdapter(ArrayList<IplayerItem> highlights) {
        imageLoader = ImageCacheManager.INSTANCE.getImageLoader();
        this.highlightsList = highlights;
    }

    public void updateHighlights(ArrayList<IplayerItem> highlights) {
        this.highlightsList = highlights;
    }

    public void setOnItemClickListener(MyClickListener myClickListener) {
        this.myClickListener = myClickListener;
    }

    @Override
    public HighlightsAdapter.HighlightsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.showlist_card, parent, false);

        HighlightsViewHolder categoryViewHolder = new HighlightsViewHolder(v);

        return categoryViewHolder;
    }

    @Override
    public void onBindViewHolder(HighlightsViewHolder holder, int position) {
        holder.title.setText(highlightsList.get(position).getTitle());
        holder.subtitle.setText(highlightsList.get(position).getSubTitle());
        holder.synopses.setText(highlightsList.get(position).getSynopses().getMedium());

        String imageUrl = highlightsList.get(position).getImages().getStandard("640x360");
        holder.thumbnail.setImageUrl(imageUrl, imageLoader);
    }

    @Override
    public int getItemCount() {
        return highlightsList.size();
    }

    public interface MyClickListener {
        public void onItemClick(int position, View v);
    }
}
