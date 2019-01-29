package hotfix.test.com.test;

public class Print {

    public static void say(){
        LoggerUtils.LOGD("say");
    }

    public static void hello(){
        LoggerUtils.LOGD("hello");
    }

    public static void talk(){
        LoggerUtils.LOGD("talk");
    }


    public static void error(){
        throw new NullPointerException("yoyo");
    }
}
