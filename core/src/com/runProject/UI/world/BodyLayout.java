package com.runProject.UI.world;

import com.badlogic.gdx.physics.box2d.Body;
import com.runProject.box2d.UserData;
import com.runProject.enums.UserDataType;

public class BodyLayout {

	public boolean bodyIsRunner(Body body) {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.RUNNER;
    }

    public boolean bodyIsGround(Body body) {
        UserData userData = (UserData) body.getUserData();
        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }
}
