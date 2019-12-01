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
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.Assets;
import com.mygdx.game.gameworld.gameobjects.background.NewScrollingBackground;
import com.mygdx.game.gameworld.gameobjects.ship.PlayerShip;



public class GameScreen extends ScreenAdapter  {


    MyGdxGame game;
    public Stage stage;
    public PlayerShip playerShip;
    public SpriteBatch batch;
    //    public Touchpad touchpad;
    public Texture touchpadBg, touchpadKonb, rocketSheet;
    Rectangle rocket;
    int ROCKET_SPEED = 100;
    public Animation<TextureRegion> rocketAnimation;
    float stateTime;
    private Controller controller;
    private Sprite background;
    private NewScrollingBackground newScrBack;

    public GameScreen(MyGdxGame newGame) {
        this.game = newGame;
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();

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
        newScrBack.draw(batch);
        playerShip.performInput(delta);
        playerShip.draw(batch,delta);


        batch.end();
        stage.act();
        stage.draw();




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


