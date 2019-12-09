package com.mygdx.game.gameworld.gui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;
import java.util.List;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SettingsImage {

    public static List<Image> initImageForField() {
        List<Image> listofImage = new ArrayList<>();
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegionField = textureAtlas.findRegion(Const.FIELD_FOR_SETTINGS_TABLE);
        TextureRegion textureRegionGfx = textureAtlas.findRegion(Const.GFX);
        TextureRegion textureRegionSfx = textureAtlas.findRegion(Const.SFX);
        Drawable drawableField = new TextureRegionDrawable(textureRegionField);
        Drawable drawableGfx = new TextureRegionDrawable(textureRegionGfx);
        Drawable drawableSfx = new TextureRegionDrawable(textureRegionSfx);
        listofImage.add(new Image(drawableField));
        listofImage.add(new Image(drawableGfx));
        listofImage.add(new Image(drawableSfx));
        return listofImage;
    }

    public static Image initBackground() {
        TextureAtlas textureAtlas = new TextureAtlas(Const.NEW_BACKGROUND_ATLAS);
        TextureRegion textureRegion = textureAtlas.findRegion(Const.NEW_BACKGROUND);
        Drawable drawable = new TextureRegionDrawable(textureRegion);
        return new Image(drawable);
    }

    public static List<Image> initImageForCheckBoxesArea() {
        List<Image> listofImage = new ArrayList<>();
        TextureAtlas textureAtlas = new TextureAtlas((Const.ATLAS_DIRECTORY));
        TextureRegion textureMusic = textureAtlas.findRegion(Const.MUSIC);
        TextureRegion textureSound = textureAtlas.findRegion(Const.SOUND);
        Drawable drawableMusic = new TextureRegionDrawable(textureMusic);
        Drawable drawableSound = new TextureRegionDrawable(textureSound);
        listofImage.add(new Image(drawableMusic));
        listofImage.add(new Image(drawableSound));
        return listofImage;
    }
}
