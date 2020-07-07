package com.sulzinc.sokoban;

import android.graphics.Point;

public class Data {

    // tree = 1 , brick=2 , background = 3 ,
    // back + dest =4

    private int[][] lvl1={
            {1,1,2,2,2,1,1,1,1},
            {1,1,2,4,2,1,1,1,1},
            {1,1,2,3,2,2,2,2,1},
            {2,2,2,3,3,3,4,2,1},
            {2,4,3,3,3,2,2,2,1},
            {2,2,2,2,3,2,1,1,1},
            {1,1,1,2,4,2,1,1,1},
            {1,1,1,2,2,2,1,1,1},
            {1,1,1,1,1,1,1,1,1}
    };

    private int[][] lvl2={
            {2,2,2,2,2,1,1,1,1},
            {2,3,3,3,2,1,1,1,1},
            {2,3,3,3,2,1,2,2,2},
            {2,3,3,3,2,1,2,4,2},
            {2,2,2,3,2,2,2,4,2},
            {1,2,2,3,3,3,3,4,2},
            {1,2,3,3,3,2,3,3,2},
            {1,2,3,3,3,2,2,2,2},
            {1,2,2,2,2,2,1,1,1}
    };
    private int[][] lvl3={
            {1,2,2,2,2,1,1,1,1},
            {2,2,3,3,2,1,1,1,1},
            {2,3,3,3,2,1,1,1,1},
            {2,2,3,3,2,2,1,1,1},
            {2,2,3,3,3,2,1,1,1},
            {2,4,3,3,3,2,1,1,1},
            {2,4,4,4,4,2,1,1,1},
            {2,2,2,2,2,2,1,1,1},
            {1,1,1,1,1,1,1,1,1},

    };
    private int[][] lvl4={
            {1,2,2,2,2,1,1,1,1},
            {1,2,3,3,2,2,2,1,1},
            {1,2,3,3,3,3,2,1,1},
            {2,2,2,3,2,3,2,2,1},
            {2,4,2,3,2,3,3,2,1},
            {2,4,3,3,3,2,3,2,1},
            {2,4,3,3,3,3,3,2,1},
            {2,2,2,2,2,2,2,2,1},
            {1,1,1,1,1,1,1,1,1},

    };
    private int[][] lvl5={
            {1,1,2,2,2,2,2,2,1},
            {1,1,2,3,3,3,3,2,1},
            {2,2,2,3,3,3,3,2,1},
            {2,3,3,3,4,4,3,2,1},
            {2,3,3,4,4,4,2,2,1},
            {2,2,2,2,3,3,2,1,1},
            {1,1,1,2,2,2,2,1,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},

    };
    private int[][] lvl6={
            {1,1,2,2,2,2,2,1,1},
            {2,2,2,3,3,3,2,1,1},
            {2,3,3,3,4,3,2,2,1},
            {2,3,3,4,3,4,3,2,1},
            {2,2,2,3,4,3,3,2,1},
            {1,1,2,3,3,3,2,2,1},
            {1,1,2,2,2,2,2,1,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},

    };
    private int[][] lvl7={
            {1,1,2,2,2,2,1,1,1},
            {1,1,2,4,4,2,1,1,1},
            {1,2,2,3,4,2,2,1,1},
            {1,2,3,3,3,4,2,1,1},
            {2,2,3,3,3,3,2,2,1},
            {2,3,3,2,3,3,3,2,1},
            {2,3,3,3,3,3,3,2,1},
            {2,2,2,2,2,2,2,2,1},
            {1,1,1,1,1,1,1,1,1},

    };
    private int[][] lvl8={
            {2,2,2,2,2,2,2,2,1},
            {2,3,3,2,3,3,3,2,1},
            {2,3,3,4,4,3,3,2,1},
            {2,3,3,4,4,3,2,2,1},
            {2,3,3,4,4,3,3,2,1},
            {2,3,3,2,3,3,3,2,1},
            {2,2,2,2,2,2,2,2,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},

    };


