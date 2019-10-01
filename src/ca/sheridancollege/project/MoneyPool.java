package ca.sheridancollege.project;
/**
 * This class is a Money Pool, which save all reword money, in final round all money of it will be given to winner
 * @author Meng
 */
public class MoneyPool {
	/**
	 * There is only one money pool, so it is static
	 */
	private static double moneyPool;

	public MoneyPool(){
		moneyPool = 0.0;
	}
	/**
	 * This method is to get all money from pool
	 * return all money
	 */
	public static double getMoneyPool() {
		return moneyPool;
	}

	public static void addInMoneyPool(double moneyPool) {
		MoneyPool.moneyPool += moneyPool;
	}
	public static void setInMoneyPool(double moneyPool) {
		MoneyPool.moneyPool = moneyPool;
	}
	
	
}
