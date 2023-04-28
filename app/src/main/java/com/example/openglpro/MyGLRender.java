package com.example.openglpro;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class MyGLRender implements GLSurfaceView.Renderer, SurfaceTexture.OnFrameAvailableListener {

//    private MyGLSurfaceView mGLSurfaceView;
//
//    public MyGLRender(MyGLSurfaceView mGLSurfaceView) {
//        this.mGLSurfaceView = mGLSurfaceView;
//    }
    private final float[] vPMatrix= new float[16];
    private final float[] projMatrix= new float[16];
    private final float[] vMatrix= new float[16];

    @Override
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {

    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        //设置画布的位置和宽高
        GLES20.glViewport(0, 0, width, height);
        float ratio = (float) width / height;
        //根据参数创建一个透视投影矩阵
        Matrix.frustumM(projMatrix, 0, -ratio, ratio, -1, 1, 3, 7);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        // Create a camera view matrix
        Matrix.setLookAtM(vMatrix,  0, 0, 0, -3, 0f, 0f, 0f, 0f, 1.0f, 0.0f);
        // Combine the projection and camera view matrices
        Matrix.multiplyMM(vPMatrix, 0, projMatrix, 0, vMatrix, 0);
        //draw objects
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT);
    }
}
