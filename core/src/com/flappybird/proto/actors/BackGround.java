package com.flappybird.proto.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class BackGround extends SimpleActor {

    private Bird bird;
    private Stage stage;

    public BackGround(Stage stage, String imagePath, float x, float y) {

        super();
        this.stage = stage;
        init(stage, imagePath, x, y);
        //velocityX = -50;

    }

//    private void init(float x, float y) {
//
//        setTexture(new Texture(Gdx.files.internal("images/land.png")));
//        setOrigin(getWidth() / 2, getHeight() / 2);
//        setPosition(x - getOriginX(),y - getOriginY());
//        stage.addActor(this);
//
//    }


    @Override
    public void act(float dt) {

        super.act(dt);

        float cameraX = stage.getCamera().position.x;
        float x = getX();

        if (cameraX - x > getWidth() * 3) setX(x + getWidth() * 5);

    }

    public void setBird(Bird bird) {
        this.bird = bird;
    }
}
