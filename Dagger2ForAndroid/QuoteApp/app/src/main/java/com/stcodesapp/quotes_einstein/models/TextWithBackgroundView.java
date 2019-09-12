package com.stcodesapp.quotes_einstein.models;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import com.stcodesapp.quotes_einstein.R;

public class TextWithBackgroundView extends View {

    public TextWithBackgroundView(Context context)
    {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        drawBackground(canvas);
        drawText(canvas);
    }

    private void drawBackground(Canvas canvas)
    {
        Bitmap bitmap = decodeSampledBitmapFromResource(getResources(),R.drawable.test_bg,512,512);

        // Define an offset value between canvas and bitmap
        int offset = 50;

        // Initialize a new Bitmap to hold the source bitmap
        Bitmap dstBitmap = Bitmap.createBitmap(
                bitmap.getWidth() + offset * 2, // Width
                bitmap.getHeight() + offset * 2, // Height
                Bitmap.Config.ARGB_8888 // Config
        );

        // Initialize a new Canvas instance
        // Draw a solid color on the canvas as background
        canvas.drawColor(Color.LTGRAY);
        //Finally, Draw the source bitmap on the canvas
        canvas.drawBitmap(
                bitmap, // Bitmap
                offset, // Left
                offset, // Top
                null // Paint
        );

    }

    private void drawText(Canvas canvas)
    {
        int x = 0;
        int y = 0;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        canvas.save();
        canvas.translate(100, 200);

        // make the entire canvas white
//        canvas.drawColor(Color.WHITE);

        // draw some text using STROKE style
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1);
        paint.setColor(Color.MAGENTA);
        paint.setTextSize(100);
        canvas.drawText("Style.STROKE", 0, 0, paint);

        canvas.translate(0, 200);

        // draw some text using FILL style
        paint.setStyle(Paint.Style.FILL);
        //turn antialiasing on
        paint.setAntiAlias(true);
        //paint.setTextSize(30);
        canvas.drawText("Style.FILL", 0, 0, paint);

        canvas.translate(0, 200);

        // draw some rotated text
        // get text width and height
        // set desired drawing location
        x = 75;
        y = 185;
        paint.setColor(Color.GRAY);
        //paint.setTextSize(25);
        String str2rotate = "Rotated!";

        // draw bounding rect before rotating text
        Rect rect = new Rect();
        paint.getTextBounds(str2rotate, 0, str2rotate.length(), rect);
        canvas.translate(x, y);
        paint.setStyle(Paint.Style.FILL);
        // draw unrotated text
        canvas.drawText("!Rotated", 0, 0, paint);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rect, paint);
        // undo the translate
        canvas.translate(-x, -y);

        // rotate the canvas on center of the text to draw
        canvas.rotate(-45, x + rect.exactCenterX(),
                y + rect.exactCenterY());
        // draw the rotated text
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText(str2rotate, x, y, paint);

        //undo the translation and rotation
        canvas.restore();
    }


    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight)
    {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId,
                                                         int reqWidth, int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }
}
