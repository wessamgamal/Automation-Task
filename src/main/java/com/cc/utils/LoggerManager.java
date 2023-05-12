package com.cc.utils;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerManager {
	public static final long WAIT = 10;

	/**
	 * logging method
	 * @return
	 */
	public Logger log() {
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}

	public void logReportInfo(String message){
		Allure.addAttachment("Info",message);
	}
}

