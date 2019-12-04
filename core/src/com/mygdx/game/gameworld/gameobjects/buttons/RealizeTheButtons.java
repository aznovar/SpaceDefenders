package com.mygdx.game.gameworld.gameobjects.buttons;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.gamescreens.MenuScreen;

import static com.mygdx.game.gameworld.gui.Const.*;

/**
 * A class that implements the functions of the buttons
 */
public class RealizeTheButtons extends OriginButton {

    public RealizeTheButtons() {

    }

    /**
     * The method that implements the functionality of the save button
     * @param
     * @return
     */
    public Button initSaveButton(){
        Button saveButton = super.initializeButton(SAVE_BUTTON_WITH_TEXT, SAVE_BUTTON_UNPR_TEXT, SAVE_BUTTON_PR_TEXT);
        saveButton.addListener(new ClickListener() {
            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        return saveButton;
    }

    /**
     * The method that implements the functionality of the back button
     * @param game
     * @return
     */
    public Button initBackButton(MyGdxGame game){
        Button backButton = super.initializeButton(BACK_BUTTON_WITH_TEXT, BACK_BUTTON_UNPR_TEXT, BACK_BUTTON_PR_TEXT);
        backButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new MenuScreen(game));
            }
        });
        return backButton;
    }
}
