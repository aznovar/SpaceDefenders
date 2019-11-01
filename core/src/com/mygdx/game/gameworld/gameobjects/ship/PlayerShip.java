package com.mygdx.game.gameworld.gameobjects.ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;


/**
 * Created by Andrey Chelkanov(aznovar)
 */
public class PlayerShip {

    Rectangle rocket;
    Texture rocketSheet;
    final int ROCKET_FRAME_COLS = 4, ROCKET_FRAME_ROWS = 1;
    private float x = Gdx.graphics.getWidth() - 300;
    private float y = Gdx.graphics.getHeight() / 2;
    private float newX, newY;
    private float speed = 400;
    private float preferredShipWidth = 100;
    private float preferredShipHeight = 100;
    private float stateTime;


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

    public void performInput(float deltaTime) {
        if (Gdx.input.isTouched()) {
            newX = Gdx.input.getX();
            newY = Gdx.input.getY();

            float xToGo, yToGo;

            xToGo = moveTowards(this.x, newX - Gdx.graphics.getWidth()/2, deltaTime * this.speed);
            yToGo = moveTowards(this.y, -newY + Gdx.graphics.getHeight() , deltaTime * this.speed);

            this.x = xToGo;
            this.y = yToGo;

               }
    }
    //todo отрегулировать движение
    public float moveTowards(float current, float target, float maxDelta) {
        if (Math.abs(target - current) <= maxDelta) {
            return target;
        }
        return current + Math.signum(target - current) * maxDelta;
    }

    public void draw(SpriteBatch batch, float delta) {
        stateTime += delta;
        batch.draw(setupAnimation().getKeyFrame(stateTime, true), this.x, this.y, this.preferredShipWidth, this.preferredShipHeight ,this.preferredShipWidth,this.preferredShipHeight,2,2,90f);
        //todo разобраться как ЭТО работает
    }
}
