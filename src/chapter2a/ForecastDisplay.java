package chapter2a;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement{

	private float currentPressure = 29.92f;
	private float lastPressure;
	
	public ForecastDisplay(Observable observable){
		//WeatherData weatherData = (WeatherData) observable;
		observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Forecast Display");
		
	}

	@Override
	public void update(Observable observable, Object arg) {
		if(observable instanceof WeatherData){
			WeatherData weatherData = (WeatherData) observable;
			lastPressure = currentPressure;
			currentPressure = weatherData.getPressure();
			display();
			
		}
		
	}

}
