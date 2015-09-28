package mx.iteso.observer.impl;

import mx.iteso.observer.Observer;
import mx.iteso.observer.Subject;

import java.util.ArrayList;

/**
 * Created by Juan on 27/09/2015.
 */
public class MobileApp implements Subject, Observer{
    private ArrayList<Observer> observers;
    private int homeGoals;
    private int awayGoals;
    private String homeTeam;
    private String awayTeam;
    private Subject scoresData;


    public MobileApp(Subject scoresData){
        observers = new ArrayList<Observer>();
        this.scoresData = scoresData;
        this.scoresData.registerObserver(this);
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observers.indexOf(observer));
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this.homeTeam, this.awayTeam, this.homeGoals, this.awayGoals);
        }
    }

    public void newScore(){
        notifyObservers();
    }



    public void update(String home, String away, int homeGoals, int awayGoals) {
        this.homeTeam = home;
        this.awayTeam = away;
        this.homeGoals = homeGoals;
        this.awayGoals = awayGoals;
        newScore();
        //display();
    }
}
