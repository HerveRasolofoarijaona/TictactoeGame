package tictactoe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import tictactoe.SimpleJoueur.tictactoeOne;
import tictactoe.doubleJoueur.tttGame;

@SuppressWarnings("serial")
public class Acceuil extends  JFrame {
	
	@SuppressWarnings("deprecation")
	public Acceuil() {
		super();
	      setTitle("Tictactoe Games ");
	      setSize(400,250);
	      CardLayout cl = new CardLayout();
	      setLayout(cl);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	      //création d'un panneau contenant les contrôles d'un onglet
	      Panel p = new Panel();
	      p.setSize(400, 250);
	      
	      //ajouter les composants au panel
	      
	      Button onegame = new Button("Simple Joueur");
	      onegame.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					tictactoeOne me = new tictactoeOne();
					me.computegame();
					
				}
			});
	      
	      Button twogame = new Button("Double Joueur");
	      twogame.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					tttGame me = new tttGame();					
					me.gametwoperson();
				}
			});
	      
	     
	      p.add(onegame);
	      p.add(twogame);
	      

	      //inclure le panneau dans la fenetre sous le nom "Page1"
	      // ce nom est utilisé par show()

	      add("Game",p);     
	      pack();
	      show();   
	 }
	
	public static void main(String[] args) {
	      new Acceuil();
	 }

	
}
