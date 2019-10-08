package com.mygdx.game.gameworld.gameobjects.ship;

import com.badlogic.gdx.math.Vector2;

import lombok.Getter;

/**
 * Класс - образец, описывающий фигуру, которую добавим на экран
 */

@Getter
public class SimpleFigure {

    private Vector2 position;

    private int width;
    private int height;

    public SimpleFigure(float x, float y, int width, int height) {
        this.height = height;
        this.width = width;
        position = new Vector2(x, y);

    }


}
