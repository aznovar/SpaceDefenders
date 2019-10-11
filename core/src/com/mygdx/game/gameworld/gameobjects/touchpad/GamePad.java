package com.mygdx.game.gameworld.gameobjects.touchpad;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.mygdx.game.gameworld.gameobjects.ship.PlayerShip;


/**
 * Created by Andrey Chelkanov(aznovar)
 */

/*TODO
Колян, нужно этот класс переделать в Screen класс и запускать его из класса типа Game,
предварительно создав его
 */
public class GamePad extends ApplicationAdapter {

    public Stage stage;
    public PlayerShip playerShip;
    public SpriteBatch batch;
    public Touchpad touchpad;
    public Texture touchpadBg, touchpadKonb, rocketSheet;
    Rectangle rocket;
    int ROCKET_SPEED = 5;
    public Animation<TextureRegion> rocketAnimation;
    float stateTime;
    public static int GENERAL_WIDTH = 480; // 480
    public static int GENERAL_HEIGHT = 720; // 720

    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();

        playerShip = new PlayerShip();
        rocket = playerShip.addRectangle();
        rocketAnimation = playerShip.setupAnimation();

        touchpad = new Pad().setupTouchpad();
        stage.addActor(touchpad);
    }

    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        TextureRegion RocketcurrentFrame = rocketAnimation.getKeyFrame(stateTime, true);
        update();
        batch.begin();
        batch.draw(RocketcurrentFrame, rocket.x, rocket.y, rocket.width, rocket.height);

        batch.end();
        stage.act();
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }


    public void update() {
        if (touchpad.isTouched() && rocket.x >= 0 && rocket.x <= Gdx.graphics.getWidth() - rocket.width) {
            rocket.x += touchpad.getKnobPercentX() * ROCKET_SPEED;
        } else if (rocket.x < 0) {
            rocket.x = 0;
        } else if (rocket.x > Gdx.graphics.getWidth() - rocket.width) {
            rocket.x = Gdx.graphics.getWidth() - rocket.width;
        }

        if (touchpad.isTouched() && rocket.y >= 0 && rocket.y <= Gdx.graphics.getHeight() - rocket.height) {
            rocket.y += touchpad.getKnobPercentY() * ROCKET_SPEED;
        } else if (rocket.y < 0) {
            rocket.y = 0;
        } else if (rocket.y > Gdx.graphics.getHeight() - rocket.height) {
            rocket.y = Gdx.graphics.getHeight() - rocket.height;
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
