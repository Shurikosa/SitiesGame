package fremes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RulesOfTheGame extends JFrame {
    RulesOfTheGame() {
        JButton button = new JButton("Продовжити");
        button.setHorizontalTextPosition(JButton.CENTER);
        ImageIcon logo = new ImageIcon("src/main/resources/LOGO_2.png");
        JTextArea textArea = new JTextArea("Гра для кількох (двох або більше) осіб, у якій кожен учасник у свою чергу називає реально існуюче місто України, назва якого починається на ту літеру, якою закінчується назва попереднього міста.\nВинятки становлять назви, що закінчуються на м'які знаки, а також літеру «И» : у таких випадках учасник називає місто на передостанню літеру");
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setTitle("Правила гри");
        setIconImage(logo.getImage());
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        add(panel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMainFrame();
            }
        });

        setVisible(true);
    }

    private void openMainFrame() {
        setVisible(false);
        dispose();
        MainFrame mainFrame = new MainFrame();
        mainFrame.setVisible(true);
    }
}
