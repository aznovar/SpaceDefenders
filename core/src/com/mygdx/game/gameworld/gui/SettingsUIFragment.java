package com.mygdx.game.gameworld.gui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

/**
 * The class intended for fine tuning of the UI element - Settings
 * Location, shape, size - all this is set up in this class for further use
 * on demand in specific screens
 */
public class SettingsUIFragment implements OriginTableInterface {

    @Override
    public Table createTableLikeBackground() {
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegion = textureAtlas.findRegion(Const.BACKGROUND_FOR_SETTINGS_TABLE);
        Table settingsBackgroundTable = new Table();
        settingsBackgroundTable.setBackground(new TextureRegionDrawable(textureRegion));
        settingsBackgroundTable.add(createTableForFields()).expand().bottom();
        settingsBackgroundTable.row();
        settingsBackgroundTable.add(createTableForButtons()).expand().padBottom(-50);
        settingsBackgroundTable.setDebug(true);
        settingsBackgroundTable.setFillParent(true);
        return settingsBackgroundTable;
    }

    @Override
    public Table createTableForFields() {
        Table settingsFieldsTable = new Table();
        SettingsImage settingsImage = new SettingsImage();
        settingsFieldsTable.add(settingsImage.initButtonsForChangeMusicAndSoundLeft()).padRight(10).width(50).height(50).spaceBottom(50);
        settingsFieldsTable.add(settingsImage.initImageForField()).width(300).height(50).spaceBottom(50);
        settingsFieldsTable.add(settingsImage.initButtonsForChangeMusicAndSoundRight()).padLeft(10).width(50).height(50).spaceBottom(50);
        settingsFieldsTable.row();
        settingsFieldsTable.add(settingsImage.initButtonsForChangeMusicAndSoundLeft()).padRight(10).width(50).height(50);
        settingsFieldsTable.add(settingsImage.initImageForField()).width(300).height(50);
        settingsFieldsTable.add(settingsImage.initButtonsForChangeMusicAndSoundRight()).padLeft(10).width(50).height(50);
        settingsFieldsTable.setDebug(true);
        return settingsFieldsTable;
    }

    @Override
    public Table createTableForButtons() {
        Table settingsButtonSaveTable = new Table();
        SettingsImage settingsImage = new SettingsImage();
        settingsButtonSaveTable.add(settingsImage.initImageForSaveButton()).width(250).height(150);
        settingsButtonSaveTable.setDebug(true);
        return settingsButtonSaveTable;
    }
}
