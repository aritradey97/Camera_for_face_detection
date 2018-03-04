package com.btechviral.android.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by 1605180 on 02-Mar-18.
 */

public class MyFaceDetectionListener extends View implements Camera.FaceDetectionListener {
    private Paint paint = new Paint();
    ArrayList <Rect> faceRect = new ArrayList<>();
    public MyFaceDetectionListener(Context context) {
        super(context);
    }

    @Override
    public void onFaceDetection(Camera.Face[] faces, Camera camera) {
        if (faces.length > 0){
            Log.d("FaceDetection", "face detected: "+ faces.length + " Face 1 Location X: " + faces[0].rect.centerX() + "Y: " + faces[0].rect.centerY() );
            ArrayList <Rect> faceRect = new ArrayList<>();
            for(int i = 0; i < faces.length; i++)
            {
                int left = faces[i].rect.left;
                int right = faces[i].rect.right;
                int top = faces[i].rect.top;
                int bottom = faces[i].rect.bottom;
                Rect uRect = new Rect(left, top, right, bottom);
                faceRect.add(uRect);
            }

        }

    }
    public void draw(Canvas canvas) {
        super.draw(canvas);
        for (int i = 0; i < faceRect.size(); i++) {
            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(3);
            canvas.drawRect(faceRect.get(i), paint);
        }
    }
}
