package test.cjhaveri.utilities;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;
import java.util.StringTokenizer;

/**
 * Created by chetanjhaveri on 6/5/16.
 */
public class CommandGenerator {

    public static void main(String[] args) throws Exception {

        //read from classpath
        InputStream is = CommandGenerator.class.getResourceAsStream("/securitynow.list");
        //read entire file
        String episodes = IOUtils.toString(is, "UTF-8");
        //split on new character (default)
        String[] lines = StringUtils.split(episodes);

        for (int i=0; lines != null && i < lines.length; i++){

            String eachLine = lines[i];
            //tokenize the line
            StringTokenizer st = new StringTokenizer(eachLine,",");
            //episode number is token 1
            String episodeNumber = st.nextToken();
            //episode name is token 2
            String episodeName = st.nextToken();
            //left pad the episide number with a 0 (if needed)
            episodeNumber = StringUtils.leftPad(episodeNumber, 3, '0');
            //sample: curl -L -o sn-072-faq.mp3 https://media.grc.com/sn/sn-072-lq.mp3
            System.out.println("curl -L -o sn-" + episodeNumber + "-" + episodeName + ".mp3 https://media.grc.com/sn/sn-" + episodeNumber + "-lq.mp3");
        }

        //final rsync command that should be printed
        System.out.println("sync -rvt . /Volumes/Music/Podcasts/security-now/");

    }

}



