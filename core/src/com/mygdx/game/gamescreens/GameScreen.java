package com.mygdx.game.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.controllers.Controller;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.Assets;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.Assets;
import com.mygdx.game.gameworld.gameobjects.background.NewScrollingBackground;

import com.mygdx.game.gameworld.gameobjects.ship.PlayerShip;



public class GameScreen extends ScreenAdapter  {


    private static float SCALE_FACTOR;
    public static int GENERAL_WIDTH = 480; // 480
    public static int GENERAL_HEIGHT = 720; // 720
    MyGdxGame game;
    private Stage stage;
    private PlayerShip playerShip;
    private SpriteBatch batch;
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
    private Sprite background;
    private NewScrollingBackground newScrBack;


    public GameScreen(MyGdxGame newGame) {
        this.game = newGame;
        stage = new Stage();
        SetupGameScreen();

//        touchpad = new Pad().setupTouchpad();
//        stage.addActor(touchpad);
    }

    private void SetupGameScreen() {
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

        //TODO вынести scroll back в отдельный класс! Не забудь, ебана, а то повторов куча, пидор, сука
        Array<Texture> textures = new Array<>();
        for(int i = 1; i <=4;i++){
            textures.add(new Texture(Gdx.files.internal("parallax/img"+i+".png")));
            textures.get(textures.size-1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }
        background = new Sprite(Assets.manager.get(Assets.backForSettings, Texture.class));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        newScrBack = new NewScrollingBackground(textures,background);
        newScrBack.setSpeed(1);
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


