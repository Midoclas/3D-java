package Class.geometry;

import Interface.ShapeInterface;
import Class.Shape;
import Class.Context;

import java.awt.*;

public class Triangle extends Shape implements ShapeInterface {
    public int x,y,z,length;
    public boolean fill;
    private int[][] coordinate = new int[8][3];

    public Triangle(int x, int y, int z, int length, boolean fill) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.length = length;
        this.fill = fill;
        setCoordinate();
        Context.getInstance().addShape(this);
    }

    public void setCoordinate() {
        coordinate[0][0] = x;
        coordinate[0][1] = y;
        coordinate[0][2] = z+length;

        coordinate[1][0] = x+length;
        coordinate[1][1] = y;
        coordinate[1][2] = z+length;

        coordinate[2][0] = x+length/2;
        coordinate[2][1] = y;
        coordinate[2][2] = z;

        coordinate[3][0] = x+length/2;
        coordinate[3][1] = y+length;
        coordinate[3][2] = z+length/2;
    }

    public int[][] getCoordinate() {
        return coordinate;
    }

    public void drawShape(Graphics g) {
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
        int[][] coord3dpol = new int[2][8];
        for (int i = 0; i < 2; i++) {
            coord3dpol[i][0] = coordinate3d[i][0];
            coord3dpol[i][1] = coordinate3d[i][1];
            coord3dpol[i][2] = coordinate3d[i][2];
            coord3dpol[i][3] = coordinate3d[i][0];
            coord3dpol[i][4] = coordinate3d[i][3];
            coord3dpol[i][5] = coordinate3d[i][1];
            coord3dpol[i][6] = coordinate3d[i][2];
            coord3dpol[i][7] = coordinate3d[i][3];
        }
        return coord3dpol;
    }

    public int[][][] get3dFillPolygonCoordinate(int[][] coordinate3d) {
        int[][][] coord3dpol = new int[4][2][3];
        for (int i = 0; i < 2; i++) {
            coord3dpol[0][i][0] = coordinate3d[i][0];
            coord3dpol[0][i][1] = coordinate3d[i][1];
            coord3dpol[0][i][2] = coordinate3d[i][2];

            coord3dpol[1][i][0] = coordinate3d[i][1];
            coord3dpol[1][i][1] = coordinate3d[i][2];
            coord3dpol[1][i][2] = coordinate3d[i][3];

            coord3dpol[2][i][0] = coordinate3d[i][0];
            coord3dpol[2][i][1] = coordinate3d[i][2];
            coord3dpol[2][i][2] = coordinate3d[i][3];

            coord3dpol[3][i][0] = coordinate3d[i][0];
            coord3dpol[3][i][1] = coordinate3d[i][1];
            coord3dpol[3][i][2] = coordinate3d[i][3];
        }
        return coord3dpol;
    }
}
