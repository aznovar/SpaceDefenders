package com.mygdx.game.assets.gui;

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
    public Table createTableWithBackground() {
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegion = textureAtlas.findRegion(Const.BACKGROUND_FOR_SETTINGS_TABLE);
        Table settingsScreenTable = new Table();
        settingsScreenTable.setBackground(new TextureRegionDrawable(textureRegion));
        settingsScreenTable.setFillParent(true);
        return settingsScreenTable;
    }

    @Override
    public Table addFieldForTable(Table table) {
        SettingsImage settingsImage = new SettingsImage();
        table.add(settingsImage.initImageForField()).width(500).height(80);
        table.row();
        table.add(settingsImage.initImageForField()).width(500).height(80);
        table.row();
        table.add(settingsImage.initImageForButton()).width(250).height(150).expand().bottom();
        table.row();
        return table;
    }

    @Override
    public Table addButtonForTable(Table table) {
        return null;
    }

    //    public TextureRegion setupFragments() {
//        textureAtlas = new TextureAtlas("atlas-directory/hhh.atlas");
//        return textureAtlas.findRegion("settings_0008_window2");
//    }
//
//
//    public static Table addTableOnScreen() {
//
//    }
}
