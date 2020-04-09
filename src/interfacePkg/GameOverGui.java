package interfacePkg;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.awt.event.ActionEvent;

public class GameOverGui extends JDialog
{	
	private static final long serialVersionUID = 1L;

	private BattleShip gui;
	private String appPath;
	private JLabel congratLbl;
	private JLabel congratMsgLbl;
	private JLabel picLbl;
	
	public GameOverGui(String appPath, BattleShip myGui)
	{
		this.gui = myGui;
		this.appPath = appPath;
		initializeComponents();		
	}
	
	private void initializeComponents() 
	{
//		setIconImage(Toolkit.getDefaultToolkit().getImage(this.appPath+"icon.png"));
		setTitle("Game Over");
		setAlwaysOnTop(true);
		setResizable(false);
		setSize(600, 525);
		getContentPane().setLayout(null);
		
		this.congratLbl = new JLabel("Chuc mung.");
		this.congratLbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.congratLbl.setFont(new Font("Arial", Font.BOLD, 28));
		this.congratLbl.setBounds(10, 11, 574, 33);
		getContentPane().add(this.congratLbl);
		
		this.congratMsgLbl = new JLabel("Ban thang nhung may thi chua :v");
		this.congratMsgLbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.congratMsgLbl.setFont(new Font("Arial", Font.PLAIN, 22));
		this.congratMsgLbl.setBounds(20, 55, 574, 33);
		getContentPane().add(this.congratMsgLbl);
		
		this.picLbl = new JLabel("");
		this.picLbl.setHorizontalAlignment(SwingConstants.CENTER);
		this.picLbl.setIcon(new ImageIcon(this.appPath+"win1.png"));
		this.picLbl.setBounds(10, 99, 500, 300);
		getContentPane().add(this.picLbl);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 410, 574, 2);
		getContentPane().add(separator);
		
		JSeparator separator1 = new JSeparator();
		separator1.setBounds(10, 495, 574, 2);
		getContentPane().add(separator1);
		
		JButton btnNewGame = new JButton("New Game");
		btnNewGame.setFont(new Font("Arial", Font.PLAIN, 18));
		btnNewGame.setBounds(10, 425, 264, 53);
		btnNewGame.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				gui.enableShipAllocation(true);
				gui.restartAllocations();
				if (gui.isSinglePlayer())
				{
					gui.StopSingleGame();
					gui.writeOutputMessage(" - Dat thuyen di ban eii, xong thi an nut Start game nha.");
				}
				dispose();
			}
		});
		getContentPane().add(btnNewGame);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("Arial", Font.PLAIN, 18));
		btnClose.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				gui.enableShipAllocation(true);
				gui.restartAllocations();
				if (gui.isSinglePlayer())
				{
					gui.StopSingleGame();
					gui.writeOutputMessage(" - Cam on ban da choi game.");
					gui.writeOutputMessage(" - Neu ban quyet dinh choi thi hay dat thuyen và an Start Game nha.");
				}
				dispose();
			}
		});
		btnClose.setBounds(320, 425, 264, 53);
		getContentPane().add(btnClose);
	}

	public void ShowGameOver(int flag)
	{
		switch (flag)
		{
			case 0: //lose
			{
				this.congratLbl.setText("You lost!");
				this.congratMsgLbl.setText("Ban thua rui. Phuc thu di chu.");
				this.picLbl.setIcon(new ImageIcon(this.appPath+"gameover.png"));
				break;
			}
			case 1: //win
			{
				this.congratLbl.setText("Congratulations!");
				this.congratMsgLbl.setText("Ban thang rui do, nhung may thi chua dau nha.");
				this.picLbl.setIcon(new ImageIcon(this.appPath+"win.png"));
				break;
			}
		}
		setLocationRelativeTo(this.gui);
	}
}
