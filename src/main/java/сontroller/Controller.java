package сontroller;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    //TODO потрібно надати значення змінним
    private List<String> usedCities = new ArrayList<>();
    private List<String> namesCities = new ArrayList<>(CitiesUtils.getWords());

    String lastLetterComputer;
    String lastLetterUser;
    int userCount;
    int computerCount=0;


    //метод реалізує прийняття запиту, обробку та надання відповіді
    public void getCityValidation(String inputCity, JLabel computerResponseLabel, JTextField inputField, JLabel userScoreLabel, JLabel computerScoreLabel) {

        if (inputCity != null && validateInput(inputCity)) {
            usedCities.add(inputCity);
            lastLetterUser = getLastLetterUser(inputCity);
            String computerCity = getNextCity(inputCity);
            userCount++;
            userScoreLabel.setText(String.valueOf(userCount));

            if (computerCity != null) {
                lastLetterComputer = getLastLetterComputer(computerCity);
                computerCount++;
                computerScoreLabel.setText(String.valueOf(userCount));
                computerResponseLabel.setText(computerCity);
            }

        } else if (inputCity.equalsIgnoreCase("Здаюсь")) {
            JOptionPane.showMessageDialog(null, "\"Ви програли з рахунком\"" + userCount + ":" + computerCount, "Нажаль", JOptionPane.PLAIN_MESSAGE);
        } else if (inputCity != null && !namesCities.contains(inputCity)) {
            JOptionPane.showMessageDialog(null, "Місто \"" + inputCity + "\" не знайдено", "Помилка", JOptionPane.PLAIN_MESSAGE);
        } else if (usedCities.contains(inputCity)) {
            JOptionPane.showMessageDialog(null, "Місто \"" + inputCity + "\" уже використане", "Помилка", JOptionPane.PLAIN_MESSAGE);
            //TODO потрібно додати посилання на клас який реалізує введення рахунку та змінити текст
        } else if (inputCity != null && !lastLetterComputer.equalsIgnoreCase(inputCity.substring(0, 1))) {
            JOptionPane.showMessageDialog(null, "Місто повинно починатися на літеру \"" + lastLetterComputer + "\"", "Помилка", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "\"Ви перемогли з рахунком\"" + userCount + ":" + computerCount, "Вітаємо", JOptionPane.PLAIN_MESSAGE);

        }
        inputField.setText("");
    }

    // метод перевіряє отриманий запит на валідність
    private boolean validateInput(String city){

        if (lastLetterComputer == null) {
            return namesCities.contains(city) && !usedCities.contains(city);
        } else {
            return namesCities.contains(city) && !usedCities.contains(city) && lastLetterComputer.equalsIgnoreCase(city.substring(0, 1));
        }
    }

    // отримуємо останню літеру слова введеного користувачам та замінюємо у разі невідповідності
    private String getLastLetterUser(String city) {
        int index = city.length() - 1;
        String lastLetter = String.valueOf(city.toLowerCase().charAt(index));
        if (lastLetter.equalsIgnoreCase("ґ") || lastLetter.equalsIgnoreCase("ї") || lastLetter.equalsIgnoreCase("й") || lastLetter.equalsIgnoreCase("ь") || lastLetter.equalsIgnoreCase("и")) {
            lastLetter = String.valueOf(city.toUpperCase().charAt(index - 1));
        }

        return lastLetter;
    }


    // отримуємо назву міста яке надсилатимиться у відповідь від комп'ютера
    private String getNextCity(String answer) {
        String nextCity = null;

        for (String city : namesCities) {
            if (!city.equalsIgnoreCase(answer) && !usedCities.contains(city) && lastLetterUser.equalsIgnoreCase(city.substring(0, 1))) {

                nextCity = city;
                break;
            }
        }

        if (nextCity != null) {
            usedCities.add(nextCity);
        }

        return nextCity;
    }

    // отримуємо останню літеру слова введеного комп'ютером та замінюємо у разі невідповідності
    private String getLastLetterComputer(String city) {
        int index = city.length() - 1;
        String lastLetterComputer = String.valueOf(city.toLowerCase().charAt(index));
        if (lastLetterComputer.equalsIgnoreCase("ґ") || lastLetterComputer.equalsIgnoreCase("ї") || lastLetterComputer.equalsIgnoreCase("й") || lastLetterComputer.equalsIgnoreCase("ь") || lastLetterComputer.equalsIgnoreCase("и")) {
            lastLetterComputer = String.valueOf(city.toUpperCase().charAt(index - 1));
        }

        return lastLetterComputer;
    }

    public void setUsedCities(List<String> usedCities) {
        this.usedCities = usedCities;
    }

    public List<String> getUsedCities() {
        return usedCities;
    }

    public void setNamesCities(List<String> namesCities) {
        this.namesCities = namesCities;
    }

    public List<String> getNamesCities() {
        return namesCities;
    }

}
