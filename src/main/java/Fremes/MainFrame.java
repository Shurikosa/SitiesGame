package Fremes;

import Controller.Controller;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextField inputField;
    private JLabel computerResponseLabel;

    public MainFrame() {
        setTitle("МІСТА УКРАЇНИ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        ImageIcon logo = new ImageIcon("src/main/resources/LOGO_2.png");
        setIconImage(logo.getImage());

        // Основний контейнер вікна
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

        // Панель вводу
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());

        JLabel inputLabel = new JLabel("Введіть місто:");
        inputField = new JTextField(15);
        JButton submitButton = new JButton("Зробити хід");

        // Збільшення розміру шрифту для компонентів вводу
        Font labelFont = inputLabel.getFont();
        Font largerLabelFont = labelFont.deriveFont(labelFont.getSize() + 15f);
        inputLabel.setFont(largerLabelFont);

        Font fieldFont = inputField.getFont();
        Font largerFieldFont = fieldFont.deriveFont(fieldFont.getSize() + 15f);
        inputField.setFont(largerFieldFont);

        Font buttonFont = submitButton.getFont();
        Font largerButtonFont = buttonFont.deriveFont(buttonFont.getSize() + 15f);
        submitButton.setFont(largerButtonFont);

        // Додаємо компоненти на панель вводу
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0); // Відступи вниз
        inputPanel.add(inputLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 0, 0); // Нульові відступи
        inputPanel.add(inputField, gbc);

        // Панель для центрування кнопки
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);

        // Додаємо компоненти на панель вводу
        gbc.gridy = 2;
        inputPanel.add(buttonPanel, gbc);

        // Панель відповіді комп'ютера
        JPanel responsePanel = new JPanel();
        responsePanel.setLayout(new FlowLayout());

        computerResponseLabel = new JLabel();
        Font responseLabelFont = computerResponseLabel.getFont();
        Font largerResponseLabelFont = responseLabelFont.deriveFont(responseLabelFont.getSize() + 15f);
        computerResponseLabel.setFont(largerResponseLabelFont);

        JLabel responseLabel = new JLabel("Відповідь комп'ютера:");
        responseLabel.setFont(largerLabelFont);
        responsePanel.add(responseLabel);
        responsePanel.add(computerResponseLabel);

        // Додаємо панелі в контейнер
        container.add(inputPanel, BorderLayout.NORTH);
        container.add(responsePanel, BorderLayout.CENTER);

        // Додаємо обробник події для кнопки "Зробити хід"
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputCity = inputField.getText();
                // Виконати дії, пов'язані з ходом гри
                Controller.performMove(inputCity, computerResponseLabel);
            }
        });
    }

}