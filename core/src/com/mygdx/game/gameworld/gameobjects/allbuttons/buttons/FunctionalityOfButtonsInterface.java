package com.mygdx.game.gameworld.gameobjects.allbuttons.buttons;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.mygdx.game.MyGdxGame;

public interface FunctionalityOfButtonsInterface {

    /**
     * The method that implements the functionality of the save button
     *
     * @param
     * @return
     */
    Button initSaveButton();

    /**
     * The method that implements the functionality of the back button
     *
     * @param game
     * @return
     */
    Button initBackButton(MyGdxGame game);

    /**
     * The method that implements the functionality of the checkbox
     */
    Button initCheckBox();
}
