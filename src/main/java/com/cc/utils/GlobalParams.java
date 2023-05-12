package com.cc.utils;

/**
 * Class for global parameters used in the project
 */
public class GlobalParams {
    private static ThreadLocal<String> platformName = new ThreadLocal<String>();
    private static ThreadLocal<String> udid = new ThreadLocal<String>();
    private static ThreadLocal<String> browsername = new ThreadLocal<String>();
    private static ThreadLocal<String> deviceName = new ThreadLocal<String>();
    private static ThreadLocal<String> language = new ThreadLocal<String>();
    private static ThreadLocal<String> systemPort = new ThreadLocal<String>();
    private static ThreadLocal<String> wdaLocalPort = new ThreadLocal<String>();
    private static ThreadLocal<String> webkitDebugProxyPort = new ThreadLocal<String>();

    public void setPlatformName(String platformNameValue){
        platformName.set(platformNameValue);
    }

    public String getPlatformName(){
        return platformName.get();
    }

    public String getUDID() {
        return udid.get();
    }

    public void setUDID(String udidValue) {
        udid.set(udidValue);
    }

    public String getBrowsername() {
        return browsername.get();
    }

    public void setBrowsername(String Browsername) {
        //Browsername.set(Browsername);
        browsername.set(Browsername);
    }



    public String getDeviceName() {
        return deviceName.get();
    }

    public void setDeviceName(String deviceNameValue) {
        deviceName.set(deviceNameValue);
    }

    public String getLanguage() {
        return language.get();
    }

    public void setLanguage(String languageValue) {
        language.set(languageValue);
    }

    public String getSystemPort() {
        return systemPort.get();
    }

    public void setSystemPort(String systemPortValue) {
        systemPort.set(systemPortValue);
    }

    public String getWdaLocalPort() {
        return wdaLocalPort.get();
    }

    public void setWdaLocalPort(String wdaLocalPort2) {
        wdaLocalPort.set(wdaLocalPort2);
    }

    public String getWebkitDebugProxyPort() {
        return webkitDebugProxyPort.get();
    }

    public void setWebkitDebugProxyPort(String webkitDebugProxyPort2) {
        webkitDebugProxyPort.set(webkitDebugProxyPort2);
    }

    /**
     * Initialize global parameters
     */
    public void initializeGlobalParams(){
        GlobalParams params = new GlobalParams();
        params.setPlatformName(System.getProperty("platformName", "Chrome"));
//        params.setPlatformName(System.getProperty("platformName", "Android"));
      params.setLanguage(System.getProperty("language", "en"));
//      params.setLanguage(System.getProperty("language", "ar"));

        switch(params.getPlatformName()){
            case "Chrome":
                break;
            case "Android":
                //System port is used for parallel execution

                params.setSystemPort(System.getProperty("systemPort", "10000"));
                params.setUDID(System.getProperty("udid", "emulator-5554"));
                params.setDeviceName(System.getProperty("deviceName", "sdk_gphone64_x86_64"));
//                params.setBrowsername(System.getProperty("browserName", "Chrome"));

                break;
            case "iOS":
                params.setUDID(System.getProperty("udid", "emulator-5554"));
                params.setDeviceName(System.getProperty("deviceName", "Emulator"));
                params.setWdaLocalPort(System.getProperty("wdaLocalPort", "10001"));
                params.setWebkitDebugProxyPort(System.getProperty("webkitDebugProxyPort", "11001"));
                break;
            default:
                throw new IllegalStateException("Invalid Platform Name!");
        }
    }
}
