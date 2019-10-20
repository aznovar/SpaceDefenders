package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.gameScreens.GameScreen;

public class MyGdxGame extends Game {
    SpriteBatch batch;
    Texture img;
    public static int GENERAL_HEIGHT = 720; // 720
    public static float SCALE_FACTOR;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }

}

