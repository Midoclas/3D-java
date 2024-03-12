package view.component;

import Class.Context;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColorComponent {

    private int margin, dim;
    private Grid grid;
    private List<JButton> btnList = new ArrayList<>();
    private Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    public Context context = Context.getInstance();

    public ColorComponent(Grid grid, int margin, int dim) {
        this.margin = margin;
        this.dim = dim;
        this.grid = grid;
        init();
    }

    private void init() {
        JButton redButton = new JButton();
        redButton.setBackground(Color.red);
        redButton.addActionListener(e -> context.setColor(Color.red));
        btnList.add(redButton);

        JButton blueButton = new JButton();
        blueButton.setBackground(Color.blue);
        blueButton.addActionListener(e -> context.setColor(Color.blue));
        btnList.add(blueButton);

        JButton greenButton = new JButton();
        greenButton.setBackground(Color.green);
        greenButton.addActionListener(e -> context.setColor(Color.green));
        btnList.add(greenButton);

        for (JButton btn: btnList) {
            grid.add(btn);
        }
    }
}
