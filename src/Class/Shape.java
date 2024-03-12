package Class;

public class Shape {

    private static Camera camera;
    private int[][] coordinate3d;

    public void calc3dCoordinate(int[][] coordinate) {
        this.coordinate3d = new int[2][coordinate.length];
        camera = Camera.getInstance();
        for (int i=0; i<coordinate.length; i++) {
            double dx = Math.cos(camera.ay) * (Math.sin(camera.az) * (coordinate[i][1] - camera.y) + Math.cos(camera.az) * (coordinate[i][0] - camera.x)) - Math.sin(camera.ay) * (coordinate[i][2] - camera.z);
            double dy = Math.sin(camera.ax) * (Math.cos(camera.ay) * (coordinate[i][2] - camera.z) + Math.sin(camera.ay) * (Math.sin(camera.az) * (coordinate[i][1] - camera.y) + Math.cos(camera.az) * (coordinate[i][0] - camera.x))) + Math.cos(camera.ax) * (Math.cos(camera.az) * (coordinate[i][1] - camera.y) - Math.sin(camera.az) * (coordinate[i][0] - camera.x));
            double dz = Math.cos(camera.ax) * (Math.cos(camera.ay) * (coordinate[i][2] - camera.z) + Math.sin(camera.ay) * (Math.sin(camera.az) * (coordinate[i][1] - camera.y) + Math.cos(camera.az) * (coordinate[i][0] - camera.x))) - Math.sin(camera.ax) * (Math.cos(camera.az) * (coordinate[i][1] - camera.y) - Math.sin(camera.az) * (coordinate[i][0] - camera.x));

            this.coordinate3d[0][i] = (int)((camera.areaz / dz) * dx + camera.areax);
            this.coordinate3d[1][i] = (int)((camera.areaz / dz) * dy + camera.areay);
        }
    }

    public int[][] get3dCoordinate() {
        return this.coordinate3d;
    }
}
