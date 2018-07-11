package com.zzy.test.dao.mysql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.zzy.test.entity.Message;
import com.zzy.dao.base.BaseDao;
import com.zzy.dao.base.RSProcessor;
import com.zzy.test.dao.MessageDao;

public class MessageDaoImpl extends BaseDao implements MessageDao{

	@Override
	public List<Message> getMessageDetail(String username) {
		// TODO Auto-generated method stub
		String sql = "select * from message where username = ?";
		Object[] params = {username};
		
		RSProcessor getMessage = new RSProcessor() {
			
			@Override
			public Object process(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				List<Message> messageList = new ArrayList<Message>();
				
				while(rs.next()){
					int messageId = rs.getInt("messageID");
					String messageLabel = rs.getString("messageLabel");
					String messageDate = rs.getString("messageDate");
					
					Message message = new Message(messageId,messageLabel,messageDate);
					messageList.add(message);
				}
				
				return messageList;
			}
		};
		return (List<Message>) this.executeQuery(getMessage, sql, params);
	}

	@Override
	public int insert(Message message) {
		// TODO Auto-generated method stub
		String sql = "insert message (messageLabel,messageDate,username)";
		Object[] params = {message.getMessageLabel(), message.getMessageDate(), message.getUsername()};
		return this.executeUpdate(sql, params);
	}
	
	public int countMessageByName(String name) {
		String sql = "select count(*) as user_count from user where username=?";
		Object[] params = {name};
		
		RSProcessor countUserByNameProcessor = new RSProcessor(){

			public Object process(ResultSet rs) throws SQLException {
				int count = 0;
				if(rs != null) {
					if(rs.next()) {
						count = rs.getInt("user_count");
					}
				}
				
				return new Integer(count);
			}

		};
		
		return (Integer)this.executeQuery(countUserByNameProcessor, sql, params);
	}

}
