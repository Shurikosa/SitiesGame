package Fremes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame implements ActionListener {
    private final JButton button;
    WelcomeFrame(){
        button = new JButton();
        button.setText("Ok");
        button.setHorizontalTextPosition(JButton.CENTER);
        ImageIcon logo = new ImageIcon("LOGO.png");        //TODO потрібно прив'язати файл.
        JLabel label = new JLabel("Вітаємо вас у грі дитинства і всіх розумників");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setTitle("Вітаємо");
        this.setIconImage(logo.getImage());
        this.setSize(400,100);
        this.setVisible(true);
        this.add(label);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //TODO реалізувати метод для кнопки.
        if (e.getSource() == button){

        }
    }
}
