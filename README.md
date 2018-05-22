# AndroidImageCropper
Android 图片裁剪器。


### 本应用的示例

![image](https://github.com/iWay7/AndroidImageCropper/blob/master/sample.gif)   

### 本示例基于 AndroidHelpers 库，访问 https://github.com/iWay7/AndroidHelpers 添加依赖。

#### 开始使用：
##### 在布局文件中声明一个 ImageCropper 视图：
```
<site.iway.androidhelpers.ImageCropper
    android:id="@+id/imageCropper"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

##### 给这个 ImageCropper 设置参数就可以啦：
```
mImageCropper = (ImageCropper) findViewById(R.id.imageCropper);
mImageCropper.setBitmap(AssetsHelper.readImageFile(this, "image.jpg")); // 设置图片
mImageCropper.setCropDrawable(new ColorDrawable(0x00000000)); // 设置指示被裁减区域的 Drawable
mImageCropper.setCoverDrawable(new ColorDrawable(0x88000000)); // 设置蒙版区域的 Drawable
mImageCropper.setCropRatio(1); // 设置裁剪比例，如果裁剪比例小于 0 则固定比例
mImageCropper.setMinCropDrawableRectSideLength(UnitHelper.dipToPx(this, 100)); // 设置最小裁剪区域边长
mImageCropper.setCropBorderWidth(UnitHelper.dipToPx(this, 10)); // 设置裁剪区域的边界粗细
mImageCropper.setMultiSamplingEnabled(true); // 设置是否进行多重采样（抗锯齿）
```

##### 获取裁剪后的图片：
```
Bitmap bitmap = mImageCropper.getCroppedBitmap();
```