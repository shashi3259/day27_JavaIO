package com.bridgelab.javaIO;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class UC2_NIOFileAPITest {
	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";
	
	
	@Test
	public void givenPathWhenCheckedThenConfirm() throws IOException{
		//Check File Exists
		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));
		
		
		//Delete File and Check FIle Not Exist
		Path playpath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if(Files.exists(playpath)) {
			FileUtils.deleteFiles(playpath.toFile());
		}	
		Assert.assertTrue(Files.notExists(playpath));
		
		// Create Directory
		Files.createDirectories(playpath);
		Assert.assertTrue(Files.exists(playpath));
		
		// Create File
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playpath +"/temp" + cntr);
			Assert.assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			}
			catch (IOException e) {}
			Assert.assertTrue(Files.exists(tempFile));
		});
		
		//List Files, Directory as well as Files With Extensions
		Files.list(playpath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playpath).forEach(System.out::println);
		Files.newDirectoryStream(playpath, path -> path.toFile().isFile() &&
												   path.toString().startsWith("temp"))
												.forEach(System.out::println);
		@Test
		public void givenADirectoryWatchedListsAllTheActivities() throws IOException{
			Path dir = Paths.get(HOME +"/"+ PLAY_WITH_NIO);
			Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
			new Java8WatchServiceExample(dir).processEvents();
			 
		}

	}

}
