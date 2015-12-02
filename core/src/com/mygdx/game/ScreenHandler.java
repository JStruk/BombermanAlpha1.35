package com.mygdx.game;

import com.badlogic.gdx.Game;

/**
 * Created by Justin on 2015-11-30.
 */
public class ScreenHandler extends Game {
    Release2 release2;
    MenuScreen menuScreen;
    InstructionScreen instructionScreen;
    boolean b=true;

    @Override
    public void create() {
        menuScreen = new MenuScreen(this);
        release2 = new Release2(this);
        instructionScreen = new InstructionScreen(this);
       screenChange("menu");
       // setScreen(menuScreen);
    }

    public void screenChange(String sBtn) {
        if(sBtn.equalsIgnoreCase("menu")){
         //   Gdx.gl.glClearColor(1, 0, 0, 1);
          //  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            setScreen(menuScreen);
        }
        if (sBtn.equalsIgnoreCase("play")) {
         //   Gdx.gl.glClearColor(1, 0, 0, 1);
          //  Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
         //   b=false;
            setScreen(release2);
        }else if (sBtn.equalsIgnoreCase("help")){
            setScreen(instructionScreen);
        }
    }
}

