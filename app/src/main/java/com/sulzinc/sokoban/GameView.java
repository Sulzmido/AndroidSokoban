package com.sulzinc.sokoban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

public class GameView extends View {


    private int screenWidth;
    private int screenHeight;

    private Paint blackPaint;
    private Paint redPaint;
    private Paint bluePaint;
    private Paint yellowPaint;
    private Paint greenPaint;
    private Paint framePaint;
    private Paint textPaint;

    private Context myContext;
    private Data data;

    public GameView(Context context){

        super(context);
        myContext=context;

        data=new Data();

        blackPaint=new Paint();
        redPaint=new Paint();
        greenPaint=new Paint();
        bluePaint=new Paint();
        yellowPaint=new Paint();
        textPaint=new Paint();

        textPaint.setAntiAlias(true);
        textPaint.setColor(Color.WHITE);
        textPaint.setStyle(Paint.Style.STROKE);
        textPaint.setTextAlign(Paint.Align.LEFT);
        textPaint.setTextSize(40);

        framePaint=new Paint();
        framePaint.setColor(Color.WHITE);
        framePaint.setStyle(Paint.Style.STROKE);

        blackPaint.setAntiAlias(true);
        blackPaint.setColor(Color.BLACK);
        redPaint.setColor(Color.RED);
        bluePaint.setColor(Color.BLUE);
        yellowPaint.setColor(Color.YELLOW);
        greenPaint.setColor(Color.GREEN);

        initLevel();
    }

    private void initLevel(){

        lvl=(lvl%15)+1;

        levelData=data.getLevelArray(lvl);
        boxData=data.getBoxData(lvl);
        playerData=data.getPlayerData(lvl);

        playerX=playerData.x;
        playerY=playerData.y;

        boxX=new int[boxData.length];
        boxY=new int[boxData.length];

        for (int i = 0; i < boxData.length; i++) {

            boxX[i]=boxData[i].x;
            boxY[i]=boxData[i].y;
        }
    }

    private int playerX,playerY;
    private int[] boxX,boxY;

    private int blockSize;

    private Bitmap temp;
    private Bitmap tree;
    private Bitmap brick;
    private Bitmap box;
    private Bitmap dest;
    private Bitmap avatar;
    private Bitmap destbox;
    private Bitmap up;
    private Bitmap down;
    private Bitmap left;
    private Bitmap right;

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        super.onSizeChanged(w,h,oldw,oldh);
        screenWidth=w;
        screenHeight=h;

        blockSize=screenWidth/9;

        div=screenWidth/3;

        temp=BitmapFactory.decodeResource(myContext.getResources(),R.drawable.back);
        tree=Bitmap.createScaledBitmap(temp,blockSize,blockSize,false);

        temp=BitmapFactory.decodeResource(myContext.getResources(),R.drawable.red_graphic);
        brick=Bitmap.createScaledBitmap(temp,blockSize,blockSize,false);

        temp=BitmapFactory.decodeResource(myContext.getResources(),R.drawable.dest);
        dest=Bitmap.createScaledBitmap(temp,blockSize,blockSize,false);

        temp=BitmapFactory.decodeResource(myContext.getResources(),R.drawable.ava);
        avatar=Bitmap.createScaledBitmap(temp,blockSize,blockSize,false);

        temp= BitmapFactory.decodeResource(myContext.getResources(),R.drawable.pat);
        box= Bitmap.createScaledBitmap(temp,blockSize,blockSize,false);

        temp= BitmapFactory.decodeResource(myContext.getResources(),R.drawable.patbl);
        destbox= Bitmap.createScaledBitmap(temp,blockSize,blockSize,false);

        temp= BitmapFactory.decodeResource(myContext.getResources(),R.drawable.up);
        up= Bitmap.createScaledBitmap(temp,div,(screenHeight-screenWidth)/2,false);

        temp= BitmapFactory.decodeResource(myContext.getResources(),R.drawable.down);
        down= Bitmap.createScaledBitmap(temp,div,(screenHeight-screenWidth)/2,false);

        temp= BitmapFactory.decodeResource(myContext.getResources(),R.drawable.left);
        left= Bitmap.createScaledBitmap(temp,div,(screenHeight-screenWidth),false);

