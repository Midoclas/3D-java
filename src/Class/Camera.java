package Class;

public class Camera {

    public int x,y,z,areax,areay,areaz;
    public double ax,ay,az;
    private static Camera instance;

    public Camera(int x, int y, int z, double ax, double ay, double az, int areax, int areay, int areaz) {

        this.x = x;
        this.y = y;
        this.z = z;
        this.ax = ax;
        this.ay = ay;
        this.az = az;
        this.areax = areax;
        this.areay = areay;
        this.areaz = areaz;
        instance = this;
    }

    public static Camera getInstance() {
        if (instance == null) {
            instance = new Camera(0,0,0,0,0,0,0,0,50);
        }
        return instance;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public void setAz(double az) {
        this.az = az;
    }

    public void setAreax(int areax) {
        this.areax = areax;
    }

    public void setAreay(int areay) {
        this.areay = areay;
    }

    public void setAreaz(int areaz) {
        this.areaz = areaz;
    }
}
