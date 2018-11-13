package personal.com.sample.Utils.File;

import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FileMover {
    //method has three arguments, first the input path of the file
    // second the desired path to move the file
    // third the file name
    public static void moveFile(String inputPath, String outputPath, String FileName) {
        InputStream in = null;
        OutputStream out = null;
        try {
            //create output directory if it doesn't exist
            File dir = new File (outputPath);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            in = new FileInputStream(inputPath+FileName);
            out = new FileOutputStream(outputPath+FileName);

            byte[] buffer = new byte[1024];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            in.close();     //closing the streamer
            in = null;
            // write the output file
            out.flush();
            out.close();    //closing the streamer
            out = null;

            // delete the original file
            new File(inputPath+FileName).delete();
        }

        catch (FileNotFoundException fnfe1) {
            Log.e("tag", fnfe1.getMessage());
        }
        catch (Exception e) {
            Log.e("tag", e.getMessage());
        }
    }
}
