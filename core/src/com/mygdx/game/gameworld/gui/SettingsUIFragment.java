package com.mygdx.game.gameworld.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * The class intended for fine tuning of the UI element - Settings
 * Location, shape, size - all this is set up in this class for further use
 * on demand in specific screens
 */
public class SettingsUIFragment implements OriginTableInterface {

    private static final Float PERCENT_OF_WIDTH = Gdx.graphics.getWidth() / 1.25f;
    private static final Float PERCENT_OF_HEIGHT = Gdx.graphics.getHeight() / 1.25f;

    @Override
    public Table createTableLikeBackground() {
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegion = textureAtlas.findRegion(Const.BACKGROUND_FOR_SETTINGS_TABLE);
        Table settingsBackgroundTable = new Table();
        SettingsImage settingsImage = new SettingsImage();
        Image background = settingsImage.initBackground();
        settingsBackgroundTable.add(background).width(PERCENT_OF_WIDTH).height(PERCENT_OF_HEIGHT).expand().bottom();
        settingsBackgroundTable.row();
        //settingsBackgroundTable.setBackground(new TextureRegionDrawable(textureRegion));
        settingsBackgroundTable.add(createTableForCheckBoxes()).padTop(PERCENT_OF_HEIGHT/-0.78f);
        settingsBackgroundTable.row();
        settingsBackgroundTable.add(createTableForFields()).padTop(PERCENT_OF_HEIGHT/-1.3f);
        settingsBackgroundTable.row();
        settingsBackgroundTable.add(createTableForButtons()).expand().padTop(PERCENT_OF_HEIGHT/-2.2f);
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
        settingsFieldsTable.add(settingsImage.initButtonsForChangeMusicAndSoundLeft()).padRight(10).width(50).height(50).spaceBottom(50);
        settingsFieldsTable.add(settingsImage.initImageForField().get(0)).width(550).height(70).spaceBottom(50);
        settingsFieldsTable.add(settingsImage.initButtonsForChangeMusicAndSoundRight()).padLeft(10).width(50).height(50).spaceBottom(50);
        settingsFieldsTable.row();
        settingsFieldsTable.add(settingsImage.initImageForField().get(2)).width(220).height(50).padRight(25);
        settingsFieldsTable.add(settingsImage.initButtonsForChangeMusicAndSoundLeft()).padRight(10).width(50).height(50);
        settingsFieldsTable.add(settingsImage.initImageForField().get(0)).width(550).height(70);
        settingsFieldsTable.add(settingsImage.initButtonsForChangeMusicAndSoundRight()).padLeft(10).width(50).height(50);
      //  settingsFieldsTable.setDebug(true);
        return settingsFieldsTable;
    }

    @Override
    public Table createTableForButtons() {
        Table settingsButtonSaveTable = new Table();
        SettingsImage settingsImage = new SettingsImage();
        settingsButtonSaveTable.add(settingsImage.initImageForSaveButton()).width(200).height(100);
        //settingsButtonSaveTable.setDebug(true);
        return settingsButtonSaveTable;
    }

    public Table createTableForCheckBoxes() {
        Table checkBoxesTable = new Table();
        SettingsImage settingsImage = new SettingsImage();
        checkBoxesTable.add(settingsImage.initImageForCheckBoxesArea().get(0)).width(60).height(60);
        checkBoxesTable.add(settingsImage.initImageForCheckBoxesArea().get(1)).width(300).height(60).padLeft(15);
        checkBoxesTable.add(settingsImage.initImageForCheckBoxesArea().get(0)).width(65).height(60).padLeft(150);
        checkBoxesTable.add(settingsImage.initImageForCheckBoxesArea().get(2)).width(300).height(60).padLeft(15);
       // checkBoxesTable.setDebug(true);
        return checkBoxesTable;
    }
}
