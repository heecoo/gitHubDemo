package renJu;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Chess extends Frame {
    ChessPad chessPad = new ChessPad();
    Chess(){
        setVisible(true);
        setLayout(null);
        Label label=new Label("welcom to Heecoo chess game",Label.CENTER);
        add(label);
        label.setBounds(70,55,440,26);
        label.setBackground(Color.ORANGE);
        add(chessPad);
        chessPad.setBounds(70,90,440,440);
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.exit(0);
            }
        });
        pack();
        setSize(600,550);
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
    }
}
