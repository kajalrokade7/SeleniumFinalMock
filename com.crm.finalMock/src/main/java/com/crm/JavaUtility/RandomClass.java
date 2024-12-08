package com.crm.JavaUtility;

import java.io.IOException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;

public class RandomClass 
{
	public static int randomNum() throws EncryptedDocumentException, IOException
	  {
		  Random r = new Random();
		  int num = r.nextInt(100);
		  return num;
	  }

}
