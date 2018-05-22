package site.iway.androidimagecropper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import site.iway.javahelpers.MemCache;

public class ViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageBitmap((Bitmap) MemCache.getObject("BITMAP"));
    }
}
