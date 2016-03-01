package iplayerlite.bbc.co.uk.iplayerlite.highlights;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

import iplayerlite.bbc.co.uk.iplayerlite.R;
import iplayerlite.bbc.co.uk.iplayerlite.categories.CategoryView;
import iplayerlite.bbc.co.uk.iplayerlite.models.Highlights;
import iplayerlite.bbc.co.uk.iplayerlite.models.IplayerItem;
import iplayerlite.bbc.co.uk.iplayerlite.watch.WatchView;

public class HighLightsView extends AppCompatActivity {

    public final static String MESSAGE = "uk.co.bbc.iplayerlite.WATCH.MESSAGE";
    private static final String IPLAYER_IBL_HIGHLIGHTS = "http://ibl.api.bbci.co.uk/ibl/v1/categories/%s/highlights?lang=en&rights=mobile&availability=available";
    final Gson gson = new Gson();
    String categoryId;
    ArrayList<IplayerItem> highlights;

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlist_view);
        Intent intent = getIntent();
        categoryId = intent.getStringExtra(CategoryView.MESSAGE);

        ((TextView)findViewById(R.id.category)).setText(categoryId);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        highlights = new ArrayList<>();
        adapter = new HighlightsAdapter(highlights);
        recyclerView.setAdapter(adapter);


        fetchData();
    }

    void fetchData(){
        StringRequest categoriesRequest = new StringRequest(Request.Method.GET, String.format(IPLAYER_IBL_HIGHLIGHTS, categoryId),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String rawResponse) {
                        Highlights response = gson.fromJson(rawResponse, Highlights.class);
                        highlights = response.getHighLights().getMedia();
                        ((HighlightsAdapter) adapter).updateHighlights(highlights);
                        adapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );

        Volley.newRequestQueue(this).add(categoriesRequest);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((HighlightsAdapter) adapter).setOnItemClickListener(
                new HighlightsAdapter.MyClickListener() {

                    @Override
                    public void onItemClick(int position, View v) {
                        Intent intent = new Intent(v.getContext(), WatchView.class);

                        IplayerItem item = highlights.get(position);

                        if(item.getVersions().size() == 0 ) {
                            Toast.makeText(v.getContext(), "Not Available to Watch", Toast.LENGTH_SHORT).show();
                        } else {

                            intent.putExtra("THUMBNAIL", item.getImages().getStandard("640x360"));
                            intent.putExtra("BRAND", item.getMasterBrand().getTitles().getLarge());
                            intent.putExtra("TITLE", item.getTitle());
                            intent.putExtra("SUBTITLE", item.getSubTitle());
                            intent.putExtra("SYNOPSES", item.getSynopses().getLarge());
                            intent.putExtra("DURATION", item.getVersions().get(0).getDuration().getText());
                            intent.putExtra("REMAINING", item.getVersions().get(0).getAvailability().getRemaining().getText());
                            intent.putExtra("FIRST_SHOWN", item.getVersions().get(0).getFirst_broadcast());

                            startActivity(intent);
                        }
                    }
                }
        );
    }
}
