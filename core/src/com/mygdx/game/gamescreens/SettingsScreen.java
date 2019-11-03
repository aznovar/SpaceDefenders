package com.mygdx.game.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.Assets;
import com.mygdx.game.assets.gui.SettingsUIFragment;

public class SettingsScreen extends ScreenAdapter {

    public MyGdxGame game;
    private SpriteBatch batch;
    private Sprite background;
    private Table settingsScreenTable;
    private Stage stage;

    public SettingsScreen(MyGdxGame game) {
        this.game = game;
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        settingsScreenTable = addTableOnScreen();
        stage.addActor(settingsScreenTable);
        background = new Sprite(Assets.manager.get(Assets.backforSettings,Texture.class));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
//        batch.draw(textureRegion,768.0f/3f,70.0f,1660,1010);
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    private Table addTableOnScreen(){
        SettingsUIFragment settingsUIFragment = new SettingsUIFragment();
        Table table = settingsUIFragment.createTableWithBackground();
        settingsUIFragment.addFieldForTable(table);
        return table;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
