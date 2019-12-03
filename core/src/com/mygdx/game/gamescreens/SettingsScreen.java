package com.mygdx.game.gamescreens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.Assets;
import com.mygdx.game.gameworld.gameobjects.background.NewScrollingBackground;
import com.mygdx.game.gameworld.gameobjects.background.ObjectHandler;
import com.mygdx.game.gameworld.gameobjects.background.ScrollingBackground;
import com.mygdx.game.gameworld.gui.InitCheckBox;
import com.mygdx.game.gameworld.gui.SettingsUIFragment;

import java.util.List;

public class SettingsScreen extends ScreenAdapter {

    public MyGdxGame game;
    private SpriteBatch batch;
    private Sprite background;
    private Stage stage;
    private ScrollingBackground scrBack;
    private List<ObjectHandler> sprites;
    private NewScrollingBackground newScrBack;

    public SettingsScreen(MyGdxGame game) {
        this.game = game;
        batch = new SpriteBatch();
        stage = new Stage(new ScreenViewport());
        //TODO перенести эту хуйню куда-нибудь ну че за пиздец Андрюха, ебана рот
        InitCheckBox initCheckBox = new InitCheckBox();
        Button button = initCheckBox.init();

        Table settingsScreenTable = addTableOnScreen(button);
        stage.addActor(settingsScreenTable);
        Gdx.input.setInputProcessor(stage);

        Array<Texture> textures = new Array<>();
        for (int i = 1; i <= 7; i++) {
            textures.add(new Texture(Gdx.files.internal("parallax/back_bright_000" + i + "_planet" + i + ".png")));
            textures.get(textures.size - 1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }
        background = new Sprite(Assets.manager.get(Assets.backForSettings, Texture.class));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        newScrBack = new NewScrollingBackground(textures, background);
        newScrBack.setSpeed(1);
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

    private Table addTableOnScreen(Button button) {
        SettingsUIFragment settingsUIFragment = new SettingsUIFragment();
        Table table = settingsUIFragment.createTableLikeBackground(button, game);
        settingsUIFragment.createTableForFields();
        return table;
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
