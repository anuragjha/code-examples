import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Test {

	public static void main(String[] args)  {
		 try (
		            InputStream inputStream = new FileInputStream("out.jpeg");
		            OutputStream outputStream = new FileOutputStream("test.jpeg");
		        ) {
		 
		            int byteRead;
		 
		            while ((byteRead = inputStream.read()) != -1) {
		                outputStream.write(byteRead);
		            }
		 
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        }
		
		
		
		
	}

}
