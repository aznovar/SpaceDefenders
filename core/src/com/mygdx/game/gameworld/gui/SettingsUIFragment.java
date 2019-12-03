package com.mygdx.game.gameworld.gui;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.gamescreens.GameScreen;
import com.mygdx.game.gamescreens.MenuScreen;

/**
 * The class intended for fine tuning of the UI element - Settings
 * Location, shape, size - all this is set up in this class for further use
 * on demand in specific screens
 */
public class SettingsUIFragment implements OriginTableInterface {

    private static final Float PERCENT_OF_WIDTH = Gdx.graphics.getWidth() / 0.6f;
    private static final Float PERCENT_OF_HEIGHT = Gdx.graphics.getHeight() / 0.6f;

    @Override
    public Table createTableLikeBackground(Button button, MyGdxGame game) {
        Table settingsBackgroundTable = new Table();
        SettingsImage settingsImage = new SettingsImage();
        Image background = settingsImage.initBackground();
        settingsBackgroundTable.add(background).width(PERCENT_OF_WIDTH).height(PERCENT_OF_HEIGHT).expand().bottom();
        settingsBackgroundTable.row();
        settingsBackgroundTable.add(createTableForCheckBoxes(button)).padTop(PERCENT_OF_HEIGHT / -0.88f);
        settingsBackgroundTable.row();
        settingsBackgroundTable.add(createTableForFields()).padTop(PERCENT_OF_HEIGHT / -1.1f);
        settingsBackgroundTable.row();
        settingsBackgroundTable.add(createTableForButtons(game)).expand().padTop(PERCENT_OF_HEIGHT / -1.5f);
        // settingsBackgroundTable.setDebug(true);
        // settingsBackgroundTable.debugActor();
        settingsBackgroundTable.setFillParent(true);
        return settingsBackgroundTable;
    }

    @Override
    public Table createTableForFields() {
        Table settingsFieldsTable = new Table();
        SettingsImage settingsImage = new SettingsImage();
        settingsFieldsTable.add(settingsImage.initImageForField().get(1)).width(220).height(50).padRight(25).spaceBottom(50);
        settingsFieldsTable.add(initSlider()).width(550).spaceBottom(50);
        settingsFieldsTable.row();
        settingsFieldsTable.add(settingsImage.initImageForField().get(2)).width(220).height(50).padRight(25);
        settingsFieldsTable.add(initSlider()).width(550).height(70);
        //  settingsFieldsTable.setDebug(true);
        return settingsFieldsTable;
    }

    @Override
    public Table createTableForButtons(MyGdxGame game) {
        Table settingsButtonSaveTable = new Table();
        settingsButtonSaveTable.add(initSaveButton()).width(200).height(100).padRight(25);
        settingsButtonSaveTable.add(initBackButton(game)).width(200).height(100).padRight(25);
        //settingsButtonSaveTable.setDebug(true);
        return settingsButtonSaveTable;
    }

    public Table createTableForCheckBoxes(Button button) {
        InitCheckBox buttonTwo = new InitCheckBox();
        Table checkBoxesTable = new Table();
        SettingsImage settingsImage = new SettingsImage();
        checkBoxesTable.add(button).width(65).height(60);
        checkBoxesTable.add(settingsImage.initImageForCheckBoxesArea().get(1)).width(300).height(60).padLeft(15);
        checkBoxesTable.add(buttonTwo.init()).width(65).height(60).padLeft(150);
        checkBoxesTable.add(settingsImage.initImageForCheckBoxesArea().get(2)).width(300).height(60).padLeft(15);
        // checkBoxesTable.setDebug(true);
        return checkBoxesTable;
    }

    private Container<Slider> initSlider() {
        TextureAtlas textureAtlas = new TextureAtlas(Const.SLIDER_DIRECTORY);
        Skin testSkin = new Skin(textureAtlas);
        Slider.SliderStyle styleOfSlider = new Slider.SliderStyle();
        styleOfSlider.background = testSkin.getDrawable(Const.FIELD_FOR_SETTINGS_TABLE);
        styleOfSlider.knob = testSkin.getDrawable(Const.KNOB);
        styleOfSlider.knobBefore = testSkin.getDrawable(Const.FILLER);
        Slider slider = new Slider(0, 100, 1, false, styleOfSlider);
        slider.getStyle().background.setMinHeight(70);
        slider.getStyle().knob.setMinHeight(85);
        slider.getStyle().knobBefore.setMinHeight(70);
        Container<Slider> contOfSl = new Container<>(slider);
        contOfSl.setTransform(true);
        contOfSl.size(550, 70);
        return contOfSl;
    }

    private Button initSaveButton() {
        TextureAtlas textureAtlas = new TextureAtlas(Const.SAVE_BUTTON_WITH_TEXT);
        Skin testSkin = new Skin(textureAtlas);
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = testSkin.getDrawable(Const.SAVE_BUTTON_UNPR_TEXT);
        style.down = testSkin.getDrawable(Const.SAVE_BUTTON_PR_TEXT);
        Button testB = new Button(style);
        testB.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        return testB;
    }

    private Button initBackButton(MyGdxGame game) {
        TextureAtlas textureAtlas = new TextureAtlas(Const.BACK_BUTTON_WITH_TEXT);
        Skin testSkin = new Skin(textureAtlas);
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = testSkin.getDrawable(Const.BACK_BUTTON_UNPR_TEXT);
        style.down = testSkin.getDrawable(Const.BACK_BUTTON_PR_TEXT);
        Button testB = new Button(style);
        testB.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button)
            {
                game.setScreen(new MenuScreen(game));
                return true;
            }
        });
        return testB;
    }
}

