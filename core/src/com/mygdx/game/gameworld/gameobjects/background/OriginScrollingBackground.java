package com.mygdx.game.gameworld.gameobjects.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;

public class OriginScrollingBackground {

    private int scroll;
    private Array<Texture> layers;
    private final int LAYER_SPEED_DIFFERENCE = 2;
    private Sprite originalBack;

    float x, y, width, heigth, scaleX, scaleY;
    int originX, originY, rotation, srcX, srcY;
    boolean flipX, flipY;

    private double speed;

    public OriginScrollingBackground(Array<Texture> textures, Sprite background) {
        layers = textures;
        for (int i = 0; i < textures.size; i++) {
            layers.get(i).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }
        scroll = 0;
        speed = 0;

        this.originalBack = background;
        x = y = originX = originY = rotation = srcY = 0;
        width = Gdx.graphics.getWidth();
        heigth = Gdx.graphics.getHeight();
        scaleX = scaleY = 1;
        flipX = flipY = false;
    }

    public void setSpeed(double newSpeed) {
        this.speed = newSpeed;
    }


    public void draw(Batch batch) {
        originalBack.draw(batch);
        scroll += speed;
        for (int i = 0; i < layers.size; i++) {
            srcX = scroll + i * this.LAYER_SPEED_DIFFERENCE * scroll;
            batch.draw(layers.get(i), x, y, originX, originY, width, heigth, scaleX, scaleY, rotation, srcX, srcY, layers.get(i).getWidth(), layers.get(i).getHeight(), flipX, flipY);
        }
    }
}
