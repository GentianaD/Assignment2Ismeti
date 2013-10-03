package com.example.gpsexample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;

public class Drawing extends View {

	Paint paint = new Paint();
	Bitmap speedometer;
	public static String asdf = "";
	float startX;
	float startY;
	float stopX;
	float stopY;

	public Drawing(Context context) {
		super(context);
		// TODO Auto-generated constructor stub

	}

	public Drawing(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		speedometer = BitmapFactory.decodeResource(getResources(),
				R.drawable.speedo);

		startX = getWidth() / 2;
		startY = getHeight() - 4;
		double R = 0;
		if (MainActivity.mRotation == Surface.ROTATION_0) {
			R = startX * 0.85;
		} else {
			R = startX * 0.7;
		}
		// Get Canvas height and width
		int canvasWidth = canvas.getWidth();
		int canvasHeight = canvas.getHeight();
		//Get the speed from the GPS
		double Speed = MainActivity.SPEED;

		double S = Speed / 60 * 180 + 180;
		if (S > 360) {
			S = 360;
		}
		//Calculating the coordinates of the line, depending on the speed measured 
		double X = startX + R * Math.cos(Math.toRadians(S));
		double Y = startY + R * Math.sin(Math.toRadians(S));
		//Used later to set the rectangle dimensions
		int squareWidth = canvasWidth - 1;
		int squareHeight = canvasHeight - 1;
		Rect destinationRect = new Rect();

		paint.setAntiAlias(true);
		paint.setStrokeWidth(6f);
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeJoin(Paint.Join.ROUND);
	
	}

}
