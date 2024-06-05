package utilities;

import factory.BaseClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.util.HashMap;

public class ServerManager {
    private static ServerManager serverManager = null;
    ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();

    public static ServerManager getInstance() {
        if (serverManager == null) {
            serverManager = new ServerManager();
        }
        return serverManager;
    }

    public void startServer(){
        String nodeJsMainPath = "C:\\Users\\ndthanh1\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
        String nodeExePath = "C:\\Program Files\\nodejs\\node.exe";
        String logFilePath = System.getProperty("user.dir") + "\\logs\\automation.log";

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
//        builder
//                .withAppiumJS(new File(nodeJsMainPath))
//                .usingDriverExecutable(new File(nodeExePath))
//                .usingPort(4723)
//                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
//                .withLogFile(new File(logFilePath))
//                .withIPAddress("127.0.0.1");
        builder
                .withAppiumJS(new File(nodeJsMainPath))
                .usingDriverExecutable(new File(nodeExePath))
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
                .withLogFile(new File(logFilePath));
        server.set(AppiumDriverLocalService.buildService(builder));

//        server.set(AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)));
//
//        AppiumDriverLocalService server = WindowsGetAppiumService();
        server.get().start();
        if(server.get() == null || !server.get().isRunning()){
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started. ABORT!!!");
        }
//        server.get().clearOutPutStreams(); // -> Comment this if you want to see server logs in the console
    }

    public AppiumDriverLocalService getServer() {
        return server.get();
    }

//    public AppiumDriverLocalService getAppiumServerDefault() {
//        return AppiumDriverLocalService.buildDefaultService();
//    }
//
//    public AppiumDriverLocalService WindowsGetAppiumService() {
//        GlobalParams params = new GlobalParams();
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE));
//                .withLogFile(new File(params.getPlatformName() + "_"
//                        + params.getDeviceName() + File.separator + "Server.log")));
//    }
//
//    public AppiumDriverLocalService MacGetAppiumService() {
//        GlobalParams params = new GlobalParams();
//        HashMap<String, String> environment = new HashMap<String, String>();
//        environment.put("PATH", "enter_your_path_here" + System.getenv("PATH"));
//        environment.put("ANDROID_HOME", "enter_your_android_home_path");
//        environment.put("JAVA_HOME", "enter_your_java_home_path");
//        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
//                .usingDriverExecutable(new File("/usr/local/bin/node"))
//                .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
//                .usingAnyFreePort()
//                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
//                .withEnvironment(environment)
//                .withLogFile(new File(params.getPlatformName() + "_"
//                        + params.getDeviceName() + File.separator + "Server.log")));
//    }
}
