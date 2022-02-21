package session;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MoveDownloadedFile {
	
	
	
	

    public static void main(String[] args) throws IOException
    {
        Path temp = Files.move
        (Paths.get("C:\\Users\\hp\\Downloads\\Screenshot_32.png"),
        Paths.get("E:\\Screenshot_32.png"));
 
        if(temp != null)
        {
            System.out.println("File renamed and moved successfully");
        }
        else
        {
            System.out.println("Failed to move the file");
        }
    }
}


