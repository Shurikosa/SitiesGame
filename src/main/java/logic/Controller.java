package logic;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<String> usedCities;
    private List<String> namesCities;
    private String lastLetterComputer;
    private String lastLetterUser;
    private int userCount;
    private int computerCount;

    public Controller(){
        this.namesCities = new ArrayList<>(CitiesUtils.readSitiesFromFile());
        this.usedCities = new ArrayList<>();
        this.computerCount = 0;
    }

    /**
     * method implements request acceptance, processing and response
     *
     * @param inputCity
     * @param computerResponseLabel
     * @param inputField
     */
    public void getCityValidation(String inputCity, JLabel computerResponseLabel, JTextField inputField, JLabel userScoreLabel, JLabel computerScoreLabel) {

        if (inputCity.isEmpty()) {
            JOptionPane.showMessageDialog(null, "\"Введіть назву міста\"", "Помилка", JOptionPane.PLAIN_MESSAGE);
        } else if (Character.isLowerCase(inputCity.charAt(0))) {
            JOptionPane.showMessageDialog(null, "\"Міста пишуться з великої літери\"", "Помилка", JOptionPane.PLAIN_MESSAGE);
        } else if (validateInput(inputCity)) {
            usedCities.add(inputCity);
            lastLetterUser = getLastLetterUser(inputCity);
            String computerCity = getNextCity(inputCity);
            userCount++;
            userScoreLabel.setText(String.valueOf(userCount));

            if (computerCity != null) {
                lastLetterComputer = getLastLetterComputer(computerCity);
                computerCount++;
                computerResponseLabel.setText(computerCity);
                computerScoreLabel.setText(String.valueOf(userCount));
            }
        } else if (inputCity.equalsIgnoreCase("Здаюсь")) {
            JOptionPane.showMessageDialog(null, "\"Ви програли з рахунком " + userCount + ":" + computerCount + "\"", "Нажаль", JOptionPane.PLAIN_MESSAGE);
        } else if (!namesCities.contains(inputCity)) {
            JOptionPane.showMessageDialog(null, "Місто \"" + inputCity + "\" не знайдено", "Помилка", JOptionPane.PLAIN_MESSAGE);
        } else if (usedCities.contains(inputCity)) {
            JOptionPane.showMessageDialog(null, "Місто \"" + inputCity + "\" уже використане", "Помилка", JOptionPane.PLAIN_MESSAGE);
            //TODO потрібно додати посилання на клас який реалізує введення рахунку та змінити текст
        } else if (!lastLetterComputer.equalsIgnoreCase(inputCity.substring(0, 1))) {
            JOptionPane.showMessageDialog(null, "Місто повинно починатися на літеру \"" + lastLetterComputer + "\"", "Помилка", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "\"Ви перемогли з рахунком " + userCount + ":" + computerCount + "\"", "Вітаємо", JOptionPane.PLAIN_MESSAGE);
        }
        inputField.setText("");
    }

    /**
     * the method checks the received request for validity
     *
     * @param city
     * @return
     */
    private boolean validateInput(String city){
        if (lastLetterComputer == null) {
            return namesCities.contains(city) && !usedCities.contains(city);
        } else {
            return namesCities.contains(city) && !usedCities.contains(city) && lastLetterComputer.equalsIgnoreCase(city.substring(0, 1));
        }
    }

    /**
     * we get the last letter of the word entered by the user and replace it in case of a mismatch
     *
     * @param city
     * @return
     */
    private String getLastLetterUser(String city) {
        int index = city.length() - 1;
        String lastLetter = String.valueOf(city.toLowerCase().charAt(index));
        if (lastLetter.equalsIgnoreCase("ґ") || lastLetter.equalsIgnoreCase("ї") || lastLetter.equalsIgnoreCase("й") || lastLetter.equalsIgnoreCase("ь") || lastLetter.equalsIgnoreCase("и")) {
            lastLetter = String.valueOf(city.toUpperCase().charAt(index - 1));
        }
        return lastLetter;
    }

    /**
     *get the name of the city that will be sent in response from the computer
     *
     * @param answer
     * @return
     */
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

    /**
     *we get the last letter of the word entered by the computer and replace it in case of a mismatch
     *
     * @param city
     * @return
     */
    private String getLastLetterComputer(String city) {
        int index = city.length() - 1;
        String lastLetterComputer = String.valueOf(city.toLowerCase().charAt(index));
        if (lastLetterComputer.equalsIgnoreCase("ґ") || lastLetterComputer.equalsIgnoreCase("ї") || lastLetterComputer.equalsIgnoreCase("й") || lastLetterComputer.equalsIgnoreCase("ь") || lastLetterComputer.equalsIgnoreCase("и")) {
            lastLetterComputer = String.valueOf(city.toUpperCase().charAt(index - 1));
        }

        return lastLetterComputer.toUpperCase();
    }

    /**
     *reaction to the "Surrender" button
     */
    public void reactionToButton() {
        JOptionPane.showMessageDialog(null, "\"Ви програли з рахунком " + userCount + ":" + computerCount + "\"", "Нажаль", JOptionPane.PLAIN_MESSAGE);

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

    public void setLastLetterUser(String lastLetterUser) {
        this.lastLetterUser = lastLetterUser;
    }

    public String getLastLetterUser() {
        return lastLetterUser;
    }

    public void setLastLetterComputer(String lastLetterComputer) {
        this.lastLetterComputer = lastLetterComputer;
    }

    public String getLastLetterComputer() {
        return lastLetterComputer;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setComputerCount(int computerCount) {
        this.computerCount = computerCount;
    }

    public int getComputerCount() {
        return computerCount;
    }
}
