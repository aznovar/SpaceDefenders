package com.mygdx.game.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    public static AssetManager manager;

    public static final String uiskin = "ui/uiskin.json";
    public static final String backForSettings = "atlas-directory/back_bright_0008_sky.png";

    public static final String pauseBtnUp = "pauseBtnUp.png";

    public static final String planetOne = "atlas-directory/back/back_bright_0000_planet1.png";
    public static final String planetTwo = "atlas-directory/back/back_bright_0001_planet2.png";
    public static final String planetThree = "atlas-directory/back/back_bright_0002_planet3.png";
    public static final String planetFour = "atlas-directory/back/back_bright_0003_planet4.png";
    public static final String planetFive = "atlas-directory/back/back_bright_0004_planet5.png";
    public static final String planetSix = "atlas-directory/back/back_bright_0005_planet6.png";
    public static final String planetSeven = "atlas-directory/back/back_bright_0006_planet7.png";
    public static final String planetEight = "atlas-directory/back/back_bright_0007_planet8.png";


    public static void loadSkin() {
        manager.load(uiskin, Skin.class);
    }

    public static void loadBackground() {
        manager.load(backForSettings, Texture.class);
        manager.load(planetOne, Texture.class);
        manager.load(planetTwo, Texture.class);
        manager.load(planetThree, Texture.class);
        manager.load(planetFour, Texture.class);
        manager.load(planetFive, Texture.class);
        manager.load(planetSix, Texture.class);
        manager.load(planetSeven, Texture.class);
        manager.load(planetEight, Texture.class);
    }

    public static void dispose() {
        manager.dispose();
    }

    public static void loadPauseButton() {
        manager.load(pauseBtnUp, Texture.class);
    }
}
