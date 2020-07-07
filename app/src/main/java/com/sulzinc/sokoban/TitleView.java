package com.sulzinc.sokoban;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class TitleView extends View {

    private Context myContext;
    private int screenH,screenW;
    private Bitmap title;
    private Bitmap play;
    private Paint paint;

    public TitleView(Context context){

        super(context);
        myContext=context;
        paint=new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(40.0f);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w,h,oldw,oldh);
        screenW=w;
        screenH=h;

        Bitmap temp= BitmapFactory.decodeResource(myContext.getResources(),R.drawable.sok);
        title=Bitmap.createScaledBitmap(temp,screenW,screenH,false);

        temp=BitmapFactory.decodeResource(myContext.getResources(),R.drawable.pl);
        play=Bitmap.createScaledBitmap(temp,screenW/2,screenH/9,false);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int eventaction=event.getAction();
        int X=(int)event.getX();
        int Y=(int)event.getY();

        switch(eventaction){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if((X>screenW/4 && X<screenW/4 + play.getWidth())&&(Y>screenH*8/10 && Y< screenH*8/10 + play.getHeight())){
                    Intent gameIntent=new Intent(myContext,GameActivity.class);
                    myContext.startActivity(gameIntent);
                }
                break;
        }
        return true;
    }

    @Override
    protected void onDraw(Canvas c)
    {
        c.drawBitmap(title,0,0,null);
        c.drawBitmap(play,screenW/4,screenH*8/10,null);
    }

}