    private int[][] lvl9={
            {2,2,2,2,2,2,1,1,1},
            {2,3,3,3,3,2,1,1,1},
            {2,3,3,3,3,2,2,1,1},
            {2,3,3,2,4,4,2,2,2},
            {2,2,3,3,4,4,3,3,2},
            {1,2,3,3,3,3,3,3,2},
            {1,2,2,2,2,2,2,2,2},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},

    };

    private int[][] lvl10={
            {2,2,2,2,2,2,2,1,1},
            {2,4,4,3,4,4,2,1,1},
            {2,4,4,2,4,4,2,1,1},
            {2,3,3,3,3,3,2,1,1},
            {2,3,3,3,3,3,2,1,1},
            {2,3,3,3,3,3,2,1,1},
            {2,3,3,2,3,3,2,1,1},
            {2,2,2,2,2,2,2,1,1},
            {1,1,1,1,1,1,1,1,1},

    };

    private int[][] lvl11={
            {1,2,2,2,2,2,1,1,1},
            {1,2,3,3,3,2,2,2,1},
            {2,2,3,2,3,3,3,2,1},
            {2,3,4,4,3,4,3,2,1},
            {2,3,3,3,3,3,2,2,1},
            {2,2,2,3,2,4,2,1,1},
            {1,1,2,3,3,3,2,1,1},
            {1,1,2,2,2,2,2,1,1},
            {1,1,1,1,1,1,1,1,1},

    };

    private int[][] lvl12={
            {2,2,2,2,2,2,1,1,1},
            {2,3,3,3,3,2,1,1,1},
            {2,3,3,3,3,2,1,1,1},
            {2,2,4,3,3,2,1,1,1},
            {2,3,4,3,2,2,1,1,1},
            {2,3,4,3,2,1,1,1,1},
            {2,3,4,3,2,1,1,1,1},
            {2,3,4,3,2,1,1,1,1},
            {2,2,2,2,2,1,1,1,1},

    };


    private int[][] lvl13={
            {1,1,2,2,2,2,1,1,1},
            {1,1,2,3,3,2,1,1,1},
            {2,2,2,3,3,2,2,1,1},
            {2,3,3,4,3,3,2,1,1},
            {2,3,3,4,3,3,2,1,1},
            {2,3,3,4,3,2,2,1,1},
            {2,2,2,4,3,2,1,1,1},
            {1,1,2,4,2,2,1,1,1},
            {1,1,2,2,2,1,1,1,1},

    };
    private int[][] lvl14={
            {2,2,2,2,2,1,1,1,1},
            {2,3,3,3,2,2,2,2,2},
            {2,3,2,3,2,3,3,3,2},
            {2,3,3,3,3,3,3,3,2},
            {2,4,4,2,3,2,3,2,2},
            {2,4,3,3,3,3,3,2,1},
            {2,4,4,3,3,2,2,2,1},
            {2,2,2,2,2,2,1,1,1},
            {1,1,1,1,1,1,1,1,1},

    };

    private int[][] lvl15={
            {1,2,2,2,2,2,2,1,1},
            {1,2,3,3,3,3,2,2,1},
            {2,2,4,2,2,3,3,2,1},
            {2,3,4,4,3,3,3,2,1},
            {2,3,3,2,3,3,3,2,1},
            {2,3,3,3,3,2,2,2,1},
            {2,2,2,2,2,2,1,1,1},
            {1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,1},

    };


    public Data(){
    }


         // movable blocks and initial player position data.
    private Point[] bData1={new Point(3,3),new Point(3,4),new Point(4,5),new Point(5,3)};
    private Point pData1=new Point(4,4);

    private Point[] bData2={new Point(2,2),new Point(2,3),new Point(3,2)};
    private Point pData2=new Point(3,1);

    private Point[] bData3={new Point(2,3),new Point(2,5),new Point(3,2),new Point(3,4),new Point(3,6)};
    private Point pData3=new Point(2,2);

    private Point[] bData4={new Point(3,2),new Point(2,5),new Point(5,6)};
    private Point pData4=new Point(2,1);

    private Point[] bData5={new Point(3,2),new Point(4,2),new Point(5,2),new Point(3,3),new Point(2,4)};
    private Point pData5=new Point(1,3);

    private Point[] bData6={new Point(3,2),new Point(4,3),new Point(4,4),new Point(5,4)};
    private Point pData6=new Point(5,1);

    private Point[] bData7={new Point(4,3),new Point(3,4),new Point(4,5),new Point(5,5)};
    private Point pData7=new Point(6,6);

    private Point[] bData8={new Point(2,2),new Point(2,3),new Point(2,4),new Point(4,3),new Point(5,2),new Point(5,4)};
    private Point pData8=new Point(1,3);

    private Point[] bData9={new Point(2,2),new Point(3,2),new Point(4,2),new Point(6,4)};
    private Point pData9=new Point(3,5);

    private Point[] bData10={new Point(3,1),new Point(2,3),new Point(3,3),new Point(4,3),new Point(3,4),new Point(2,5),new Point(3,5),new Point(4,5)};
    private Point pData10=new Point(4,6);

    private Point[] bData11={new Point(4,2),new Point(2,3),new Point(3,4),new Point(4,4)};
    private Point pData11=new Point(3,1);

    private Point[] bData12={new Point(2,2),new Point(2,3),new Point(2,4),new Point(2,5),new Point(2,6)};
    private Point pData12=new Point(4,2);

    private Point[] bData13={new Point(3,2),new Point(3,3),new Point(3,4),new Point(3,5),new Point(3,6)};
    private Point pData13=new Point(5,3);

    private Point[] bData14={new Point(2,3),new Point(6,3),new Point(4,4),new Point(6,4),new Point(3,5)};
    private Point pData14=new Point(2,5);

    private Point[] bData15={new Point(5,2),new Point(4,3),new Point(4,4)};
    private Point pData15=new Point(3,5);



         // getters

    public int[][] getLevelArray(int level){
        switch (level){
            case 1: return lvl1;
            case 2: return lvl2;
            case 3: return lvl3;
            case 4: return lvl4;
            case 5: return lvl5;
            case 6: return lvl6;
            case 7: return lvl7;
            case 8: return lvl8;
            case 9: return lvl9;
            case 10: return lvl10;
            case 11: return lvl11;
            case 12: return lvl12;
            case 13: return lvl13;
            case 14: return lvl14;
            case 15: return lvl15;
            default:return null;

        }
    }


    public Point[] getBoxData(int level){

        switch (level){
            case 1: return bData1;
            case 2: return bData2;
            case 3: return bData3;
            case 4: return bData4;
            case 5: return bData5;
            case 6: return bData6;
            case 7: return bData7;
            case 8: return bData8;
            case 9: return bData9;
            case 10: return bData10;
            case 11: return bData11;
            case 12: return bData12;
            case 13: return bData13;
            case 14: return bData14;
            case 15: return bData15;
            default:return null;
        }
    }
    public Point getPlayerData(int level){

        switch (level){
            case 1: return pData1;
            case 2: return pData2;
            case 3: return pData3;
            case 4: return pData4;
            case 5: return pData5;
            case 6: return pData6;
            case 7: return pData7;
            case 8: return pData8;
            case 9: return pData9;
            case 10: return pData10;
            case 11: return pData11;
            case 12: return pData12;
            case 13: return pData13;
            case 14: return pData14;
            case 15: return pData15;
            default:return null;
        }
    }
}
