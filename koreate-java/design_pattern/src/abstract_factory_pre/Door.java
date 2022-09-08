package abstract_factory_pre;

public abstract class Door {
	private DoorStatus doorStatus;

	public Door() {
		doorStatus = DoorStatus.CLOSE;
	}

	public DoorStatus getDoorStatus() {
		
		return doorStatus;
	}

//	open을 굳이 doOpen 메서드를 선언해서 사용해야 될까?
//	하나만 있으면 상관 없지만 실제론 훨씬 많은 것들이 들어간다
	public void open() {
		if(doorStatus == DoorStatus.OPEN)return;
		doOpen();
		doorStatus = DoorStatus.OPEN;
	}

	public void close() {
		if(doorStatus == DoorStatus.CLOSE)return;
		doClose();
		doorStatus = DoorStatus.CLOSE;
	}

	protected abstract void doOpen(); // hook

	protected abstract void doClose(); //or primitive
 
}
