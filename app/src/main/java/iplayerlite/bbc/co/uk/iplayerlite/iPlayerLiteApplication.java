package iplayerlite.bbc.co.uk.iplayerlite;

import android.app.Application;

import iplayerlite.bbc.co.uk.iplayerlite.utils.ImageCacheManager;
import iplayerlite.bbc.co.uk.iplayerlite.utils.VolleyHelper;

public class iPlayerLiteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        VolleyHelper.initQueues(this);
        ImageCacheManager.INSTANCE.initImageCache();

    }
}
