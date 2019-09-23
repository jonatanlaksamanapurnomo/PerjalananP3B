package com.example.m0516081;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.example.m0516081.listeners.SimpleListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private Bitmap bitmap;
    private ImageView iv_canvas;
    private Canvas canvas;
    private Button button;
    private Paint paint;
    private GestureDetector mDetector;
    private int BACKGROUND_COLOR;
    private int TEST_COLOR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.mDetector = new GestureDetector(this, new SimpleListener());
        this.iv_canvas = this.findViewById(R.id.iv_canvas);
        this.button = this.findViewById(R.id.btn_new);
        this.button.setOnClickListener(this);
        this.BACKGROUND_COLOR = ResourcesCompat.getColor(getResources(), R.color.colorPrimary, null);
        this.TEST_COLOR = ResourcesCompat.getColor(getResources(), R.color.colorAccent, null);
        this.iv_canvas.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        //btn new : initiate canvas
        this.initiateCanvas();
    }

    public void initiateCanvas() {
        // 1. Create Bitmap
        this.bitmap = Bitmap.createBitmap(this.iv_canvas.getWidth(), this.iv_canvas.getHeight(), Bitmap.Config.ARGB_8888);
        // 2. Associate the bitmap to the ImageView.
        this.iv_canvas.setImageBitmap(this.bitmap);

        // 3. Create a Canvas with the bitmap.
        this.canvas = new Canvas(this.bitmap);
        this.canvas.drawColor(BACKGROUND_COLOR);
        this.paint = new Paint();
        this.paint.setColor(TEST_COLOR);

        this.resetCanvas();
        Rect rect = new Rect(10, 400, 100, 500);
        this.canvas.drawRect(rect, this.paint);
    }

    public void resetCanvas() {
        // 4. Draw canvas background
        this.canvas.drawColor(BACKGROUND_COLOR);
        // 5. force draw
        this.iv_canvas.invalidate();
    }


    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        //touch listener
        this.mDetector.onTouchEvent(motionEvent);
//        switch (motionEvent.getAction() & MotionEvent.ACTION_MASK){
//            case MotionEvent.ACTION_DOWN:
//                Log.d("d", "down");
//                break;
//            case MotionEvent.ACTION_POINTER_DOWN:
//                Log.d("d" , "pointer down");
//                break;
//            case MotionEvent.ACTION_UP:
//                Log.d("d", "up");
//                break;
//            case MotionEvent.ACTION_POINTER_UP:
//                Log.d("d", "pointer up");
//                break;
//            case  MotionEvent.ACTION_MOVE:
//                Log.d("d", "move");
//                break;
//        }
        return true;
    }

}