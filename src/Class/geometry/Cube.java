package Class.geometry;

import Interface.ShapeInterface;
import Class.Shape;
import Class.Context;

import java.awt.*;


public class Cube extends Shape implements ShapeInterface {

    public int x,y,z,length;
    public boolean fill;
    public Color c;
    private int[][] coordinate = new int[8][3];

    public Cube(int x, int y, int z, int length, boolean fill, boolean object, Color c) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.length = length;
        this.fill = fill;
        this.c = c;
        setCoordinate();
        if (object) {
            Context.getInstance().addShape(this);
        }
    }

    public void setCoordinate() {
        coordinate[0][0] = x;
        coordinate[0][1] = y;
        coordinate[0][2] = z;

        coordinate[1][0] = x+length;
        coordinate[1][1] = y;
        coordinate[1][2] = z;

        coordinate[2][0] = x+length;
        coordinate[2][1] = y+length;
        coordinate[2][2] = z;

        coordinate[3][0] = x;
        coordinate[3][1] = y+length;
        coordinate[3][2] = z;

        coordinate[4][0] = x;
        coordinate[4][1] = y+length;
        coordinate[4][2] = z+z;

        coordinate[5][0] = x+length;
        coordinate[5][1] = y+length;
        coordinate[5][2] = z+z;

        coordinate[6][0] = x+length;
        coordinate[6][1] = y;
        coordinate[6][2] = z+z;

        coordinate[7][0] = x;
        coordinate[7][1] = y;
        coordinate[7][2] = z+z;
    }

    public int[][] getCoordinate() {
        return coordinate;
    }

    public void drawShape(Graphics g) {
        g.setColor(c);
        if (this.fill) {
            int[][][] coordinate3d = get3dFillPolygonCoordinate(super.get3dCoordinate());
            if (coordinate3d != null) {
                for (int i = 0; i < coordinate3d.length; i++) {

                    g.fillPolygon(coordinate3d[i][0], coordinate3d[i][1], coordinate3d[i][0].length);
                }
            }
        } else {
            int[][] coordinate3d = get3dDrawPolygonCoordinate(super.get3dCoordinate());
            if (coordinate3d != null) {
                g.drawPolygon(coordinate3d[0], coordinate3d[1], coordinate3d[0].length);
            }
        }
    }

    public int[][] get3dDrawPolygonCoordinate(int[][] coordinate3d) {
        int[][] coord3dpol = new int[2][18];
        for (int i = 0; i < 2; i++) {
            coord3dpol[i][0] = coordinate3d[i][0];
            coord3dpol[i][1] = coordinate3d[i][1];
            coord3dpol[i][2] = coordinate3d[i][2];
            coord3dpol[i][3] = coordinate3d[i][3];
            coord3dpol[i][4] = coordinate3d[i][4];
            coord3dpol[i][5] = coordinate3d[i][5];
            coord3dpol[i][6] = coordinate3d[i][6];
            coord3dpol[i][7] = coordinate3d[i][7];
            coord3dpol[i][8] = coordinate3d[i][4];
            coord3dpol[i][9] = coordinate3d[i][3];
            coord3dpol[i][10] = coordinate3d[i][0];
            coord3dpol[i][11] = coordinate3d[i][7];
            coord3dpol[i][12] = coordinate3d[i][6];
            coord3dpol[i][13] = coordinate3d[i][1];
            coord3dpol[i][14] = coordinate3d[i][2];
            coord3dpol[i][15] = coordinate3d[i][5];
            coord3dpol[i][16] = coordinate3d[i][4];
            coord3dpol[i][17] = coordinate3d[i][3];
        }
        return coord3dpol;
    }

    public int[][][] get3dFillPolygonCoordinate(int[][] coordinate3d) {
        int[][][] coord3dpol = new int[6][2][4];
        for (int i = 0; i < 2; i++) {
            coord3dpol[0][i][0] = coordinate3d[i][0];
            coord3dpol[0][i][1] = coordinate3d[i][1];
            coord3dpol[0][i][2] = coordinate3d[i][2];
            coord3dpol[0][i][3] = coordinate3d[i][3];

            coord3dpol[1][i][0] = coordinate3d[i][4];
            coord3dpol[1][i][1] = coordinate3d[i][5];
            coord3dpol[1][i][2] = coordinate3d[i][6];
            coord3dpol[1][i][3] = coordinate3d[i][7];

            coord3dpol[2][i][0] = coordinate3d[i][0];
            coord3dpol[2][i][1] = coordinate3d[i][3];
            coord3dpol[2][i][2] = coordinate3d[i][4];
            coord3dpol[2][i][3] = coordinate3d[i][7];

            coord3dpol[3][i][0] = coordinate3d[i][1];
            coord3dpol[3][i][1] = coordinate3d[i][2];
            coord3dpol[3][i][2] = coordinate3d[i][5];
            coord3dpol[3][i][3] = coordinate3d[i][6];

            coord3dpol[4][i][0] = coordinate3d[i][0];
            coord3dpol[4][i][1] = coordinate3d[i][1];
            coord3dpol[4][i][2] = coordinate3d[i][6];
            coord3dpol[4][i][3] = coordinate3d[i][7];

            coord3dpol[5][i][0] = coordinate3d[i][2];
            coord3dpol[5][i][1] = coordinate3d[i][3];
            coord3dpol[5][i][2] = coordinate3d[i][4];
            coord3dpol[5][i][3] = coordinate3d[i][5];

        }
        return coord3dpol;
    }
}
