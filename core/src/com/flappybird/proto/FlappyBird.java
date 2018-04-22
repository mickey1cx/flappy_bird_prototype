package com.flappybird.proto;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
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
import com.flappybird.proto.actors.BackGround;
import com.flappybird.proto.actors.Bird;
import com.flappybird.proto.actors.SimpleActor;

public class FlappyBird extends Game {

    private Stage mainStage;
    private Stage backStage;
    private Camera camera;

    private float velocity = 100.0f;
    private Animation birdAnim;
    float vBird = 0;

    private Bird bird;

    private Array<BackGround> ground;

    @Override
	public void create() {

		mainStage = new Stage();
		//backStage = new Stage();
		initActors();

		camera = mainStage.getCamera();


	}

    private void initActors() {


        //background
        for (int i = 0; i < 5; i++) {
            BackGround _ground = new BackGround(mainStage, "images/bg_day.png",i * 288, 240);
           // _ground.setBird(bird);
        }


        bird = new Bird(mainStage);
        bird.setVelocity(new Vector2(75, 0));

        //ground
        for (int i = 0; i < 5; i++) {
            BackGround _ground = new BackGround(mainStage, "images/land.png",i * 336, 0);
//            _ground.setBird(bird);
            _ground.setVelocity(new Vector2(-25, 0));
        }


    }

    @Override
    public void render () {

        float dt = Gdx.graphics.getDeltaTime();

        if (Gdx.input.isTouched()) {
            vBird =4f;
        } else {
            vBird = -2f;
        }

        bird.addVelocityY(vBird);

        mainStage.act(dt);

        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        mainStage.draw();

        float birdY = bird.getY();
        float cameraY = (birdY < 200) ? 200 : (birdY > 230) ? 230 : birdY;
        camera.position.set(bird.getX() + mainStage.getWidth() * 0.4f, cameraY, 0);

    }



    @Override
    public void dispose () {

    }

}
