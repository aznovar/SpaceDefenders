package com.mygdx.game.gameworld.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.gameworld.gameobjects.buttons.FunctionalityOfButtons;

/**
 * A class containing methods that describe the approach to implementing classes for the GUI
 */
public interface OriginTableInterface {

    /**
     * A method that allows you to add a background to your table
     *
     * @return
     */
    Table createTableLikeBackground(Button button, MyGdxGame game);

    /**
     * A method that allows you to add fields to your table
     *
     * @return
     */
    Table createTableForFields();

    /**
     * A method that allows you to add buttons to your table
     *
     * @return
     */
    Table createTableForButtons(FunctionalityOfButtons functionalityOfButtons, MyGdxGame game);
}
