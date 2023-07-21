
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
//import sun.misc.BASE64Encoder;
//import java.math.BigInteger; 

import java.io.*;
import java.util.*;


public class MerkleRoot{


	public static void main(String args[]){

		ArrayList<String> grades = new ArrayList<String>();
		String instructorMerkleRoot, friendMerkleRoot;
		

		String input;
		try{
			BufferedReader file = new BufferedReader(new FileReader("input.csv"));
			while((input = file.readLine()) != null){

				String[] line = input.split(", "); 
				for(String i: line){
					grades.add(i);
				}

				
				

			}
		}catch(IOException e){
			System.out.println("ERROR\n");
		}

		
		ArrayList<String> gradesHashed = new ArrayList<String>();
		System.out.print("Grades for Instructor: ");
		for(String i : grades){
			gradesHashed.add(getSHA(i));
			System.out.print(i + " ");
			
		}

		instructorMerkleRoot = calculteRoot(gradesHashed);
		System.out.println("\r\ninstructorMerkle: " + instructorMerkleRoot);



		gradesHashed.clear();
		System.out.print("Grades for Friend: ");
		grades.set(0,"0");
		for(String i : grades){
			gradesHashed.add(getSHA(i));
			System.out.print(i + " ");
			
		}
		friendMerkleRoot = calculteRoot(gradesHashed);
		System.out.println("\r\nfriendMerkle: " + friendMerkleRoot);

		

		try{

			//inlitialztion 
			KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
			SecureRandom sRandom = SecureRandom.getInstance("SHA1PRNG", "SUN");
			kpg.initialize(1024, sRandom);
			byte[] data;

			//signing roots for Instuctor
			KeyPair instructorPair = kpg.genKeyPair();
			Signature instructorSignature = Signature.getInstance("SHA1WithRSA");
			instructorSignature.initSign(instructorPair.getPrivate());
			data = instructorMerkleRoot.getBytes("UTF8");
			instructorSignature.update(data);
			byte[] instuctorSign = instructorSignature.sign();
			System.out.print("\r\nInstructor Signature: ");
			for(int i = 0; i < instuctorSign.length; i++){
				System.out.print(instuctorSign[i]);
			}

			//signing roots for friend
			KeyPair friendPair = kpg.genKeyPair();
			Signature friendSignature = Signature.getInstance("SHA1WithRSA");
			friendSignature.initSign(friendPair.getPrivate());
			 data = friendMerkleRoot.getBytes("UTF8");
			friendSignature.update(data);
			byte[] friendSign = instructorSignature.sign();
			System.out.print("\r\nInstructor Signature: ");
			for(int i = 0; i < friendSign.length; i++){
				System.out.print(friendSign[i]);
			}

			//verify instuctor data againts instructor public key
			instructorSignature.initVerify(instructorPair.getPublic());
        	instructorSignature.update(instructorMerkleRoot.getBytes("UTF8"));
        	System.out.println("\r\n\r\nInstructor verify: " + instructorSignature.verify(instuctorSign));

        	//verify friend data againts instructor public key
        	friendSignature.initVerify(friendPair.getPublic());
        	friendSignature.update(friendMerkleRoot.getBytes("UTF8"));
        	System.out.println("Friend verify: " + friendSignature.verify(friendSign));
		
		}catch(NoSuchAlgorithmException | NoSuchProviderException out){
			out.printStackTrace();
		}catch(InvalidKeyException out) {
			out.printStackTrace();
		}
		catch(SignatureException out) {
			out.printStackTrace();
		}
		catch(UnsupportedEncodingException out){
			out.printStackTrace();
		}


	}

	public static String calculteRoot(ArrayList<String> input){ 

		String out = "";
		if(input.size() == 1){
			out = input.get(0) + input.get(0);
			return getSHA(out);

		}else if(input.size() == 2){
			out = input.get(0) + input.get(1);
			return getSHA(out);
		}else if(input.size() > 2){
			
			ArrayList<String> temp = new ArrayList<String>();

			
			while(input.size() > 1){
				temp.add(getSHA(input.get(0) + input.get(1)));
				input.remove(1);
				input.remove(0);
				

			}
			if(input.size() > 0){
				temp.add(getSHA(input.get(0) + input.get(0)));
			}

			return calculteRoot(temp);

		}else{

			
			for(int i = 0; i < 32; i++){
				out += "0";
			}
			return out;
		}

	}

	public static String getSHA(String input) 
	{ 

		

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        
			//Applies sha256 to our input, 
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
	        
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);

		}
	} 


}

