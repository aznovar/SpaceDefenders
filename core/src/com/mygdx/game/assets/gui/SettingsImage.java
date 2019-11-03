package com.mygdx.game.assets.gui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class SettingsImage {

    public Image initImageForField(){
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegion = textureAtlas.findRegion(Const.FIELD_FOR_SETTINGS_TABLE);
        Drawable drawable = new TextureRegionDrawable(textureRegion);
        return new Image(drawable);
    }

    public Image initImageForButton(){
        //TODO переделать на Button with ButtonStyle
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegion = textureAtlas.findRegion(Const.SAVE_BUTTON);
        Drawable drawable = new TextureRegionDrawable(textureRegion);
        return new Image(drawable);
    }
}
