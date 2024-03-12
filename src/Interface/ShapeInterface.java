package Interface;

import java.awt.*;

public interface ShapeInterface {
    void setCoordinate();
    int[][] getCoordinate();
    void calc3dCoordinate(int[][] coordinate);
    void drawShape(Graphics g);
    int[][] get3dDrawPolygonCoordinate(int[][] coordinate3d);
    int[][][] get3dFillPolygonCoordinate(int[][] coordinate3d);
}
