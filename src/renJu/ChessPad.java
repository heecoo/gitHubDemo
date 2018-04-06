package renJu;

import java.awt.*;
import java.awt.event.*;

/**
 * @author kent
 * 创建棋盘的类
 */
public class ChessPad extends Panel implements MouseListener,ActionListener{
    int x=-1,y=-1,colorOfChess=1;
    Button button = new Button("restart");
    TextField text_1= new TextField("请黑子落子");
    TextField text_2= new TextField();

    ChessPad(){
        setSize(440,440);
        setLayout(null);
        setBackground(Color.ORANGE);
        addMouseListener(this);
        add(button);
        button.setBounds(10,5,60,26);
        button.addActionListener(this);
        add(text_1);
        text_1.setBounds(290,5,90,24);
        add(text_2);
        text_2.setBounds(290,5,90,24);
        text_1.setEditable(false);
        text_2.setEditable(false);
    }
    //绘制围棋棋盘外观
    public void paint(Graphics graphics){
        for (int i=40;i<=400;i+=20){
            graphics.drawLine(40,i,400,i);
        }
        for (int j=40;j<400;j+=20){
            graphics.drawLine(j,40,j,400);
        }
        //五个小点
        graphics.fillOval(97,97,6,6);
        graphics.fillOval(97,337,6,6);
        graphics.fillOval(337,97,6,6);
        graphics.fillOval(337,337,6,6);
        graphics.fillOval(217,217,6,6);
    }
    public void mousePressed(MouseEvent event){
        if (event.getModifiers() == InputEvent.BUTTON1_MASK){
            x= event.getX();
            y= event.getY();

            ChessPoint_black chessPoint_black = new ChessPoint_black(this);
            ChessPoint_white chessPoint_white = new ChessPoint_white(this);
            int a = (x+10)/20,b=(y+10)/20;
            if (x/20 < 2 || y/20 < 2 ||x/20 > 19 ||y/20 > 19){}
            else {
                if (colorOfChess==1){
                    this.add(chessPoint_black);
                    chessPoint_black.setBounds(a*20-10,b*20-10,20,20);
                    colorOfChess = colorOfChess*(-1);
                    text_1.setText(null);
                    text_2.setText("请白棋落子");
                    }else if (colorOfChess == -1){
                    this.add(chessPoint_black);
                    chessPoint_white.setBounds(a*20-10,b*20-10,20,20);
                    colorOfChess = colorOfChess*(-1);
                    text_1.setText("请黑棋落子");
                    text_2.setText(null);
                }
            }
        }
    }
    public void mouseReleased(MouseEvent event){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseClicked(MouseEvent e){}
    public void actionPerformed(ActionEvent actionEvent){
        this.removeAll();
        colorOfChess=1;
        add(button);
        button.setBounds(10,5,60,26);
        add(text_1);
        text_1.setBounds(90,5,90,24);
        add(text_2);
        text_2.setBounds(290,5,90,24);
        text_1.setText("请黑棋落子");
        text_2.setText(null);
    }
}
