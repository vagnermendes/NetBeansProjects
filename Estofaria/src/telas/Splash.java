package telas;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.geom.Dimension2D;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class Splash extends JWindow{

    private static final long serialVersionUID = 1L;
    private int duracao;

        public Splash(int d){
            duracao=d;
        }

        public void mostraSpalsh(){
            JPanel painel=(JPanel)getContentPane();
            int width =680;
            int height=177;
            Dimension2D screen = Toolkit.getDefaultToolkit().getScreenSize();
            int x = (int) ((screen.getWidth()-width)/2);
            int y = (int) ((screen.getHeight()-height)/2);
            setBounds(x,y,width,height);
            JLabel lbSpash= new JLabel(new javax.swing.ImageIcon(getClass().getResource("logo.png")));
            painel.add(lbSpash,BorderLayout.CENTER);
            painel.setBackground(Color.black);
            //Color linha = new Color(0,0,0,0);
            //painel.setBorder(BorderFactory.createLineBorder(linha,8));
            setVisible(true);

            try{
              Thread.sleep(duracao);
              setVisible(false);
              }
           catch(Exception e){
           JOptionPane.showMessageDialog(null,"Erro"+e.getMessage());
           }
        }
        public void mostraTela(){
         mostraSpalsh();

       }
}


