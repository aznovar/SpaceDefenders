package com.mygdx.game.gameworld.gameobjects.touchpad;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Touchpad;

public class GamePad {

    public Stage stage;
    public Touchpad touchpad;

    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Skin skin = new Skin(Gdx.files.internal("data/Button_08_Normal_Virgin.png"));

        touchpad = new Touchpad(20, skin);
        touchpad.setBounds(15, 15, 100, 100);
        stage.addActor(touchpad);
    }

    public void render() {
        // System.out.println(touchpad.getKnobPercentX() + " " + touchpad.getKnobPercentY());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    public void dispose() {
        stage.dispose();
    }

}
