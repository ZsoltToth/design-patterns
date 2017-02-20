package hu.uni.miskolc.iit.design.patterns.creational.factory.pcp.company;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class StorageTest {

	public Storage storage;
	private static final int INITIAL_BEER_COUNT = 10;
	private static final int INITIAL_FOOD_COUNT = 10;
	
	@Before
	public void setUp() throws Exception {
		storage = new Storage();
		storage.deposit(ProductType.BEER, INITIAL_BEER_COUNT);
		storage.deposit(ProductType.FOOD, INITIAL_FOOD_COUNT);
	}

	@Ignore
	@Test
	public void test() {
		System.out.println(storage.toString());
	}
	
	@Test
	public void testWithdraw() throws NotEnoughProductException{
		storage.withdraw(ProductType.BEER, INITIAL_BEER_COUNT);
	}
	
	@Test(expected=NotEnoughProductException.class)
	public void testWithdrawTooMuch() throws NotEnoughProductException{
		storage.withdraw(ProductType.BEER, INITIAL_BEER_COUNT+1);
	}

}
