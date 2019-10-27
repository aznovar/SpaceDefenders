package com.mygdx.game.assets.gui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Класс предназначенный для тонкой настройки UI элемента - Settings
 * Расположение, форма, размер - всё это настраивается в этом классе для дальнейшего использования
 * по требованию в конкретных экранах
 */
public class SettingsUIFragment {

    private TextureAtlas textureAtlas;

    public TextureRegion setupFragments() {
        textureAtlas = new TextureAtlas("atlas-directory/hhh.atlas");
        return textureAtlas.findRegion("settings_0008_window2");
    }

}
