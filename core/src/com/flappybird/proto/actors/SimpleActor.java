package com.flappybird.proto.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class SimpleActor extends Actor {

    protected TextureRegion region;
    protected Rectangle boundary;
    protected float velocityX;
    protected float velocityY;

    public SimpleActor() {

        super();

        region = new TextureRegion();
        boundary = new Rectangle();
        velocityX = 0;
        velocityY = 0;

    }

    protected void init(Stage stage, String imagePath, float x, float y) {

        setTexture(new Texture(Gdx.files.internal(imagePath)));
        setOrigin(getWidth() / 2, getHeight() / 2);
        setPosition(x - getOriginX(),y - getOriginY());
        stage.addActor(this);

    }

    public Vector2 getVelocity() {
        return new Vector2(velocityX, velocityY);
    }

    public void setVelocityY(float velocity) {
        velocityY = velocity;
    }

    public void setVelocity(Vector2 velocity) {
        velocityX = velocity.x;
        velocityY = velocity.y;
    }

    public void setTexture(Texture t) {

        setWidth(t.getWidth());
        setHeight(t.getHeight());
        region.setRegion(t);
    }

    public Rectangle getBoundingRectangle() {

        boundary.set(getX(), getY(), getWidth(), getHeight());
        return boundary;

    }

    public void act(float dt) {

        super.act(dt);
        moveBy(velocityX * dt, velocityY * dt);

    }

    public void draw(Batch batch, float parentAlpha) {

        Color c = getColor();
        batch.setColor(c.r, c.g, c.b, c.a);

        if (isVisible()) {
            batch.draw(region, getX(), getY(), getOriginX(), getOriginY(),
                    getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
        }

    }

    public Vector2 getPosition() {
        return new Vector2(getX(), getY());
    }
}