        temp= BitmapFactory.decodeResource(myContext.getResources(),R.drawable.right);
        right= Bitmap.createScaledBitmap(temp,div,(screenHeight-screenWidth),false);

    }



    // tree = 1 , brick=2 , background = 3 ,
    // back + dest =4

    private int lvl=0;
    private int[][] levelData;
    private Point[] boxData;
    private Point playerData;

    private int div;

    @Override
    protected void onDraw(Canvas c){

        update();

            //  draw the direction control colors.
        //c.drawRect(0,screenWidth,div,screenHeight,redPaint);
        //c.drawRect(div,screenWidth,2*div,screenWidth+(screenHeight/2-screenWidth/2),yellowPaint);
        //c.drawRect(div,screenWidth+(screenHeight/2-screenWidth/2),2*div,screenHeight,bluePaint);
        //c.drawRect(2*div,screenWidth,screenWidth,screenHeight,greenPaint);

            // draw the arrows.
        c.drawBitmap(left,0,screenWidth,null);
        c.drawBitmap(up,div,screenWidth,null);
        c.drawBitmap(down,div,screenWidth+(screenHeight/2-screenWidth/2),null);
        c.drawBitmap(right,2*div,screenWidth,null);

        // draw outline rectangles
        c.drawRect(0,screenWidth,div,screenHeight,framePaint);
        c.drawRect(div,screenWidth,2*div,screenWidth+(screenHeight/2-screenWidth/2),framePaint);
        c.drawRect(div,screenWidth+(screenHeight/2-screenWidth/2),2*div,screenHeight,framePaint);
        c.drawRect(2*div,screenWidth,screenWidth,screenHeight,framePaint);

        //draw black background.
        c.drawRect(0.0f,0.0f,screenWidth,screenWidth,blackPaint);
        c.drawRect(0.0f,0.0f,screenWidth,screenWidth,framePaint);

           // draw static game elements .
        for (int i = 0; i <levelData.length ; i++) {
            for (int j = 0; j < levelData[i].length; j++) {

                if(levelData[i][j]==1){
                    c.drawBitmap(tree,j*blockSize,i*blockSize,framePaint);

                }else if(levelData[i][j]==2){
                   c.drawBitmap(brick,j*blockSize,i*blockSize,framePaint);

                }else if(levelData[i][j]==3){
                    c.drawRect(j*blockSize,i*blockSize,(j+1)*blockSize,(i+1)*blockSize,greenPaint);

                }else if(levelData[i][j]==4){
                    c.drawRect(j*blockSize,i*blockSize,(j+1)*blockSize,(i+1)*blockSize,greenPaint);
                    c.drawBitmap(dest,j*blockSize,i*blockSize,null);

                }

            }

        }
                 // draw the player
       // System.out.println(playerX+"  "+playerY);
        c.drawBitmap(avatar,playerX*blockSize,playerY*blockSize,null);

               // draw the movable boxes.
        for (int i = 0; i <boxData.length ; i++) {

            if(levelData[boxY[i]][boxX[i]]==4){
                c.drawBitmap(destbox,boxX[i]*blockSize,boxY[i]*blockSize,framePaint);

            }else c.drawBitmap(box,boxX[i]*blockSize,boxY[i]*blockSize,framePaint);

        }

            // draw number of level at the bottom.
        c.drawText(""+lvl,screenWidth*5/6,screenWidth*11/12,textPaint);

        invalidate();
    }

    private int count;
    private void update(){

        count=0;

        for (int i = 0; i < boxData.length; i++) {

            if(levelData[boxY[i]][boxX[i]]==4){
                count++;
            }

        }
        if(count==boxData.length){
          //  try{Thread.sleep(2000);}catch (Exception e){}
            initLevel();
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        int eventAction = event.getAction();
        int X = (int)event.getX();
        int Y = (int)event.getY();

        int keycode=getKeyCode(X,Y);

        switch (eventAction ) {
            case MotionEvent.ACTION_DOWN:

                if(keycode==0) {
                    initLevel();
                    invalidate();
                    return true;
                }

                if(canMove(keycode)) move();
                break;
            case MotionEvent.ACTION_MOVE:

                break;
            case MotionEvent.ACTION_UP:

                break;
        }
        invalidate();
        return true;
    }

    private Point nxt1,nxt2;

    private boolean canMove(int keycode){

        switch (keycode){

            case 1:
                nxt1=new Point(playerX,playerY-1);
                nxt2=new Point(playerX,playerY-2);
                break;
            case 2:
                nxt1=new Point(playerX,playerY+1);
                nxt2=new Point(playerX,playerY+2);
                break;
            case 3:
                nxt1=new Point(playerX-1,playerY);
                nxt2=new Point(playerX-2,playerY);
                break;
            case 4:
                nxt1=new Point(playerX+1,playerY);
                nxt2=new Point(playerX+2,playerY);
                break;

        }

        if(levelData[nxt1.y][nxt1.x]==2){
            return false;
        }
        for (int i = 0; i <boxData.length ; i++) {
            if(nxt1.x==boxX[i] && nxt1.y==boxY[i]){
                for (int j = 0; j <boxData.length ; j++) {
                    if(nxt2.x==boxX[j] && nxt2.y==boxY[j]){
                        return false;

                    }

                }

            }

        }

        for (int i = 0; i <boxData.length ; i++) {
            if(nxt1.x==boxX[i] && nxt1.y==boxY[i]){
                if(levelData[nxt2.y][nxt2.x]==2){
                    return false;
                }

            }

        }

        return true;
    }

    private void move(){

        for (int i = 0; i < boxData.length; i++) {
            if(nxt1.x==boxX[i] && nxt1.y==boxY[i]){
                playerY=nxt1.y;
                playerX=nxt1.x;
                boxX[i]=nxt2.x;
                boxY[i]=nxt2.y;
                return;
            }

        }

        if(levelData[nxt1.y][nxt1.x]==3){
            playerY=nxt1.y;
            playerX=nxt1.x;

        }
        if(levelData[nxt1.y][nxt1.x]==4){
            playerY=nxt1.y;
            playerX=nxt1.x;

        }

    }

    public final int UP=1;
    public final int DOWN=2;
    public final int LEFT=3;
    public final int RIGHT=4;
    public final int SCREEN=0;

    private int getKeyCode(int x,int y){

        if((x>0 && x < div)&&(y>screenWidth && y< screenHeight)) {
            //System.out.println(LEFT);
            return LEFT;
        }

        if((x>2*div && x < screenWidth)&&(y>screenWidth && y< screenHeight)) {
            //System.out.println(RIGHT);
            return RIGHT;
        }

        if((x>0 && x < screenWidth)&&(y>0 && y< screenWidth)) {
            //System.out.println(SCREEN);
            return SCREEN;
        }

        if((x>div && x < 2*div)&&(y>screenWidth && y< screenHeight-(screenHeight/2-screenWidth/2))) {
            //System.out.println(UP);
            return UP;
        }

        if((x>div && x < 2*div)&&(y>screenWidth+(screenHeight/2-screenWidth/2) && y< screenHeight)) {
            //System.out.println(DOWN);
            return DOWN;
        }

        return 0;
    }

}
