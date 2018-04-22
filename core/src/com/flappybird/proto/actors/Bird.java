package com.flappybird.proto.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;

public class Bird extends AnimateActor {

    private Stage stage;
    private float maxVelocityY = 75;

    public Bird(Stage stage) {

        super();

        this.stage = stage;

        init();

    }

    private void init() {

        TextureRegion[] frames = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            String fileName = "images/bird0_" + i + ".png";
            Texture tex = new Texture(Gdx.files.internal(fileName));
            tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            frames[i] = new TextureRegion(tex);
        }
        Array<TextureRegion> framesArray = new Array<TextureRegion>(frames);
        Animation birdAnim = new Animation(0.1f, framesArray, Animation.PlayMode.LOOP_PINGPONG);

        setAnimimation(birdAnim);
        setPosition(0, stage.getHeight() / 2);
        setOrigin(getWidth() / 2, getHeight() / 2);
        stage.addActor(this);

    }

    public void addVelocityY(float vBird) {

        velocityY += (Math.abs(velocityY + vBird) > maxVelocityY) ? 0 :vBird;

    }


}
