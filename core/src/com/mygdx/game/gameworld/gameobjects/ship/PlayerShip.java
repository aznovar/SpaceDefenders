package com.mygdx.game.gameworld.gameobjects.ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;


/**
 * Created by Andrey Chelkanov(aznovar)
 */
public class PlayerShip {

    Rectangle rocket;
    Texture rocketSheet;
    final int ROCKET_FRAME_COLS = 4, ROCKET_FRAME_ROWS = 1;

    public Animation<TextureRegion> setupAnimation() {
        TextureRegion[] rocketFrame = setupTexture();
        Animation<TextureRegion> textureRegionAnimation = new Animation<>(0.15f, rocketFrame);
        return textureRegionAnimation;
    }

    public Rectangle addRectangle() {
        rocket = new Rectangle();
        rocket.x = Gdx.graphics.getWidth() / 2 - 50;
        rocket.y = Gdx.graphics.getHeight() / 6 - 75;
        rocket.setCenter(rocket.x, rocket.y);
        rocket.width = 100;
        rocket.height = 150;
        return rocket;
    }

    private TextureRegion[] setupTexture() {
        rocketSheet = new Texture("spaceShipSprite.png");
        TextureRegion[][] Rtmp = TextureRegion.split(rocketSheet,
                rocketSheet.getWidth() / ROCKET_FRAME_COLS,
                rocketSheet.getHeight() / ROCKET_FRAME_ROWS);
        TextureRegion[] rocketFrame = new TextureRegion[ROCKET_FRAME_COLS * ROCKET_FRAME_ROWS];
        int Rindex = 0;
        for (int i = 0; i < ROCKET_FRAME_ROWS; i++) {
            for (int j = 0; j < ROCKET_FRAME_COLS; j++) {
                rocketFrame[Rindex++] = Rtmp[i][j];
            }
        }
        return rocketFrame;
    }
}
