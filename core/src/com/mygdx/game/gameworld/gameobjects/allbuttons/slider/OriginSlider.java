package com.mygdx.game.gameworld.gameobjects.allbuttons.slider;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;

/**
 * Super-class for sliders
 */
public class OriginSlider {

    public Slider initializeSlider(String sliderDirectory, String sliderBack, String knob, String knobBefore) {
        TextureAtlas textureAtlas = new TextureAtlas(sliderDirectory);
        Skin testSkin = new Skin(textureAtlas);
        Slider.SliderStyle styleOfSlider = new Slider.SliderStyle();
        styleOfSlider.background = testSkin.getDrawable(sliderBack);
        styleOfSlider.knob = testSkin.getDrawable(knob);
        styleOfSlider.knobBefore = testSkin.getDrawable(knobBefore);
        return new Slider(0, 100, 1, false, styleOfSlider);
    }
}
