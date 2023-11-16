package lesson_51.persons;
/*
@date 16.11.2023
@author Sergey Bugaienko
*/

public class PasswordValidator {

    public static void validate(String password) throws PasswordValidateException {

        if (password.length() < 8) throw new PasswordValidateException("wrong password length");



        boolean[] res = new boolean[4]; // [false, false, false, false]
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isDigit(c)) {
                res[0] = true;
            }

            if (Character.isLowerCase(c)) {
                res[1] = true;
            }

            if (Character.isUpperCase(c)) {
                res[2] = true;
            }

            if ("!%$@&".indexOf(c) >= 0) {
                res[3] = true;
            }
        }

//        System.out.println(Arrays.toString(res));
        if (!res[0]) {
            throw new PasswordValidateException("absent digit in password");
        }
        if (!res[1]){
            throw new PasswordValidateException("absent lowercase");
        }
        if (!res[2]) {
            throw new PasswordValidateException("absent uppercase");
        }
        if (!res[3]) {
            throw new PasswordValidateException("absent !%$@&");
        }

    }
}

 /*
    Требования к валидному password
    1. длина >= 8
    2. мин 1 цифра
    3. мин 1 маленькая буква
    4. мин 1 большая буква
    5. мин 1 спец.символ ("!%$@&")
     */