package decorator;

public class Client {

	public static void main(String[] args) {
		Display road = new RoadDisplay();
		road.draw();
		
		Display roadWithLane = new LaneDecorator(new RoadDisplay());
		roadWithLane.draw();
		
		Display roadWithTraffic = new TrafficDecorator(new RoadDisplay());
		roadWithTraffic.draw();
		
		Display roadWithLaneAndTraffic = new LaneDecorator(new TrafficDecorator(new RoadDisplay()));
		roadWithLaneAndTraffic.draw();
		
		Display roadWithCrossingAndLaneAndTraffic = new CrossingDecorator(new LaneDecorator(new RoadDisplay()));
		roadWithCrossingAndLaneAndTraffic.draw();
		
	}

}

// 또다른 도로 표시 기능을 추가? 기본 도로 표시에 교통량을 표시하고 싶다면?
// 여러가지 추가 기능을 조합해 제공? 차선 표시기능과 교통량 표시 기능을 함께 제공하고 싶다면? 