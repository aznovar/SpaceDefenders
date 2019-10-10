package com.mygdx.game.gameworld.gameobjects.touchpad;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.mygdx.game.gameworld.gameobjects.ship.PlayerShip;


/**
 * Created by Andrey Chelkanov(aznovar)
 */
public class GamePad extends ApplicationAdapter {

    public Stage stage;
    public PlayerShip playerShip;
    public SpriteBatch batch;
    public Touchpad touchpad;
    public Texture bg1, bg2, touchpadBg, touchpadKonb, rocketSheet;
    public TextureRegionDrawable padBG, padKnob;
    public Touchpad.TouchpadStyle touchpadStyle;
    final int ROCKET_FRAME_COLS = 4, ROCKET_FRAME_ROWS = 1,
            ASTEROID_FRAME_COLS = 8, ASTEROID_FRAME_ROWS = 1,
            START = 0, RUNING = 1, GAME_OVER = 2;
    public Rectangle Rocket;
    int ROCKET_SPEED = 5;
    public Animation<TextureRegion> rocketAnimation, asteroidAAnimation;
    float yMax, yCoordBg1, yCoordBg2, stateTime, lastAsteroid_time;


    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();

        playerShip = new PlayerShip();

        touchpadBg = new Texture("touchpad_bg.png");
        touchpadKonb = new Texture("touchpad_knob.png");
        padBG = new TextureRegionDrawable(touchpadBg);
        padKnob = new TextureRegionDrawable(touchpadKonb);
        touchpadStyle = new Touchpad.TouchpadStyle(padBG, padKnob);
        touchpad = new Touchpad(20f, touchpadStyle);
        touchpad.setBounds(Gdx.graphics.getWidth() / 2 - 75, Gdx.graphics.getHeight() / 10 - 75, 150, 150);
        stage.addActor(touchpad);
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        TextureRegion RocketcurrentFrame = rocketAnimation.getKeyFrame(stateTime, true);
        update();
        batch.begin();
        batch.draw(RocketcurrentFrame, Rocket.x, Rocket.y, Rocket.width, Rocket.height);
        batch.end();
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }


    public void update() {
        if (touchpad.isTouched() && playerShip.addRectangle().x >= 0 && playerShip.addRectangle().x <= Gdx.graphics.getWidth() - playerShip.addRectangle().width) {
            playerShip.addRectangle().x += touchpad.getKnobPercentX() * ROCKET_SPEED;
        } else if (playerShip.addRectangle().x < 0) {
            playerShip.addRectangle().x = 0;
        } else if (playerShip.addRectangle().x > Gdx.graphics.getWidth() - playerShip.addRectangle().width) {
            playerShip.addRectangle().x = Gdx.graphics.getWidth() - playerShip.addRectangle().width;
        }

        if (touchpad.isTouched() && playerShip.addRectangle().y >= 0 && playerShip.addRectangle().y <= Gdx.graphics.getHeight() - playerShip.addRectangle().height) {
            playerShip.addRectangle().y += touchpad.getKnobPercentY() * ROCKET_SPEED;
        } else if (Rocket.y < 0) {
            playerShip.addRectangle().y = 0;
        } else if (playerShip.addRectangle().y > Gdx.graphics.getHeight() - playerShip.addRectangle().height) {
            playerShip.addRectangle().y = Gdx.graphics.getHeight() - playerShip.addRectangle().height;
        }

    }

    public void dispose() {
        batch.dispose();
        rocketSheet.dispose();
        touchpadBg.dispose();
        touchpadKonb.dispose();
        stage.dispose();
//        touchpadBg.dispose();
//        touchpadKonb.dispose();
    }

}
