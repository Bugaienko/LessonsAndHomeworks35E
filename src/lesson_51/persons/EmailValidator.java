package lesson_51.persons;
/*
@date 15.11.2023
@author Sergey Bugaienko
*/

public class EmailValidator {
    /*
    1. @ присутствует и только одна (done)
    2. точка после собаки (done)
    3. после последней точки 2 или больше символов
    4. английский алфавит, цифры, '_', '-', '.', '@'
    5. до собаки должен быть мин 1 символ
     */
    public static void validate(String email) throws EmailValidateException {
        // 1. @ присутствует и только одна (done)
        int indexAt = email.indexOf('@');
        if (indexAt == -1 || indexAt != email.lastIndexOf('@')) throw new EmailValidateException("@ error");

        // 2. точка после собаки
        if (email.indexOf('.', indexAt) == -1) throw new EmailValidateException(". after @ error");

        // 3. после последней точки 2 или больше символов
        // индекс последнего length - 1;
        // индекс пред-последнего length - 2;

        if (email.lastIndexOf('.') >= email.length() - 2) throw new EmailValidateException("last . error");

        // английский алфавит, цифры, '_', '-', '.', '@'
        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);


            if (!(isContainLegalSymbols(c))) {
                throw new EmailValidateException("illegal symbols");
            }
        }

    }

    private static boolean isContainLegalSymbols(char c){
        return (Character.isAlphabetic(c) || Character.isDigit(c) || c == '.'
                || c == '_' || c == '-' || c == '@' );
    }
}
