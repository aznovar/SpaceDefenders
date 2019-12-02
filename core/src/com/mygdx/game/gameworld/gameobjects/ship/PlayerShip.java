package com.mygdx.game.gameworld.gameobjects.ship;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Andrey Chelkanov(aznovar)
 */
public class PlayerShip {

    private Rectangle rocket;
    private Texture rocketSheet;
    final static int ROCKET_FRAME_COLS = 4, ROCKET_FRAME_ROWS = 1;
    private float x = Gdx.graphics.getWidth() - 300;
    private float y = Gdx.graphics.getHeight() / 2;
    private float touchedX, touchedY, newX, newY;
    private float speed = 5000;
    private float preferredShipWidth = 100;
    private float preferredShipHeight = 100;
    private float stateTime;
//    private int[] coordToMoveX;
//    private int[] coordToMoveY;


    public Animation<TextureRegion> setupAnimation() {
        TextureRegion[] rocketFrame = setupTexture();
        return new Animation<>(0.15f, rocketFrame);
    }

    public Rectangle addRectangle() {
        rocket = new Rectangle();
        rocket.x = Gdx.graphics.getWidth() / 6 - 100;
        rocket.y = Gdx.graphics.getHeight() / 2 - 75;
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
        //todo понять почему корабль улетает вниз на свою высоту
    public void correctBounds() {
        // Top bounds
        if (this.x < 0 - this.preferredShipWidth )
            this.x = 0 - this.preferredShipWidth;
        // Bottom bounds
        if (this.x >  Gdx.graphics.getWidth() - this.preferredShipWidth)
            this.x =  Gdx.graphics.getWidth() - this.preferredShipWidth;
        // Left bounds
        if (this.y < 0)
            this.y = 0;
        // Right bounds
        if (this.y > Gdx.graphics.getHeight() - this.preferredShipHeight)
            this.y = Gdx.graphics.getHeight() - this.preferredShipHeight;
    }


//    private Vector2 lastTouch = new Vector2();
//
//
//    public Vector2 touchDragged(int screenX, int screenY) {
//
//        Vector2 newTouch = new Vector2(screenX, screenY);
//        // delta will now hold the difference between the last and the current touch positions
//        // delta.x > 0 means the touch moved to the right, delta.x < 0 means a move to the left
//        Vector2 delta = newTouch.cpy().sub(lastTouch);
//        lastTouch = newTouch;
//
//        return delta;
//
//
//    }

    public void performInput(float deltaTime) {
        float xToGo, yToGo;

        if (Gdx.input.isTouched()) {

            newX = this.x + Gdx.input.getDeltaX();
            newY = this.y - Gdx.input.getDeltaY();


//            if (coordToMoveX.size() < 2 || coordToMoveY.size() < 2) {
//                coordToMoveX.add(newX);
//                coordToMoveY.add(newY);
//            }


//
//            System.out.println("X COORD " + coordToMoveX);
//            System.out.println("Y COORD " + coordToMoveY);


//            if(Gdx.input.getX() == 0) {
//                newX = 1;
//            }
//            else if(Gdx.input.getX() == Gdx.graphics.getWidth() - this.preferredShipWidth) {
//                newX = Gdx.graphics.getWidth() - this.preferredShipWidth - 1;
//            }
//            if(Gdx.input.getY() == 0) {
//                newY = 1;
//            }
//            else if(Gdx.input.getY() == Gdx.graphics.getHeight() - this.preferredShipHeight) {
//                newY = Gdx.graphics.getHeight() - this.preferredShipHeight - 1;
//            }


            xToGo = moveTowards(this.x, newX, deltaTime * this.speed);
            yToGo = moveTowards(this.y, newY, deltaTime * this.speed);

            this.x = xToGo;
            this.y = yToGo;

            this.correctBounds();


        }

    }

    //todo отрегулировать движение
    private float moveTowards(float current, float target, float maxDelta) {
        if (Math.abs(target - current) <= maxDelta) {
            return target;
        }
        return current + Math.signum(target - current) * maxDelta;
    }

    public void draw(SpriteBatch batch, float delta) {
        stateTime += delta;
        batch.draw(setupAnimation().getKeyFrame(stateTime, true), this.x, this.y, this.preferredShipWidth, this.preferredShipHeight ,this.preferredShipWidth,this.preferredShipHeight,1,1,90f);
    }
}
