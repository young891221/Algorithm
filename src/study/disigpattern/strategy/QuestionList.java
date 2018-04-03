package study.disigpattern.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by KimYJ on 2018-04-03.
 */
class QuestionList {
    private List<String> questions;

    public QuestionList() {
        this.questions = new ArrayList<>();
    }

    void ready() {
        questions.addAll(Arrays.asList(new EmployerA().question(), new  EmployerB().question()));
    }
}
