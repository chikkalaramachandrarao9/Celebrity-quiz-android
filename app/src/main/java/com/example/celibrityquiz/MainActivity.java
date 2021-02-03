package com.example.celibrityquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button btn1,btn2,btn3,btn4;
    String page = null;
    ArrayList<String> celeburls = new ArrayList<String>();
    ArrayList<String> celebnames = new ArrayList<String>();
    int chosenCeleb;
    String[] options = new String[4];
    int correctAnswer = 0;
    MediaPlayer cor,wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.celebImg);
        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);

        cor = MediaPlayer.create(MainActivity.this,R.raw.correct);
        wrong = MediaPlayer.create(MainActivity.this,R.raw.wrong);
        
//        DownloadPage task1  = new DownloadPage();
//
//        try {
//            page = task1.execute("https://www.indiaglitz.com/telugu-actor-photos").get();
//
//
//            int n=0;
//
//            Pattern p = Pattern.compile("<img src=\"(.*?)\"");
//            Matcher m = p.matcher(page);
//
//            m.find();
//            m.find();
//            while (m.find()){
//                Log.i("hello",m.group(1));
//
//                celeburls.add(m.group(1));
//                n++;
//            }
//            Pattern p1 = Pattern.compile("<span>(.*?)</span>");
//            Matcher m1 = p1.matcher(page);
//            n=0;
//            while (m1.find()){
//                Log.i("hello",m1.group(1));
//
//                celebnames.add(m1.group(1));
//                n++;
//            }
//
////            Random random = new Random();
////            chosenCeleb = random.nextInt(celeburls.size());
////            Log.i("hello","ok");
////            ImageDownloader task2 = new ImageDownloader();
////            Bitmap choosenCelebImg = task2.execute(celeburls.get(chosenCeleb)).get();
////            Log.i("hello","ok");
////            img.setImageBitmap(choosenCelebImg);
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }



        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/vishwak-sen-20190214110550-40865.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/allu-arjun-20190607155519-4140.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/aadi-saikumar-20190517110333-23530.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/adarsh-balakrishna-20150522140946-25199.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/akhil-akkineni-20181214110930-21850.jpg");
        celeburls.add("https://www.filmibeat.com/img/136x146/popcorn/profile_photos/prabhu-deva-20180307162505-4789.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x133/popcorn/profile_photos/ram-charan-teja-20130904104829-7340.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x133/popcorn/profile_photos/srikanth-20141016151435-4546.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/sundeep-kishan-20190627153238-18689.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/raj-tharun-20190619144233-32127.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/sudheer-babu-26148.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/ram-pothineni-20181009094946-4105.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/jr-ntr-20160112144609-4308.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/karthi-20191021112744-9542.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/nikhil-siddhartha-20191129101110-4470.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/venu-4374.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/balakrishna-20130820173945-4158.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/gopichand-20190612103106-4091.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/rajendra-prasad-20150417123307-11894.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/suriya-sivakumar-20190423095612-2747.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/nara-rohit-16849.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/mahesh-babu-20140227172800-5310.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/arjun-sarja-20130618131220-9396.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/chiranjeevi-20190801110016-8359.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/priyadarshi-20190621121826-36775.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/nagarjuna-akkineni-20180531112851-1466.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/vishal-krishna-20190829160318-3265.jpg");
        celeburls.add("https://www.filmibeat.com/img/125x156/popcorn/profile_photos/pawan-kalyan-20130816115207-4225.jpg");
        celeburls.add("https://www.filmibeat.com/img/162x203/popcorn/profile_photos/brahmaji-20131203102813-4389.jpg");
        celeburls.add("https://www.filmibeat.com/img/162x203/popcorn/profile_photos/nitin-20190329175353-4035.jpg");
        celeburls.add("https://www.filmibeat.com/img/162x203/popcorn/profile_photos/vijay-deverakonda-20170912113037-34598.jpg");
        celeburls.add("https://www.filmibeat.com/img/162x203/popcorn/profile_photos/sharwanand-20200330173112-4271.jpg");
        celeburls.add("https://www.filmibeat.com/img/162x203/popcorn/profile_photos/varun-tej-20180419152017-33402.jpg");
        celeburls.add("https://www.filmibeat.com/img/162x203/popcorn/profile_photos/nandu-20130604114414-17440.jpg");
        celeburls.add("https://www.filmibeat.com/img/162x203/popcorn/profile_photos/naga-shourya-20190704174712-25201.jpg");
        celeburls.add("https://www.filmibeat.com/img/162x203/popcorn/profile_photos/allari-naresh-20190410152710-4002.jpg");
        celeburls.add("https://www.filmibeat.com/img/162x203/popcorn/profile_photos/kalyan-ram-20190705105542-4275.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2013/12/krishnudu-stills-from-crazy-boys-movie_138786604520.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/a-r-rahman-20140106102237-2362.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/a-v-ravi-20181115151739-24270.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/avs-10894.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/aamir-khan-20190805105527-2360.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/abbas-20140526101429-3893.jpg");
        celeburls.add("https://www.filmibeat.com/img/107x90x133/popcorn/profile_photos/abhishek-bachchan-20131219123753-1925.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2020/03/pradeep-machiraju_158392504650.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2019/12/naga-chaitanya_1576054551140.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2019/07/vikram-tamil-actor_156316716330.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2019/07/ali-reza_1563785141180.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2019/07/vishnu-manchu_1562568912120.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2019/05/bellamkonda-sai-sreenivas_155894200170.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2019/03/sudeep_1552477399120.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2019/02/kamal-haasan_155056776590.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2019/02/mohanlal_1550576448230.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2019/01/jagapati-babu_1547014210240.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2018/05/ravi-teja_152697389390.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2017/04/sonu-sood_149344174050.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2016/10/rana-daggubati_147548524930.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2016/09/varun-sandesh_147443318530.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2016/08/sai-kumar_147158308230.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2015/02/navdeep_142486368250.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2013/10/actor-srihari_1381322563130.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2013/01/kadal_135823855514.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2013/12/sumanth-still-from-emo-gurram-egara-vachu-movie_138665292820.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2013/07/s-p-balasubrahmanyam-madhura-madhuravee-manjulagaana-book-launch_13744756720.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2013/12/sapthagiri-venkatadri-express-success-meet_138598364910.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2014/01/brahmanandam-still-from-bangkok-brahmanandam-movie_138882319210.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2015/01/m-s-narayana_142199348870.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2014/04/l-b-sriram_139815840870.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2014/04/prudhviraj-telugu-actor_139816357310.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2014/04/tanikella-bharani-in-telugu-movie-ori-devudoy_139815968700.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2014/04/gundu-sudarshan_139815876510.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2014/04/fish-venkat-in-telugu-movie-ori-devudoy_139815986400.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2015/11/mohan-babu_144782106120.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2015/12/krishna-telugu-actor_144965261030.jpg");
        celeburls.add("https://www.filmibeat.com/imgm/360x241x100/2016/07/devi-sri-prasad-mirchi-music-awards-south-2016_146968587020.jpg");


        celebnames.add("Vishwak Sen");
        celebnames.add("Allu Arjun");
        celebnames.add("Aadi");
        celebnames.add("Adarsh Balakrishna");
        celebnames.add("Akhil Akkineni");
        celebnames.add("Prabhu Deva");
        celebnames.add("Ram Charan Teja");
        celebnames.add("Srikanth");
        celebnames.add("Sandeep Kishan");
        celebnames.add("Raj Tharun");
        celebnames.add("Sudheer Babu");
        celebnames.add("Ram Pothineni");
        celebnames.add("Jr Ntr");
        celebnames.add("Karthi");
        celebnames.add("Nikhil Siddhartha");
        celebnames.add("Venu");
        celebnames.add("BalaKrishna");
        celebnames.add("Gopichand");
        celebnames.add("Rajendra Prasad");
        celebnames.add("Surya Sivakumar");
        celebnames.add("Nara Rohit");
        celebnames.add("Mahesh Babu");
        celebnames.add("Arjun Sarja");
        celebnames.add("Chiranjeevi");
        celebnames.add("Priyadarshi");
        celebnames.add("Nagarjuna");
        celebnames.add("Vishal Krishna");
        celebnames.add("Pawan Kalyan");
        celebnames.add("Brahmaji");
        celebnames.add("Nitin");
        celebnames.add("Vijay Devarakonda");
        celebnames.add("Sharwanand");
        celebnames.add("Varun Tej");
        celebnames.add("Nandu");
        celebnames.add("Naga Shourya");
        celebnames.add("Allari Naresh");
        celebnames.add("Kalyan Ram");
        celebnames.add("Krishnudu");
        celebnames.add("A R Rahman");
        celebnames.add("A V Ravi");
        celebnames.add("Avs");
        celebnames.add("Aamir Khan");
        celebnames.add("Abbas");
        celebnames.add("Abishek Bachan");
        celebnames.add("Pradeep");
        celebnames.add("Nagachaitanya");
        celebnames.add("Vikram");
        celebnames.add("Ali Reza");
        celebnames.add("Vishnu");
        celebnames.add("Sai Srinivas");
        celebnames.add("Sudeep");
        celebnames.add("Kamal Hasan");
        celebnames.add("Mohan Lal");
        celebnames.add("JagapatiBabu");
        celebnames.add("Ravi Teja");
        celebnames.add("Sonu Sood");
        celebnames.add("Rana");
        celebnames.add("Varun Sandesh");
        celebnames.add("Sai Kumar");
        celebnames.add("Navdeep");
        celebnames.add("Srihari");
        celebnames.add("Aravind Swamy");
        celebnames.add("Sumanth");
        celebnames.add("Sp Balu");
        celebnames.add("Sapthagiri");
        celebnames.add("Brahmanandam");
        celebnames.add("Ms Narayana");
        celebnames.add("Lb SriRam");
        celebnames.add("Prudhviraj");
        celebnames.add("Tanikella Bharani");
        celebnames.add("GunduSudarshan");
        celebnames.add("Fish Venkat");
        celebnames.add("MohanBabu");
        celebnames.add("Krishna");
        celebnames.add("Devi Sri Prasad");
        makeQuestion();


    }


    public void makeQuestion()
    {
        Random random = new Random();
        chosenCeleb = random.nextInt(celeburls.size());
        ImageDownloader task2 = new ImageDownloader();
        Bitmap choosenCelebImg = null;
        try {
            choosenCelebImg = task2.execute(celeburls.get(chosenCeleb)).get();
            img.setImageBitmap(choosenCelebImg);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        correctAnswer = random.nextInt(4);

        for (int i=0;i<4;i++){
            if(i == correctAnswer)
                options[i] = celebnames.get(chosenCeleb);
            else {
                int inncorrectAns = random.nextInt(celeburls.size());
                while(inncorrectAns == correctAnswer)
                {
                    inncorrectAns = random.nextInt(celeburls.size());
                }
                options [i] = celebnames.get(inncorrectAns);
            }
        }

        btn1.setText(options[0]);
        btn2.setText(options[1]);
        btn3.setText(options[2]);
        btn4.setText(options[3]);
    }

//    public class DownloadPage extends AsyncTask<String,Void,String>{
//
//        @Override
//        protected String doInBackground(String... urls) {
//            HttpURLConnection connection;
//            String result = " ";
//
//            try {
//
//                URL url = new URL(urls[0]);
//                connection = (HttpURLConnection) url.openConnection();
//                connection.connect();
//                InputStream is = connection.getInputStream();
//                InputStreamReader reader = new InputStreamReader(is);
//
//                int data = reader.read();
//
//                while ( data !=-1) {
//                    char c = (char) data;
//                    result += c;
//                    data = reader.read();
//                }
//
//                Log.i("hello","task downloaded");
//                return result;
//
//            }
//            catch (Exception e){
//                e.printStackTrace();
//            }
//            Log.i("hello","not ok");
//            return null;
//        }
//    }

    public class ImageDownloader extends AsyncTask<String,Void, Bitmap>{

        @Override
        protected Bitmap doInBackground(String... urls) {
            try {
                URL url = new URL(urls[0]);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.connect();

                InputStream input = connection.getInputStream();

                Bitmap bitmap = BitmapFactory.decodeStream(input);


                return bitmap;

            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.i("hello","not ok");
            return null;
        }

    }

    public void celebchoosen(View view) {

        if(view.getTag().toString().equals(Integer.toString(correctAnswer)))
        {
            cor.start();
            Toast.makeText(getBaseContext(),"Correct Answer",Toast.LENGTH_SHORT).show();
        }
        else {
            wrong.start();
            Toast.makeText(getBaseContext(),"Wrong Answer!, Answer is "+celebnames.get(chosenCeleb),Toast.LENGTH_SHORT).show();

        }
        makeQuestion();
    }
}
