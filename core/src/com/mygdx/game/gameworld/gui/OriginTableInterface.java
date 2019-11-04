package com.mygdx.game.gameworld.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * A class containing methods that describe the approach to implementing classes for the GUI
 */
interface OriginTableInterface {

    /**
     * A method that allows you to add a background to your table
     *
     * @return
     */
    Table createTableLikeBackground();

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
    Table createTableForButtons();
}
