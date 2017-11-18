package com.bignerdranch.android.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.SurfaceHolder;

import java.io.IOException;
import java.net.URI;

/**
 * Video player
 * Created by alex on 05.11.17.
 */

class VideoPlayer {

    private static final String TAG = "VideoPlayer";
    private MediaPlayer mPlayer;
    private boolean mPaused;

    VideoPlayer() {
        mPlayer = null;
        mPaused = false;
        mPlayer = new MediaPlayer();
    }


    void stop() {
        if (mPlayer != null) {
            mPlayer.release();
            mPlayer = null;
            mPaused = false;
        }
    }

    void play(Context c, SurfaceHolder surfaceHolder) throws IOException {
        if (!mPaused) {
            stop();

            mPlayer = MediaPlayer.create(c, R.raw.apollo_17_stroll);
            mPlayer.setDisplay(surfaceHolder);

            mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    stop();
                }
            });
        }

        mPlayer.start();
        mPaused = false;
    }

    void pause() {
        if (mPlayer != null) {
            mPlayer.pause();
            mPaused = true;
        }
    }
}
