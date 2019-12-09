package com.mygdx.game;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.assets.Assets;
import com.mygdx.game.gamescreens.MenuScreen;

public class MyGdxGame extends Game {
    private SpriteBatch batch;
    public static Application.ApplicationType applicationType;
    public static int GENERAL_WIDTH = 480; // 480
    public static int GENERAL_HEIGHT = 720; // 720
    public static float SCALE_FACTOR;
    public static float SCALE_X;
    public static float SCALE_Y;

    @Override
    public void create() {
        batch = new SpriteBatch();
        loadAssets();
        applicationType = Gdx.app.getType();
        GENERAL_WIDTH = Gdx.graphics.getWidth();
        GENERAL_HEIGHT = Gdx.graphics.getHeight();
        SCALE_FACTOR = (100 / (720 * 100 / (float) Math.max(GENERAL_HEIGHT, GENERAL_WIDTH)) + 100 / (480 * 100 / (float) Math.min(GENERAL_HEIGHT, GENERAL_WIDTH))) / 2;
        SCALE_X = 100 / (480 * 100 / (float) GENERAL_WIDTH);
        SCALE_Y = 100 / (720 * 100 / (float) GENERAL_HEIGHT);
        this.setScreen(new MenuScreen(this));
    }

    @Override
    public void dispose() {
        batch.dispose();
        Assets.dispose();
    }

    void loadAssets() {
        Assets.manager = new AssetManager();
        Assets.loadSkin();
        Assets.loadBackground();
        Assets.loadPauseButton();
        Assets.manager.finishLoading();
    }
}

