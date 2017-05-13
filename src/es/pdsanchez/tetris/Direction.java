/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.pdsanchez.tetris;

/**
 *
 * @author pdsanchez
 */
public enum Direction {
    UP(0, -1),
    RIGHT(1, 0),
    DOWN(0, 1),
    LEFT(-1,0);
    
    int x, y;
    
    Direction(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public Direction prev() {
        int nextIdx = ordinal() - 1;
        
        if (nextIdx == -1) {
            nextIdx = Direction.values().length - 1;
        }
        
        return Direction.values()[nextIdx];
    }
    
    public Direction next() {
        int nextIdx = ordinal() + 1;
        
        if (nextIdx == Direction.values().length) {
            nextIdx = 0;
        }
        
        return Direction.values()[nextIdx];
    }
}
