package com.irsbpm.ui;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import com.irsbpm.main.IRSBPMDecision;

import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventWindow {
	private JFrame frame;
	private JTextPane txtMsg;
	private JButton btnNewButton_4;
	private JButton btnNewButton_6;
	private JButton btnNewButton_5;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	/**
	 * Create the application.
	 */
	public EventWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("IRS BPM Alert Event");

		frame.setResizable(false);
		frame.setVisible(true);
		frame.setBounds(50, 150, 396, 184);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtMsg = new JTextPane();
		txtMsg.setText("> Status Message");
		txtMsg.setBackground(Color.BLACK);
		txtMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMsg.setForeground(Color.RED);
		txtMsg.setBounds(10, 118, 364, 20);
		frame.getContentPane().add(txtMsg);

		btnNewButton_4 = new JButton("Alert MFOL");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alertMFOLButton(e);
			}
		});
		btnNewButton_4.setBounds(10, 67, 111, 23);
		frame.getContentPane().add(btnNewButton_4);

		btnNewButton_6 = new JButton("Clear Alert");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				clearAlertButton(e);
			}
		});
		btnNewButton_6.setBounds(250, 67, 111, 23);
		frame.getContentPane().add(btnNewButton_6);
		
		btnNewButton_5 = new JButton("Alert IDRS");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alertIDRSButton(e);
			}
		});
		btnNewButton_5.setBounds(133, 67, 111, 23);
		frame.getContentPane().add(btnNewButton_5);
		
		btnNewButton_1 = new JButton("Alert RUP");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alertRUPButton(e);
			}
		});
		btnNewButton_1.setBounds(10, 29, 111, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Alert EUP");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alertEUPButton(e);
			}
		});
		btnNewButton_2.setBounds(133, 32, 111, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Alert MeF");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				alertMeFButton(e);
			}
		});
		btnNewButton_3.setBounds(250, 32, 111, 23);
		frame.getContentPane().add(btnNewButton_3);

	}

	public void alertRUPButton(MouseEvent e) {
		IRSBPMDecision.alertRUPAction();
	}

	public void alertEUPButton(MouseEvent e) {
		IRSBPMDecision.alertEUPAction();
	}

	public void alertMeFButton(MouseEvent e) {
		IRSBPMDecision.alertMeFAction();
	}

	public void alertMFOLButton(MouseEvent e) {
		IRSBPMDecision.alertMFOLAction();
	}
	
	public void alertIDRSButton(MouseEvent e) {
		IRSBPMDecision.alertIDRSAction();
	}

	public void clearAlertButton(MouseEvent e) {
		IRSBPMDecision.clearAlertAction();
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EventWindow window = new EventWindow();
//				window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}