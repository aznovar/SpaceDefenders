package com.mygdx.game.assets.gui;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

/**
 * A class containing methods that describe the approach to implementing classes for the GUI
 */
interface OriginTableInterface {

    /**
     * A method that allows you to add a background to your table
     * @return
     */
    Table createTableWithBackground();

    /**
     * A method that allows you to add fields to your table
     * @return
     */
    Table addFieldForTable(Table table);

    /**
     * A method that allows you to add buttons to your table
     * @param table
     * @return
     */
    Table addButtonForTable(Table table);
}
