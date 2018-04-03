package study.disigpattern.strategy;

/**
 * Created by KimYJ on 2018-04-03.
 */
class EmployerA implements Employer {
    @Override
    public String question() {
        return "자신있나요?";
    }
}
