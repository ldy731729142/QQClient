package com.example.qqclient;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.HorizontalScrollView;





public class BaseHorizontalScrollView extends HorizontalScrollView {
    private float mOffsetX,mOffsetY;    //横纵偏移
    private float mLastPostX,mLastPostY; //上次落点
    private int mInterval;

    public BaseHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        boolean result;
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mOffsetX=0.0F;
                mOffsetY=0.0F;
                mLastPostX=event.getX();
                mLastPostY=event.getY();
                result=super.onInterceptHoverEvent(event);
                break;
            default://其余动作
                float thisPosX=event.getX();
                float thisPosY=event.getY();
                mOffsetX+=Math.abs(thisPosX-mLastPostX);//X轴偏差
                mLastPostY+=Math.abs(thisPosY-mLastPostY);//Y轴偏差
                mLastPostX=thisPosX;
                mLastPostY=thisPosY;
                if (mOffsetX<mOffsetY){
                    result=true;
                }else{
                    result=false;
                }
                break;

        }
        return result;
    }

}
