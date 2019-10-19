package com.mygdx.game.gameScreens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.assets.Assets;
import com.mygdx.game.gameworld.gameobjects.touchpad.GamePad;

import static com.mygdx.game.MyGdxGame.SCALE_FACTOR;

public class MenuScreen extends ScreenAdapter {

    public MyGdxGame game;
    private Table menuTable;
    private Stage stageForMenu;
    private Button buttonForMenu;
    private SpriteBatch batch;
    private Skin skin;
    private TextButton playButton;

    public MenuScreen(MyGdxGame myGdxGame) {
        this.game = myGdxGame;
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
                game.setScreen(new GamePad());//TODO переделать GamePad в игровой экран
            }
        });
    }
}
