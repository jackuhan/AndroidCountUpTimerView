package cn.iwgang.countuptime;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;

/**
 * 改成SystemClock.elapsedRealtime()计算时间，即使放在listview或者recyclerview中被回收了始终也不会停止
 * listview的demo等着有空改进下。
 * Created by hanjiahu on 16/5/11.
 */
public abstract class CustomCountUpTimer {
  private static final int MSG = 1;
  private long mMillisInFuture;
  private final long mCountupInterval;
  private long mStopTimeInFuture;
  private long mPauseTimeInFuture;
  private boolean isStop = false;
  private boolean isPause = false;
  private boolean started = false;

  public CustomCountUpTimer(long millisInFuture, long countDownInterval) {
    mMillisInFuture = millisInFuture;
    mCountupInterval = countDownInterval;
  }

  private synchronized CustomCountUpTimer start(long millisInFuture) {
    isStop = false;
    if (millisInFuture <= 0) {
      onFinish();
      return this;
    }
    mStopTimeInFuture = SystemClock.elapsedRealtime() - millisInFuture;
    mHandler.removeMessages(MSG);
    mHandler.sendMessage(mHandler.obtainMessage(MSG));
    return this;
  }

  /**
   * 开始倒计时
   */
  public synchronized final void start() {
    start(mMillisInFuture);
  }

  /**
   * 停止倒计时
   */
  public synchronized final void stop() {
    isStop = true;
    mHandler.removeMessages(MSG);
  }

  /**
   * 暂时倒计时
   * 调用{@link #restart()}方法重新开始
   */
  public synchronized final void pause() {
    if (isStop) return;

    isPause = true;
    mPauseTimeInFuture = SystemClock.elapsedRealtime() - mStopTimeInFuture;
    mHandler.removeMessages(MSG);
  }

  /**
   * 重新开始
   */
  public synchronized final void restart() {
    if (isStop || !isPause) return;

    isPause = false;
    start(mPauseTimeInFuture);
  }

  public boolean isStarted() {
    return started;
  }

  public synchronized final void recycledstart() {
    isStop = false;
    isPause = false;
    mHandler.removeMessages(MSG);
    mHandler.sendMessage(mHandler.obtainMessage(MSG));
  }

  /**
   * 倒计时间隔回调
   *
   * @param millisUntilFinished 剩余毫秒数
   */
  public abstract void onTick(long millisUntilFinished);

  /**
   * 倒计时结束回调
   */
  public abstract void onFinish();

  private Handler mHandler = new Handler() {

    @Override public void handleMessage(Message msg) {

      synchronized (CustomCountUpTimer.this) {
        if (isStop || isPause) {
          return;
        }

        final long millisLeft = SystemClock.elapsedRealtime() - mStopTimeInFuture;
        if (millisLeft <= 0) {
          onFinish();
        } else {
          onTick(millisLeft);
          sendMessageDelayed(obtainMessage(MSG), mCountupInterval);
        }
      }
    }
  };
}
