package com.flappybird.proto;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.flappybird.proto.actors.AnimateActor;
import com.flappybird.proto.actors.SimpleActor;

public class FlappyBird extends Game {

    private Stage mainStage;

    private float velocity = 100.0f;
    private Animation birdAnim;
    float vBird = 0;

    private AnimateActor bird;

    @Override
	public void create() {

		mainStage = new Stage();
        initAnimation();
		initActors();

	}

    private void initActors() {

        bird = createAnimateActor(birdAnim, 100, mainStage.getHeight() / 2);
        bird.setVelocity(new Vector2(10, -10));

    }

    private void initAnimation() {

        TextureRegion[] frames = new TextureRegion[3];
        for (int i = 0; i < 3; i++) {
            String fileName = "images/bird0_" + i + ".png";
            Texture tex = new Texture(Gdx.files.internal(fileName));
            tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            frames[i] = new TextureRegion(tex);
        }
        Array<TextureRegion> framesArray = new Array<TextureRegion>(frames);
        birdAnim = new Animation(0.1f, framesArray, Animation.PlayMode.LOOP_PINGPONG);

    }


    private SimpleActor createActor(String pathToTexture, float x, float y) {
        return createActor(pathToTexture, x, y, true);
    }

    private SimpleActor createActor(String pathToTexture, float x, float y, boolean visible) {

        SimpleActor actor = new SimpleActor();
        actor.setTexture(new Texture(
                Gdx.files.internal(pathToTexture)
        ));
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
        actor.setPosition(x - actor.getOriginX(),y - actor.getOriginY());
        actor.setVisible(visible);
        mainStage.addActor(actor);

        return actor;

    }

    private AnimateActor createAnimateActor(Animation animation, float x, float y) {

        AnimateActor actor = new AnimateActor();
        actor.setAnimimation(animation);
        actor.setPosition(x,y);
        actor.setOrigin(actor.getWidth() / 2, actor.getHeight() / 2);
        mainStage.addActor(actor);

        return actor;

    }

    @Override
    public void render () {

        float dt = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isTouched()) {
            vBird =2f;
        } else {
            vBird = -1f;
        }

        bird.addVelocityY(vBird);

        mainStage.act(dt);

        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.draw();

    }

    @Override
    public void dispose () {

    }

}
