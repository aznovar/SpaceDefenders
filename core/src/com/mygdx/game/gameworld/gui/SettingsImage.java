package com.mygdx.game.gameworld.gui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import java.util.ArrayList;
import java.util.List;


public class SettingsImage {

    public Image initImageForField() {
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegion = textureAtlas.findRegion(Const.FIELD_FOR_SETTINGS_TABLE);
        Drawable drawable = new TextureRegionDrawable(textureRegion);
        return new Image(drawable);
    }

    public Image initBackground(){
        //TODO переделать на Button with ButtonStyle и выделить в один метод, т.к. повторы
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegion = textureAtlas.findRegion(Const.BACKGROUND_FOR_SETTINGS_TABLE);
        Drawable drawable = new TextureRegionDrawable(textureRegion);
        return new Image(drawable);
    }

    public Image initImageForSaveButton() {
        //TODO переделать на Button with ButtonStyle и выделить в один метод, т.к. повторы
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegion = textureAtlas.findRegion(Const.SAVE_BUTTON);
        Drawable drawable = new TextureRegionDrawable(textureRegion);
        return new Image(drawable);
    }

    public Image initButtonsForChangeMusicAndSoundLeft() {
        //TODO переделать на Button with ButtonStyle и выделить в один метод, т.к. повторы
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegionArrowLeft = textureAtlas.findRegion(Const.ARROW_LEFT);
        Drawable drawable = new TextureRegionDrawable(textureRegionArrowLeft);
        return new Image(drawable);
    }

    public Image initButtonsForChangeMusicAndSoundRight() {
        //TODO переделать на Button with ButtonStyle и выделить в один метод, т.к. повторы
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        TextureRegion textureRegionArrowRight = textureAtlas.findRegion(Const.ARROW_RIGHT);
        Drawable drawable = new TextureRegionDrawable(textureRegionArrowRight);
        return new Image(drawable);
    }

    public List<Image> initImageForCheckBoxesArea() {
        //TODO переделать на Button with ButtonStyle и выделить в один метод, т.к. повторы
        List<Image> listofImage = new ArrayList<>();
        TextureAtlas textureAtlas = new TextureAtlas((Const.ATLAS_DIRECTORY));
        TextureRegion textureRegionCheckBox = textureAtlas.findRegion(Const.CHECK_BOX);
        TextureRegion textureMusic = textureAtlas.findRegion(Const.MUSIC);
        TextureRegion textureSound = textureAtlas.findRegion(Const.SOUND);
        Drawable drawableUntouchCheckBox = new TextureRegionDrawable(textureRegionCheckBox);
        Drawable drawableMusic = new TextureRegionDrawable(textureMusic);
        Drawable drawableSound = new TextureRegionDrawable(textureSound);
        listofImage.add(new Image(drawableUntouchCheckBox));
        listofImage.add(new Image(drawableMusic));
        listofImage.add(new Image(drawableSound));
        return listofImage;
    }
}
