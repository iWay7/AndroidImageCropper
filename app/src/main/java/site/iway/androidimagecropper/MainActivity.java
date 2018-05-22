package site.iway.androidimagecropper;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import site.iway.androidhelpers.AssetsHelper;
import site.iway.androidhelpers.ImageCropper;
import site.iway.androidhelpers.UnitHelper;
import site.iway.javahelpers.MemCache;

public class MainActivity extends Activity implements OnClickListener, OnCheckedChangeListener {

    private ImageCropper mImageCropper;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageCropper = (ImageCropper) findViewById(R.id.imageCropper);
        mImageCropper.setBitmap(AssetsHelper.readImageFile(this, "image.jpg")); // 设置图片
        mImageCropper.setCropDrawable(new ColorDrawable(0x00000000)); // 设置指示被裁减区域的 Drawable
        mImageCropper.setCoverDrawable(new ColorDrawable(0x88000000)); // 设置蒙版区域的 Drawable
        mImageCropper.setCropRatio(1); // 设置裁剪比例，如果裁剪比例小于 0 则固定比例
        mImageCropper.setMinCropDrawableRectSideLength(UnitHelper.dipToPx(this, 100)); // 设置最小裁剪区域边长
        mImageCropper.setCropBorderWidth(UnitHelper.dipToPx(this, 10)); // 设置裁剪区域的边界粗细
        mImageCropper.setMultiSamplingEnabled(true); // 设置是否进行多重采样（抗锯齿）
        ((Button) findViewById(R.id.button)).setOnClickListener(this);
        ((CheckBox) findViewById(R.id.check_box)).setOnCheckedChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        Bitmap bitmap = mImageCropper.getCroppedBitmap();
        MemCache.putObject("BITMAP", bitmap);
        startActivity(new Intent(this, ViewActivity.class));
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        mImageCropper.setCropRatio(isChecked ? 1f : -1f);
    }

}
