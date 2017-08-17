package com.toong.androidmyimageview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class MyImageView extends android.support.v7.widget.AppCompatImageView {
    private boolean mPressed;

    public MyImageView(Context context) {
        this(context, null);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void refresh() {
        if (mPressed) {
            setImageAlpha(230);
            invalidate();
            return;
        }
        setImageAlpha(255);
        invalidate();
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        mPressed = pressed;
        refresh();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            setPressed(true);
        } else if (event.getAction() == MotionEvent.ACTION_UP) {
            setPressed(false);
            float x = event.getX();
            float y = event.getY();
            boolean isInside = (x > 0 && x < getWidth() && y > 0 && y < getHeight());
            if (isInside) {
                performClick();
            }
        }
        return true;
    }
}