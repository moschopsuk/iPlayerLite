package iplayerlite.bbc.co.uk.iplayerlite.watch;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import iplayerlite.bbc.co.uk.iplayerlite.R;
import iplayerlite.bbc.co.uk.iplayerlite.categories.CategoryView;
import iplayerlite.bbc.co.uk.iplayerlite.utils.ImageCacheManager;

public class WatchView extends AppCompatActivity {
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_watch);
        imageLoader = ImageCacheManager.INSTANCE.getImageLoader();

        Intent intent = getIntent();

        ((NetworkImageView)findViewById(R.id.thumbnail)).setImageUrl(intent.getStringExtra("THUMBNAIL"), imageLoader);
        ((TextView)findViewById(R.id.brand)).setText(intent.getStringExtra("BRAND"));
        ((TextView)findViewById(R.id.title)).setText(intent.getStringExtra("TITLE"));
        ((TextView)findViewById(R.id.subtitle)).setText(intent.getStringExtra("SUBTITLE"));
        ((TextView)findViewById(R.id.synopses)).setText(intent.getStringExtra("SYNOPSES"));
        ((TextView)findViewById(R.id.duration)).setText(intent.getStringExtra("DURATION"));
        ((TextView)findViewById(R.id.remain)).setText(intent.getStringExtra("REMAINING"));
        ((TextView)findViewById(R.id.firstShown)).setText(intent.getStringExtra("FIRST_SHOWN"));
    }

}
