package com.framework;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import com.epam.reportportal.message.ReportPortalMessage;
import com.epam.reportportal.service.ReportPortal;

public class MyLogger {
	File file = null;

	public MyLogger() {
		// TODO Auto-generated constructor stub
		file = new File("test-output/execution.log");
	}

	public static void write(LogLevel logLevel, String rp_message) {
		// String screenshot_file_path = "resources/Holiday_Pune_2019.jpg";
		ReportPortalMessage message = null;
		try {
			File destFile = Selenium.Screenshot();
			if (destFile == null)
				message = new ReportPortalMessage(rp_message);
			else
				message = new ReportPortalMessage(destFile, rp_message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ReportPortal.emitLog(message, logLevel.toString(), Calendar.getInstance().getTime());
	}
}
