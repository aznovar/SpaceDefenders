package com.mygdx.game.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.gui.SettingsUIFragment;

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
        batch.draw(textureRegion,64.0f,64.0f,textureRegion.getRegionWidth(),textureRegion.getRegionHeight());
        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
