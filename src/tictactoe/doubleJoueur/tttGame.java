package tictactoe.doubleJoueur;



import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class tttGame extends JPanel {
	
	char playerMark = 'x';
	JButton[] buttons = new JButton[9];
	
	public tttGame() {
		setLayout(new GridLayout(3,3));
		initializeButtons();
		
	}
	
	public void initializeButtons()
    {
        for(int i = 0; i <= 8; i++)
        {
            buttons[i] = new JButton();
            buttons[i].setText("-");
            buttons[i].setBackground(Color.white);
            buttons[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton buttonClicked = (JButton) e.getSource(); 
			        buttonClicked.setText(String.valueOf(playerMark));
			        
			        
			        if(playerMark == 'x') {
			        	playerMark = 'o';
			        	buttonClicked.setBackground(Color.CYAN);
			        }
			        else {
			        	playerMark ='x';
			        	buttonClicked.setBackground(Color.ORANGE);
			        }
			        displayVictor();
			        
					
				}
			});
            
            add(buttons[i]);       
        }
    }
	
	
	
	public void displayVictor() {
		
		if(checkForWinner() == true) {
			
			if(playerMark == 'x') playerMark = 'o';
	        else playerMark ='x';
			
			JOptionPane pane = new JOptionPane();
			int dialogResult = JOptionPane.showConfirmDialog(pane, "Game Over. "+ playerMark + " wins. Voudriez vous rejouer?","Game over.",
					JOptionPane.YES_NO_OPTION);
			
			if(dialogResult == JOptionPane.YES_OPTION) resetTheButtons();
			else System.exit(0);
		}
		
		else if(checkDraw()) {
			JOptionPane pane = new JOptionPane();
			int dialogResult = JOptionPane.showConfirmDialog(pane, "Win. Rejouer?","Game over.", JOptionPane.YES_NO_OPTION);
			if(dialogResult == JOptionPane.YES_OPTION)  resetTheButtons();
			else System.exit(0);
		}
	}
	
	private void resetTheButtons() {
		playerMark = 'x';
		for(int i =0;i<9;i++) {
			  
			  buttons[i].setText("-");
			  buttons[i].setBackground(Color.white);
			  
		  }	
	}

	public boolean checkDraw() {
		
		boolean full = true;
		for(int i = 0 ; i<9;i++) {
			if(buttons[i].getText().charAt(0) == '-') {
				full = false;
			}
		}
		return full;
	}
	
		public boolean checkForWinner() {
			if(checkRows() == true || checkColumns() == true || checkDiagonals() == true) return true;
			else return false;
		}
		
		public boolean checkRows() {
			int i = 0;
			for(int j = 0;j<3;j++) {
			if( buttons[i].getText().equals(buttons[i+1].getText()) && buttons[i].getText().equals(buttons[i+2].getText()) 
					&& buttons[i].getText().charAt(0) != '-') {
				return true;
			}
			i = i+3;
			
		}
			return false;
	}
		
		
		public boolean checkColumns() {
			
			int i = 0;
			for(int j = 0;j<3;j++) {
			if( buttons[i].getText().equals(buttons[i+3].getText()) && buttons[i].getText().equals(buttons[i+6].getText())
					&& buttons[i].getText().charAt(0) != '-') 
			{
				return true;
			}
			i++;
			}
			return false;	
		}
		
		public boolean checkDiagonals() {
			if(buttons[0].getText().equals(buttons[4].getText()) && buttons[0].getText().equals(buttons[8].getText())
					&& buttons[0].getText().charAt(0) !='-')
				return true;
			else if(buttons[2].getText().equals(buttons[4].getText()) && buttons[2].getText().equals(buttons[6].getText())
					&& buttons[2].getText().charAt(0) !='-') return true;
				
			else return false;
		}
	
	
	
	public void gametwoperson() {
		JFrame window = new JFrame("Tic Tac Toe");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new tttGame());
        window.setBounds(500,500,500,500); 
        window.setVisible(true); 
        window.setLocationRelativeTo(null); 
	}

}