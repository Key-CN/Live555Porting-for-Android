package io.keyss.microbeanandroid.base.utils.live555;

import android.text.TextUtils;
import android.util.Log;

public class KeyRTSPClient {
    private static RTSPVideoListener mVideoListener;
    private static RTSPInfoListener mInfoListener;

    public static native int start(String path);

    public void onNativeCallBack(byte[] data, int len) {
        if (mVideoListener != null) {
            mVideoListener.videoCallBack(data, len);
        }
    }

    public void onNativeInfo(String errorMsg) {
        if (TextUtils.isEmpty(errorMsg)) {
            return;
        }

        if (mInfoListener != null) {
            mInfoListener.infoCallBack(errorMsg);
        }

        Log.e("KeyRTSPClient", errorMsg);
    }

    public static native void stop();

    public static void setRTSPVideoListener(RTSPVideoListener listener) {
        mVideoListener = listener;
    }

    public static void setRTSPInfoListener(RTSPInfoListener listener) {
        mInfoListener = listener;
    }

    public interface RTSPInfoListener {
        void infoCallBack(String msg);
    }

    public interface RTSPVideoListener {
        void videoCallBack(byte[] data, int len);
    }
}
