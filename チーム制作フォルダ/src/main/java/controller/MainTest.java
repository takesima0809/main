package controller;

import java.sql.SQLException;
import java.text.ParseException;

public class MainTest {

	public static void main(String[] args) throws ParseException, SQLException {
		// TODO 自動生成されたメソッド・スタブ
		final FactoryController factoryController = new FactoryController();
		final ShopController shopController = new ShopController();
		shopController .run();
	}

}
