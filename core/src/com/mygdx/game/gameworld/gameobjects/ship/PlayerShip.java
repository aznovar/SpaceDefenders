package com.mygdx.game.gameworld.gameobjects.ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class PlayerShip {

    Rectangle rocket;
    Texture rocketSheet;
    int ROCKET_SPEED = 5;
    final int ROCKET_FRAME_COLS = 4, ROCKET_FRAME_ROWS = 1;
    Animation<TextureRegion> rocketAnimation;

    public PlayerShip() {
        setupTexture();
    }


    private void setupTexture() {
        rocketSheet = new Texture("spaceShipSprite.png");
        TextureRegion[][] Rtmp = TextureRegion.split(rocketSheet,
                rocketSheet.getWidth() / ROCKET_FRAME_COLS,
                rocketSheet.getHeight() / ROCKET_FRAME_ROWS);
        TextureRegion[] RocketFrame = new TextureRegion[ROCKET_FRAME_COLS * ROCKET_FRAME_ROWS];
        int Rindex = 0;
        for (int i = 0; i < ROCKET_FRAME_ROWS; i++) {
            for (int j = 0; j < ROCKET_FRAME_COLS; j++) {
                RocketFrame[Rindex++] = Rtmp[i][j];
            }
        }
        rocketAnimation = new Animation<TextureRegion>(0.15f, RocketFrame);
    }

    public Rectangle addRectangle(){
        rocket = new Rectangle();
        rocket.x = Gdx.graphics.getWidth() / 2 - 50;
        rocket.y = Gdx.graphics.getHeight() / 6 - 75;
        rocket.setCenter(rocket.x, rocket.y);
        rocket.width = 100;
        rocket.height = 150;
        return rocket;
    }
}
