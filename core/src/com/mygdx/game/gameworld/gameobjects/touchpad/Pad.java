package com.mygdx.game.gameworld.gameobjects.touchpad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;


/**
 * Created by Andrey Chelkanov(aznovar)
 */

public class Pad extends Widget {
    public Touchpad touchpad;
    public Texture touchpadBg, touchpadKonb;
    public TextureRegionDrawable padBG, padKnob;
    public Touchpad.TouchpadStyle touchpadStyle;

    public Touchpad setupTouchpad() {
        touchpadBg = new Texture("touchpad_bg.png");
        touchpadKonb = new Texture("touchpad_knob.png");
        padBG = new TextureRegionDrawable(touchpadBg);
        padKnob = new TextureRegionDrawable(touchpadKonb);
        touchpadStyle = new Touchpad.TouchpadStyle(padBG, padKnob);
        touchpad = new Touchpad(20f, touchpadStyle);
        touchpad.setBounds(Gdx.graphics.getWidth() / 2 - 75, Gdx.graphics.getHeight() / 10 - 75, 150, 150);
        return touchpad;
    }
}
