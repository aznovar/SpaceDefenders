package com.mygdx.game.gameworld.gameobjects.background;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.assets.Assets;

import lombok.experimental.UtilityClass;

/**
 * Class for generation scrolling background
 */
@UtilityClass
public class ConfigureBackground {

    /**
     * Use this method whenever you want to get scrolling background
     *
     * @param staticBackground
     * @param targetParallax
     * @param count
     * @return
     */
    public static OriginScrollingBackground createScrollingBackground(String staticBackground, String targetParallax, Integer count) {
        Array<Texture> textures = new Array<>();
        for (int i = 1; i <= count; i++) {
            textures.add(new Texture(Gdx.files.internal(targetParallax + i + ".png")));
            textures.get(textures.size - 1).setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        }
        Sprite background = new Sprite(Assets.manager.get(staticBackground, Texture.class));
        background.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        OriginScrollingBackground newScrBack = new OriginScrollingBackground(textures, background);
        newScrBack.setSpeed(1);
        return newScrBack;
    }

}
