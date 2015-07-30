package com.akvasov.android.paintbolltrainermvp;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by alex on 28.07.15.
 */
public class FieldView extends View {

        /*private List<ImageView> images;
    private Bitmap bitmap;

    private ImageView createImage(int left, int top) {
        LayoutParams lpView = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpView.setMargins(left, top, 0, 0);
        ImageView result = new ImageView(this);
        result.setLayoutParams(lpView);
        result.setImageBitmap(bitmap);
        images.add(result);

        return result;
    }*/

    private Paint paint;
    private Bitmap bitmap;

    public FieldView(Context context) {
        super(context);

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawARGB(80, 100, 200, 255);
        canvas.drawBitmap(bitmap, 50, 50, paint);
    }

}
