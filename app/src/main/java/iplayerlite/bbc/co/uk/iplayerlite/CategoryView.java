package iplayerlite.bbc.co.uk.iplayerlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.ArrayList;

import iplayerlite.bbc.co.uk.iplayerlite.models.Categories;
import iplayerlite.bbc.co.uk.iplayerlite.models.CategoryItem;

public class CategoryView extends AppCompatActivity {

    private static final String IPAYER_IBL_CATEGORIES = "http://ibl.api.bbci.co.uk/ibl/v1/Categories?rights=mobile";
    private ArrayList<CategoryItem> catagories;
    final Gson gson = new Gson();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_view);

        catagories = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CategoryAdapter(catagories);
        recyclerView.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        fetchData();
    }

    void fetchData(){
        StringRequest categoriesRequest = new StringRequest(Request.Method.GET, IPAYER_IBL_CATEGORIES,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String rawResponse) {
                    Categories response = gson.fromJson(rawResponse, Categories.class);
                    catagories = response.getCategoriesList();
                    ((CategoryAdapter) adapter).updateCategories(catagories);
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
        ((CategoryAdapter) adapter).setOnItemClickListener(
                new CategoryAdapter.MyClickListener() {

                    @Override
                    public void onItemClick(int position, View v) {
                        Log.i("CATEGORY", catagories.get(position).getId());
                    }
                }
        );
    }
}
