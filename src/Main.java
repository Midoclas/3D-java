import view.Layout;
import view.component.Grid;
import Class.Context;

public class Main {

    private static Grid grid = new Grid();
    public static final Layout layout = new Layout(grid);


     public static void main(String[] args) {
         new Context();
    }
}
