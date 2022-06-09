package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import clothesValues.Price;
import clothesValues.WaitDay;
import entities.BeforeDeposit;
import entities.ClothesData;
import entities.DepositData;
import entities.DepositDataList;
import entities.RegisterInfo;
import entities.UserData;
import entities.viewClothesData;

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

	private String setDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		// Date型変換
		Date formatDate=null;

		formatDate=sdf.parse(str);

		//カレンダー型
		Calendar cdr =Calendar.getInstance();
		cdr.setTime(formatDate);
		cdr.add(Calendar.HOUR_OF_DAY, 9);
		formatDate=cdr.getTime();
		//str変換
		String string=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(formatDate);

		return string;
	}

	private String deleteTime(String str) {
		if(!str.equals("お渡し可")&&str.length()>10) {
			return str.substring(0,str.length()-9);
		}
		return str;
	}

	//会員登録
	public void writeUserDatas(UserData userData){
		
		Connection con=getConnection();
		try(PreparedStatement preparableStatement=
				con.prepareStatement("insert into User (UserName,PhoneNumber) values(?,?);")){
			//書き込み処理		
			preparableStatement.setString(1, userData.getUserName().toStr());
			preparableStatement.setString(2, userData.getPhoneNumber().toStr());

			preparableStatement.executeUpdate();//実行
			
			preparableStatement.close();
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		
	}

	//追加したデータの一覧表示＋（登録）
	public RegisterInfo showAddDatas(BeforeDeposit beforeDeposit) {
		RegisterInfo registerInfo=null;
		Connection con=getConnection();
		try(PreparedStatement preparableStatement=
				con.prepareStatement("insert into Regist (UserId,ClothesId,"
						+"WashHurryFinish,WashDeluxeFinish,WashStainRemoval,FinishDate,TotalAmount)"
						+ " values(?,?,?,?,?,?,?);")){

			//書き込み処理		
			preparableStatement.setInt(1, beforeDeposit.getUserData().getUserId().toInt());
			preparableStatement.setInt(2, beforeDeposit.getClothesData());
			preparableStatement.setBoolean(3, beforeDeposit.getCleanOption1());
			preparableStatement.setBoolean(4, beforeDeposit.getCleanOption2());
			preparableStatement.setInt(5, beforeDeposit.getCleanOption3());
			preparableStatement.setString(6, beforeDeposit.getFinishDay());
			preparableStatement.setInt(7, beforeDeposit.geTotalPrice());

			preparableStatement.executeUpdate();//実行
			
			preparableStatement.close();
			
			try(PreparedStatement SelectPreparableStatement=
					con.prepareStatement("select Regist.DepositNumber,Regist.DepositDate,Regist.TotalAmount from Regist order by Regist.DepositNumber desc limit 1;")){

				try(ResultSet rs =SelectPreparableStatement.executeQuery()){
					while(rs.next()) {
						String date=rs.getString("DepositDate");
						//処理
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						
						// Date型変換
						Date formatDate=sdf.parse(date);
						
						//カレンダー型
						Calendar cdr =Calendar.getInstance();
						cdr.setTime(formatDate);
						
						//オプション1
						cdr.add(Calendar.HOUR_OF_DAY,9);
						
						formatDate=cdr.getTime();
						//str変換
						String string=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(formatDate);
						registerInfo=new RegisterInfo(string,rs.getInt("DepositNumber"),rs.getInt("TotalAmount"));
					}
					
					rs.close();
				}catch (Exception e) {
					System.out.println(e);
				}
				SelectPreparableStatement.close();
				con.close();
			}catch (Exception e) {
				System.out.println(e);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return registerInfo;
	}

	//預かりデータの一覧表示
	public DepositDataList findDepositDataAll(int userId) {
		DepositDataList depositDataList=new DepositDataList();
		Connection con=getConnection();

		try(PreparedStatement SelectPreparableStatement=
				con.prepareStatement("select * from Regist where UserId = ?;")){
			SelectPreparableStatement.setInt(1, userId);

			try(ResultSet rs =SelectPreparableStatement.executeQuery()){
				while(rs.next()) {
					DepositData depositData=new DepositData(rs.getInt("DepositNumber"),setDate(rs.getString("DepositDate")), rs.getInt("UserId"),rs.getInt("ClothesId"),rs.getBoolean("WashHurryFinish"),
							rs.getBoolean("WashDeluxeFinish"),rs.getBoolean("WashStainRemoval"),
							rs.getInt("TotalAmount"),deleteTime(rs.getString("FinishDate")),rs.getString("FactoryMessage"));
					depositDataList.addData(depositData);
				}
				SelectPreparableStatement.close();
				con.close();
				rs.close();
			}catch (Exception e) {
				System.out.println(e);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
		return depositDataList;
	}

	//データを削除
	public void deleteDepositData(List<Integer>list) throws SQLException {
		Connection con=getConnection();
		for(int i=0;i<list.size();i++) {
			try(PreparedStatement preparableStatement=
					con.prepareStatement("delete from Regist where DepositNumber=?;")){
				preparableStatement.setInt(1, list.get(i));
				preparableStatement.executeUpdate();//実行
				preparableStatement.close();
				
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		con.close();
	}

	//予定日を変更
	public void updateDay(int depositId,String day) {
		System.out.println(day); //2022-01-01
		Connection con=getConnection();
		try(PreparedStatement preparableStatement=
				con.prepareStatement("update Regist set FinishDate=? where DepositNumber=?")){
			preparableStatement.setString(1, day);
			preparableStatement.setInt(2, depositId);
			preparableStatement.executeUpdate();//実行
			preparableStatement.close();
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	//メッセージを追加
	public void addMessage(int depositId,String message) {
		Connection con=getConnection();
		try(PreparedStatement preparableStatement=
				con.prepareStatement("update Regist set FactoryMessage=? where DepositNumber=?")){
			preparableStatement.setString(1, message);
			preparableStatement.setInt(2, depositId);
			preparableStatement.executeUpdate();//実行
			preparableStatement.close();
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

	//衣服データ取得
	public ClothesData getClothesData(int clothesId) {
		ClothesData clothesData=null;
		Connection con=getConnection();
		try(PreparedStatement preparableStatement=
				con.prepareStatement("select * from Clothes where ClothesId=?;")){
			preparableStatement.setInt(1, clothesId);
			try(ResultSet rs =preparableStatement.executeQuery()){
				if(rs.next()) {
					Price price=new Price(rs.getInt("ClothesPrice"));
					WaitDay waitDay=new WaitDay(rs.getInt("FinishDays"));
					clothesData=new ClothesData(null, price, waitDay);
				}
				rs.close();
			}catch (Exception e) {
				System.out.println(e);
			}
			
			con.close();
			preparableStatement.close();
		}catch (Exception e) {
			System.out.println(e);
		}

		return clothesData;
	}

	//絞り込み
	public DepositDataList getFilteringList(String depositDate) {
		DepositDataList depositDataList=new DepositDataList();
		Connection con=getConnection();
		try(PreparedStatement preparableStatement=
				con.prepareStatement("select * from Regist where DepositDate like ?;")){
			preparableStatement.setString(1,"%"+depositDate+"%");
			try(ResultSet rs =preparableStatement.executeQuery()){
				while(rs.next()) {
					DepositData depositData=new DepositData(rs.getInt("DepositNumber"),setDate(rs.getString("DepositDate")), rs.getInt("UserId"),rs.getInt("ClothesId"),rs.getBoolean("WashHurryFinish"),
							rs.getBoolean("WashDeluxeFinish"),rs.getBoolean("WashStainRemoval"),
							rs.getInt("TotalAmount"),deleteTime(rs.getString("FinishDate")),rs.getString("FactoryMessage"));
					depositDataList.addData(depositData);
				}
				rs.close();
			}catch (Exception e) {
				System.out.println(e);
			}
			preparableStatement.close();
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}

		return depositDataList;
	}

	//預かり一覧（渡すとき）
	public DepositDataList findDepositDataList(List<Integer>list) throws SQLException {
		DepositDataList depositDataList=new DepositDataList();
		Connection con=getConnection();
		for(int i=0;i<list.size();i++) {
			try(PreparedStatement preparableStatement=
					con.prepareStatement("select * from Regist where DepositNumber = ?;")){
				preparableStatement.setInt(1,list.get(i));
				try(ResultSet rs =preparableStatement.executeQuery()){
					if(rs.next()) {
						if(rs.getString("FinishDate").equals("お渡し可")) {
						DepositData depositData=new DepositData(rs.getInt("DepositNumber"),rs.getString("DepositDate"), rs.getInt("UserId"),rs.getInt("ClothesId"),rs.getBoolean("WashHurryFinish"),
								rs.getBoolean("WashDeluxeFinish"),rs.getBoolean("WashStainRemoval"),
								rs.getInt("TotalAmount"),deleteTime(rs.getString("FinishDate")),rs.getString("FactoryMessage"));
						depositDataList.addData(depositData);	
						}
						rs.close();
					}
				}catch (Exception e) {
					System.out.println(e);
				}
				preparableStatement.close();
				
			}catch (Exception e) {
				System.out.println(e);
			}
		}
		
		con.close();
		return depositDataList;
	}

	//全表示
	public DepositDataList findAll() {
		DepositDataList depositDataList=new DepositDataList();
		Connection con=getConnection();
		try(PreparedStatement preparableStatement=
				con.prepareStatement("select * from Regist;")){
			try(ResultSet rs =preparableStatement.executeQuery()){
				while(rs.next()) {
					DepositData depositData=new DepositData(rs.getInt("DepositNumber"),setDate(rs.getString("DepositDate")), rs.getInt("UserId"),rs.getInt("ClothesId"),rs.getBoolean("WashHurryFinish"),
							rs.getBoolean("WashDeluxeFinish"),rs.getBoolean("WashStainRemoval"),
							rs.getInt("TotalAmount"),deleteTime(rs.getString("FinishDate")),rs.getString("FactoryMessage"));
					depositDataList.addData(depositData);
				}
				rs.close();
			}catch (Exception e) {
				System.out.println(e);
			}
			con.close();
			preparableStatement.close();
		}catch (Exception e) {
			System.out.println(e);
		}

		return depositDataList;
	}
	
	//衣類データ取得
	public List<viewClothesData> getClothesData() {
		List<viewClothesData>list=new ArrayList<>();
		Connection con=getConnection();
		try(PreparedStatement preparableStatement=
				con.prepareStatement("select * from Clothes;")){
			try(ResultSet rs =preparableStatement.executeQuery()){
				while(rs.next()) {
					viewClothesData viewClothesData=new viewClothesData(rs.getInt("ClothesId"),rs.getString("ClothesName"),rs.getInt("ClothesPrice"),rs.getInt("FinishDays"));
					list.add(viewClothesData);
				}
				rs.close();
			}catch (Exception e) {
				System.out.println(e);
			}
			preparableStatement.close();
			con.close();
		}catch (Exception e) {
			System.out.println(e);
		}
		
		return list;
	}

}
