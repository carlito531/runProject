package com.runProject.common;

import com.badlogic.gdx.math.Vector2;

public class Constants {
	
	/* screen size */
	public static final int APP_WIDTH = 800;
    public static final int APP_HEIGHT = 480;
	
    /* world generation */
    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);
    public static final float GROUND_X = 0F;
    public static final float GROUND_Y = 0F;
	public static final float GROUND_WIDTH = 50F;
	public static final float GROUND_HEIGHT = 2F;
	public static final float GROUND_DENSITY = 0F;
	
	/* runner */
	public static final float RUNNER_X = 2;
    public static final float RUNNER_Y = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH = 1F;
    public static final float RUNNER_HEIGHT = 2F;
    public static float RUNNER_DENSITY = 0.5F;
}
