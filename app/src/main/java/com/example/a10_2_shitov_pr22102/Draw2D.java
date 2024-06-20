package com.example.a10_2_shitov_pr22102;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.view.View;
import android.graphics.Typeface;

public class Draw2D extends View {
    private Paint mPaint = new Paint();
    private Rect mRect = new Rect();
    private Bitmap mDotaLogo;
    private Bitmap mPudjImage;
    private int mDotaLogoWidth;
    private int mDotaLogoHeight;
    private int mPudjImageWidth;
    private int mPudjImageHeight;

    public Draw2D(Context context, int dotaLogoWidth, int dotaLogoHeight, int pudjImageWidth, int pudjImageHeight) {
        super(context);
        Resources res = this.getResources();
        mDotaLogo = BitmapFactory.decodeResource(res, R.drawable.dotalogo);
        mPudjImage = BitmapFactory.decodeResource(res, R.drawable.pudj);
        mDotaLogoWidth = dotaLogoWidth;
        mDotaLogoHeight = dotaLogoHeight;
        mPudjImageWidth = pudjImageWidth;
        mPudjImageHeight = pudjImageHeight;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        // Создание градиентного фона
        Shader shader = new LinearGradient(0, 0, 0, height, Color.BLACK, Color.RED, Shader.TileMode.CLAMP);
        mPaint.setShader(shader);
        canvas.drawRect(0, 0, width, height, mPaint);

        // Рисование логотипа Доты
        Bitmap scaledDotaLogo = Bitmap.createScaledBitmap(mDotaLogo, mDotaLogoWidth, mDotaLogoHeight, true);
        canvas.drawBitmap(scaledDotaLogo, width / 2 - scaledDotaLogo.getWidth() / 2, 10, mPaint);

        // Рисование красного текста "Dota 2"
        mPaint.setShader(null);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextSize(200);
        canvas.drawText("Dota 2", 440, 650, mPaint);

        // Рисование изображения Пуджа
        Bitmap scaledPudjImage = Bitmap.createScaledBitmap(mPudjImage, mPudjImageWidth, mPudjImageHeight, true);
        canvas.drawBitmap(scaledPudjImage, width / 2 - scaledPudjImage.getWidth() / 2, height - scaledPudjImage.getHeight() - 50, mPaint);
    }
}