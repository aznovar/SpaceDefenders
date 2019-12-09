package com.mygdx.game.bindings;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.gameworld.gameobjects.allbuttons.buttons.FunctionalityOfButtons;
import com.mygdx.game.gameworld.gameobjects.allbuttons.buttons.FunctionalityOfButtonsInterface;

public class UiModule extends AbstractModule {

    @Override
    protected void configure() {
        /**
         * Здесь мы указываем guice, что где бы не использовался интерфейс FunctionalityOfButtonsInterface
         * то его использование должно разрешаться с помощью класса FunctionalityOfButtons
         */
        bind(FunctionalityOfButtonsInterface.class).to(FunctionalityOfButtons.class);

        bind(MyGdxGame.class).in(Singleton.class);
    }
}
