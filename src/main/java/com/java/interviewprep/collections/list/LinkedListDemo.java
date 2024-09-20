/**
 * 
 */
package com.java.interviewprep.collections.list;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * @author Abhishek Ingle
 * @since Sep 20, 2024
 * @version 1.0
 */
public class LinkedListDemo {
	
//	Create a program that simulates a playlist using a LinkedList. 
//	Implement functionalities to add songs to the playlist, remove songs, and display the current playlist. 
//	Additionally, allow users to play the next song and the previous song.
	
	public static void main(String[] args) {
		
		PlayListManager playListManager = new PlayListManager();
		
		Scanner sc = new Scanner(System.in);
		int command;
		
		while(true) {
			System.out.println("Enter command for (add=1, remove=2, display=3, next=4, previous=5, exit=6):");
			command = sc.nextInt();
			switch(command) {
				case 1:
					System.out.println("Enter song name");
					String songName = sc.next().trim();
					System.out.println("Enter singer name");
					String singerName = sc.next().trim();
					System.out.println("Enter song length");
					Float songLength = sc.nextFloat();
					Song song = new Song(songName, singerName, songLength);
					System.out.println(playListManager.addSongToPlayList(song));
					break;
				case 2:
					System.out.println("Enter song name");
					String songName1 = sc.next().trim();
					System.out.println(playListManager.removeSongFromPlayList(songName1));
					break;
				case 3:
					List<Song> displayPlayList = playListManager.displayPlayList();
					ListIterator<Song> listIterator = displayPlayList.listIterator();
					while(listIterator.hasNext()) {
						System.out.println(listIterator.next());
					}
					break;
				case 4:
					System.out.println(playListManager.playNextSong());
					break;
				case 5:
					System.out.println(playListManager.playPreviousSong());
					break;
				case 6:
					sc.close();
					return;
				default:
					System.out.println("Invalid command input!");
				
			}
		}
		
	}

}

class PlayListManager {
	
	private LinkedList<Song> playList;
	
	public PlayListManager() {
		Song[] songs = {new Song("Song1", "Singer1", 4.3f), new Song("Song2", "Singer2", 5.2f), new Song("Song3", "Singer3", 3.5f), new Song("Song4", "Singer4", 4.5f)};
		playList = new LinkedList<>(Arrays.asList(songs));
	}
	
	
	public List<Song> addSongToPlayList(Song song) {
		playList.add(song);
		return playList;
	}
	
	public List<Song> removeSongFromPlayList(String songName) {
		for(Song s : playList) {
			if(s.getSongName().equalsIgnoreCase(songName)) {
				playList.remove(playList.indexOf(s));
				return playList;
			}
		}
		System.out.println("Song not found!");
		return playList;
	}
	
	public List<Song> displayPlayList() {
		return playList;
	}
	
	public List<Song> playNextSong() {
		boolean flag = false;
		Song song = null;
		for(Song s : playList) {
			if(s.isPlaying().booleanValue()) {
				s.setPlaying(false);
				int indexOf = playList.indexOf(s);
				if(playList.size()-1 != indexOf) {
					song = playList.get(indexOf + 1);					
					song.setPlaying(true);
					flag = true;
					break;
				}
			}
		}
		
		if(!flag) {
			song = playList.get(0);
			song.setPlaying(true);
		}
		
		playList.set(playList.indexOf(song), song);
		return playList;
	}
	
	public List<Song> playPreviousSong() {
		boolean flag = false;
		Song song = null;
		for(Song s : playList) {
			if(s.isPlaying().booleanValue()) {
				s.setPlaying(false);
				int indexOf = playList.indexOf(s);
				if(indexOf != 0) {
					song = playList.get(indexOf - 1);					
					song.setPlaying(true);
					flag = true;
					break;
				}
			}
		}
		
		if(!flag) {
			song = playList.get(playList.size()-1);
			song.setPlaying(true);
		}
		
		playList.set(playList.indexOf(song), song);
		return playList;
	}
}

class Song {
	
	private String songName;
	private String singerName;
	private Float songLength;
	private Boolean isPlaying;
	
	public Song(String songName, String singerName, Float songLength){
		this.songName = songName;
		this.singerName = singerName;
		this.songLength = songLength;
		this.isPlaying = false;
	}
	
	public String toString() {
		return this.songName.concat("-").concat(this.singerName).concat("-").concat(this.songLength.toString().concat("-").concat(this.isPlaying.toString()));
	}
	
	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSingerName() {
		return singerName;
	}

	public void setSingerName(String singerName) {
		this.singerName = singerName;
	}

	public Float getSongLength() {
		return songLength;
	}

	public void setSongLength(Float songLength) {
		this.songLength = songLength;
	}

	public Boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(Boolean isPlaying) {
		this.isPlaying = isPlaying;
	}
	
}
