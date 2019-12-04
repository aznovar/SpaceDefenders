package com.mygdx.game.gameworld.gameobjects.buttons;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class OriginButton {

        public Button initializeButton(String atlasString, String fragmentOne, String fragmentTwo){
            TextureAtlas textureAtlas = new TextureAtlas(atlasString);
            Skin testSkin = new Skin(textureAtlas);
            Button.ButtonStyle style = new Button.ButtonStyle();
            style.up = testSkin.getDrawable(fragmentOne);
            style.down = testSkin.getDrawable(fragmentTwo);
            return new Button(style);
        }

    public Button initializeCheckBoxButton(String atlasString, String fragmentOne, String fragmentTwo){
        TextureAtlas textureAtlas = new TextureAtlas(atlasString);
        Skin testSkin = new Skin(textureAtlas);
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = testSkin.getDrawable(fragmentOne);
        style.checked = testSkin.getDrawable(fragmentTwo);
        return new Button(style);
    }
}
