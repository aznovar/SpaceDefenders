package com.mygdx.game.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.Assets;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.gameworld.gameobjects.background.ConfigureBackground;
import com.mygdx.game.gameworld.gameobjects.background.OriginScrollingBackground;

import com.mygdx.game.gameworld.gameobjects.ship.PlayerShip;
import com.mygdx.game.gameworld.gui.Const;


public class GameScreen extends ScreenAdapter {


    private static float SCALE_FACTOR;
    public static int GENERAL_WIDTH = 480; // 480
    public static int GENERAL_HEIGHT = 720; // 720
    MyGdxGame game;
    private Stage stage;
    private PlayerShip playerShip;
    private SpriteBatch batch;
    public Texture rocketSheet;
    Rectangle rocket;
    public Animation<TextureRegion> rocketAnimation;
    private ImageButton pauseBtnUp;
    private Skin skin;
    private Table pauseTable;
    private Stage stageForGame;
    private Sprite background;
    private OriginScrollingBackground newScrBack;


    public GameScreen(MyGdxGame newGame) {
        this.game = newGame;
        stage = new Stage();
        setupGameScreen();

//        touchpad = new Pad().setupTouchpad();
//        stage.addActor(touchpad);
    }

    private void setupGameScreen() {
        SCALE_FACTOR = (100 / (720 * 100 / (float) Math.max(GENERAL_HEIGHT, GENERAL_WIDTH)) + 100 / (480 * 100 / (float) Math.min(GENERAL_HEIGHT, GENERAL_WIDTH))) / 2;

        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        pauseBtnUp = new ImageButton(new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.pauseBtnUp, Texture.class))));
        pauseBtnUp.getImage().setScale(SCALE_FACTOR * 2);
        pauseBtnUp.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                batch.dispose();
                game.setScreen(new MenuScreen(game));
            }
        });

        newScrBack = ConfigureBackground.createScrollingBackground(Assets.backForSettings, Const.GAMEPARALLAX, 4);
        playerShip = new PlayerShip();
        rocket = playerShip.addRectangle();
        rocketAnimation = playerShip.setupAnimation();
        stageForGame = new Stage(new ScreenViewport());


        // Create Table for pause button
        pauseTable = new Table();
        pauseTable.setWidth(stage.getWidth());
        pauseTable.setWidth(stageForGame.getWidth());
        pauseTable.align(Align.right | Align.center);
        pauseTable.setPosition(-100, Gdx.graphics.getHeight() - 100);
        pauseTable.add(pauseBtnUp);
        Gdx.input.setInputProcessor(stageForGame);
//        stageForGame.addActor(playerShip);
        stageForGame.addActor(pauseTable);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
//        TextureRegion RocketcurrentFrame = rocketAnimation.getKeyFrame(stateTime, true);
//        update();
        batch.begin();
//        batch.draw(RocketcurrentFrame, rocket.x, rocket.y, rocket.width, rocket.height);
        newScrBack.draw(batch);
        playerShip.performInput(delta);
        playerShip.draw(batch, delta);
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


