package com.irsbpm.ui;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class StatusWindow {
	private JFrame frame;
	private JTextPane txtMsg;
	private JTextField txtRup;
	private JTextField txtEup;
	private JTextField txtMef;
	private JTextField txtAir;
	private JTextField txtCade;
	private JTextField txtMasterFile;
	private JTextField txtIdrs;
	private JTextField txtCfol;
	private JTextField txtRrp;
	private JTextField txtAur;

	/**
	 * Create the application.
	 */
	public StatusWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("IRS BPM Demo Decision Systems Flow");

		try {
			frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("background.jpg")))));
		} catch (IOException e) {
			e.printStackTrace();
		}

		frame.setResizable(false);
		frame.setVisible(true);
		frame.setBounds(250, 200, 856, 469);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtMsg = new JTextPane();
		txtMsg.setText("> Status Message");
		txtMsg.setBackground(Color.BLACK);
		txtMsg.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMsg.setForeground(Color.RED);
		txtMsg.setBounds(10, 409, 830, 20);
		frame.getContentPane().add(txtMsg);

		txtRup = new JTextField();
		txtRup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RupButton(e);
			}
		});
		txtRup.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtRup.setHorizontalAlignment(SwingConstants.CENTER);
		txtRup.setText("RUP");
		txtRup.setBounds(55, 67, 120, 85);
		frame.getContentPane().add(txtRup);
		txtRup.setColumns(10);

		txtEup = new JTextField();
		txtEup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EupButton(e);
			}
		});
		txtEup.setText("EUP");
		txtEup.setHorizontalAlignment(SwingConstants.CENTER);
		txtEup.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtEup.setColumns(10);
		txtEup.setBounds(55, 198, 120, 85);
		frame.getContentPane().add(txtEup);

		txtMef = new JTextField();
		txtMef.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MefButton(e);
			}
		});
		txtMef.setText("MeF");
		txtMef.setHorizontalAlignment(SwingConstants.CENTER);
		txtMef.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMef.setColumns(10);
		txtMef.setBounds(212, 139, 120, 85);
		frame.getContentPane().add(txtMef);

		txtAir = new JTextField();
		txtAir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AirButton(e);

			}
		});
		txtAir.setText("AIR");
		txtAir.setHorizontalAlignment(SwingConstants.CENTER);
		txtAir.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAir.setColumns(10);
		txtAir.setBounds(212, 287, 120, 85);
		frame.getContentPane().add(txtAir);

		txtCade = new JTextField();
		txtCade.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CadeButton(e);
			}
		});
		txtCade.setText("CADE2");
		txtCade.setHorizontalAlignment(SwingConstants.CENTER);
		txtCade.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCade.setColumns(10);
		txtCade.setBounds(372, 67, 120, 85);
		frame.getContentPane().add(txtCade);

		txtMasterFile = new JTextField();
		txtMasterFile.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MFButton(e);

			}
		});
		txtMasterFile.setText("Master File");
		txtMasterFile.setHorizontalAlignment(SwingConstants.CENTER);
		txtMasterFile.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtMasterFile.setColumns(10);
		txtMasterFile.setBounds(372, 198, 120, 85);
		frame.getContentPane().add(txtMasterFile);

		txtIdrs = new JTextField();
		txtIdrs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				IdrsButton(e);

			}
		});
		txtIdrs.setText("IDRS");
		txtIdrs.setHorizontalAlignment(SwingConstants.CENTER);
		txtIdrs.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtIdrs.setColumns(10);
		txtIdrs.setBounds(526, 126, 120, 85);
		frame.getContentPane().add(txtIdrs);

		txtCfol = new JTextField();
		txtCfol.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		txtCfol.setText("CFOL");
		txtCfol.setHorizontalAlignment(SwingConstants.CENTER);
		txtCfol.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtCfol.setColumns(10);
		txtCfol.setBounds(526, 287, 120, 85);
		frame.getContentPane().add(txtCfol);

		txtRrp = new JTextField();
		txtRrp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RrpButton(e);

			}
		});
		txtRrp.setText("RRP");
		txtRrp.setHorizontalAlignment(SwingConstants.CENTER);
		txtRrp.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtRrp.setColumns(10);
		txtRrp.setBounds(671, 67, 120, 85);
		frame.getContentPane().add(txtRrp);

		txtAur = new JTextField();
		txtAur.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AurButton(e);
			}
		});
		txtAur.setText("AUR");
		txtAur.setHorizontalAlignment(SwingConstants.CENTER);
		txtAur.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAur.setColumns(10);
		txtAur.setBounds(671, 230, 120, 85);
		frame.getContentPane().add(txtAur);
	}

	public void RupButton(MouseEvent e) {
		RupColor(false);
	}

	public void EupButton(MouseEvent e) {
		RupColor(false);
	}

	public void MefButton(MouseEvent e) {
		RupColor(false);
	}

	public void AirButton(MouseEvent e) {
		RupColor(false);
	}

	public void CadeButton(MouseEvent e) {
		RupColor(false);
	}

	public void MFButton(MouseEvent e) {
		RupColor(false);
	}

	public void IdrsButton(MouseEvent e) {
		RupColor(false);
	}

	public void CfolButton(MouseEvent e) {
		RupColor(false);
	}

	public void RrpButton(MouseEvent e) {
		RupColor(false);
	}

	public void AurButton(MouseEvent e) {
		RupColor(false);
	}
	
	public void RupColor(Boolean b) {
		if (b) {
			txtRup.setBackground(Color.RED);

		} else {
			txtRup.setBackground(Color.WHITE);
		}
	}

	public void EupColor(Boolean b) {
		if (b) {
			txtEup.setBackground(Color.RED);

		} else {
			txtEup.setBackground(Color.WHITE);
		}
	}

	public void MefColor(Boolean b) {
		if (b) {
			txtMef.setBackground(Color.RED);

		} else {
			txtMef.setBackground(Color.WHITE);
		}
	}

	public void AirColor(Boolean b) {
		if (b) {
			txtAir.setBackground(Color.RED);

		} else {
			txtAir.setBackground(Color.WHITE);
		}
	}
	
	public void CadeColor(Boolean b) {
		if (b) {
			txtCade.setBackground(Color.RED);

		} else {
			txtCade.setBackground(Color.WHITE);
		}
	}

	public void MFColor(Boolean b) {
		if (b) {
			txtMasterFile.setBackground(Color.RED);

		} else {
			txtMasterFile.setBackground(Color.WHITE);
		}
	}

	public void IdrsColor(Boolean b) {
		if (b) {
			txtIdrs.setBackground(Color.RED);

		} else {
			txtIdrs.setBackground(Color.WHITE);
		}
	}

	public void CfolColor(Boolean b) {
		if (b) {
			txtCfol.setBackground(Color.RED);

		} else {
			txtCfol.setBackground(Color.WHITE);
		}
	}

	public void RrpColor(Boolean b) {
		if (b) {
			txtRrp.setBackground(Color.RED);

		} else {
			txtRrp.setBackground(Color.WHITE);
		}
	}

	public void AurColor(Boolean b) {
		if (b) {
			txtAur.setBackground(Color.RED);

		} else {
			txtAur.setBackground(Color.WHITE);
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StatusWindow window = new StatusWindow();
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
