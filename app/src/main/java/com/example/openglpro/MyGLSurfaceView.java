package com.example.openglpro;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRender mRender;
    public MyGLSurfaceView(Context context) {
        super(context);
        setEGLContextClientVersion(2);
        mRender = new MyGLRender();
        setRenderer(mRender);
    }


}
