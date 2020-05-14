package com.example.tourismo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class cniAbout extends AppCompatActivity {
    TextView cityTextviewA;
    TextView detailText,places;
    ImageView tour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cni_about);
        cityTextviewA=findViewById(R.id.citytextViewAbout);
        detailText=findViewById(R.id.detailTextViewAbout);
        tour=findViewById(R.id.tourcniview);
        places=findViewById(R.id.cniplaces);
        Intent intent = getIntent();
        String city = intent.getStringExtra("activity");
        cityTextviewA.setText(city);

        if(city.equals("Chennai"))
        {
            detailText.setText("Chennai, also known as Madras, is the capital of the Indian state of Tamil Nadu. Located on the Coromandel Coast off the Bay of Bengal, it is the biggest cultural, economic and educational centre of south India." +
                    "It is the sixth-most populous city and fourth-most populous urban agglomeration in India.Chennai is among the most-visited Indian cities by foreign tourists."+"\n"+"With temples, beaches and centres of historical and cultural significance, including the UNESCO Heritage Site of Mahabalipuram, Chennai is one of the most-visited cities in India. The city serves as the gateway to the southern part of India with tourists landing in the city and then visiting the rest of the region." +
                    "As of 2012, the city had 21 luxury hotels in the five-star category, with over 4,500 rooms in the inventory.");
            tour.setImageResource(R.drawable.tourchennai);
            places.setText("Marina Beach\n" +
                    "Marina Beach is a 13-kilometre stretch of golden sands. The longest urban beach in the country, the beach is a recreational hub of the city and ranks amongst the top tourist places in Chennai. The atmosphere is electric with swarms of visitors and vendors creating a carnival-like ambience. An interesting point to note about Marina Beach is that swimming in the water isn’t legally permitted because of the turbulent undercurrents. Beyond the surf and sand, Marina Beach is also dotted with several monuments and statues of historical figures\n" +
                    "\nKapaleeshwarar Temple\n" +
                    "The 7th century Kapaleeshwarar Temple is dedicated to Lord Shiva. Built in Dravidian style architecture, the temple’s eastern entrance displays an impressive 40-metre high pillar with carvings of deities. Within the temple complex, there are several shrines and courtyards with figures of religious significance including a bull, chariot and an elephant\n" +
                    "\nFort St. George\n" +
                    "Built in the 1640 by the British East India Company, Fort St. George was the center point of merchant trade activity.  Today, it houses the Secretariat and Legislative Assembly. Within the confines of Fort St. George is the Fort Museum with displays of historical artefacts and St. Mary's Church, the oldest Anglican church in the country.\n" +
                    "\nThousand Lights Mosque\n" +
                    "On the list of tourist places in Chennai is the Thousand Lights Mosque. The holy worship place for follower of Islam, the mosque gets its name because of the 1,000 plus lamps that are illuminated in the Assembly Hall. Verses from the holy book are painted on the walls of this multi-domed mosque.  The Thousand Lights Mosque enclosure also has a library and burial ground\n");


        }
        else if(city.equals("Lucknow"))
        {
            detailText.setText("Lucknow is the capital city of the Indian state of Uttar Pradesh and is also the administrative headquarters of the eponymous district and division. It is the fourteenth-most populous city and the twelfth-most populous urban agglomeration of India." +
                    " Lucknow has always been a multicultural city that flourished as a North Indian cultural and artistic hub, and the seat of power of Nawabs in the 18th and 19th centuries.It continues to be an important centre of governance, administration, education, commerce, aerospace, finance, pharmaceuticals, technology, design, culture, tourism, music and poetry.\n" +
                    "\n" +
                    "Lucknow district covers an area of 2,528 square kilometres (976 sq mi).Lucknow sits on the northwestern shore of the Gomti River.\n" +
                    "\n" +
                    "Historically, Lucknow was the capital of the Awadh region, controlled by the Delhi Sultanate and later the Mughal Empire. It was transferred to the Nawabs of Awadh.");
            tour.setImageResource(R.drawable.tourlko);
            places.setText("Bara Imambara\n" +
                    "Built-in 1784 by the 4th Nawab of Awadh, Asaf-ud-Daula, it is one of the most well-known monuments in Lucknow and place of worship for Muslims. Built in 14 years at the cost of a million dollars, it is one of the last structures that didn’t use iron or other European elements. The Bara Imambara is home to largest arched halls in the world and a beautiful maze constructed on the first floor of the monument.\n" +
                    "\nIndira Gandhi Planetarium\n" +
                    "Located on banks of the river Gomti in Suraj Kund Park, the planetarium was built in 2003 to resemble the planet Saturn complete with outer rings. The building inside is modern and boasts of state-of-art projectors equipped with every kind of special effect you can imagine. The shows are quite popular\n" +
                    "\nJama Masjid\n" +
                    "A prominent landmark in Lucknow, this beautiful mosque was built in 1423 by Sultan Ahmed Shah. The yellow sandstone structure, is admired for its stunning display of Hindu and Muslim architecture and intricate designs. Spread over a massive 4950 sq.mt, the elaborate carvings on the pillars are inspired by both Hindu and Jain culture.\n" +
                    "\nRumi Darwaza\n" +
                    "Called the Turkish Gate, it was built under the Food for Work program by Nawab Asad-ud-Daula in 1784. Standing 60ft tall, this impressive monument, it was created to help the populace get over the brutal famine. It was modelled after the decorative, beautiful carved gates of Constantinople, i.e. Istanbul of today. The entrance is free standing and like the Bara Imambara arch is not supported with iron or wood.\n");
        }
        else
        {
            detailText.setText("Dehradun , also spelled Dera Doon, is the capital and most populous city of Uttarakhand, a state in India. It is the administrative headquarters of Dehradun district.\n" +
                    "\n" +
                    "It is one of the \"Counter Magnets\" of the National Capital Region (NCR) being developed as an alternative centre of growth to help ease the migration.\n" +
                    "\n" +
                    "Dehradun is located in the Doon Valley on the foothills of the Himalayas nestled between the river Ganges on the east and the river Yamuna on the west. The city is noted for its picturesque landscape and slightly milder climate and provides a gateway to the surrounding region. It is well connected and in proximity to Himalayan tourist destinations such as Mussoorie, and Auli and the Hindu holy cities of Haridwar and Rishikesh along with the Himalayan pilgrimage circuit of Chota Char Dham.Dehradun houses various defense academies and research institutes, such as Indian Military Academy, Rashtriya Indian Military College, Forest Research Institute, and Wadia Institute of Himalayan Geology.");
            tour.setImageResource(R.drawable.tourdehradun);
            places.setText("Sahastradhara\n"+"Sahastradhara or a thousand fold spring is located 16km from the city. The falls not only add to the scenic beauty of the place but is also popular for its therapeutic qualities. The water contains sulphur which helps in curing skin diseases. \n" +
                    "\nThe Forest Research Institute\n"+"The Forest Research Institute was set up in Dehradun in 1906 to facilitate research activities associated with forests. Apart from its educational significance, the imposing building with strong colonial and Greco-Roman architectural influence and sprawling grounds is a treat to the eyes. The institute also houses six museums accessible to the public. Open from 9am to 1pm and 2:30pm to 5:30pm, entry to these museums is free.\n" +
                    "\nChetwode Hall\n"+"Dehradun is popular for the Indian Military Academy. Inside the academy is the small yet charming Chetwoode Hall where arms and ammunitions and military artefacts of the 20th century are displayed. \n" +
                    "\nRobber's Cave\n"+"Also known as Guchchu Paani, Robber’s Cave is an exotic picnic spot and popular tourist destination. It has a natural cave with water flowing inside. A stream of water goes underground and appears a few metres away. The cave is surrounded by beautiful hills and this serene spot is an ideal getaway for anyone looking for peace and quiet");
        }

    }
}
