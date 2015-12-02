package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

public class Release2 implements Screen {
    Map map;
    Thumbstick thumbstick;
    Character character;
    ScreenHandler screenHandler;

    public Release2(ScreenHandler _screenHandler) {
        this.screenHandler = _screenHandler;
    }

    public void create() {
        thumbstick = new Thumbstick();
        map = new Map();
        thumbstick.create();
        map.ThumbstickHeight(thumbstick.fTouchPadHeight);
        map.create();
        character = new Character();
        character.setMap(map);
        character.create();
        thumbstick.setCharacter(character, character.arbDirection, character.bStop);
    }


    @Override
    public void show() {
        this.create();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        map.render();
        thumbstick.render();
        character.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        //   this.render();

    }

    @Override
    public void dispose() {

    }
}
