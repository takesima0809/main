package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.BeforeDeposit;
import entities.RegisterInfo;
import entities.RegisterList;
import entities.UserData;

public class ShopRepository {
	private final String url ="jdbc:mysql://3.112.79.30:3306/cleaning_shop";
	private final String user ="trainee";
	private final String password="trainee";

	private Connection getConnection () {
		try {
			Connection con =DriverManager.getConnection(url, user, password);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//会員登録
	public void witeUserDatas(UserData userData){

		try(PreparedStatement preparableStatement=
				getConnection().prepareStatement("insert into User (UserName,PhoneNumber) values(?,?);")){
			//書き込み処理		
			preparableStatement.setString(1, userData.getUserName().toStr());
			preparableStatement.setString(2, userData.getPhoneNumber().toStr());

			preparableStatement.executeUpdate();//実行
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	//追加したデータの一覧表示＋（登録）
	public RegisterList showAddDatas(BeforeDeposit beforeDeposit,int clothesCount) {
		RegisterList registerList=new RegisterList();
		try(PreparedStatement preparableStatement=
				getConnection().prepareStatement("insert into Regist (UserId,ClothesId,"
						+"WashHurryFinish,WashDeluxeFinish,WashStainRemoval,FinishDate,TotalAmount)"
						+ " values(?,?,?,?,?,?,?);")){
			//書き込み処理		
			preparableStatement.setInt(1, beforeDeposit.getUserData().getUserId().toInt());
			preparableStatement.setInt(2, beforeDeposit.getClothesData());
			preparableStatement.setBoolean(3, beforeDeposit.getCleanOption1());
			preparableStatement.setBoolean(4, beforeDeposit.getCleanOption2());
			preparableStatement.setBoolean(5, beforeDeposit.getCleanOption3());
			preparableStatement.setString(6, beforeDeposit.getFinishDay());
			preparableStatement.setInt(7, beforeDeposit.geTotalPrice());

			preparableStatement.executeUpdate();//実行

			try(PreparedStatement SelectPreparableStatement=
					getConnection().prepareStatement("select Regist.DepositNumber,Regist.DepositDate from Regist order by Regist.DepositNumber desc limit ?;")){
				SelectPreparableStatement.setInt(1, clothesCount);

				try(ResultSet rs =SelectPreparableStatement.executeQuery()){
					while(rs.next()) {
						RegisterInfo registerInfo=new RegisterInfo(rs.getString("DepositDate"),rs.getInt("DepositNumber"));
						registerList.add(registerInfo);
					}
				}catch (Exception e) {
					System.out.println(e);
				}
			}catch (Exception e) {
				System.out.println(e);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return registerList;
	}

	//預かりデータの一覧表示

	//データを追加

	//データを削除

	//予定日を変更

	//メッセージを追加

}
