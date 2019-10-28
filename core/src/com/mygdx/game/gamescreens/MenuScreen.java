package com.mygdx.game.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.Assets;

import static com.mygdx.game.MyGdxGame.SCALE_FACTOR;

public class MenuScreen extends ScreenAdapter {

    public MyGdxGame game;
    private Table menuTable;
    private Stage stageForMenu;
    private SpriteBatch batch;
    private Skin skin;
    private TextButton playButton;

    public MenuScreen(MyGdxGame newGame) {
        this.game = newGame;
        setupScreen();
    }


    private void setupScreen() {
        batch = new SpriteBatch();

        skin = Assets.manager.get(Assets.uiskin, Skin.class);
        stageForMenu = new Stage(new ScreenViewport());

        menuTable = new Table();
        menuTable.setWidth(stageForMenu.getWidth());
        menuTable.align(Align.center | Align.top);
        menuTable.setPosition(0, MyGdxGame.GENERAL_HEIGHT);

        playButton = new TextButton("Play", skin);

        playButton.getLabel().setFontScale(2.2f * SCALE_FACTOR);
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                batch.dispose();
                game.setScreen(new GameScreen(game));
            }
        });

        menuTable.padTop(100 * SCALE_FACTOR);
        menuTable.add(playButton).padBottom(48 * SCALE_FACTOR);
        stageForMenu.addActor(menuTable);
        Gdx.input.setInputProcessor(stageForMenu);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stageForMenu.act(Gdx.graphics.getDeltaTime());
        stageForMenu.draw();
    }

    @Override
    public void dispose() {
        stageForMenu.dispose();
        skin.dispose();
        batch.dispose();
    }
}
