package view;

import Class.geometry.Cube;
import view.component.Grid;
import Class.Context;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import Class.Camera;

public class Layout implements KeyListener, MouseWheelListener, MouseListener, MouseMotionListener {

    private JFrame container;
    private Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
    private Camera camera;
    public Grid grid;
    private boolean rotation = false;
    private int previousX, previousY, btnClick;

    public Layout(Grid grid) {
        new Camera(0,0,40,0,0,0, winSize.width/2, winSize.height/2, 40);
        container = new JFrame("3D Constructor");
        container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container.addKeyListener(this);
        container.addMouseWheelListener(this);
        container.addMouseListener(this);
        container.addMouseMotionListener(this);
        container.pack();
        container.setSize(winSize.width, winSize.height);
        container.setContentPane(grid);
        container.setVisible(true);
        camera = Camera.getInstance();
        this.grid = grid;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        if (keycode == KeyEvent.VK_Q) {
            if (!rotation) {
                camera.setX(camera.x - 2);
            } else {
                camera.setAy(camera.ay - 0.01);
            }
        }
        if (keycode == KeyEvent.VK_Z) {
            if (!rotation) {
                camera.setY(camera.y - 2);
            } else {
                camera.setAx(camera.ax - 0.01);
            }
        }
        if (keycode == KeyEvent.VK_D) {
            if (!rotation) {
                camera.setX(camera.x + 2);
            } else {
                camera.setAy(camera.ay + 0.01);
            }
        }
        if (keycode == KeyEvent.VK_S) {
            if (!rotation) {
                camera.setY(camera.y + 2);
            } else {
                camera.setAx(camera.ax + 0.01);
            }
        }
        if (keycode == KeyEvent.VK_LEFT) {
            camera.setAreax(camera.areax - 5);
        }
        if (keycode == KeyEvent.VK_UP) {
            camera.setAreay(camera.areay - 5);
        }
        if (keycode == KeyEvent.VK_RIGHT) {
            camera.setAreax(camera.areax + 5);
        }
        if (keycode == KeyEvent.VK_DOWN) {
            camera.setAreay(camera.areay + 5);
        }
        if (keycode == KeyEvent.VK_R) {
            this.rotation = !this.rotation;
        }

        container.getContentPane().repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        int notches = e.getWheelRotation();
        if (notches < 0) {
            camera.setZ(camera.z+1);
        } else {
            camera.setZ(camera.z-1);
        }
        container.getContentPane().repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point coord = e.getPoint();
        grid.create(new Cube(coord.x+camera.x-camera.areax, coord.y+camera.y-camera.areay, 46,50,true, true, Context.getColor()));
    }

    @Override
    public void mousePressed(MouseEvent e) {
    	this.previousX = e.getX();
		this.previousY = e.getY();
		this.btnClick = e.getButton();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    	
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
    	if (this.btnClick == MouseEvent.BUTTON3) {
    		camera.setX(camera.x - (e.getX() - this.previousX));
    		camera.setY(camera.y - (e.getY() - this.previousY));
    		this.previousX = e.getX();
    		this.previousY = e.getY();
    		grid.repaint();
    	}
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point coord = e.getPoint();
        grid.previsualize(new Cube(coord.x+camera.x-camera.areax, coord.y+camera.y-camera.areay, 46,50,false, false, Context.getColor()));
    }
}