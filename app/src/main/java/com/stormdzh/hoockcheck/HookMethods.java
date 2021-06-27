package com.stormdzh.hoockcheck;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.location.LocationManager;
import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class HookMethods implements IXposedHookLoadPackage {

    private final String HOOK_TARGET = "com.stormdzh.hooksources";

    private static final String TAG = "codedzh";

    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {

        if (lpparam == null) {
            return;
        }
        Log.e(TAG, "进入hook的应用包名 : " + lpparam.packageName);
        /*判断hook的包名*/

//        if (!TextUtils.equals(HOOK_TARGET, lpparam.packageName)) {
//            return;
//        }

        //imei- getDeviceId-无参 固定格式
        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(), // 需要hook的方法所在类的完整类名
                lpparam.classLoader,                            // 类加载器，固定这么写就行了
                "getDeviceId",                     // 需要hook的方法名
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        String log = "检测到 调用getDeviceId()获取了imei";
                        Log.e(TAG, log);
                        XposedBridge.log(log);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("getDeviceId()");
                    }
                }
        );

        //imei-getDeviceId-有参
        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(),
                lpparam.classLoader,
                "getDeviceId",
                int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        String log = "检测到 调用getDeviceId(int)获取了imei";
                        Log.e(TAG, log);
                        XposedBridge.log(log);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("getDeviceId(1)");
                    }
                }
        );


        //imei- getImei-无参 固定格式
        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(), // 需要hook的方法所在类的完整类名
                lpparam.classLoader,                            // 类加载器，固定这么写就行了
                "getImei",                     // 需要hook的方法名
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        String log = "检测到 调用getImei()获取了imei";
                        Log.e(TAG, log);
                        XposedBridge.log(log);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("getImei()");
                    }
                }
        );

        //imei-getDeviceId-有参
        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(),
                lpparam.classLoader,
                "getImei",
                int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        String log = "检测到 调用getImei(int)获取了imei";
                        Log.e(TAG, log);
                        XposedBridge.log(log);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("getImei(1)");
                    }
                }
        );


        //imsi
        XposedHelpers.findAndHookMethod(
                android.telephony.TelephonyManager.class.getName(),
                lpparam.classLoader,
                "getSubscriberId",
                int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        String log = "检测到 调用getSubscriberId获取了imsi";
                        Log.e(TAG, log);
                        XposedBridge.log(log);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("getSubscriberId()");
                    }
                }
        );

        //mac
        XposedHelpers.findAndHookMethod(
                android.net.wifi.WifiInfo.class.getName(),
                lpparam.classLoader,
                "getMacAddress",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        String log = "检测到 调用getMacAddress()获取了mac地址";
                        Log.e(TAG, log);
                        XposedBridge.log(log);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("getMacAcdress()");
                    }
                }

        );

        //mac
        XposedHelpers.findAndHookMethod(
                java.net.NetworkInterface.class.getName(),
                lpparam.classLoader,
                "getHardwareAddress",
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        String log = "检测到 调用getHardwareAddress()获取了mac地址";
                        Log.e(TAG, log);
                        XposedBridge.log(log);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("getHardwareAddress()");
                    }
                }

        );

        //android id - android10 获取不到
//        XposedHelpers.findAndHookMethod(
//                android.provider.Settings.Secure.class.getName(),
//                lpparam.classLoader,
//                "getString",
//                android.content.ContentResolver.class,
//                String.class,
//                new XC_MethodHook() {
//                    @Override
//                    protected void beforeHookedMethod(MethodHookParam param) {
//                        if (param == null || param.args == null) {
//                            Log.e(TAG, "getString 参数为空！！！！！");
//                            return;
//                        }
//                        String log = "检测到 调用Settings.Secure.getstring获取了" + param.args[1];
//                        Log.e(TAG, log);
//                        XposedBridge.log(log);
//                    }
//                }
//        );

        //android id  https://www.52pojie.cn/thread-1063915-1-1.html
        //android.provider.Settings.System.getString
        XposedHelpers.findAndHookMethod(android.provider.Settings.System.class.getName(),
                lpparam.classLoader,
                "getString",
                ContentResolver.class,
                String.class,
                new XC_MethodHook() {

                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {

                        if (param == null || param.args == null) {
                            Log.e(TAG, "getString 参数为空！！！！！");
                            return;
                        }
                        String log = "检测到 调用Settings.Secure.getstring获取了" + param.args[1];
                        Log.e(TAG, log);
                        XposedBridge.log(log);

                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("AndroidId()");
                    }
                });


        //获取定位
        XposedHelpers.findAndHookMethod(
                LocationManager.class.getName(),
                lpparam.classLoader,
                "getLastKnownLocation",
                String.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        String log = "检测到 调用getLastKnownLocation获取了GPS地址";
                        Log.e(TAG, log);
                        XposedBridge.log(log);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("getLastKnownLocation()");
                    }
                }
        );

        //获取任务列表 getRecentTasks
        XposedHelpers.findAndHookMethod(
                ActivityManager.class.getName(),
                lpparam.classLoader,
                "getRecentTasks",
                int.class,
                int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        String log = "检测到 调用getRecentTasks获取任务列表";
                        Log.e(TAG, log);
                        XposedBridge.log(log);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("getRecentTasks()");
                    }
                }
        );


        //获取任务列表 getRunningTasks
        XposedHelpers.findAndHookMethod(
                ActivityManager.class.getName(),
                lpparam.classLoader,
                "getRunningTasks",
                int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) {
                        String log = "检测到 调用getRunningTasks（0）获取任务列表";
                        Log.e(TAG, log);
                        XposedBridge.log(log);
                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//                        super.afterHookedMethod(param);
                        printStackTree("getRunningTasks()");
                    }
                }
        );
    }


    public void printStackTree(String method) {
        XposedBridge.log("***********************************");
        XposedBridge.log(method + " 堆栈:---------------start----------------");
        Log.e(TAG, "***********************************");
        Log.e(TAG, method + " 堆栈:---------------start----------------");
        Throwable ex = new Throwable();
        StackTraceElement[] stackElements = ex.getStackTrace();
        for (int i = 0; i < stackElements.length; i++) {
            StackTraceElement element = stackElements[i];
            String format = String.format("at %s.%s(%s:%d)",
                    element.getClassName(), element.getMethodName(), element
                            .getFileName(), element.getLineNumber());
            XposedBridge.log(format);
            Log.e(TAG, format);
        }
        XposedBridge.log(method + " 堆栈:---------------end----------------");
        Log.e(TAG, method + " 堆栈:---------------end----------------");
    }


//    打印堆栈信息代码
//    findAndHookMethod(WifiInfo.class, "getImei", new XC_MethodHook() {
//        @Override
//        protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
////                    XposedBridge.log("getExternalStorageDirectory调用之前");
//        }
//
//        @SuppressLint("DefaultLocale")
//        @Override
//        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
//            XposedBridge.log("getImei() 堆栈:---------------start----------------");
//            Throwable ex = new Throwable();
//            StackTraceElement[] stackElements = ex.getStackTrace();
//            for (int i = 0; i < stackElements.length; i++) {
//                StackTraceElement element = stackElements[i];
//                XposedBridge.log(String.format("at %s.%s(%s:%d)",
//                        element.getClassName(), element.getMethodName(), element
//                                .getFileName(), element.getLineNumber()));
//            }
//            XposedBridge.log("getImei() 堆栈:---------------end----------------");
//        }
//    });
}
