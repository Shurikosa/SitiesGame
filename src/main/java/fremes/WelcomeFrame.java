package fremes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeFrame extends JFrame  {

    WelcomeFrame(){
        JButton button = new JButton("Старт"); // Создали кнопку
        button.setHorizontalTextPosition(JButton.CENTER);
        ImageIcon logo = new ImageIcon("src/main/resources/LOGO_2.png");        //TODO потрібно прив'язати файл.
        JLabel label = new JLabel("Вітаємо вас у грі дитинства і всіх розумників");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setTitle("Вітаємо");
        setIconImage(logo.getImage());
        setSize(400,100);
        setLocationRelativeTo(null); // Положення центр
        setVisible(true);
        add(label);
        add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMainFrame();
            }
        });
    }

    private void openMainFrame() {
        setVisible(false);
        dispose(); // Закриває вітальне вікно
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true); // Відкриває вікно гри
    }
}
