package com.mygdx.game.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    public static AssetManager manager;

    public static final String uiskin = "ui/uiskin.json";
    public static final String backforSettings = "atlas-directory/back_bright_0008_sky.png";

    public static void loadSkin() {
        manager.load(uiskin, Skin.class);
    }

    public static void loadBackground(){
        manager.load(backforSettings, Texture.class);
    }

    public static void dispose() {
        manager.dispose();
    }
}
