//Абстрактный пример компоновщика на примере работы оборудования предприятия
//	 		Предприятие____________
//  	  	  /        				\
// 			цех_________		  	отдел
//		   /   \        \  				 \
//	токарные  фрезерные	компьютеры		компьютеры	
//  станки		станки	цеха			отдела


public interface Equipment {
	void switchON();
	void switchOFF();
	void maintain();
}

public class Lathe implements Equipment {
	private Long id;
	private boolean isON = false;
	private Long lastMaintainedHours = 0L;
	private Thread counter;

	public void switchON() {
		this.isON = true;
		counter = new Thread(() -> {
			while (isON) {
				try {
					Thread.sleep(3600000)
					this.lastMaintainedHours++;
				} catch (InterruptedException e) {
					System.out.println("Lathe " + this.id + " stopped")
				}
			}
		});
		counter.start();
	}

	public void switchOFF() {
		this.isON = false;
		counter.interrupt();
	}

	public void maintain() {
		this.lastMaintainedHours = 0L;
	}

}

public class Miller implements Equipment {
	private Long id;
	private boolean isON = false;
	private Long lastMaintainedHours = 0L;
	private Thread counter;

	public void switchON() {
		this.isON = true;
		counter = new Thread(() -> {
			while (isON) {
				try {
					Thread.sleep(3600000)
					this.lastMaintainedHours++;
				} catch (InterruptedException e) {
					System.out.println("Miller " + this.id + "stopped")
				}
			}
		});
		counter.start();
	}

	public void switchOFF() {
		this.isON = false;
		counter.interrupt();
	}

	public void maintain() {
		this.lastMaintainedHours = 0L;
	}

}

public class DepartmentEquipment implements Equipment {
	private long id;
	private List<Equipment> equipment;

	void switchON() {
		for (Equipment eq : equipment) {
			equipment.switchON();
		}
	}

	void switchOFF() {
		for (Equipment eq : equipment) {
			equipment.switchOFF();
		}
	}

	void maintain() { 
		for (Equipment eq : equipment) {
			equipment.maintain();
		}
	}
}