package iplayerlite.bbc.co.uk.iplayerlite.utils;

import android.graphics.Bitmap;
import android.os.Build;
import android.support.v4.util.LruCache;
import android.util.Log;

import com.android.volley.toolbox.ImageLoader;

public class BitmapMemoryCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {

    private static final String TAG = "BitmapMemoryCache";

    public BitmapMemoryCache(int maxSize) {
        super(maxSize);
        Log.i(TAG, "Size: " + maxSize);
    }

    @Override
    protected int sizeOf(String key, Bitmap value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR1)
            return value.getByteCount();
        else
            return (value.getRowBytes() * value.getHeight());

    }

    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }

    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url, bitmap);
    }

}
