package iplayerlite.bbc.co.uk.iplayerlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ShowListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showlist_view);
        Intent intent = getIntent();
        String categoryId = intent.getStringExtra(CategoryView.MESSAGE);
        ((TextView) findViewById(R.id.textViewID)).setText(categoryId);
    }
}
