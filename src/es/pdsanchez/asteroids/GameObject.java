/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pdsanchez.asteroids;

import javafx.geometry.Point2D;
import javafx.scene.Node;

/**
 *
 * @author pdsanchez
 */
public class GameObject {
    private static final int DEFAULT_ROTATION = 5;
    
    private Node view;
    private Point2D velocity;
    
    private boolean alive = true;
    
    public GameObject(Node view) {
        this.view = view;
        this.velocity = new Point2D(0, 0);
    }
    
    public void update() {
        view.setTranslateX(view.getTranslateX() + velocity.getX());
        view.setTranslateY(view.getTranslateY() + velocity.getY());
    }
    
    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    public boolean isDead() {
        return !alive;
    }

    public Point2D getVelocity() {
        return velocity;
    }

    public void setVelocity(Point2D velocity) {
        this.velocity = velocity;
    }

    public Node getView() {
        return view;
    }
    
    public double getRotate() {
        return view.getRotate();
    }
    
    public void rotateRight() {
        view.setRotate(view.getRotate() + DEFAULT_ROTATION);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
    }
    
    public void rotateLeft() {
        view.setRotate(view.getRotate() - DEFAULT_ROTATION);
        setVelocity(new Point2D(Math.cos(Math.toRadians(getRotate())), Math.sin(Math.toRadians(getRotate()))));
    }
    
    public boolean isColliding(GameObject other) {
        return view.getBoundsInParent().intersects(other.getView().getBoundsInParent());
    }
}
