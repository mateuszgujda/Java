import Exceptions.NoSequenceFoundException;
import Exceptions.WrongFrameSequenceException;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by student on 2018-10-23.
 */
public class MicroDVD {

    public MicroDVD() {

    }

    public void delay(final String in, String out, int delay, int fps) throws NoSequenceFoundException,WrongFrameSequenceException,IOException {
        try {
            String pattern = "\\{(.*)\\}\\{(.*)\\}(.*)";
            FileInputStream in_file = new FileInputStream(in);
            Scanner rd = new Scanner(in_file);
            BufferedWriter wrt = new BufferedWriter(new FileWriter(out));
            String line;
            String outline;
            int frames_to_delay = delay/1000*fps ;

            Pattern famePattern = Pattern.compile(pattern);
            while(rd.hasNext()) {
                line = rd.nextLine();
                Matcher matcher = famePattern.matcher(line);
                int inFrame;
                int outFrame;
                int delayed_inFrame;
                int delayed_outFrame;
                if (matcher.find()) {
                    try {
                        inFrame = Integer.parseInt(matcher.group(1));
                        outFrame = Integer.parseInt(matcher.group(2));
                        if (inFrame > outFrame)
                            throw new WrongFrameSequenceException("Wrong sequence: in frame is bigger than out frame");
                        else{
                        delayed_inFrame = inFrame+frames_to_delay;
                        delayed_outFrame = outFrame+frames_to_delay;
                        outline ="{"+delayed_inFrame+"}"+"{"+delayed_outFrame+"}"+matcher.group(3)+System.lineSeparator();
                        wrt.append(outline);
                        }
                    } catch (NumberFormatException e) {
                        throw new WrongFrameSequenceException("Wrong sequence: The frames are not represented by numbers");
                    }
                } else {
                    throw new NoSequenceFoundException("No subtitles sequence was found");
                }
            }
            rd.close();
            wrt.close();
        } catch(IOException e){
            throw e;
        }
    }
}

