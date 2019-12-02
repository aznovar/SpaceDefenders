package com.mygdx.game.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.Assets;
import com.mygdx.game.gameworld.gameobjects.ship.PlayerShip;
import com.mygdx.game.gameworld.gameobjects.touchpad.Pad;

import javax.activation.MailcapCommandMap;

import sun.audio.AudioPlayer;

public class GameScreen extends ScreenAdapter  {


    private static float SCALE_FACTOR;
    public static int GENERAL_WIDTH = 480; // 480
    public static int GENERAL_HEIGHT = 720; // 720
    MyGdxGame game;
    private Stage stage;
    private PlayerShip playerShip;
    private SpriteBatch batch;
    //    public Touchpad touchpad;
    public Texture touchpadBg, touchpadKonb, rocketSheet;
    Rectangle rocket;
    int ROCKET_SPEED = 100;
    public Animation<TextureRegion> rocketAnimation;
    float stateTime;
    private Controller controller;
    private ImageButton pauseBtnUp;
    private Skin skin;
    private Table pauseTable;
    private Stage stageForGame;




    public GameScreen(MyGdxGame newGame) {
        SCALE_FACTOR = (100 / (720 * 100 / (float) Math.max(GENERAL_HEIGHT, GENERAL_WIDTH)) + 100 / (480 * 100 / (float) Math.min(GENERAL_HEIGHT, GENERAL_WIDTH))) / 2;

        this.game = newGame;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        pauseBtnUp = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.pauseBtnUp, Texture.class))));
        pauseBtnUp.getImage().setScale(SCALE_FACTOR);
        pauseBtnUp.setTransform(true);
        pauseBtnUp.setRotation(90);


        playerShip = new PlayerShip();
        rocket = playerShip.addRectangle();
        rocketAnimation = playerShip.setupAnimation();
        stageForGame = new Stage(new ScreenViewport());


        // Create Table for pause button
        pauseTable = new Table();
        pauseTable.setWidth(stage.getWidth());
        pauseTable.setWidth(stageForGame.getWidth());
        pauseTable.align(Align.left | Align.top);
        pauseTable.setPosition(75, 75);
        pauseTable.add(pauseBtnUp);
        Gdx.input.setInputProcessor(stageForGame);
//        stageForGame.addActor(playerShip);
        stageForGame.addActor(pauseTable);

//        touchpad = new Pad().setupTouchpad();
//        stage.addActor(touchpad);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
//        TextureRegion RocketcurrentFrame = rocketAnimation.getKeyFrame(stateTime, true);
//        update();
        batch.begin();
//        batch.draw(RocketcurrentFrame, rocket.x, rocket.y, rocket.width, rocket.height);
        playerShip.performInput(delta);
        playerShip.draw(batch,delta);
        batch.end();

        stageForGame.act(Gdx.graphics.getDeltaTime());
        stageForGame.draw();
//        pauseTable.draw();


//        stage.act();
//        stage.draw();




    }

    @Override
    public void resize(int width, int height) {
        Gdx.app.log("GameScreen", "resizing");


    }

    @Override
    public void pause() {
        Gdx.app.log("GameScreen", "pause called");


    }


    @Override
    public void resume() {
        Gdx.app.log("GameScreen", "resume called");
    }

    @Override
    public void hide() {
        Gdx.app.log("GameScreen", "hide called");
    }
    @Override
    public void dispose() {
        batch.dispose();
        rocketSheet.dispose();
//        touchpadBg.dispose();
//        touchpadKonb.dispose();
        stage.dispose();
    }




}


