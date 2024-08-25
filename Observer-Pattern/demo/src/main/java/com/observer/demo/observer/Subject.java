package com.observer.demo.observer;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers(String userId);
}