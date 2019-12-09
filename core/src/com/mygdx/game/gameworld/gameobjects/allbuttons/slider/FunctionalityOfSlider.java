package com.mygdx.game.gameworld.gameobjects.allbuttons.slider;

import com.badlogic.gdx.scenes.scene2d.ui.Container;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;

import static com.mygdx.game.gameworld.gui.Const.*;

public class FunctionalityOfSlider extends OriginSlider {

    public Container<Slider> sliderForSettings() {
        Slider sliderForSettings = super.initializeSlider(SLIDER_DIRECTORY, FIELD_FOR_SETTINGS_TABLE, KNOB, FILLER);
        sliderForSettings.getStyle().background.setMinHeight(70);
        sliderForSettings.getStyle().knob.setMinHeight(85);
        sliderForSettings.getStyle().knobBefore.setMinHeight(70);
        Container<Slider> contOfSl = new Container<>(sliderForSettings);
        contOfSl.setTransform(true);
        contOfSl.size(550, 70);
        return contOfSl;
    }
}
