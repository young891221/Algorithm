package study.disigpattern.strategy;

/**
 * Created by KimYJ on 2018-04-03.
 */
class EmployerB implements Employer {
    @Override
    public String question() {
        return "당신은 어떤 개발자입니까?";
    }
}
