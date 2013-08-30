import java.io.File;
import java.io.IOException;

import org.json.JSONException;

import com.bitcasa.BitcasaConnection;
import com.bitcasa.exceptions.NetworkUnavailableExeption;
import com.bitcasa.exceptions.RequestErrorException;

/** Uploads a file to bitcasa using the unofficial bitcasa API. **/
public class BcUp
{
  private static final String DESTINATION = "/Downloads/"; // bitcasa path of the destination

  public static void main(String[] args) throws IOException, RequestErrorException, JSONException, NetworkUnavailableExeption, InterruptedException
  {
    String email = System.getenv("BITCASA_EMAIL");
    String password = System.getenv("BITCASA_PASSWORD");
    // Initialize a connection to the client
    BitcasaConnection client = new BitcasaConnection(email, password);

    File file = new File(args[0]);
    // Copy the local file to Bitcasa
    client.cp(file, DESTINATION);

    // Print the results
    System.out.println("Upload Successful");
    // System.out.println(client.ls(DESTINATION));
  }
}
