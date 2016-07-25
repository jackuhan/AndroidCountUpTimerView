# CountupView
Android 正计时控件，使用Canvas绘制，支持多种样式

修改自https://github.com/iwgang/CountdownView
支持秒计时和10毫秒计时

SystemClock.elapsedRealtime()计算时间，即使放在listview或者recyclerview中被回收了始终也不会停止。
具体参考如下：
```
@Override protected void onDetachedFromWindow() {
    LogUtils.d("被回收","");
    stop();//现在不会导致bug
    super.onDetachedFromWindow();
  }

  @Override protected void onAttachedToWindow() {
    LogUtils.i("视图创建","");
    if (null != mCustomCountUpTimer && mCustomCountUpTimer.isStarted()) {
      mCustomCountUpTimer.recycledstart();
      LogUtils.i("时钟复用","");
    }
    super.onAttachedToWindow();
  }
```

### screenshot
![](https://raw.githubusercontent.com/jackuhan/AndroidCountUpTimerView/master/screenshot/androidCountUpTimeView.gif)  
![](https://raw.githubusercontent.com/jackuhan/AndroidCountUpTimerView/master/screenshot/screenshot2.png) 

### code
```
CountupView mCvCountupView = (CountupView)findViewById(R.id.cv_CountupViewTest1);
mCvCountupView.start(995550000); // 毫秒
```

### layout
``` xml
<cn.iwgang.countuptime.CountupView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:isHideTimeBackground="true"
    app:isShowDay="true"
    app:isShowHour="true"
    app:isShowMinute="true"
    app:isShowSecond="true"
    app:isShowMillisecond="true"
    app:timeTextColor="#000000"
    app:timeTextSize="22sp"
    app:isTimeTextBold="true"
    app:suffixGravity="bottom"
    app:suffixTextColor="#000000"
    app:suffixTextSize="12sp"
    app:suffixHour="时"
    app:suffixMinute="分"
    app:suffixSecond="秒"
    app:suffixMillisecond="毫秒" />
```

### customization
    参数 | 类型 | 默认值
--- | --- | ---
isHideTimeBackground | boolean | true
timeBgColor  | color      | #444444
timeBgSize   | dimension  | timeSize + 2dp * 4
timeBgRadius | dimension  | 0
isShowTimeBgDivisionLine | boolean  | true
timeBgDivisionLineColor | color | #30FFFFFF
timeBgDivisionLineSize  | dimension | 0.5dp
timeTextSize   | dimension | 12sp | 
timeTextColor  | color | #000000
isTimeTextBold | boolean | false
isShowDay  | boolean | 自动显示 (天 > 1 显示, = 0 隐藏)
isShowHour  | boolean | 自动显示 (小时 > 1 显示， = 0 隐藏)
isShowMinute  | boolean | true
isShowSecond  | boolean | true
isShowMillisecond  | boolean | false
suffixTextSize | dimension | 12sp
suffixTextColor  | color | #000000
isSuffixTextBold  | boolean | false
suffixGravity | 'top' or 'center' or 'bottom' | 'center'
suffix | string | ':'
suffixDay  | string | null
suffixHour  | string | null
suffixMinute  | string | null
suffixSecond  | string | null
suffixMillisecond  | string | null
suffixLRMargin  | dimension | left 3dp right 3dp
suffixDayLeftMargin | dimension | 0
suffixDayRightMargin  | dimension | 0
suffixHourLeftMargin  | dimension | 0
suffixHourRightMargin  | dimension | 0
suffixMinuteLeftMargin | dimension | 0
suffixMinuteRightMargin  | dimension | 0
suffixSecondLeftMargin  | dimension | 0
suffixSecondRightMargin  | dimension | 0
suffixMillisecondLeftMargin | dimension | 0



## 作者联系方式
  QQ:1196681436
  Weibo:http://www.weibo.com/u/1693069642

欢迎提出意见，提交代码。
