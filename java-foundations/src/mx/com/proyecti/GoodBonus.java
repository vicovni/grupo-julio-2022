package mx.com.proyecti;

public class GoodBonus {
	public static double getBonusPercent(Employee emp) {
		if(emp instanceof Manager) {
			return 0.5;
		} else if(emp instanceof HR) {
			return 0.2;
		} else if(emp instanceof Engineer) {
			return 0.3;
		} else {
			return 0.1;
		}
	}
}
