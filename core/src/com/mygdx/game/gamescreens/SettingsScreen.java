package com.mygdx.game.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.MyGdxGame;

public class SettingsScreen extends ScreenAdapter {

    public MyGdxGame game;
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;
    private TextureRegion textureRegion;

    public SettingsScreen() {
        batch = new SpriteBatch();
        textureAtlas = new TextureAtlas("atlas-directory/hhh.atlas");
        textureRegion = textureAtlas.findRegion("settings_0008_window2");
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(textureRegion,768.0f/3f,70.0f,1660,1010);
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
