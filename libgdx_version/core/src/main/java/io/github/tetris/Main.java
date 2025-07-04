package io.github.tetris;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main extends ApplicationAdapter {

    // Declare all assets here as variables use (Texture, Sound, Music etc.)
    private Sound blockPlacedSound;
    private Sound lineClearedSound;

    private Texture image;
    private Texture buckTexture;

    private SpriteBatch spriteBatch;
    private FitViewport viewport;

    @Override
    public void create() {

        // Also initialize all assets here
        blockPlacedSound = Gdx.audio.newSound(Gdx.files.internal("block_placed_sound.mp3"));
        lineClearedSound = Gdx.audio.newSound(Gdx.files.internal("line_cleared_sound.mp3"));
        image = new Texture("libgdx.png");
        buckTexture = new Texture("bucket.png");
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(800, 600);
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    @Override
    public void render() {
        // ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        // batch.begin();
        // batch.draw(image, 140, 210);
        // batch.end();
        input();
        logic();
        draw();
    }

    private void input() {

    }

    private void logic() {

    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        spriteBatch.draw(buckTexture,  100, 100, 128, 128);

        spriteBatch.end();
    }

    @Override
    public void dispose() {
       // batch.dispose();
        //image.dispose();
    }
}
