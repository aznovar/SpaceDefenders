package com.mygdx.game.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.Assets;
import com.mygdx.game.gameworld.gameobjects.background.ConfigureBackground;
import com.mygdx.game.gameworld.gameobjects.background.OriginScrollingBackground;
import com.mygdx.game.gameworld.gui.Const;
import com.mygdx.game.gameworld.gui.OriginTableInterface;
import com.mygdx.game.gameworld.gui.SettingsUIFragment;

public class SettingsScreen extends ScreenAdapter {

    public MyGdxGame game;
    private SpriteBatch batch;
    private Sprite background;
    private Stage stage;
    private OriginScrollingBackground newScrBack;

    public SettingsScreen(MyGdxGame game) {
        this.game = game;
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        Table settingsScreenTable = addTableOnScreen();
        stage.addActor(settingsScreenTable);
        Gdx.input.setInputProcessor(stage);
        newScrBack = ConfigureBackground.createScrollingBackground(Assets.backForSettings, Const.MAINPARALLAX, 7);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        newScrBack.draw(batch);
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    private Table addTableOnScreen() {
        OriginTableInterface settingsUIFragment = new SettingsUIFragment();
        Table table = settingsUIFragment.createTableLikeBackground(game);
       // settingsUIFragment.createTableForSliderFields();
        return table;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
