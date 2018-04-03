package study.disigpattern.strategy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by KimYJ on 2018-04-03.
 */
class QuestionList {
    private Queue<String> questions;

    public QuestionList() {
        this.questions = new LinkedList<>();
    }

    void ready() {
        Employer firstEmployer = new EmployerA();
        Employer seccondEmployer = new EmployerB();
        questions.add(firstEmployer.question());
        questions.add(seccondEmployer.question());
    }
}
