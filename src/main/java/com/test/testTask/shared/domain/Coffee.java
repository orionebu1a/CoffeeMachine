package com.test.testTask.shared.domain;

import java.net.HttpCookie;
import java.time.LocalDateTime;

public interface Coffee {
    Cup getCup();
    void setCup(Cup cup);
    Grade getGrade();
    void setGrade(Grade grade);
    Type getType();
    void setType(Type type);
    int getSugar();
    void setSugar(int sugar);
    void setTime(int time);
    int getTime();
}
