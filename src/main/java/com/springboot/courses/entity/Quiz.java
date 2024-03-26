package com.springboot.courses.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "quizs")
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String question;

    @Enumerated(EnumType.STRING)
    private QuizType quizType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answerList = new ArrayList<>();

    public void add(String content, boolean isCorrect){
        answerList.add(new Answer(content, isCorrect, this));
    }

    public void setAnswerList(List<Answer> answerList) {
        if(answerList != null && !answerList.isEmpty()){
            this.answerList.clear();
            this.answerList.addAll(answerList);
        }
    }

}
