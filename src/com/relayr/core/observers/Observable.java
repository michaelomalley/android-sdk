package com.relayr.core.observers;

import java.util.ArrayList;

public class Observable<T> implements IObservable<T> {
	private final ArrayList<Observer<T>> observers = new ArrayList<Observer<T>>();

	public void addObserver(Observer<T> observer) {
		synchronized (observers) {
			observers.add(observer);
		}
	}

	public void removeObserver(Observer<T> observer) {
		synchronized (observers) {
			observers.remove(observer);
		}
	}

	protected boolean hasObserver(Observer<?> observer) {
		synchronized (observers) {
			return observers.contains(observer);
		}
	}

	public void notifyObservers(final T t) {
		synchronized (observers) {
			for (Observer<T> observer : observers) {
				observer.notify(t);
			}
		}
	}
}