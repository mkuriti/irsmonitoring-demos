package com.irsbpm.main;

import java.awt.EventQueue;
import java.io.File;
import java.util.Locale;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.irsbpm.model.EventMessage;
import com.irsbpm.ui.EventWindow;
import com.irsbpm.ui.StatusWindow;

/**
 * This is a sample class to launch the IRS BPM System Flow rule IRS BPM System
 * Flow :: Drools-jBPM Expert System Flow IRS BPM :: IRS Application using jBPM
 * and Drools Rules Engine for System Flow
 */

public class IRSBPMDecision {
	IRSBPMDecision irsbpmDecisionTable;

	private String base_path = "";
	private boolean is64bitJMV = false;

	private String knowledgeDebug = "none"; // none, debug
	private String kSessionType = ""; // createKieSession
	private String kSessionName = ""; // ksession-IRScontrol
	private String processID = ""; // com.IRSControl
	private long startTime = 0; // Time the server started

	private EventWindow eventwindow;
	private static StatusWindow statuswindow;

	public IRSBPMDecision(String[] args) {

		this.irsbpmDecisionTable = this;

		if (knowledgeDebug.indexOf("none") == -1) {
			System.out.println("os.name: " + System.getProperty("os.name"));
			System.out.println("os.arch: " + System.getProperty("os.arch"));
			is64bitJMV = (System.getProperty("os.arch").indexOf("64") != -1);
			String result = (is64bitJMV == true) ? "64bit" : "32bit";

			System.out.println("java.home: " + System.getProperty("java.home"));
			System.out.println("java.vendor: " + System.getProperty("java.vendor"));
			System.out.println("java.version: " + System.getProperty("java.version") + " " + result);
			long maxHeapBytes = Runtime.getRuntime().maxMemory();
			System.out.println("Max heap memory: " + maxHeapBytes / 1024L / 1024L + "M");
			System.out.println("java.io.tmpdir: " + System.getProperty("java.io.tmpdir"));
			System.out.println("user.home: " + System.getProperty("user.home"));

			base_path = (System.getProperty("user.home") + File.separator);

			System.out.println("base_path: " + base_path);
			System.out.println("File.separator: " + File.separator);
			System.out.println("Local language: " + Locale.getDefault().getLanguage());
		}
		startTime = System.currentTimeMillis();
	}

	public void init(final boolean exitOnClose) {
		// set up and show main window
		Locale.setDefault(Locale.US);

		if (kSessionType == "") {
			kSessionType = "createKieSession"; // Default kSessionType=createKieSession
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					eventwindow = new EventWindow();
					// eventwWindow.show(); // .setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					statuswindow = new StatusWindow();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
//		startIRSServer();
	}

	public static void clearAlertAction() {
		statuswindow.RupColor(false);
		statuswindow.EupColor(false);
		statuswindow.MefColor(false);
		statuswindow.AirColor(false);
		statuswindow.CadeColor(false);
		statuswindow.MFColor(false);
		statuswindow.IdrsColor(false);
		statuswindow.CfolColor(false);
		statuswindow.RrpColor(false);
		statuswindow.AurColor(false);
	}

	public static void alertRUPAction() {
		startIRSServer(EventMessage.RUP);
		startIRSServer(EventMessage.MEF2);
		startIRSServer(EventMessage.CADE2);
		startIRSServer(EventMessage.MFOL2);
		startIRSServer(EventMessage.MFOL3);
		startIRSServer(EventMessage.MFOL4);
	}

	public static void alertEUPAction() {
		startIRSServer(EventMessage.EUP);
		startIRSServer(EventMessage.MEF2);
		startIRSServer(EventMessage.CADE2);
		startIRSServer(EventMessage.MFOL2);
		startIRSServer(EventMessage.MFOL3);
		startIRSServer(EventMessage.MFOL4);
	}
	
	public static void alertMeFAction() {
		startIRSServer(EventMessage.MEF);
		startIRSServer(EventMessage.MEF2);
		startIRSServer(EventMessage.CADE2);
		startIRSServer(EventMessage.MFOL2);
		startIRSServer(EventMessage.MFOL3);
		startIRSServer(EventMessage.MFOL4);
	}

	public static void alertMFOLAction() {
		startIRSServer(EventMessage.MFOL);
		startIRSServer(EventMessage.MFOL2);
		startIRSServer(EventMessage.MFOL3);
		startIRSServer(EventMessage.MFOL4);
	}

	public static void alertIDRSAction() {
		startIRSServer(EventMessage.IDRS);
	}
	
	// System.out.println(m.getMessage());
	public static void actionMessage(String m) {
		if (m == "Registered User Portal") {
			statuswindow.RupColor(true);
		}
		if (m == "Employee User Portal") {
			statuswindow.EupColor(true);
		}
		if (m == "Modernized e-File") {
			statuswindow.MefColor(true);
		}
		if (m == "Act Information Return") {
			statuswindow.AirColor(true);
		}
		if (m == "Customer Account Data Engine") {
			statuswindow.CadeColor(true);
		}
		if (m == "Master File On-Line") {
			statuswindow.MFColor(true);
		}
		if (m == "Integrated Data Retrieval System") {
			statuswindow.IdrsColor(true);
		}
		if (m == "Return Review Program") {
			statuswindow.CfolColor(true);
		}
		if (m == "Corporate Files on Line") {
			statuswindow.RrpColor(true);
		}
		if (m == "Automated Under-reporter") {
			statuswindow.AurColor(true);
		}
		// Decision Systems Flow Done
		// D:\Java\eclipse-irsbpm\irsdecisionflow\src\main\resources\com\irsbpm\dtables

	}

	public static void startIRSServer(int eventMsg) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-dtables");

			// go !
			EventMessage eventmessage = new EventMessage();
			eventmessage.setStatus(eventMsg);

			kSession.insert(eventmessage);
			kSession.fireAllRules();

		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	public static void stopIRSServer() {
//		System.out.println("Server <stop>");
	}

	public static void main(String[] args) {
		System.out.println("IRS Sensor Processor System jBPM Server");

		new IRSBPMDecision(args).init(true);
	}
}
