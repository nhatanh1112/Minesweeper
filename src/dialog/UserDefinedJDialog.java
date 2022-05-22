package dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import listener.UserDefinedListener;
import tools.StaticTool;
import main.MainFrame;

public class UserDefinedJDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jLabelHigh = new JLabel("Length: ");
	private JLabel jLabelWide = new JLabel("Width: ");
	private JLabel jLabelBomb = new JLabel("Mines: ");
	private JLabel jLabelMessage = new JLabel("    ");

	private JTextField jTextFieldLong;
	private JTextField jTextFieldWide;
	private JTextField jTextFieldBomb;

	private JPanel panel;

	private JButton buttonSure;

	private JButton buttonCancel;

	MainFrame mainFrame;
	// Customize Feature
	public UserDefinedJDialog(final MainFrame mainFrame) {

		// Customize panel in game dropbox
		super(mainFrame);
		this.mainFrame = mainFrame;
		jLabelMessage.setFont(new Font("", Font.PLAIN, 12));
		jLabelMessage.setForeground(Color.red);
		this.setTitle("Customize");
		this.add(getPanel());
		this.add(jLabelMessage, BorderLayout.NORTH);
		this.setSize(new Dimension(200, 150));
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);

		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowDeactivated(WindowEvent e) {

				mainFrame.reStartGame();
			}

		});
		this.setModal(true);
		this.setVisible(true);

	}

	public JPanel getPanel() {
		JPanel jPanel = new JPanel();

		Border border1 = BorderFactory.createEmptyBorder(5, 20, 5, 5);
		panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));

		// Length
		Box boxHigh = Box.createHorizontalBox();
		jTextFieldLong = new JTextField(StaticTool.allrow + "");
		jTextFieldLong.setPreferredSize(new Dimension(30, 20));
		jTextFieldLong.addKeyListener(new KeyListener() {

			// Input check for length
			@Override
			public void keyReleased(KeyEvent e) {
				String text = jTextFieldLong.getText();

				Pattern pattern = Pattern.compile("^[0-9]{1,3}$");
				Matcher matcher = pattern.matcher(text);
				if (!matcher.matches()) {
					jLabelMessage.setText("Please Input Appropriately!!!");
					if (text.length() > 3) {
						jTextFieldLong.setText(text.substring(0, 3));
					}

				}

			}

			@Override
			public void keyTyped(KeyEvent e) {

				char ch = e.getKeyChar();
				if ((ch < '0') || (ch > '9')) {
					jLabelMessage.setText("Input Number Please!!!");
					e.setKeyChar((char) 8);
				} else {
					jLabelMessage.setText("    ");

				}

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});

		boxHigh.add(jLabelHigh);
		boxHigh.add(jTextFieldLong);
		
		// Width
		Box boxWide = Box.createHorizontalBox();
		jTextFieldWide = new JTextField(StaticTool.allcol + "");
		jTextFieldWide.setPreferredSize(new Dimension(30, 20));
		jTextFieldWide.addKeyListener(new KeyListener() {

			// Input width check
			@Override
			public void keyReleased(KeyEvent e) {
				String text = jTextFieldWide.getText();

				Pattern pattern = Pattern.compile("^[0-9]{1,3}$");
				Matcher matcher = pattern.matcher(text);
				if (!matcher.matches()) {
					jLabelMessage.setText("Please Input Appropriately!!!");
					if (text.length() > 3) {
						jTextFieldWide.setText(text.substring(0, 3));
					}

				}

			}

			@Override
			public void keyTyped(KeyEvent e) {

				char ch = e.getKeyChar();
				if ((ch < '0') || (ch > '9')) {
					jLabelMessage.setText("Input Number Please!!!");
					e.setKeyChar((char) 8);
				} else {
					jLabelMessage.setText("    ");

				}

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		boxWide.add(jLabelWide);
		boxWide.add(jTextFieldWide);

		// Mines
		Box boxBomb = Box.createHorizontalBox();
		jTextFieldBomb = new JTextField(StaticTool.bombCount + "");
		jTextFieldBomb.setPreferredSize(new Dimension(30, 20));
		jTextFieldBomb.addKeyListener(new KeyListener() {

			// Input mines check
			@Override
			public void keyReleased(KeyEvent e) {
				String text = jTextFieldBomb.getText();

				Pattern pattern = Pattern.compile("^[0-9]{1,3}$");
				Matcher matcher = pattern.matcher(text);
				if (!matcher.matches()) {
					jLabelMessage.setText("Please Input Appropriately!!!");
					if (text.length() > 3) {
						jTextFieldBomb.setText(text.substring(0, 3));
					}

				}

			}

			@Override
			public void keyTyped(KeyEvent e) {

				char ch = e.getKeyChar();
				if ((ch < '0') || (ch > '9')) {
					jLabelMessage.setText("Input Number Please!!!");
					e.setKeyChar((char) 8);
				} else {
					jLabelMessage.setText("    ");

				}

			}

			@Override
			public void keyPressed(KeyEvent e) {

			}
		});
		boxBomb.add(jLabelBomb);
		boxBomb.add(jTextFieldBomb);

		// Customize box
		Box boxS = new Box(BoxLayout.Y_AXIS);
		boxS.add(boxHigh);
		boxS.add(Box.createVerticalStrut(8));
		boxS.add(boxWide);
		boxS.add(Box.createVerticalStrut(8));
		boxS.add(boxBomb);
		boxS.add(Box.createVerticalStrut(8));
		boxS.setBorder(border1);
		Box boxT = new Box(BoxLayout.Y_AXIS);
		buttonSure = new JButton("Apply");

		UserDefinedListener definedListener = new UserDefinedListener(this,
				mainFrame);
		buttonSure.setPreferredSize(new Dimension(70, 30));
		buttonSure.setMargin(new Insets(0, 2, 0, 2));
		buttonSure.addActionListener(definedListener);

		buttonCancel = new JButton("Close");
		buttonCancel.setMargin(new Insets(0, 2, 0, 2));
		buttonCancel.setSize(new Dimension(70, 30));
		buttonCancel.addActionListener(definedListener);
		boxT.add(buttonSure);
		boxT.add(Box.createVerticalStrut(25));
		boxT.add(buttonCancel);
		boxT.setBorder(border1);
		panel.add(boxS);
		panel.add(boxT);

		Border border = BorderFactory.createEmptyBorder(3, 15, 5, 15);
		jPanel.setBorder(border);
		jPanel.add(panel);
		return jPanel;
	}

	public JLabel getjLabelMessage() {
		return jLabelMessage;
	}

	public JTextField getjTextFieldLong() {
		return jTextFieldLong;
	}

	public JTextField getjTextFieldWide() {
		return jTextFieldWide;
	}

	public JTextField getjTextFieldBomb() {
		return jTextFieldBomb;
	}

	public JButton getButtonSure() {
		return buttonSure;
	}

	public JButton getbuttonCancel() {
		return buttonCancel;
	}

}
