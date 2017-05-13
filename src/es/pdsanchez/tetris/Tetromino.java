/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pdsanchez.tetris;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import static es.pdsanchez.tetris.TetrisApp.TILE_SIZE;

/**
 *
 * @author pdsanchez
 */
class Tetromino {
    public int x;
    public int y;
    public Color color;
    
    public List<Piece> pieces;
    
    public Tetromino(Color color, Piece... pieces) {
        this.color = color;
        this.pieces = new ArrayList<>(Arrays.asList(pieces));
        
        for(Piece piece: this.pieces) {
            piece.setParent(this);
        }
    }
    
    public void move(int dx, int dy) {
        y += dx;
        y += dy;
        
        pieces.forEach(p -> {
            p.x += dx;
            p.y += dy;
        });
    }
    
    public void move(Direction direction) {
        move(direction.x, direction.y);
    }
    
    public void draw(GraphicsContext g) {
        g.setFill(color);
        
        pieces.forEach(p -> g.fillRect(p.x * TILE_SIZE, p.y * TILE_SIZE, TILE_SIZE, TILE_SIZE));
    }
    
    public void rotateBack() {
        pieces.forEach(p -> p.setDirection(p.direction.prev()));
    }
    
    public void rotate() {
        pieces.forEach(p -> p.setDirection(p.direction.next()));
    }
    
    public void detach(int x, int y) {
        pieces.removeIf(p -> p.x == x && p.y == y);
    }
    
    public Tetromino copy() {
        return new Tetromino(color, pieces.stream().map(Piece::copy).collect(Collectors.toList()).toArray(new Piece[0]));
    }
}
