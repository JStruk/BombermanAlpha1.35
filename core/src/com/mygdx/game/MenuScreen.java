package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Justin on 2015-11-30.
 */
public class MenuScreen implements Screen {
    SpriteBatch batch;
    Texture splash;
    TextureAtlas taButtons;
    ImageButton.ImageButtonStyle ibsPlay, ibsHelp;
    ImageButton ibPlay, ibHelp;
    Skin skButtons;
    Stage stage;
    ScreenHandler screenHandler;

    public MenuScreen(ScreenHandler _screenHandler) {
        this.screenHandler = _screenHandler;
    }

    @Override
    public void show() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        batch = new SpriteBatch();
        splash = new Texture("MainMenu.png");
        taButtons = new TextureAtlas("Buttons/Buttons.atlas");
        skButtons = new Skin();
        skButtons.addRegions(taButtons);

        ibsPlay = new ImageButton.ImageButtonStyle();
        ibsPlay.up = skButtons.getDrawable("PBTNUp");
        ibsPlay.down = skButtons.getDrawable("PBTNDown");
        ibsPlay.checked = skButtons.getDrawable("PBTNUp");
        ibPlay = new ImageButton(ibsPlay);

        ibsHelp = new ImageButton.ImageButtonStyle();
        ibsHelp.up = skButtons.getDrawable("IBTNUp");
        ibsHelp.down = skButtons.getDrawable("IBTNDown");
        ibsHelp.checked = skButtons.getDrawable("IBTNUp");

        ibHelp = new ImageButton(ibsHelp);
        ibPlay.setSize(814, 160); // Sizing for Android
        ibHelp.setSize(124, 124); // Sizing for Android
        ibPlay.setPosition((Gdx.graphics.getWidth() / 2) - ibPlay.getWidth() / 2,
                (Gdx.graphics.getHeight() / 2 - 300) - ibPlay.getHeight() / 2);
        ibPlay.setName("play");
        ibHelp.setName("help");
        ibPlay.addListener(new InputListener() {//http://gamedev.stackexchange.com/questions/60123/registering-inputlistener-in-libgdx

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                //System.out.println("Play");
                screenHandler.screenChange(ibPlay.getName());
                //setScreen(ScreenManager);
                return true;
            }
        });

        ibHelp.addListener(new InputListener() {

            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                //screenHandler.screenChange(ibHelp.getName());
                return true;
            }

            /* @Override
            public boolean touchUp(InputEvent event, float x, float y, int pointer, int button) {
                screenHandler.screenChange(ibHelp.getName());
                return false;
            } */
        });
        stage.addActor(ibPlay);
        stage.addActor(ibHelp);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(splash, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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
        stage.dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
        batch.dispose();
        splash.dispose();

    }
}



