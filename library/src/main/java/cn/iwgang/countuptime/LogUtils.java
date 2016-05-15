package cn.iwgang.countuptime;

import android.util.Log;

/**
 * 统一管理log类
 */
public class LogUtils {

  private static final boolean LOGGER = true;//

  private static String getVersion() {
    return " version is " + "";
  }

  public static void v(String tag,String mess) {
    if (LOGGER) {
      Log.v(tag ,getTags()+" "+  mess + getVersion());
    }
  }

  public static void d(String tag,String mess) {
    if (LOGGER) {
      Log.d(tag ,getTags()+" "+  mess + getVersion());
    }
  }

  public static void i(String tag,String mess) {
    if (LOGGER) {
      Log.i(tag ,getTags()+" "+  mess + getVersion());
    }
  }

  public static void w(String tag,String mess) {
    if (LOGGER) {
      Log.w(tag ,getTags()+" "+  mess + getVersion());
    }
  }

  public static void e(String tag,String mess) {
    if (LOGGER) {
      Log.e(tag ,getTags()+" "+  mess + getVersion());
    }
  }

  public static void e(String tag, String msg, Throwable tr) {
    if (LOGGER) {
      Log.e(tag, msg + getVersion());
    }
  }

  public static void v(String mess) {
    if (LOGGER) {
      v("",mess);
    }
  }

  public static void d(String mess) {
    if (LOGGER) {
      d("",mess);
    }
  }

  public static void i(String mess) {
    if (LOGGER) {
      i("",mess);
    }
  }

  public static void w(String mess) {
    if (LOGGER) {
      w("",mess);
    }
  }

  public static void e(String mess) {
    if (LOGGER) {
      e("",mess);
    }
  }

  /**
   * 获取日志的标签 格式：类名_方法名_行号 （需要权限：android.permission.GET_TASKS）
   *
   * @return tag
   * @see [类、类#方法、类#成员]
   */
  /**
   * 异常栈位移
   */
  private static final int EXCEPTION_STACK_INDEX = 2;
  private static String getTags()
  {
    try
    {
      Exception exception = new LogException();
      if (exception.getStackTrace() == null || exception.getStackTrace().length <= EXCEPTION_STACK_INDEX)
      {
        return "***";
      }
      StackTraceElement element = exception.getStackTrace()[EXCEPTION_STACK_INDEX];
      String className = element.getClassName();
      int index = className.lastIndexOf(".");
      if (index > 0)
      {
        className = className.substring(index + 1);
      }
      return className + "_" + element.getMethodName() + "_" + element.getLineNumber();
    }
    catch (Throwable e)
    {
      e.printStackTrace();
      return "***";
    }
  }

  /**
   * 取日志标签用的的异常类，只是用于取得日志标签
   */
  private static class LogException extends Exception
  {
    /**
     * 注释内容
     */
    private static final long serialVersionUID = 1L;
  }


}
