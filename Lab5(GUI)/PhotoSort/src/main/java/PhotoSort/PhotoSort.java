package  PhotoSort;
import io.indico.Indico;
import io.indico.api.results.BatchIndicoResult;
import io.indico.api.results.IndicoResult;
import io.indico.api.utils.IndicoException;

import javax.activation.MimetypesFileTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class PhotoSort {
    public void dir_sort(String API_key, String folder) throws IndicoException, IOException {
        Indico indico = new Indico(API_key);
        File dir = new File(folder);
        if(!dir.exists())
            throw new IOException("Folder does not exist");
        File[] example = dir.listFiles();
        Map<String, Object> options = new HashMap<String, Object>();
        File new_dir;
        options.put("top_n", 1);
        for (File picture : example) {
            String mimeType = new MimetypesFileTypeMap().getContentType(picture);
            if(mimeType.equals("image")) {
                IndicoResult result = indico.imageRecognition.predict(picture, options);
                String category = (String) result.getImageRecognition().keySet().toArray()[0];
                new_dir = new File(folder + category);
                if (!new_dir.exists())
                    new_dir.mkdir();

               picture.renameTo(new File(new_dir.toString() + "/" + picture.getName()));
            }
        }
    }
}
