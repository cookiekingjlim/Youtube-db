package com.youtube.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import com.youtube.model.dao.ChannelDAO;
import com.youtube.model.dao.CommentLikeDAO;
import com.youtube.model.dao.MemberDAO;
import com.youtube.model.dao.VideoDAO;
import com.youtube.model.vo.Category;
import com.youtube.model.vo.Channel;
import com.youtube.model.vo.Member;
import com.youtube.model.vo.Video;
import com.youtube.model.vo.VideoComment;

public class YouTubeController {

	private Member member = new Member();
	private Channel channel = new Channel();
	
	private MemberDAO memberDao = new MemberDAO();
	private ChannelDAO channelDao = new ChannelDAO();
	private VideoDAO videoDao = new VideoDAO();
	private CommentLikeDAO commentDao = new CommentLikeDAO();
	
	public boolean register(Member member) {
		try {
			if(memberDao.register(member)==1) return true;
		} catch (SQLException e) {
			return false;
		}
		return false;
	}
	
	public Member login(String id, String password) {
		try {
			member = memberDao.login(id, password);
			if(member!=null) return member;
			else return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addChannel(Channel channel) {
		try {
			channel.setMember(member);
			if(channelDao.addChannel(channel)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updateChannel(Channel channel) {
		myChannel();
		try {
			channel.setChannelCode(this.channel.getChannelCode());
			if(channelDao.updateChannel(channel)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteChannel() {
		myChannel();
		try {
			if(channelDao.deleteChannel(this.channel.getChannelCode())==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Channel myChannel() {
		try {
			channel = channelDao.myChannel(this.member.getMemberId());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return channel;
	}
	
	public boolean addVideo(Video video) {
		myChannel();
		video.setChannel(this.channel);
		video.setMember(this.member);
		try {
			if(videoDao.addVideo(video)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<Category> categoryList() {
		try {
			return videoDao.categoryList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Video> videoAllList() {
		try {
			return videoDao.videoAllList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<Video> channelVideoList() {
		myChannel();
		try {
			return videoDao.channelVideoList(this.channel.getChannelCode());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateVideo(Video video) {
		try {
			if(videoDao.updateVideo(video)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteVideo(int videoCode) {
		try {
			if(videoDao.deleteVideo(videoCode)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return false;
	}
	
	public Video viewVideo(int videoCode) {
		try {
			return videoDao.viewVideo(videoCode);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean addComment(VideoComment comment) {
		try {
			comment.setMember(member);
			if(commentDao.addComment(comment)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<VideoComment> videoCommentList(int video_code) {
		try {
			return commentDao.videoCommentList(video_code);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean updateComment(VideoComment comment) {
		try {
			if(commentDao.updateComment(comment)==1) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}






