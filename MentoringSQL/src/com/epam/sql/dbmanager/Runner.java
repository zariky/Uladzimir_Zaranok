package com.epam.sql.dbmanager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Runner {
	private static List<Integer> likesList = new ArrayList<Integer>();
	private static List<Integer> friendsList = new ArrayList<Integer>();
	private static Map<Integer, String> userIdNameMap = new HashMap<Integer, String>();
	enum Name { Alexander, Burt, Christopher, Daniel, Eric, Alexandra, Bertha, Christine, Daniela, Erica, Tom, Dick, Harry, Jughead, Archie, Sally, Sue, Peggy, Betty, Veronica };
	enum Surname { Morgan, Simpson, Walker, Bauer, Taylor, Morris, Elliott, Clark, Rock, Sadler, Grenier, Soyinka, Labs, Soumerai, Behrens, Lelacheur, Lipka, Escott, Stanger, Hiltz };
	private static final Random RANDOM = new Random();
	public final static String INSERT_USER = "INSERT INTO users(name, surname, birthdate) VALUES(?,?,?)";
	public final static String INSERT_FRIENDSHIP = "INSERT INTO friendships(userid1, userid2, timestamp) VALUES(?,?,?)";
	public final static String INSERT_POSTS = "INSERT INTO posts(userId, text, timestamp) VALUES(?,?,?)";
	public final static String INSERT_LIKES = "INSERT INTO likes(postid, userid, timestamp) VALUES(?,?,?)";
	public final static String USERS_IDS = "SELECT id FROM users";
	public final static String POSTS_IDS = "SELECT id FROM posts";
	public final static String GET_LIKES = "SELECT userid, COUNT(userid) as likesCount FROM likes GROUP BY userid HAVING COUNT(userid) > 100";
	public final static String GET_FRIENDS = "SELECT userid1, COUNT(userid2) as friendsCount FROM friendships	GROUP BY userid1 HAVING COUNT(userid2) > 50	ORDER BY userid1";
	public static final String SELECT_ID_USERS = "SELECT id, name FROM users";
	
	public static void main(String[] args) {
		
		createDataBaseStrucure();
		fillUsersTable();
		fillFriendshipsTable();
		fillPosts();
		fillLikes();
		
		showResults();
	}
	
	private static List<Integer> getUsersIDS() {
		List<Integer> listValues = new ArrayList<Integer>();
		try(Connection currentCon = ConnectionManager.getConnection();
			Statement stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery(USERS_IDS);) {
			while (rs.next()) {
				listValues.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listValues;
	}
	
	private static List<Integer> getPostsIDS() {
		List<Integer> listValues = new ArrayList<Integer>();
		try(Connection currentCon = ConnectionManager.getConnection();
			Statement stmt = currentCon.createStatement();
			ResultSet rs = stmt.executeQuery(POSTS_IDS);) {
			while (rs.next()) {
				listValues.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listValues;
	}
	
	private static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
		int x = RANDOM.nextInt(clazz.getEnumConstants().length);
		return clazz.getEnumConstants()[x];
	}
	
	private static Date getRandomDate(String d1, String d2) {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		long beginTime = Timestamp.valueOf(d1).getTime();
		long endTime = Timestamp.valueOf(d2).getTime();
	    long diff = endTime - beginTime + 1;
	    
		Date randomDate = new Date(beginTime + (long) (Math.random() * diff));
		return randomDate;
	}
	
	private static void fillUsersTable() {
		try(Connection currentCon = ConnectionManager.getConnection();
			PreparedStatement pstmt = currentCon.prepareStatement(INSERT_USER);) {
			String d1 = "1970-01-01 00:00:00";
			String d2 = "2013-12-31 00:58:00";
			
			for (int i = 0; i < 110; i++) {
				pstmt.setString(1, randomEnum(Name.class).toString());
				pstmt.setString(2, randomEnum(Surname.class).toString());
				pstmt.setDate(3, getRandomDate(d1, d2));
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void fillFriendshipsTable() {
		try(Connection currentCon = ConnectionManager.getConnection();
			PreparedStatement pstmt = currentCon.prepareStatement(INSERT_FRIENDSHIP);) {
			String d1 = "2015-01-01 00:00:00";
			String d2 = "2015-12-31 00:58:00";
			List<Integer> listUsersId = getUsersIDS();
			int size = listUsersId.size();
			for (int i = 0; i < 7100; i++) {
				pstmt.setInt(1, listUsersId.get(RANDOM.nextInt(size)));
				pstmt.setInt(2, listUsersId.get(RANDOM.nextInt(size)));
				pstmt.setDate(3, getRandomDate(d1, d2));
				pstmt.addBatch();
			}
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void fillPosts() {
		try(Connection currentCon = ConnectionManager.getConnection();
				PreparedStatement pstmt = currentCon.prepareStatement(INSERT_POSTS);) {
			String d1 = "2015-01-01 00:00:00";
			String d2 = "2015-12-31 00:58:00";
			List<Integer> listUsersId = getUsersIDS();
			int size = listUsersId.size();
			
			for (int i = 0; i < 5000; i++) {
				pstmt.setInt(1, listUsersId.get(RANDOM.nextInt(size)));
				pstmt.setString(2, "text" + i);
				pstmt.setDate(3, getRandomDate(d1, d2));
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void fillLikes() {
		try(Connection currentCon = ConnectionManager.getConnection();
				PreparedStatement pstmt = currentCon.prepareStatement(INSERT_LIKES);) {
			String d1 = "2015-01-01 00:00:00";
			String d2 = "2015-12-31 00:58:00";
			List<Integer> listPostsId = getPostsIDS();
			List<Integer> listUsersId = getUsersIDS();
			int sizePots = listPostsId.size();
			int sizeUsers = listUsersId.size();
			
			for (int i = 0; i < 30000; i++) {
				pstmt.setInt(1, listPostsId.get(RANDOM.nextInt(sizePots)));
				pstmt.setInt(2, listUsersId.get(RANDOM.nextInt(sizeUsers)));
				pstmt.setDate(3, getRandomDate(d1, d2));
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void fillLikesSet() {
		try(Connection currentCon = ConnectionManager.getConnection();
				Statement stmt = currentCon.createStatement();
				ResultSet rs = stmt.executeQuery(GET_LIKES);) {
			while (rs.next()) {
				likesList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void fillFriendsSet() {
		try(Connection currentCon = ConnectionManager.getConnection();
				Statement stmt = currentCon.createStatement();
				ResultSet rs = stmt.executeQuery(GET_FRIENDS);) {
			while (rs.next()) {
				friendsList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void fillUserIdNameMap() {
		try(Connection currentCon = ConnectionManager.getConnection();
				Statement stmt = currentCon.createStatement();
				ResultSet rs = stmt.executeQuery(SELECT_ID_USERS);) {
			while (rs.next()) {
				userIdNameMap.put(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void showResults() {
		fillUserIdNameMap();
		fillLikesSet();
		fillFriendsSet();
		friendsList.retainAll(likesList);
		
		for (Integer id : friendsList) {
			System.out.println("User name: " + userIdNameMap.get(id));
		}
	}
	
	static void createDataBaseStrucure() {
		String dropDb = "DROP DATABASE facebook";
		String createDb = "CREATE DATABASE facebook DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci";
		String createTableFriendships ="CREATE TABLE IF NOT EXISTS facebook.friendships (userid1 int(11) NOT NULL, userid2 int(11) NOT NULL, timestamp date NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8";
		String createTableLikes ="CREATE TABLE IF NOT EXISTS facebook.likes (postid int(11) NOT NULL, userid int(11) NOT NULL, timestamp date NOT NULL) ENGINE=InnoDB DEFAULT CHARSET=utf8";
		String createTablePosts ="CREATE TABLE IF NOT EXISTS facebook.posts (id int(11) NOT NULL AUTO_INCREMENT, userId int(11) NOT NULL, text text NOT NULL, timestamp date NOT NULL, PRIMARY KEY (id)) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=5001";
		String createTableUsers ="CREATE TABLE IF NOT EXISTS facebook.users (id int(11) NOT NULL AUTO_INCREMENT, name text NOT NULL, surname text NOT NULL, birthdate date NOT NULL, PRIMARY KEY (id)) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=111";
		
		try(Connection currentCon = ConnectionManager.getConnection();
			Statement stmt = currentCon.createStatement();) {
			stmt.executeUpdate(dropDb);
			stmt.executeUpdate(createDb);
			stmt.executeUpdate(createTableFriendships);
			stmt.executeUpdate(createTableLikes);
			stmt.executeUpdate(createTablePosts);
			stmt.executeUpdate(createTableUsers);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
