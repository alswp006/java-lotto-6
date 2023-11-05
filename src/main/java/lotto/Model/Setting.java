package lotto.Model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Setting {
    Lotto winningNumbers;

    public int getBonusNumber() {
        int bonusNumber;

        while (true) {
            try {
                bonusNumber = input_bonusNumber();
                break;
            } catch (IllegalArgumentException e) {
            }
        }

        return bonusNumber;
    }

    public Lotto getWinningNumbers() {

        while(true){
            try{
                String inputNumbers = Console.readLine();
                winningNumbers = new Lotto(stringToList(inputNumbers));
                break;
            }catch (IllegalArgumentException e){}
        }

        return winningNumbers;
    }

    private int input_bonusNumber() {
        String input = Console.readLine();
        int bonusNumber = inputToInt(input);
        checkNumber(bonusNumber);
        winningNumbers.check_bonusNumber(bonusNumber);
        return bonusNumber;
    }

    private int inputToInt(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println("\n[ERROR] 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
    private void checkNumber(int number){
        if (number<1 || number>45){
            System.out.println("\n[ERROR] 1부터 45까지의 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public int purchase_amount() {
        while (true) {
            String input = Console.readLine();
            check_money(input);

            return inputToInt(input);
        }
    }

    private void check_money(String money) {
        if (Integer.parseInt(money) % 1000 != 0) {
            System.out.println("[ERROR] 입력 금액은 1000의 배수로 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> stringToList(String input) throws IllegalArgumentException{
        List<Integer> player = new ArrayList<>();
        String[] numbers = input.split(",");

        for (String number : numbers) {
            int playerNumber = inputToInt(number);
            player.add(playerNumber);
        }

        return player;
    }

}

