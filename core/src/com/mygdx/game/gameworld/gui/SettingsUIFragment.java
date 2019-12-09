package com.mygdx.game.gameworld.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.gameworld.gameobjects.allbuttons.buttons.FunctionalityOfButtons;
import com.mygdx.game.gameworld.gameobjects.allbuttons.slider.FunctionalityOfSlider;

/**
 * The class intended for fine tuning of the UI element - Settings
 * Location, shape, size - all this is set up in this class for further use
 * on demand in specific screens
 */
public class SettingsUIFragment implements OriginTableInterface {

    private static final Float PERCENT_OF_WIDTH = Gdx.graphics.getWidth() / 0.6f;
    private static final Float PERCENT_OF_HEIGHT = Gdx.graphics.getHeight() / 0.6f;

    @Override
    public Table createTableLikeBackground(MyGdxGame game) {
        FunctionalityOfButtons functionalityOfButtons = new FunctionalityOfButtons();
        FunctionalityOfSlider functionalityOfSlider = new FunctionalityOfSlider();
        Table settingsBackgroundTable = new Table();
        settingsBackgroundTable.add(SettingsImage.initBackground()).width(PERCENT_OF_WIDTH).height(PERCENT_OF_HEIGHT).expand().bottom();
        settingsBackgroundTable.row();
        settingsBackgroundTable.add(createTableForCheckBoxes(functionalityOfButtons)).padTop(PERCENT_OF_HEIGHT / -0.88f);
        settingsBackgroundTable.row();
        settingsBackgroundTable.add(createTableForSliderFields(functionalityOfSlider)).padTop(PERCENT_OF_HEIGHT / -1.1f);
        settingsBackgroundTable.row();
        settingsBackgroundTable.add(createTableForButtons(game, functionalityOfButtons)).expand().padTop(PERCENT_OF_HEIGHT / -1.5f);
        settingsBackgroundTable.setFillParent(true);
        return settingsBackgroundTable;
    }

    @Override
    public Table createTableForSliderFields(FunctionalityOfSlider functionalityOfSlider) {
        Table settingsFieldsTable = new Table();
        settingsFieldsTable.add(SettingsImage.initImageForField().get(1)).width(220).height(50).padRight(25).spaceBottom(50);
        settingsFieldsTable.add(functionalityOfSlider.sliderForSettings()).width(550).spaceBottom(50);
        settingsFieldsTable.row();
        settingsFieldsTable.add(SettingsImage.initImageForField().get(2)).width(220).height(50).padRight(25);
        settingsFieldsTable.add(functionalityOfSlider.sliderForSettings()).width(550).height(70);
        return settingsFieldsTable;
    }

    @Override
    public Table createTableForButtons(MyGdxGame game, FunctionalityOfButtons button) {
        Table settingsButtonSaveTable = new Table();
        settingsButtonSaveTable.add(button.initSaveButton()).width(200).height(100).padRight(25);
        settingsButtonSaveTable.add(button.initBackButton(game)).width(200).height(100).padRight(25);
        return settingsButtonSaveTable;
    }

    private Table createTableForCheckBoxes(FunctionalityOfButtons button) {
        Table checkBoxesTable = new Table();
        checkBoxesTable.add(button.initCheckBox()).width(65).height(60);
        checkBoxesTable.add(SettingsImage.initImageForCheckBoxesArea().get(0)).width(300).height(60).padLeft(15);
        checkBoxesTable.add(button.initCheckBox()).width(65).height(60).padLeft(150);
        checkBoxesTable.add(SettingsImage.initImageForCheckBoxesArea().get(1)).width(300).height(60).padLeft(15);
        return checkBoxesTable;
    }

}

