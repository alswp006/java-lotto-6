package lotto.Model;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Setting {
    public int inputToInt(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            System.out.println("\n[ERROR] 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
    public void checkNumber(int number){
        if (number<1 || number>45){
            System.out.println("\n[ERROR] 1부터 45까지의 숫자를 입력해주세요.");
            throw new IllegalArgumentException();
        }
    }
    public List<List<Integer>> createLottoNumber(int amount) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();

        while (lottoNumbers.size() < amount) {
            List<Integer> randomNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(randomNumbers);
            lottoNumbers = addLottoNumbers(lottoNumbers, randomNumbers);
        }

        return lottoNumbers;
    }

    public int purchase_amount() {
        while (true) {
            String input = Console.readLine();
            if (check_Integer(input) && check_money(input)) {
                return Integer.parseInt(input);
            }
        }
    }

    public boolean check_money(String money) {
        try {
            if (Integer.parseInt(money) % 1000 == 0) {
                return true;
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 입력 금액은 1000의 배수로 입력해주세요.");
            return false;
        }
    }

    public boolean check_Integer(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요");
            return false;
        }
    }

    public List<List<Integer>> addLottoNumbers(List<List<Integer>> lottoNumbers, List<Integer> randomNumber) {
        if (!lottoNumbers.contains(randomNumber)) {
            lottoNumbers.add(randomNumber);
        }
        return lottoNumbers;
    }

    public List<Integer> stringToList(String s) {
        List<Integer> player = new ArrayList<>();
        String[] numbers = s.split(",");

        for (String ss : numbers) {
            int playerNumber = Integer.parseInt(ss);
            player.add(playerNumber);
        }
        return player;
    }

}

