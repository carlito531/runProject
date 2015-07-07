package com.runProject.box2d;

import com.runProject.enums.UserDataType;

public abstract class UserData {
	
	protected UserDataType userDataType;

    public UserData() {
    }

    public UserDataType getUserDataType() {
        return userDataType;
    }
}