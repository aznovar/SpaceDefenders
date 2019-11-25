package com.mygdx.game.gameworld.gui;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class InitCheckBox {

    public Button init() {
        TextureAtlas textureAtlas = new TextureAtlas(Const.ATLAS_DIRECTORY);
        Skin testSkin = new Skin(textureAtlas);
        Button.ButtonStyle style = new Button.ButtonStyle();
        style.up = testSkin.getDrawable(Const.CHECK_BOX_ON);
        style.checked = testSkin.getDrawable(Const.CHECK_BOX_OFF);
        Button testB = new Button(style);
        testB.addListener(new InputListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        return testB;
    }
}
